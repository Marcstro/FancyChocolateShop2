/*
 * 
 * 
 * 
 */
package Chokladgruppen.repository;

import Chokladgruppen.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alenj
 */
public interface PersonRepository extends JpaRepository<Person,Long>{

   
    
}
