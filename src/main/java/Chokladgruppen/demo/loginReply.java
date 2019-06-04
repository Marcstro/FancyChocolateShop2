
package Chokladgruppen.demo;

import lombok.ToString;


// Detta namn som NetBeans klagar på ev. Vill att man ska döpa om i terminalen/commandline
@ToString
public class loginReply {
    
    private String userName;
    private String password;
    private String loginStatus;
    // private String pageProducts = "html/products.html";

    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        //this.userName="MarcusSattUserName i loginreply";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

//    public String getPageProducts() {
//        return pageProducts;
//    }
//
//    public void setPageProducts(String pageProducts) {
//        this.pageProducts = pageProducts;
//    }
    
    
}
