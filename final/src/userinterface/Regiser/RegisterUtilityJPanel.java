/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.Regiser;

import Business.model.user.User;
import Business.service.UserService;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static userinterface.MainJFrame.infoBox;

/**
 *
 * @author Frank
 */
public class RegisterUtilityJPanel extends javax.swing.JPanel {
        String type;
        String role;
    /**
     * Creates new form RegisterUtilityJPanel
     */
    public RegisterUtilityJPanel() {
        initComponents();
        type = "Customer";
        role = "Customer";
        
        cbxType.addItem("Customer");
        cbxType.addItem("Utility");
        cbxType.addItem("Tax");
        cbxType.addItem("Medical");
        cbxType.addItem("Public");
        
       cbxType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // 选择的下拉框选项
                    type = (String) e.getItem();
                    cbxRole.removeAllItems();
                    if(e.getItem().equals("Utility")){
                            cbxRole.addItem("Water");
                            cbxRole.addItem("Gas");
                            cbxRole.addItem("Electricity");
                    }else if(e.getItem().equals("Tax")){
                            cbxRole.addItem("Income Tax");
                            cbxRole.addItem("Property Tax");
                    }else if(e.getItem().equals("Medical")){
                           cbxRole.addItem("Medical Bill");
                           cbxRole.addItem("Insurance fee");
                    }else if(e.getItem().equals("Public")){
                           cbxRole.addItem("Traffic Ticket");
                           cbxRole.addItem("Other vloation ticket");
                    }else if(e.getItem().equals("Customer")){
                           cbxRole.addItem("Customer");
                    }
                  }
                }
          });
       
       cbxRole.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                 if (e.getStateChange() == ItemEvent.SELECTED) {
                     role = (String) e.getItem();
                 }  
            }   
       });
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUserName1 = new javax.swing.JLabel();
        lblPassword1 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        cbxType1 = new javax.swing.JComboBox<>();
        txtUserName1 = new javax.swing.JTextField();
        btnBack1 = new javax.swing.JButton();
        psdPassword1 = new javax.swing.JPasswordField();
        btnRegist1 = new javax.swing.JButton();
        lblTitle1 = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        lblType1 = new javax.swing.JLabel();
        cbxRole1 = new javax.swing.JComboBox<>();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        cbxType = new javax.swing.JComboBox<>();
        txtUserName = new javax.swing.JTextField();
        psdPassword = new javax.swing.JPasswordField();
        btnRegist = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        cbxRole = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        lblUserName1.setText("User Name:");

        lblPassword1.setText("Password:");

        cbxType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBack1.setText("<<Back");

        btnRegist1.setText("Regist");

        lblTitle1.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        lblTitle1.setText("Register for Utility,tax,public,medical");

        lblName1.setText("Name:");

        lblType1.setText("Type:");

        cbxRole1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack1)
                        .addComponent(lblTitle1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(lblPassword1))
                                            .addComponent(lblUserName1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(30, 30, 30)
                                            .addComponent(lblType1)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(psdPassword1)
                                        .addComponent(txtUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(btnRegist1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblName1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxType1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(2, 2, 2)))
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(249, 249, 249)
                    .addComponent(cbxRole1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(250, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnBack1)
                .addGap(18, 18, 18)
                .addComponent(lblTitle1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName1)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblType1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName1)
                    .addComponent(txtUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword1)
                    .addComponent(psdPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegist1)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(191, 191, 191)
                    .addComponent(cbxRole1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(191, Short.MAX_VALUE)))
        );

        lblUserName.setText("User Name:");

        lblPassword.setText("Password:");

        btnRegist.setText("Regist");
        btnRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        lblTitle.setText("Register ");

        lblType.setText("Type:");

        cbxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer" }));

        jLabel2.setText("Select role for your account:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblPassword))
                                    .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(lblType)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(psdPassword)
                                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(btnRegist)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(lblTitle)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(psdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegist)
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistActionPerformed
        // TODO add your handling code here:
        String userName = txtUserName.getText();
        String pwd =  new String(psdPassword.getPassword());
      
        User user = new User();
        user.setUsername(userName);
        user.setPassword(pwd);
        user.setRole(role);
        user.setType(type);
        user.setLocation("1");
        user.setCompanyId(111);
        
        UserService us = new UserService();
        boolean flag = us.addUser(user);
        
       if(flag){
           infoBox("User register success!!", "Valid");
       }else{
           infoBox("User name exist,please Check!!", "Valid");
       }
    }//GEN-LAST:event_btnRegistActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnRegist;
    private javax.swing.JButton btnRegist1;
    private javax.swing.JComboBox<String> cbxRole;
    private javax.swing.JComboBox<String> cbxRole1;
    private javax.swing.JComboBox<String> cbxType;
    private javax.swing.JComboBox<String> cbxType1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblType1;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserName1;
    private javax.swing.JPasswordField psdPassword;
    private javax.swing.JPasswordField psdPassword1;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserName1;
    // End of variables declaration//GEN-END:variables
}
