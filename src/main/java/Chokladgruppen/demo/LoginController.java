package Chokladgruppen.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String index() {
        return "html/login.html";
    }

    // Denna kan nu returnera en json.
    @RequestMapping(method = RequestMethod.POST, value = "/test")
    @ResponseBody
    ResponseEntity<LoginReply> test(@RequestBody LoginPerson loginCheckPerson) {
        System.out.println("LoginController!");
        System.out.println(loginCheckPerson.getUserName());
        LoginReply lReply = new LoginReply();
        lReply.setUserName(loginCheckPerson.getUserName());
        lReply.setPassword(loginCheckPerson.getPassword());
        return ResponseEntity.ok(lReply);
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
    public LoginReply testGetJson() {
        System.out.println("Inne i testGetJson!");
        LoginReply lReply = new LoginReply();
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
