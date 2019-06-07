package Chokladgruppen.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CustomerAndCart {

    private Person person;
    private List<Chocolate> cart = new ArrayList();

    public CustomerAndCart() {
    }

    public CustomerAndCart(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Chocolate> getCart() {
        return cart;
    }

    public void setCart(List<Chocolate> cart) {
        this.cart = cart;
    }
}
