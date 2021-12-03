/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.model.order;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Animal
 */
@Data
public class Order {
    private Date payTime;
    private Date ddl;
    private Integer id;
    private Integer fee;
    private Integer companyId;
    private Integer userId;
    
}
