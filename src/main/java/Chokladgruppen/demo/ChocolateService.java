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

@Service("chocolateService")
public class ChocolateService {
    
    @Autowired
    ChocolateRepository repository;
    
    Chocolate getChocolate(long id){
        //return repository.findById(id);
        return repository.findById(id).get(0);
    }
    
     Iterable<Chocolate> getAllChocolate(){
         return repository.findAll();
         //return repository.findAll();
        //return repository.findAll();
    }
     
     Iterable<Chocolate> getChocolateByNameContainingIgnoreCase(String ord){
         return repository.findByNameContainingIgnoreCase(ord);
     }
    

}
