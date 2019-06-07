package Chokladgruppen.demo;

import Chokladgruppen.demo.Orders;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

    List<Orders> findById(long id);
}
