/*
 * 
 * 
 * 
 */
package Chokladgruppen.repository;

import Chokladgruppen.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alenj
 */
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long>{
    
}
