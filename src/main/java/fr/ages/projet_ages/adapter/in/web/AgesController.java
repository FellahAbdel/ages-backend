package fr.ages.projet_ages.adapter.in.web;

import fr.ages.projet_ages.application.port.in.SendAgesDataCommand;
import fr.ages.projet_ages.application.port.in.SendAgesDataUseCase;
import fr.ages.projet_ages.common.WebAdapter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/ages")
public class AgesController {
    private final SendAgesDataUseCase sendAgesDataUseCase;

    public AgesController(SendAgesDataUseCase sendAgesDataUseCase) {
        this.sendAgesDataUseCase = sendAgesDataUseCase;
    }


    @PostMapping(path = "/add/{titre}/{desc}")
    void sendAgesData(
        @PathVariable("titre") String titre,
        @PathVariable("desc") String desc
    ){
        SendAgesDataCommand command = new SendAgesDataCommand(titre, desc);

        sendAgesDataUseCase.sendAgesData(command);
    }

//    @PutMapping("/update/{titre}/{desc}")
//    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
//        Employee updateEmployee = employeeService.updateEmployee(employee);
//        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
//    }
}
