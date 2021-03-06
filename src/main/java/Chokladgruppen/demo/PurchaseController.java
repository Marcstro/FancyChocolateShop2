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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PersonService personService;
    private final OrdersService orderService;
    private final ChocolateService chocolateService;
    private final OrderDetailsService orderDetailsService;

    @Autowired
    public PurchaseController(PersonService personService, OrdersService orderService, ChocolateService chocolateService, OrderDetailsService orderDetailsService) {
        this.personService = personService;
        this.orderService = orderService;
        this.chocolateService = chocolateService;
        this.orderDetailsService = orderDetailsService;
        System.out.println("purchaseController skapats korrekt!");
    }
    
    
    @PostMapping 
    @ResponseBody
    boolean postResult(@RequestBody Purchase purchase){
        if(purchase==null)
            System.out.println("objektet är null");
        System.out.println(purchase.toString());
        if(purchase.getPerson()==null){
            System.out.println("personen ar null");
        }
        else{
        System.out.println("Nu sa koper " + purchase.getPerson().getName()
        + " dessa choklader: " + purchase.getChocolates().toString());
        
        Orders nyOrder=new Orders(purchase.getPerson());
        orderService.repository.save(nyOrder);
        for(int x=0; x<purchase.getChocolates().size()+1; x++){
            if(x==purchase.getChocolates().size()){
                return true;
            }
            //if(!((x+1)<purchase.getChocolates().size())){
            System.out.println("Nu gar for lopen igenom " + x);
//            OrderDetails nyOrderDetails = new OrderDetails(purchase.getChocolates().get(x).getAmount(),
//            purchase.getChocolates().get(x),
//            nyOrder);
//            orderDetailsService.repository.save(nyOrderDetails);
            
            
            
            //This changes the amount of chocolates in the database
            System.out.println(chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).getInStock());
            System.out.println((purchase.getChocolates().get(x).getAmount()));
            
            System.out.println((chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).getInStock())
                    -(purchase.getChocolates().get(x).getAmount()));
            
            
            int initialAmount=chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).getInStock();
            int amountToRemove=purchase.getChocolates().get(x).getAmount();
            int theFinalAmount=initialAmount-amountToRemove;
            System.out.println("The final number:" + theFinalAmount);
            
            chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).setInStock(theFinalAmount);
            System.out.println(chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).getInStock());
//            chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).setInStock(
//            ((chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).getInStock())
//                            -(purchase.getChocolates().get(x).getAmount())));
//            
//           
            OrderDetails nyOrderDetails = new OrderDetails(purchase.getChocolates().get(x).getAmount(),
            purchase.getChocolates().get(x),
            nyOrder);
            orderDetailsService.repository.save(nyOrderDetails);
            
//                    if(x==purchase.getChocolates().size()-1){
//                        System.out.println("extrametoden tillakllades");
//                        chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).setInStock(5);
//                    }
        }
//        int x=purchase.getChocolates().size();
//                    chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).setInStock(
//            ((chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).getInStock())
//                            -(purchase.getChocolates().get(x).getAmount())));
        //}
        }
        //System.out.println(purchase.getChocolates().toString());
        
        return true;
    }
    
}
