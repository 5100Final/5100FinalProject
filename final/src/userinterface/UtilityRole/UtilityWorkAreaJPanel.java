/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.UtilityRole;

import Business.model.order.Order;
import Business.model.user.User;
import Business.service.OrderService;
import Business.service.UserService;
import Business.util.Validation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frank
 */
public class UtilityWorkAreaJPanel extends javax.swing.JPanel {
  
    private JSplitPane splitPanel;
    private OrderService orderService ;
     private UserService userService ;
    private User user;
    /**
     * Creates new form UtilityWorkAreaJPanel
     */
    public UtilityWorkAreaJPanel(JSplitPane splitPanel,User user) {
        initComponents();
        this.splitPanel = splitPanel;
        this.user = user;
        orderService = new OrderService();
        userService = new UserService();
        preWork(user);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOrganization = new javax.swing.JLabel();
        lblCompanyName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        btnFind = new javax.swing.JButton();
        txtFindBillNumber = new javax.swing.JTextField();
        lblBillNumber = new javax.swing.JLabel();
        btnNewBill = new javax.swing.JButton();
        btnAll = new javax.swing.JButton();

        lblOrganization.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblOrganization.setText("Public Service");

        lblCompanyName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCompanyName.setText("<value>");

        tblBill.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Bill Number", "User", "Total Amount", "Status", "Payment Due"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBill);

        btnFind.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        txtFindBillNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFindBillNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindBillNumberActionPerformed(evt);
            }
        });

        lblBillNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblBillNumber.setText("Bill Number:");

        btnNewBill.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnNewBill.setText("New Bill");
        btnNewBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBillActionPerformed(evt);
            }
        });

        btnAll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAll.setText("List All");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrganization)
                        .addGap(17, 17, 17)
                        .addComponent(lblCompanyName))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtFindBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAll))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNewBill)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAll, btnFind});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrganization)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblCompanyName)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFindBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAll, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNewBill)
                .addContainerGap(147, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if(txtFindBillNumber.getText()!=null && Validation.isValidInt(txtFindBillNumber.getText())){
            List<Order> orders = new ArrayList<>();
            orders.add(orderService.getOrderById(txtFindBillNumber.getText()));
            populateTable(orders);
        }       
        
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtFindBillNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindBillNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindBillNumberActionPerformed

    private void btnNewBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBillActionPerformed
        // TODO add your handling code here:
        UtilityBillProcessJPanel ub = new UtilityBillProcessJPanel(splitPanel,user);
        splitPanel.setRightComponent(ub);
    }//GEN-LAST:event_btnNewBillActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        // TODO add your handling code here:
         List<Order> list  = orderService.getListByCompanyId(user.getUsername());
        populateTable(list);
    }//GEN-LAST:event_btnAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNewBill;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JTable tblBill;
    private javax.swing.JTextField txtFindBillNumber;
    // End of variables declaration//GEN-END:variables

    private void preWork(User user) {
        lblOrganization.setText(user.getType()+" Service");
        lblCompanyName.setText(user.getUsername());
        List<Order> list  = orderService.getListByCompanyId(user.getUsername());
        populateTable(list);
    }
    
    public void populateTable(List<Order> orders){
        
          DefaultTableModel orderModel = (DefaultTableModel) tblBill.getModel();
     
          orderModel.setRowCount(0);

          for(Order order:orders){
            Object[] row = new Object[5];
            row[0] = order.getId();
            row[1] = order.getUserId();
            row[2] = order.getFee();
            row[3] = order.getStatus();
            row[4] = order.getDdl();
            orderModel.addRow(row);
         }
    }
}
