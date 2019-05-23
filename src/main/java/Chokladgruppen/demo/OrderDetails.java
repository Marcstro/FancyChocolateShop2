

package Chokladgruppen.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetails {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int amount;

    public OrderDetails() {
    }

    public OrderDetails(int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    

    @Override
    public String toString() {
        return "OrderDetails{" + "id=" + id + ", amount=" + amount + '}';
    }
    
    

}
