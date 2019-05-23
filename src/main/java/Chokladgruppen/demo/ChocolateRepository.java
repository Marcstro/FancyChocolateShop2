/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcu
 * aer awesome
 */

package Chokladgruppen.demo;

import Chokladgruppen.demo.Chocolate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface ChocolateRepository extends CrudRepository<Chocolate, Long> {

    List<Chocolate> findByName(String name);
    
    List<Chocolate> findByPriceLessThan(double price);

}
