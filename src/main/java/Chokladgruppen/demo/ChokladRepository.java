/*
 * 
 * 
 * 
 */
package Chokladgruppen.demo;

import Chokladgruppen.demo.Chocolate;
import java.util.List;
import javax.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alenj
 */
@Repository
public interface ChokladRepository extends CrudRepository<Chocolate,Long>{
    
    List<Chocolate> findByName(String name);
    
    //List<Chocolate> findById(long id);
        
    @Query("select u from Chocolate u where u.name = ?1 ")
    List<Chocolate> findBoth(String namn);
    
//    @NamedQuery(name = "Customer.Named",
//  query = "select u from Chocolate u where u.name = ?1")
}

