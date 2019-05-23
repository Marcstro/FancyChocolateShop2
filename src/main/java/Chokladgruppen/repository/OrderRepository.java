/*
 * 
 * 
 * 
 */
package Chokladgruppen.repository;

import Chokladgruppen.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alenj
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders,Long>{
    
}
