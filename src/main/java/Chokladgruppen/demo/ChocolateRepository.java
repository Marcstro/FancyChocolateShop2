package Chokladgruppen.demo;

import Chokladgruppen.demo.Chocolate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ChocolateRepository extends CrudRepository<Chocolate, Long> {

    List<Chocolate> findByName(String name);

    List<Chocolate> findByPriceLessThan(double price);

    List<Chocolate> findById(long id);

    List<Chocolate> findByNameContainingIgnoreCase(String name);

}
