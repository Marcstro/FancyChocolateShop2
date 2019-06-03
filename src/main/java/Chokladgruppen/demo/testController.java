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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Chocolates")
public class testController {

    @Autowired
    testService service;
    
    @GetMapping
    public Iterable<Chocolate> getChocolates(){
        return service.getAllChocolate();
    }
    
    @GetMapping("/{id}")
    public Chocolate getChocolateyId(@PathVariable Long id){
        return service.getChocolate(id);
    }
}
