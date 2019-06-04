/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcu
 * aer awesome
 */

package Chokladgruppen.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    
    //private final MultiplicationService multiplicationService;
    
    private final PersonService personService;
    
    @Autowired
    RegistrationController(final PersonService personService) {
        this.personService = personService;
    }
    
    @PostMapping 
    @ResponseBody
    boolean postResult(@RequestBody Registration registration){
        //System.out.println("vi kom till postResult i RegistrationController");
        if(registration==null)
            System.out.println("objektet är null");
        System.out.println(registration.toString());
        System.out.println("testar att skriva ut personens namn:" + registration.getName());
        
        Person nyPerson = new Person();
        nyPerson.setName(registration.getName());
        nyPerson.setAddress(registration.getAddress());
        nyPerson.setPassword(registration.getPassword());
        nyPerson.setUserName(registration.getUserName());
        nyPerson.setPremium(false);
        nyPerson.setAdmin(false);
        
        personService.repository.save(nyPerson);
        
        return true;
    }
//    @PostMapping
//    ResponseEntity<ResultResponse> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
//        return ResponseEntity.ok(
//                new ResultResponse(multiplicationService
//                        .checkAttempt(multiplicationResultAttempt)));
//    }
//
//    @RequiredArgsConstructor
//    @NoArgsConstructor(force = true)
//    @Getter
//    static final class ResultResponse {
//        private final boolean correct;
//    }
    
    

}
