

package Chokladgruppen.demo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long orderId;
    public Date date;
    private double price;

    public Orders() {
    }

    public Orders(Date date, double price) {
        this.date = date;
        this.price = price;
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
    
    

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", date=" + date + ", price=" + price + '}';
    }
    
    

}
