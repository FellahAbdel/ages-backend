package fr.ages.projet_ages.adapter.in.web;

import fr.ages.projet_ages.application.domain.model.Ages;
import fr.ages.projet_ages.application.port.in.GetAgesDataUseCase;
import fr.ages.projet_ages.application.port.in.SendAgesDataCommand;
import fr.ages.projet_ages.application.port.in.SendAgesDataUseCase;
import fr.ages.projet_ages.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequestMapping("/ages")
@RequiredArgsConstructor
public class AgesController {
    private final SendAgesDataUseCase sendAgesDataUseCase;
    private final GetAgesDataUseCase getAgesDataUseCase;


    @PostMapping(path = "/add/")
    ResponseEntity<String> sendAgesData(
            @RequestBody Ages ages
    ){
        String titre = ages.getTitre();
        String desc = ages.getDescription();
        String objectif = ages.getObjectif();
        SendAgesDataCommand command = new SendAgesDataCommand(titre, desc, objectif, null);

        boolean result = sendAgesDataUseCase.sendAgesData(command);
        if (result) {
            return ResponseEntity.ok("Data successfully processed.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to process data.");
        }
    }

    @GetMapping(path = "/get/{id}/")
    ResponseEntity<Ages> receiveAgesData(@PathVariable("id") Long id){
        Ages agesData = getAgesDataUseCase.getAgesData(id);
        return new ResponseEntity<>(agesData, HttpStatus.OK);
    }

    @PutMapping("/update/")
    public ResponseEntity<String> updateAgesData(@RequestBody Ages ages) {
        String titre = ages.getTitre();
        String desc = ages.getDescription();
        String objectif = ages.getObjectif();
        Long id = ages.getId();
        SendAgesDataCommand command = new SendAgesDataCommand(titre, desc, objectif, id);

        boolean result = sendAgesDataUseCase.sendAgesDataForUpdate(command);
        if (result) {
            return ResponseEntity.ok("Data successfully updated.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to process data.");
        }
    }
}
