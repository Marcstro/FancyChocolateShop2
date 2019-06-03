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

@Service("orderService")
public class OrdersService {
    
    @Autowired
    OrdersRepository repository;
    
    Orders getOrders(long id){
        //return repository.findById(id);
        return repository.findById(id).get(0);
    }
    
     Iterable<Orders> getAllOrders(){
         return repository.findAll();
         //return repository.findAll();
        //return repository.findAll();
    }
    

}