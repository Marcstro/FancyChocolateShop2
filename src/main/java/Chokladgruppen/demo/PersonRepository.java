/*
 * 
 * 
 * 
 */
package Chokladgruppen.demo;

import Chokladgruppen.demo.Person;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marcu
 */
public interface PersonRepository extends CrudRepository<Person, Long>{
    
    List<Person> findByName(String name);
    
    List<Person> findByPremiumTrue();
    
    List<Person> findById(long id);
    
}
