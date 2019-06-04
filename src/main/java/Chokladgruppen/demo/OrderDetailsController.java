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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsController {

    @Autowired
    OrderDetailsService service;
    
    @GetMapping
    public Iterable<OrderDetails> getOrderDetails(){
        return service.getAllOrderDetails();
    }
    
    @GetMapping("/{id}")
    public OrderDetails getOrderDetailsId(@PathVariable Long id){
        return service.getOrderDetails(id);
    }
}
