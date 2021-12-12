/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.dao;

import Business.model.user.CountVO;
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
public class UserDao {
   QueryRunner queryRunner = new QueryRunner();
   Connection connection = DBUtil.getConn();
   /*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 * ScalarHandler: 处理单个值，比如记录的个数
		 */
    public void addUser(User user) {
		String sql = "insert into user(username,password,type,location,company_id,role) values(?,?,?,?,?,?)";
		
		Object[] params = {user.getUsername(),user.getPassword(),user.getType(),user.getLocation(),user.getCompanyId(),user.getRole()};
		
		try { 
			queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}   
    }
     public boolean CheckName(String userName) {
           	
		String sql = "select * from user where username = ?";
		
		Object[] params = {userName};
		
		try { 
			User user = (User)queryRunner.query(connection, sql,new BeanHandler(User.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return user == null ? true : false;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}
                return true;
    }
     
      public User checkNameAndPwd(String userName,String pwd) {
           	
		String sql = "select * from user where username = ? and password = ?";
		Object[] params = {userName,pwd};
		try {
			User user = (User)queryRunner.query(connection, sql,new BeanHandler(User.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                       return  user;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
             
                return null;
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
 public int modifyUserByName(User user) {
           	
		 QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "update user set password = ?,type = ?,role = ? where username = ? ";
		Object[] params = {user.getPassword(),user.getType(),user.getRole(),user.getUsername(),};      
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

    public List<User> getListByType(String type) {
                String sql = "select * from user where type = ? ";
		Object[] params = {type};
		try {
			List<User> users = (List<User>)queryRunner.query(connection, sql,new BeanListHandler(User.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  users == null ? null:users;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }

    public int getIdByName(String cusName) {
        
               String sql = "select * from user where username = ? ";
		Object[] params = {cusName};
		try {
			User user = (User)queryRunner.query(connection, sql,new BeanHandler(User.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  user == null ? -1:user.getId();
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return -1;
                
    }

    public User getUserById(Integer userId) {
                String sql = "select * from user where id = ? ";
		Object[] params = {userId};
		try {
			User user = (User)queryRunner.query(connection, sql,new BeanHandler(User.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  user == null ? null:user;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }

    public List<User> getList() {
                 String sql = "select * from user";
		Object[] params = {};
		try {
			List<User> users = (List<User>)queryRunner.query(connection, sql,new BeanListHandler(User.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  users == null ? null:users;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }

    public int deletedByName(String name) {
      
                QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = " delete from user where username=?";
		Object[] params = {name};      
		try { 
			return queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return 0;
    }

    public String getTypeByName(String name) {
                String sql = "select * from user where username = ? ";
		Object[] params = {name};
		try {
			User user = (User)queryRunner.query(connection, sql,new BeanHandler(User.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  user == null ? null:user.getType();
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                return null;
    }

    public List<CountVO> getOrganRation() {
               String sql = "SELECT type,COUNT(type) sum FROM user where type != 'admin' and type != 'Customer' GROUP BY type ";
                
		Object[] params = {};
		try {
			List<CountVO> pie = (List<CountVO>)queryRunner.query(connection, sql,new BeanListHandler(CountVO.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  pie;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}       
                return null;
    }

    public void updatePhoto(String path,String username) {
         QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConn();
		
		String sql = "update user set photo = ? where username = ? ";
		Object[] params = {path,username};      
		try { 
			queryRunner.update(connection, sql,params);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
              
    }
}
