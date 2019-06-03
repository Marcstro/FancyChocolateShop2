/*
 * 
 * 
 * 
 */
package Chokladgruppen.demo;

import Chokladgruppen.demo.Orders;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marcu
 */
public interface OrdersRepository extends CrudRepository<Orders, Long> {
    
    List<Orders> findById(long id);
}
