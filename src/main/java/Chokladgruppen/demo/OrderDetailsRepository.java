package Chokladgruppen.demo;

import Chokladgruppen.demo.OrderDetails;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {

    List<OrderDetails> findById(long id);
}
