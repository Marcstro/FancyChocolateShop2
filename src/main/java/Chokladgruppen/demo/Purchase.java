package Chokladgruppen.demo;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Purchase {

    private Person person;
    private List<Chocolate> chocolates;

    public Purchase() {
    }

    public Purchase(Person person, List<Chocolate> chocolates) {
        this.person = person;
        this.chocolates = chocolates;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Chocolate> getChocolates() {
        return chocolates;
    }

    public void setChocolates(List<Chocolate> chocolates) {
        this.chocolates = chocolates;
    }
}
