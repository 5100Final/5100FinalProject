/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.dao;

import Business.model.order.Order;
import Business.model.order.PayMethod;
import Business.model.user.Customer;
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
public class CustomerDao {
     QueryRunner queryRunner = new QueryRunner();
     Connection connection = DBUtil.getConn();
     
     public void addCus(String name) {
                String sql = "insert into customer(username,photo) values(?,?)";
		
                String path = "src/photo/default.jpg";
		Object[] params = {name,path‪};
		
		try { 
			queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}   
     }

    public int updateCus(Customer cus) {
              QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "update customer set birthday = ?,phone = ?,addr = ?,ssn = ?, email =?,photo =? where username = ? ";
		Object[] params = {cus.getBirthday(),cus.getPhone(),cus.getAddr(),cus.getSsn(),cus.getEmail(),cus.getUsername(),cus.getPhoto()};      
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return 0;
    }

    public Customer getCusByName(String username) {
          String sql = "select * from customer where username = ? ";
		Object[] params = {username};
		try {
			Customer cus = (Customer)queryRunner.query(connection, sql,new BeanHandler(Customer.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  cus;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }

    
 public int addMethod(String username, String method, String number, String expir) {
                QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "insert into pay_method(username,method,card_number,expire) values(?,?,?,?) ";
		Object[] params = {username,method,number,expir};      
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return 0;
    }
    public int updateMethodByName(String username, String method, String number, String expir) {
               QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "update pay_method set pay_method = ?,card_number = ?,expir = ? where username = ? ";
		Object[] params = {method,number,expir,username};      
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return 0;
    }

    public List<PayMethod> getPayListByName(String username) {
                String sql = "select * from pay_method where username = ? ";
                
		Object[] params = {username};
		try {
			List<PayMethod> payMethods = (List<PayMethod>)queryRunner.query(connection, sql,new BeanListHandler(PayMethod.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  payMethods;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }

    public int updateMethodById(PayMethod method) {
                QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "update pay_method set method = ?,card_number = ?,expire = ? where id = ? ";
		Object[] params = {method.getMethod(),method.getCardNumber(),method.getExpire(),method.getId()};      
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return 0;
    }

    public int deletedById(Integer id) {
                QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = " delete from pay_method where id=?";
		Object[] params = {id};      
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return 0;
    }

    public void updatePhoto(String path, String username) {
         QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "update customer set photo = ? where username = ? ";
		Object[] params = {path,username};      
		try { 
			queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }
    
}
