/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.service;

import Business.dao.CustomerDao;
import Business.model.user.Customer;

/**
 *
 * @author Animal
 */
public class CustomerService {
    CustomerDao cusDao = new CustomerDao();
    public void addCus(String name) {
        cusDao.addCus(name);
    }

    public int updateCus(Customer cus) {
        return cusDao.updateCus(cus);
    }

    public Customer getCusByName(String username) {
          return cusDao.getCusByName(username);
    }
    
}
