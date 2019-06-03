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

@Service("orderDetailsService")
public class OrderDetailsService {
    
    @Autowired
    OrderDetailsRepository repository;
    
    OrderDetails getOrderDetails(long id){
        //return repository.findById(id);
        return repository.findById(id).get(0);
    }
    
     Iterable<OrderDetails> getAllOrderDetails(){
         return repository.findAll();
         //return repository.findAll();
        //return repository.findAll();
    }
    

}