/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Animal
 */
public class Validation {
 
     private boolean isValid(String s){
        return s.matches("^[A-Za-z0-9]+$");
    }
     private boolean isValidString(String s){
        return s.matches("^[a-zA-Z]*$");
    }
     private boolean isValidInt(String s){
        return s.matches("^[0-9]*$");
    }
     
    private boolean isValidName(String s){
      return false;
    }
    
     private boolean isValidRole(String s){
         if(s.equals("admin")||s.equals("customer")||s.equals("deliver")) return true;
         return false;
    }
}
