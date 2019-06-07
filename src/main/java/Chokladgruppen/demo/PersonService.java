package Chokladgruppen.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonService {

    @Autowired
    PersonRepository repository;

    Person getPerson(long id) {
        return repository.findById(id).get(0);
    }

    Iterable<Person> getAllPerson() {
        return repository.findAll();
    }

    Person findPersonByName(String name, String password) {
        Person person = null;

        for (Person p : getAllPerson()) {
            if (name.equalsIgnoreCase(p.getUserName())) {
                if (password.equalsIgnoreCase(p.getPassword())) {
                    person = p;
                    break;
                }
            }
        }

        return person;
    }
}
