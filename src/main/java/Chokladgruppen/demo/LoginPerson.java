
package Chokladgruppen.demo;


public class LoginPerson {
    
    private String userName;
    private String password;

    public LoginPerson() {
        //System.out.println("Du har kommit till loginpersons tomma constructor");
    }
    
    public LoginPerson(String userName, String password) {
        this.userName = userName;
        this.password = password;
        System.out.println("Person skapats som heter " + userName);
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        //System.out.println("och har ar metoden serusernamn");
        this.userName = userName;
        //this.userName="MarcusTestUserName";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
