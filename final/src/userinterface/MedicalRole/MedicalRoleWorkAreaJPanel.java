/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.MedicalRole;


import Business.model.order.Order;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author raunak
 */
public class MedicalRoleWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
 
    private JSplitPane splitPanel;
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public MedicalRoleWorkAreaJPanel(JSplitPane jsplitPanel) {
        initComponents();
        
        //this.userProcessContainer = userProcessContainer;
        this.splitPanel = jsplitPanel;
      
    }
    
    public void populateTable(){
        
 
        DefaultTableModel orderModel = (DefaultTableModel) tblBill.getModel();
     
        orderModel.setRowCount(0);
           
        List<Order> list = new ArrayList<>();
         
          for(Order order:list){
            Object[] row = new Object[4];
            row[0] = order.getAddr();
            row[1] = order.getCompanyId();
            row[2] = order.getDdl();
            row[3] = order.getStatus();
          
            orderModel.addRow(row);
         }
    }
 public void populateTable(Order order){
        
 
        DefaultTableModel orderModel = (DefaultTableModel) tblBill.getModel();
     
        orderModel.setRowCount(0);
           
            Object[] row = new Object[4];
             row[0] = order.getAddr();
            row[1] = order.getCompanyId();
            row[2] = order.getDdl();
            row[3] = order.getStatus(); 
          
            orderModel.addRow(row);
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        btnFind = new javax.swing.JButton();
        txtFindBillNumber = new javax.swing.JTextField();
        lblBillNumber = new javax.swing.JLabel();
        btnNewBill = new javax.swing.JButton();
        lblOrganization = new javax.swing.JLabel();
        lblCompanyName = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Bill Number", "Patient", "Total Amount", "Status", "Payment Due"
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
        if (tblBill.getColumnModel().getColumnCount() > 0) {
            tblBill.getColumnModel().getColumn(0).setResizable(false);
            tblBill.getColumnModel().getColumn(1).setResizable(false);
            tblBill.getColumnModel().getColumn(2).setResizable(false);
            tblBill.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 420, 130));

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 70, 30));

        txtFindBillNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindBillNumberActionPerformed(evt);
            }
        });
        add(txtFindBillNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 120, 30));

        lblBillNumber.setText("Bill Number:");
        add(lblBillNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 80, 30));

        btnNewBill.setText("New Bill");
        add(btnNewBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, -1, -1));

        lblOrganization.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        lblOrganization.setText("Medical");
        add(lblOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        lblCompanyName.setText("<value>");
        add(lblCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

     
    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
       
    }//GEN-LAST:event_btnFindActionPerformed
 
    private void txtFindBillNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindBillNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindBillNumberActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNewBill;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JTable tblBill;
    private javax.swing.JTextField txtFindBillNumber;
    // End of variables declaration//GEN-END:variables
}
