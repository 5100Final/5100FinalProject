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
 
     private static boolean isValid(String s){
        return s.matches("^[A-Za-z0-9]+$");
    }
     private static boolean isValidString(String s){
        return s.matches("^[a-zA-Z]*$");
    }
     private static boolean isValidInt(String s){
        return s.matches("^[0-9]*$");
    }
     
    private static boolean isValidName(String s){
      return false;
    }
    
     private  static boolean isValidRole(String s){
         if(s.equals("Customer")||s.equals("Utility")||s.equals("Tax")||s.equals("Public")||s.equals("Medical")) return true;
         return false;
    }
}
