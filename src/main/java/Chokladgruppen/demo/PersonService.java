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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonService {
    
    @Autowired
    PersonRepository repository;
    
    Person getPerson(long id){
        //return repository.findById(id);
        return repository.findById(id).get(0);
    }
    
     Iterable<Person> getAllPerson(){
         return repository.findAll();
         //return repository.findAll();
        //return repository.findAll();
    }
    

}

