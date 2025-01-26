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


    @PostMapping(path = "/add/{titre}/{desc}")
    void sendAgesData(
        @PathVariable("titre") String titre,
        @PathVariable("desc") String desc
    ){
        SendAgesDataCommand command = new SendAgesDataCommand(titre, desc);

        sendAgesDataUseCase.sendAgesData(command);
    }

    @GetMapping(path = "/get/{id}/")
    ResponseEntity<Ages> receiveAgesData(@PathVariable("id") Long id){
        Ages agesData = getAgesDataUseCase.getAgesData(id);
        return new ResponseEntity<>(agesData, HttpStatus.OK);
    }

//    @PutMapping("/update/{titre}/{desc}")
//    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
//        Employee updateEmployee = employeeService.updateEmployee(employee);
//        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
//    }
}
