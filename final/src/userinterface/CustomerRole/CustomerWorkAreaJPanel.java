/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;


import java.awt.*;
import Business.model.order.Order;
import Business.model.order.PayMethod;
import Business.model.user.Customer;
import Business.model.user.User;
import Business.service.CustomerService;
import Business.service.OrderService;
import Business.service.PayService;
import Business.service.UserService;
import Business.util.BarChartEx;
import Business.util.Validation;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import static userinterface.MainJFrame.infoBox;
/**
 *
 * @author raunak
 */
public class CustomerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
       
    private JSplitPane splitPanel;
    private CustomerService cs;
    private OrderService os;
    private UserService us;
    private User user;
 
    /**
     * Creates new form RequestLabTestJPanel
     */
    public CustomerWorkAreaJPanel(JSplitPane splitPanel, User user) {
        initComponents();
        
        this.splitPanel = splitPanel;
        this.user = user;
        this.cs = new CustomerService();
        this.os = new OrderService();
        this.us = new UserService();
         preWork(user);

    }
    
    void preWork(User user){
         customerName.setText(user.getUsername());
         Customer cus =  cs.getCusByName(user.getUsername());
         
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File(cus.getPhoto()));
//            int width = 100;
//            int height = 100;
//            ImageIcon icon = new ImageIcon(img);
//            icon.setImage(icon.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
//            this.lblPhoto.setIcon(icon);
//        } catch (IOException e) {
//            infoBox("No Photo!", "Valid");
//        }

        populateInformation(cus);
        populateTable(os.getListByCus(user.getUsername()));       
    }
    public void populateInformation(Customer cus){
         SimpleDateFormat sdf =  new SimpleDateFormat( "MM/dd/yyyy" ); 
         if(cus != null){
                 txtAddress.setText(cus.getAddr());
           try{
             txtBirthday.setText(sdf.format(cus.getBirthday()));
               }catch(Exception e){
           return;
       }
       
            txtPhoneNumber.setText(cus.getPhone());
            txtEmail.setText(cus.getEmail());
            txtSSN.setText(cus.getSsn());
           }
    }
    
 public void populateTable(List<Order> orders){
        
          DefaultTableModel billModel = (DefaultTableModel) tblRecentBill.getModel();
     
          billModel.setRowCount(0);

          for(Order order:orders){
            Object[] row = new Object[5];
            row[0] = order.getId();
            row[1] = us.getTypeByName(order.getCompanyId());
            row[2] = order.getCompanyId();
            row[3] = order.getFee();
            row[4] = order.getDdl();
            billModel.addRow(row);
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

        enterpriseLabel = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblBirthday = new javax.swing.JLabel();
        txtBirthday = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSSN = new javax.swing.JLabel();
        txtSSN = new javax.swing.JTextField();
        lblPhoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecentBill = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnUtility = new javax.swing.JButton();
        btnTax = new javax.swing.JButton();
        btnMedical = new javax.swing.JButton();
        btnPublicService = new javax.swing.JButton();
        lblMore = new javax.swing.JLabel();
        bntPayBill = new javax.swing.JButton();
        btnChangeInfo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bntViewGraph = new javax.swing.JButton();
        btnPhoto = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Name:");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 30));

        customerName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        customerName.setText("<value>");
        add(customerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 130, -1));

        lblAddress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAddress.setText("Address:");
        add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        txtAddress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 160, -1));

        lblBirthday.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblBirthday.setText("Birthday:");
        add(lblBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtBirthday.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBirthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthdayActionPerformed(evt);
            }
        });
        add(txtBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 160, -1));

        lblPhoneNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");
        add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtPhoneNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 160, -1));

        lblEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEmail.setText("Email Address:");
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 160, -1));

        lblSSN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSSN.setText("SSN:");
        add(lblSSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 40, -1));

        txtSSN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(txtSSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 150, 20));

        lblPhoto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(lblPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 160, 150));

        tblRecentBill.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblRecentBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Bill Number", "Department ", "From", "Total Amount", "Due time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRecentBill);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 140));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Recent unpaid bill:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        btnUtility.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnUtility.setText("Utility");
        btnUtility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtilityActionPerformed(evt);
            }
        });
        add(btnUtility, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 100, -1));

        btnTax.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnTax.setText("Tax");
        btnTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaxActionPerformed(evt);
            }
        });
        add(btnTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 100, -1));

        btnMedical.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnMedical.setText("Medical");
        btnMedical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicalActionPerformed(evt);
            }
        });
        add(btnMedical, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 100, -1));

        btnPublicService.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPublicService.setText("Public Service");
        btnPublicService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicServiceActionPerformed(evt);
            }
        });
        add(btnPublicService, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 100, -1));

        lblMore.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMore.setText("More:");
        add(lblMore, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));

        bntPayBill.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bntPayBill.setText("View and Pay");
        bntPayBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPayBillActionPerformed(evt);
            }
        });
        add(bntPayBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 110, 30));

        btnChangeInfo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnChangeInfo.setText("Save Information");
        btnChangeInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeInfoActionPerformed(evt);
            }
        });
        add(btnChangeInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 200, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Management Payment method");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 200, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("ex:08/09/2021");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 115, -1, 10));

        bntViewGraph.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bntViewGraph.setText("View Pay Graph");
        bntViewGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntViewGraphActionPerformed(evt);
            }
        });
        add(bntViewGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 120, 30));

        btnPhoto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPhoto.setText("Chose Photo");
        btnPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhotoActionPerformed(evt);
            }
        });
        add(btnPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void btnChangeInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeInfoActionPerformed
         
           Date birth = null;
         try{
           SimpleDateFormat sdf =  new SimpleDateFormat( "MM/dd/yyyy" ); 
           birth =  sdf.parse(txtBirthday.getText()); 
         }catch(Exception e){
            infoBox("Date format wrong!!", "Valid");
            return;
         }
         
           Customer cus = new Customer();
           cus.setUsername(user.getUsername());
           cus.setAddr(txtAddress.getText());
           cus.setBirthday(birth);
           cus.setPhone(txtPhoneNumber.getText());
           cus.setEmail(txtEmail.getText());
           cus.setSsn(txtSSN.getText());
           
           if(check(cus)&&cs.updateCus(cus)>0){
                infoBox("Save information success!!", "Valid");
            }else{
                 infoBox("Save information fail!!", "invalid");
           }
                         
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChangeInfoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CustomerPaymentMethodJPanel cp = new CustomerPaymentMethodJPanel(splitPanel,user);
        splitPanel.setRightComponent(cp);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bntPayBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPayBillActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblRecentBill.getSelectedRow();
        
        if (selectedRow < 0){
             infoBox("Select a row!!", "invalid");
            return;
        }
        
        CustomerPayBillJPanel cp = new CustomerPayBillJPanel(splitPanel,user,tblRecentBill.getValueAt(selectedRow, 0)+"");
        splitPanel.setRightComponent(cp);
    }//GEN-LAST:event_bntPayBillActionPerformed

    private void txtBirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthdayActionPerformed

    private void btnUtilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtilityActionPerformed
        // TODO add your handling code here:
        
        populateTable(os.getListByType("Utility",user.getUsername()));
    }//GEN-LAST:event_btnUtilityActionPerformed

    private void btnPublicServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicServiceActionPerformed
        // TODO add your handling code here:
        populateTable(os.getListByType("Public",user.getUsername()));
    }//GEN-LAST:event_btnPublicServiceActionPerformed

    private void btnMedicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicalActionPerformed
        // TODO add your handling code here:
        populateTable(os.getListByType("Medical",user.getUsername()));
    }//GEN-LAST:event_btnMedicalActionPerformed

    private void btnTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaxActionPerformed
        // TODO add your handling code here:
        populateTable(os.getListByType("Tax",user.getUsername()));
    }//GEN-LAST:event_btnTaxActionPerformed

    private void bntViewGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntViewGraphActionPerformed
        // TODO add your handling code here:
         SwingUtilities.invokeLater(() -> {
            PayService p = new PayService();
            BarChartEx ex = new BarChartEx(p.getPie(user.getUsername()));
            ex.setVisible(true);
        });
    }//GEN-LAST:event_bntViewGraphActionPerformed

    private void btnPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhotoActionPerformed
        // TODO add your handling code here:
       
        JFileChooser imgChooser = new JFileChooser();
        imgChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
 
        imgChooser.showDialog(new JLabel(), "Chose");
        File file = imgChooser.getSelectedFile();
        String filepath = file.getPath();
        if(filepath.endsWith(".jpg") || filepath.endsWith(".png") || filepath.endsWith(".gif") ||
                filepath.endsWith(".JPG") || filepath.endsWith(".PNG") || filepath.endsWith(".GIF")) {
        
            
            cs.updatePhoto(file.getPath(),user.getUsername());
            us.updatePhoto(file.getPath(),user.getUsername());
            
         BufferedImage img = null;
        try {
            img = ImageIO.read(new File(file.getPath()));
            int width = 100;
            int height = 100;
            ImageIcon icon = new ImageIcon(img);
            icon.setImage(icon.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
            this.lblPhoto.setIcon(icon);
        } catch (IOException e) {
            infoBox("No Photo!", "Valid");
        }
        }
        else{
            infoBox("Wrong File!","invalid");
        }
    }//GEN-LAST:event_btnPhotoActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntPayBill;
    private javax.swing.JButton bntViewGraph;
    private javax.swing.JButton btnChangeInfo;
    private javax.swing.JButton btnMedical;
    private javax.swing.JButton btnPhoto;
    private javax.swing.JButton btnPublicService;
    private javax.swing.JButton btnTax;
    private javax.swing.JButton btnUtility;
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMore;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblSSN;
    private javax.swing.JTable tblRecentBill;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSSN;
    // End of variables declaration//GEN-END:variables

    private boolean check(Customer cus) {
        return Validation.isValid(cus.getAddr()) && Validation.isValidInt(cus.getSsn()) && Validation.isValidInt(cus.getPhone()) && cus.getEmail().contains("@") ;
        
    }
}
