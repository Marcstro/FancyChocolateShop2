/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcu
 * aer awesome
 */

package Chokladgruppen.demo;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;



//@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Registration {
    
    private String name;
    private String userName;
    private String password;
    private String address;

    
    public Registration(){
        System.out.println("du har kommit till registration klassen");
        System.out.println("namnet ar " + name);
        //name="";
    }

    public Registration(String name) {
        System.out.println("du har kommit till registration klassen OBS OBS NAMNET GES");
        //denna metod rors aldrig. har kvar for.. i dunno //marcus
        this.name = name;
    }

    public void setName(String name) {
        System.out.println("du har kommit till setName pa registration");
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    
    
    

}
