/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.ConfigureASystem;
import Business.model.user.User;
import Business.model.user.UserType;
import Business.util.DBUtil;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Business.service.UserService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.BasicRowProcessor;
import userinterface.CustomerRole.CustomerAreaJPanel;
import userinterface.DeliveryManRole.DeliveryManWorkAreaJPanel;
import userinterface.RestaurantAdminRole.AdminWorkAreaJPanel;
import static userinterface.RestaurantAdminRole.MenuManage.infoBox;
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

/**
 *
 * @author Lingfeng
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
//    private EcoSystem system;
//    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
   
    public MainJFrame() {
        
        initComponents();
        this.setSize(1680, 1050); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        loginJButton = new javax.swing.JButton();
        userNameJTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginJLabel = new javax.swing.JLabel();
        logoutJButton = new javax.swing.JButton();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userNameJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(logoutJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addGap(26, 26, 26)
                            .addComponent(loginJLabel)))
                    .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginJButton)
                .addGap(34, 34, 34)
                .addComponent(logoutJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginJLabel)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        container.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // Get user name
       
        String userName = userNameJTextField.getText();
        
        String pwd = new String(passwordField.getPassword());
        
       // UserAccount ua =   system.getUserAccountDirectory().authenticateUser(userName, pwd);
        
        
        
       UserService us = new UserService();
        
       User admin = us.findUserByName("admin");
       
       admin.setPassword("2333");
       
       System.out.print(us.modifyUser(admin));
           
//        User user = new User();
//        user.setUsername("hxx");
//        user.setLocation("123");
//        user.setCompanyId(123);
//        user.setPassword("222");
//        user.setType("customer");
//        
//        us.addUser(user);
   
     
        //Lombok
       // Food food = new Food("name",123);
        
      //  System.out.print(food.getPrice());
//                Statement stmt = DBUtil.getStatement();
////update
//                QueryRunner queryRunner = new QueryRunner();
//		Connection connection = DBUtil.getConn();
//		
//		String sql = "update admin set password = ? where username = ?";
//		Object[] params = {pwd,userName};      
//		try { 
//			queryRunner.update(connection, sql,params);
//			 infoBox("update success!!", "valid");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 


//add
//	        QueryRunner queryRunner = new QueryRunner();
//		Connection connection = DBUtil.getConn();
////		                                     start number
//		String sql = "insert into user(username,password) values(?,?,?)";
//		;
//		Object[] params = {userName,pwd};
//		/*
//		 * BeanListHandler:将结果集封装为list集合
//		 * BeanHandler：将结果集中的第一条记录封装为对象
//		 * ScalarHandler: 处理单个值，比如记录的个数
//		 */
//		try { 
//			queryRunner.update(connection, sql,params);
//                        infoBox("add success!!", "valid");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

//check
//                QueryRunner queryRunner = new QueryRunner();
//		Connection connection = DBUtil.getConn();
//
//		String sql = "select * from user where username = ? and password = ?";
//		Object[] params = {userName,pwd};
//		try {
//			User user = (User)queryRunner.query(connection, sql,new BeanHandler(User.class, new BasicRowProcessor(new GenerousBeanProcessor())),params);
//			// System.out.println(user.getUsername());
//                         //System.out.println(user.getPassword());
//                         System.out.println(user.getCompanyId());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
	
//        if(ua == null){
//           infoBox("User not exist! please check", "Invalid");
//           return;
//         }else{
//            if(ua.getRole() instanceof SystemAdminRole){
//                //管理员添加删除 下面所有的职员信息
//                SystemAdminWorkAreaJPanel systemPanel = new SystemAdminWorkAreaJPanel(jSplitPane1,system);
//                jSplitPane1.setRightComponent(systemPanel);
//
//            }else if(ua.getRole() instanceof ResAdminRole){
//                
//                
//               AdminWorkAreaJPanel adminPanel = new AdminWorkAreaJPanel(jSplitPane1,system,ua);
//               jSplitPane1.setRightComponent(adminPanel) ;
//               
//            }else if(ua.getRole() instanceof DeliverManRole){
//                
//               DeliveryManWorkAreaJPanel deliverPanel = new DeliveryManWorkAreaJPanel(jSplitPane1,ua,system);
//               jSplitPane1.setRightComponent(deliverPanel);
//               
//            }else if(ua.getRole() instanceof CustomerRole){
//                
//               CustomerAreaJPanel customerAreaPanel = new CustomerAreaJPanel(jSplitPane1,ua,system);
//               jSplitPane1.setRightComponent(customerAreaPanel);
//               
//            }
//            switchLogOut();
//        }
            
    }//GEN-LAST:event_loginJButtonActionPerformed
     private void switchLogOut() {
        logoutJButton.setEnabled(true);
        userNameJTextField.setEnabled(false);
        passwordField.setEnabled(false);
        loginJButton.setEnabled(false);
        
    }
    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);
    
        userNameJTextField.setText("");
        passwordField.setText("");
        
        jSplitPane1.setRightComponent(container);
        container.removeAll();
        JPanel blankJP = new JPanel();
        container.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
       
    }//GEN-LAST:event_logoutJButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loginJButton;
    private javax.swing.JLabel loginJLabel;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables

   
}
