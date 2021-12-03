/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  Business.util;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Animal
 */
public class DBUtil {
    private static final String USER = "root";
    private static final String PWD = "root";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/5100DB?useSSL=true";
    private static Statement stmt;
    private static Connection con;
    private static DBUtil utils = null;
    private static PreparedStatement pstmt;

    private DBUtil() {
    }

    public static synchronized DBUtil getDBUtil() {
        if (utils == null) {
            utils = new DBUtil();
            return utils;
        } else {
            return utils;
        }
    }

    public static Connection getConn() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PWD);
            } catch (Exception var1) {
                var1.printStackTrace();
            }
        }

        return con;
    }

    public static Statement getStatement() {
        if (stmt == null) {
            try {
                if (con == null) {
                    con = getConn();
                }

                stmt = con.createStatement();
            } catch (Exception var1) {
                var1.printStackTrace();
            }
        }

        return stmt;
    }

    public static PreparedStatement getPstmt(String sql) {
        if (pstmt == null) {
            try {
                pstmt = con.prepareStatement(sql);
            } catch (SQLException var2) {
                var2.printStackTrace();
            }
        }

        return null;
    }
}