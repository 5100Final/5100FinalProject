/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.service;

import Business.dao.CustomerDao;
import Business.model.order.PayMethod;
import Business.model.user.Customer;
import java.util.List;

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

    public int updateMethodByName(String username, String method, String number, String expir) {
        return cusDao.updateMethodByName(username,method,number,expir);
    }
    public int addMethod(String username, String method, String number, String expir) {
        return cusDao.addMethod(username,method,number,expir);
    }

    public List<PayMethod> getPayListByName(String username) {
       return cusDao.getPayListByName(username);
    }

    public int updateMethodById(PayMethod method) {
        return cusDao.updateMethodById(method);
    }

    public int deletedById(Integer id) {
       return cusDao.deletedById(id);
    }
}
