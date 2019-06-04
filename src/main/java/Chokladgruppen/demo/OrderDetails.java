

package Chokladgruppen.demo;

import Chokladgruppen.demo.Chocolate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int amount;
    
    //denna kanske behovs?
    //@JsonIgnore
    @OneToOne(cascade=MERGE)
    private Chocolate chocolate;
    
    //denna ocksa?
    //@JsonIgnore
    @ManyToOne(cascade=MERGE)
    public Orders orders;

    public OrderDetails() {
    }

    public OrderDetails(int amount) {
        this.amount = amount;
    }

    public OrderDetails(int amount, Chocolate chocolate, Orders orders) {
        this.amount = amount;
        this.chocolate = chocolate;
        this.orders = orders;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
    
    

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    

//    @Override
//    public String toString() {
//        return "OrderDetails{" + "id=" + id + ", amount=" + amount + '}';
//    }

    @Override
    public String toString() {
        return "OrderDetails{" + "id=" + id + ", amount=" + amount + ", chocolate=" + chocolate + ", orders=" + orders + '}';
    }
    
    
    
    

}
