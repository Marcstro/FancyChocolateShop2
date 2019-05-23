/*
 * 
 * 
 * 
 */
package Chokladgruppen.repository;

import Chokladgruppen.domain.Chocolate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alenj
 */
@Repository
public interface ChokladRepository extends JpaRepository<Chocolate,Long>{
        
}

