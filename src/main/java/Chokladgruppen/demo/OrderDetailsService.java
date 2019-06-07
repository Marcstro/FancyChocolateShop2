package Chokladgruppen.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderDetailsService")
public class OrderDetailsService {

    @Autowired
    OrderDetailsRepository repository;

    OrderDetails getOrderDetails(long id) {
        return repository.findById(id).get(0);
    }

    Iterable<OrderDetails> getAllOrderDetails() {
        return repository.findAll();
    }
}
