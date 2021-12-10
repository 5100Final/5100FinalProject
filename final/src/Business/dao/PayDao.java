/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.dao;

import Business.model.order.Order;
import Business.model.order.PayMethod;
import Business.model.user.CountVO;
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
     	        String sql = "select * from pay_method where username = ? ";
                
		Object[] params = {username};
		try {
			List<PayMethod> methods = (List<PayMethod>)queryRunner.query(connection, sql,new BeanListHandler(PayMethod.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  methods;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}       
                return null;
    }

    public List<PayMethod> getNumberByMethod(String method,String username) {
           String sql = "select * from pay_method where username = ? and method = ?";
                
		Object[] params = {username,method};
		try {
			List<PayMethod> methods = (List<PayMethod>)queryRunner.query(connection, sql,new BeanListHandler(PayMethod.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  methods;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}       
                return null;
    }

    public List<CountVO> getPie(String username) {
        
                 String sql = "SELECT r2.type,SUM(r1.fee) sum FROM orders r1 join user r2  ON  r2.username = r1.company_id where  r1.user_id = ? GROUP BY r2.type";
                
		Object[] params = {username};
		try {
			List<CountVO> pie = (List<CountVO>)queryRunner.query(connection, sql,new BeanListHandler(CountVO.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
                        return  pie;
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}       
                return null;
    }
    
}
