/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.model.user;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Animal
 */
@Data
public class Customer {
   
    private String username;
    private Date birthday;
    private String phone;
    private String email;
    private String payMethod;
    private String ssn;
    private String photo;
    private String cardNumber;
    private String expir;
    private String addr;
    
}
