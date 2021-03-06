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
@RequestMapping("/Chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService service;
    
    @Autowired
    CustomerAndCart customerAndCart;
    
    
    @GetMapping
    public Iterable<Chocolate> getChocolates(){
        return service.getAllChocolate();
    }
    
    @GetMapping("/{id}")
    public Chocolate getChocolateyId(@PathVariable Long id){
        return service.getChocolate(id);
    }
    
    @GetMapping("/sokt/{ord}")
    public Iterable<Chocolate> getSoughtChocolate(@PathVariable String ord){
        return service.getChocolateByNameContainingIgnoreCase(ord);
    }
}

