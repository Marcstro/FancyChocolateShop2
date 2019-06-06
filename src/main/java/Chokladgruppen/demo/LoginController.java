package Chokladgruppen.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    
    private final PersonService personService;
    
    @Autowired
    LoginController(final PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/")
    public String index() {
        return "html/login.html";
    }

    // Denna kan nu returnera en json.
    //Retrunerar en person, null om personen inte finns
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    ResponseEntity<Person> CheckNameAndPWForLogin(@RequestBody LoginPerson loginCheckPerson) {
        return ResponseEntity.ok(personService.findPersonByName(loginCheckPerson.getUserName(), loginCheckPerson.getPassword()));
    }
    
    // Returnerar en String
    @RequestMapping(method = RequestMethod.GET, value = "/testGet")
    @ResponseBody
    public String test() {
        System.out.println("Inne i test! (Get)");
        return "html/products.html";
    }
    
    
    // Returnerar en Json
    @RequestMapping(method = RequestMethod.GET, value = "/testGetJson")
    @ResponseBody
    public LoginReplyA testGetJson() {
        System.out.println("Inne i testGetJson!");
        LoginReplyA lReply = new LoginReplyA();
        lReply.setUserName("JnyGetJson");
        lReply.setPassword("PassGetJson");
        return lReply;
    }
    
    
    


    
    // De nedan kanske inte fungerar. Antagligen inte.
    @RequestMapping("/index")
    public String index2() {
        return "html/login.html";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "html/admin.html";
    }

    @RequestMapping("/registration")
    public String registration() {
        return "html/registration.html";
    }

    @RequestMapping("/cart")
    public String cart() {
        return "html/cart.html";
    }

    @RequestMapping("/products")
    public String products() {
        return "html/products.html";
    }

}
