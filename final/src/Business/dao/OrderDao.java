/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.dao;

import Business.model.order.Order;
import Business.model.user.User;
import Business.util.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Animal
 */
public class OrderDao {
     QueryRunner queryRunner = new QueryRunner();
     Connection connection = DBUtil.getConn();
     
      public int addOrder(Order order) {
		String sql = "insert into orders(ddl,fee,company_id,user_id,status) values(?,?,?,?,?)";
		
		Object[] params = {order.getDdl(),order.getFee(),order.getCompanyId(),order.getUserId(),order.getStatus()};
		
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}   
                return 0;
    }


    public List<Order> getListByCompanyId(String id) {
          	String sql = "select * from orders where company_id = ? ";
                
		Object[] params = {id};
		try {
			List<Order> orders = (List<Order>)queryRunner.query(connection, sql,new BeanListHandler(Order.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  orders == null ? null:orders;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }

    public List<Order> getAll() {
              String sql = "select * from orders ";
                
		Object[] params = {};
		try {
			List<Order> orders = (List<Order>)queryRunner.query(connection, sql,new BeanListHandler(Order.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  orders == null ? null:orders;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }

    public int modifyById(Order order) {
                 QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "update orders set ddl = ?,company_id = ?,user_id = ?,fee = ?, status = ? where id = ? ";
		Object[] params = {order.getDdl(),order.getCompanyId(),order.getUserId(),order.getFee(),order.getStatus(),order.getId()};      
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return 0;
    }

    public int deletedById(String id) {
                QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = " delete from orders where id=?";
		Object[] params = {id};      
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return 0;
    }

    public List<Order> getListByCus(String username) {
                String sql = "select * from orders where user_id = ? and status != 'finished' ";
                
		Object[] params = {username};
		try {
			List<Order> orders = (List<Order>)queryRunner.query(connection, sql,new BeanListHandler(Order.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  orders == null ? null:orders;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }

    public Order getOrderById(String id) {
       
          String sql = "select * from orders where id = ? ";
		Object[] params = {id};
		try {
			Order order = (Order)queryRunner.query(connection, sql,new BeanHandler(Order.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  order;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
 
    }

    public int finishPay(String id) {
        
                QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "update orders set status = ? where id = ? ";
		Object[] params = {"finished",id};      
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return 0;
    }

    public List<Order> getListByType(String type, String username) {
                String sql = "SELECT DISTINCT r1.id,r1.user_id,r1.status,r1.company_id,r1.fee,r1.ddl FROM orders r1 join user r2  ON  r2.username = r1.company_id where r2.type = ? and r1.user_id = ? and r1.status != 'finished'";
                
		Object[] params = {type,username};
		try {
			List<Order> orders = (List<Order>)queryRunner.query(connection, sql,new BeanListHandler(Order.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  orders == null ? null:orders;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }

   
}
