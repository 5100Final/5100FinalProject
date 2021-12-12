/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.CustomerRole;

import Business.model.order.Order;
import Business.model.order.PayMethod;
import Business.model.user.Customer;
import Business.model.user.User;
import Business.service.CustomerService;
import Business.service.OrderService;
import Business.service.UserService;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import static userinterface.MainJFrame.infoBox;

/**
 *
 * @author Frank
 */
public class CustomerPaymentMethodJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerPaymentMethod
     */
    private JSplitPane splitPanel;
    private CustomerService cs;
    private OrderService os;
    private UserService us;
    private User user;
    private String method;
    public CustomerPaymentMethodJPanel(JSplitPane splitPanel, User user) {
        initComponents();
        this.splitPanel = splitPanel;
        this.user = user;
        this.cs = new CustomerService();
        this.os = new OrderService();
        this.us = new UserService();
        
         preWork(user);
         
        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {  
                 if (e.getStateChange() == ItemEvent.SELECTED) {
                     method = (String)e.getItem();
                 }           
            }   
       });  
    }
    public void populateTable(String name){
        
          List<PayMethod> list = cs.getPayListByName(name);
          DefaultTableModel payModel = (DefaultTableModel) tblPaymentMethod.getModel();
     
          payModel.setRowCount(0);
            
          for(PayMethod method:list){
            Object[] row = new Object[4];
            row[0] = method.getId();
            row[1] = method.getCardNumber();
            row[2] = method.getMethod();
            row[3] = method.getExpire();
            payModel.addRow(row);
         }
          
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaymentMethod = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtAccountNumber = new javax.swing.JTextField();
        txtExpiration = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Manage Payment Method:");

        btnBack.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblPaymentMethod.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblPaymentMethod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Number", "Method", "Expiration  "
            }
        ));
        jScrollPane1.setViewportView(tblPaymentMethod);

        btnDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnChange.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnChange.setText("Save");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Method:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Account Number:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Expiration:");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "paypal", "credit card", "ali Pay" }));

        txtAccountNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAccountNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountNumberActionPerformed(evt);
            }
        });

        txtExpiration.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnDelete)
                            .addGap(314, 314, 314)
                            .addComponent(btnChange))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAccountNumber, txtExpiration});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnChange))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CustomerWorkAreaJPanel cw = new CustomerWorkAreaJPanel(splitPanel,user);
        splitPanel.setRightComponent(cw);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtAccountNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccountNumberActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String number =  txtAccountNumber.getText();
        String expir = txtExpiration.getText();
        
        if(cs.addMethod(user.getUsername(),method,number,expir)>0){
              infoBox("Create pay method success!!", "Valid");
              populateTable(user.getUsername());
        }else{
              infoBox("Create pay method fail!!", "invalid");
        };
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblPaymentMethod.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        PayMethod method = new PayMethod();
        method.setId((Integer)tblPaymentMethod.getValueAt(selectedRow, 0)); 
        method.setCardNumber((String)tblPaymentMethod.getValueAt(selectedRow, 1)); 
        method.setMethod((String)tblPaymentMethod.getValueAt(selectedRow, 2));
        method.setExpire((String)tblPaymentMethod.getValueAt(selectedRow, 3));
        
       if( cs.updateMethodById(method)>0){
              infoBox("Modify pay method success!!", "Valid");
              populateTable(user.getUsername());
       }else{
              infoBox("Modify pay method fail!!", "invalid");
       };
        
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPaymentMethod.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        Integer id = (Integer)tblPaymentMethod.getValueAt(selectedRow, 0);
        
         if( cs.deletedById(id)>0){
              infoBox("deleted pay method success!!", "Valid");
        }else{
              infoBox("deleted pay method fail!!", "invalid");
        }
         populateTable(user.getUsername());
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPaymentMethod;
    private javax.swing.JTextField txtAccountNumber;
    private javax.swing.JTextField txtExpiration;
    // End of variables declaration//GEN-END:variables

    private void preWork(User user) {
        populateTable(user.getUsername());
    }
}
