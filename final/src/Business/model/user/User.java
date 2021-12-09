/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.model.user;

import lombok.Data;

/**
 *
 * @author Animal
 */
@Data
public class User {
   private String username;
   private Integer id;
   private String type;
   private String location;        
   private String password;
   private Integer companyId;
   private String role;
}
