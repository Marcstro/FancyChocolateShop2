/*
 * 
 * 
 * 
 */
package Chokladgruppen.demo;

import Chokladgruppen.demo.Orders;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marcu
 */
public interface OrdersRepository extends CrudRepository<Orders, Long> {
    
}
