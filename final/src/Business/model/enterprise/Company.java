/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.model.enterprise;

import lombok.Data;

/**
 *
 * @author Animal
 */
@Data
public class Company {
   private String name;
   private Integer id;
   private Integer pay;
   private Integer fee;
   private String location;
   
    public Company(String name) {
        this.name = name;
    }
   
}
