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

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
public class testService {
    
    @Autowired
    ChocolateRepository repository;
    
//    Optional<Chocolate> getChocolate(long id){
//        return repository.findById(id);
//        return repository.findById(id).get(0);
//    }
    Chocolate getChocolate(long id){
        //return repository.findById(id);
        return repository.findById(id).get(0);
    }
    
     Iterable<Chocolate> getAllChocolate(){
         return repository.findAll();
         //return repository.findAll();
        //return repository.findAll();
    }
    

}
