/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.dao;

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
public class UserDao {
   QueryRunner queryRunner = new QueryRunner();
   Connection connection = DBUtil.getConn();
   /*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 * ScalarHandler: 处理单个值，比如记录的个数
		 */
    public void addUser(User user) {
           	
		String sql = "insert into user(username,password,type,location,company_id) values(?,?,?,?,?)";
		
		Object[] params = {user.getUsername(),user.getPassword(),user.getType(),user.getLocation(),user.getCompanyId()};
		
		try { 
			queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
      public boolean checkNameAndPwd(String userName,String pwd) {
           	
		String sql = "select * from user where username = ? and password = ?";
		Object[] params = {userName,pwd};
		try {
			User user = (User)queryRunner.query(connection, sql,new BeanHandler(User.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                       return  user == null ? false:true ;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
             
                return false;
    }
        public int modifyUser(User user) {
           	
		 QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "update user set username = ?,password = ?,type = ?,location = ?,company_id = ? where id = ? ";
		Object[] params = {user.getUsername(),user.getPassword(),user.getType(),user.getLocation(),user.getCompanyId(),user.getId()};      
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return 0;
    }

    public User findUserByName(String name) {
                String sql = "select * from user where username = ? ";
		Object[] params = {name};
		try {
			User user = (User)queryRunner.query(connection, sql,new BeanHandler(User.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  user == null ? null:user;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }
}
