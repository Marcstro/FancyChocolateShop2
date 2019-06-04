package Chokladgruppen.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String address;
    private boolean admin;
    private boolean premium;

    @JsonIgnore
     @OneToMany(cascade=MERGE , mappedBy="person")
    private List<Orders> orders = new ArrayList();
     
     
    public Person() {
    }

    public Person(String name, String userName, String password, String address, boolean admin, boolean premium) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.admin = admin;
        this.premium = premium;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    
    
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + ", address=" + address + ", admin=" + admin + ", premium=" + premium + '}';
    }
    
    

}
