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
    }

    @PostMapping
    @ResponseBody
    boolean postResult(@RequestBody Purchase purchase) {
        
        if (purchase.getPerson() == null) {
            
        } else {
            Orders nyOrder = new Orders(purchase.getPerson());
            orderService.repository.save(nyOrder);
            for (int x = 0; x < purchase.getChocolates().size() + 1; x++) {
                if (x == purchase.getChocolates().size()) {
                    return true;
                }

                //This changes the amount of chocolates in the database
                int initialAmount = chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).getInStock();
                int amountToRemove = purchase.getChocolates().get(x).getAmount();
                int theFinalAmount = initialAmount - amountToRemove;

                chocolateService.getChocolate(purchase.getChocolates().get(x).getChocolateId()).setInStock(theFinalAmount);
                
                OrderDetails nyOrderDetails = new OrderDetails(purchase.getChocolates().get(x).getAmount(),
                        purchase.getChocolates().get(x),
                        nyOrder);
                orderDetailsService.repository.save(nyOrderDetails);
            }
        }

        return true;
    }
}
