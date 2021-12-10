/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.service;

import Business.dao.OrderDao;
import Business.model.order.Order;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Animal
 */
public class OrderService {
   OrderDao orderDao = new OrderDao();
 
    public  List<Order> getListById(String id) {
        return orderDao.getListByCompanyId(id);
    }
    public Order getOrderById(String id) {
        return orderDao.getOrderById(id);
    }
    
    public int addOrder(Order order) {
	return orderDao.addOrder(order);
    }

    public List<Order> getAllList() {
        return orderDao.getAll();
    }

    public int modifyById(Order order) {
      return  orderDao.modifyById(order);
    }

    public int deletedById(String id) {
       return orderDao.deletedById(id);
    }

    public List<Order> getListByCus(String username) {
       return orderDao.getListByCus(username);
    }

    public int finishPay(String id) {
      return  orderDao.finishPay(id);
    }
}
