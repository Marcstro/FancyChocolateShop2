

package Chokladgruppen.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long orderId;
    public Date date;
    private double price;
    
    @ManyToOne(cascade=MERGE )
    public Person person;
    
    @OneToMany(cascade=MERGE , mappedBy="orders")
    private List<OrderDetails> orderDetails = new ArrayList();

    public Orders() {
        this.date = new Date();
    }

    

    public Orders(Person person) {
        this.date = new Date();
        this.person = person;
    }
    
    

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    

//    @Override
//    public String toString() {
//        return "Orders{" + "orderId=" + orderId + ", date=" + date + ", price=" + price + '}';
//    }

//    @Override
//    public String toString() {
//        return "Orders{" + "orderId=" + orderId + ", date=" + date + ", price=" + price + ", person=" + person + ", orderDetails=" + orderDetails + '}';
//    }
    
    
//    OBS OBS VILL DU ATT DENNA SKA SKRIVA UT ORDERDETAILS SA TA TA BORT KOMMENTARSAKERNA FOR TOsTRING OVAN
    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", date=" + date + ", price=" + price + ", person=" + person + '}';
    }
    
    
    
    

}
