package Chokladgruppen.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class LoginController {
    @RequestMapping("/")
    public String index() {
        return "html/cart.html";
    }
    
    @RequestMapping("/admin")
    public String admin() {
        return "html/admin.html";
    }
}
