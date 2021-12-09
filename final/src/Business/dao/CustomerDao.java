/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.dao;

import Business.model.user.Customer;
import Business.model.user.User;
import Business.util.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 *
 * @author Animal
 */
public class CustomerDao {
     QueryRunner queryRunner = new QueryRunner();
     Connection connection = DBUtil.getConn();
     
     public void addCus(String name) {
                String sql = "insert into customer(username) values(?)";
		
		Object[] params = {name};
		
		try { 
			queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}   
     }

    public int updateCus(Customer cus) {
              QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "update customer set birthday = ?,phone = ?,addr = ?,ssn = ?, email =? where username = ? ";
		Object[] params = {cus.getBirthday(),cus.getPhone(),cus.getAddr(),cus.getSsn(),cus.getEmail(),cus.getUsername()};      
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
    
}
