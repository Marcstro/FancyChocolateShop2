package Chokladgruppen.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final PersonService personService;

    @Autowired
    RegistrationController(final PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseBody
    boolean postResult(@RequestBody Registration registration) {
        if (registration == null) {
            System.out.println("objektet är null");
        }

        Person nyPerson = new Person();
        nyPerson.setName(registration.getName());
        nyPerson.setAddress(registration.getAddress());
        nyPerson.setPassword(registration.getPassword());
        nyPerson.setUserName(registration.getUserName());
        nyPerson.setPremium(false);
        nyPerson.setAdmin(false);

        personService.repository.save(nyPerson);

        return true;
    }
}
