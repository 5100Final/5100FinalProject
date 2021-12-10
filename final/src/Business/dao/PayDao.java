/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.dao;

import Business.model.order.Order;
import Business.model.order.PayMethod;
import Business.util.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Animal
 */
public class PayDao {
    QueryRunner queryRunner = new QueryRunner();
    Connection connection = DBUtil.getConn();
     
    public List<PayMethod> getListByUser(String username) {
     	        String sql = "select * from orders where username = ? ";
                
		Object[] params = {username};
		try {
			List<PayMethod> methods = (List<PayMethod>)queryRunner.query(connection, sql,new BeanListHandler(PayMethod.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  methods;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} 
                
                return null;
    }
    
}
