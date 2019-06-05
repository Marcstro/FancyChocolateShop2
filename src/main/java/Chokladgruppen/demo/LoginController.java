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
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    ResponseEntity<Person> CheckNameAndPWForLogin(@RequestBody LoginPerson loginCheckPerson) {
        System.out.println("LoginController!");
        System.out.println("Du har forsokt logga in som "  + loginCheckPerson.getUserName());
        // System.out.println("LoginController!");
//        loginReply lReply = new loginReply();
//        lReply.setUserName(loginCheckPerson.getUserName());
//        lReply.setPassword(loginCheckPerson.getPassword());
//        System.out.println(lReply.toString());
        //System.out.println(loginCheckPerson.getUserName());
        
        Person p2 = null;
        
        for(Person p: personService.getAllPerson()){
            //System.out.println(p.getUserName() + ", " + p.getPassword());
            if(loginCheckPerson.getUserName().equalsIgnoreCase(p.getUserName())){
                if(loginCheckPerson.getPassword().equalsIgnoreCase(p.getPassword())){
                    p2=p;
                    System.out.print("Korrekt user and pw, logged in as:");
                    System.out.println(p.getName());
                    break;
                }
            }
        }
//        if(p2==null){
//            p2=new Person();
//            p2.setUserName("WRONG");
//        }

        
        return ResponseEntity.ok(p2);
    }

    
    // Returnerar en String
    @RequestMapping(method = RequestMethod.GET, value = "/testGet")
    @ResponseBody
    public String test() {
        // System.out.println("Inne i test! (Get)");
        return "jny";
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
