/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.model.order;

import lombok.Data;

/**
 *
 * @author Animal
 */
@Data
public class PayMethod {
    private int id;
    private String username;
    private String method;
    private String cardNumber;
    private String expire;
}
