package Chokladgruppen.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping
    public Iterable<Person> getPersons() {
        return service.getAllPerson();
    }

    @GetMapping("/{id}")
    public Person getPersonId(@PathVariable Long id) {
        return service.getPerson(id);
    }
}
