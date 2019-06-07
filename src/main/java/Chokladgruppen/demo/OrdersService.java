package Chokladgruppen.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrdersService {

    @Autowired
    OrdersRepository repository;

    Orders getOrders(long id) {
        return repository.findById(id).get(0);
    }

    Iterable<Orders> getAllOrders() {
        return repository.findAll();
    }
}
