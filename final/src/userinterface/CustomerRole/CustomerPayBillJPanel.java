/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;


import Business.model.order.Order;
import Business.model.order.PayMethod;
import Business.model.user.User;
import Business.service.CustomerService;
import Business.service.OrderService;
import Business.service.PayService;
import Business.service.UserService;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.application.Application;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import static userinterface.MainJFrame.infoBox;


/**
 *
 * @author raunak
 */
public class CustomerPayBillJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private JSplitPane splitPanel;
    private User user;
    private CustomerService cs;
    private OrderService os;
    private UserService us; 
    private PayService ps;
    private String method;
    private String orderId;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public CustomerPayBillJPanel(JSplitPane splitPanel, User user,String orderId) {
        initComponents();
        
     
        this.splitPanel = splitPanel;
        this.user = user;
        this.cs = new CustomerService();
        this.os = new OrderService();
        this.us = new UserService();
        this.ps = new PayService();
         this.orderId = orderId;
        preWork(orderId);
        
        cbxSelectPayment.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                 cbxSelectCard.removeAllItems();
                 if (e.getStateChange() == ItemEvent.SELECTED) {
                     method = (String)e.getItem();  
                     
                    List<PayMethod> list =  ps.getNumberByMethod(method,user.getUsername());
                    for(PayMethod pay:list){
                            cbxSelectCard.addItem(pay.getCardNumber());
                    }
                 }           
            }   
       });  
       
    }
    
    void preWork(String id){
         List<PayMethod> list =  ps.getListByUser(user.getUsername());
         Set<String> set = new HashSet<>();
         for(PayMethod pay:list){
             String method = pay.getMethod();
             if(set.add(method)){
                 cbxSelectPayment.addItem(method);
             } 
         }
         
         populateInformation(os.getOrderById(id));
          
    }
     private void populateInformation(Order order) {
      // setEditable(false)
        SimpleDateFormat sdf = new SimpleDateFormat( "MM/dd/yyyy" ); 
        txtDepartment.setText(us.getTypeByName(order.getCompanyId()));
        txtFrom.setText(order.getCompanyId());
        txtTotalAmount.setText(order.getFee()+"");
        txtPaymentDue.setText(sdf.format(order.getDdl()));
        txtBillNumber.setText(order.getId()+"");
        
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        enterpriseLabel1 = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        lblFrom = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        lblPaymentDue = new javax.swing.JLabel();
        lblSelectPayment = new javax.swing.JLabel();
        cbxSelectPayment = new javax.swing.JComboBox<>();
        lblBillNumber = new javax.swing.JLabel();
        btnPayment = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        cbxSelectCard = new javax.swing.JComboBox<>();
        txtDepartment = new javax.swing.JLabel();
        txtFrom = new javax.swing.JLabel();
        txtTotalAmount = new javax.swing.JLabel();
        txtPaymentDue = new javax.swing.JLabel();
        txtBillNumber = new javax.swing.JLabel();
        btnViewPosition = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        enterpriseLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel1.setText("Pay your Bill:");

        lblDepartment.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDepartment.setText("Department:");

        lblFrom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFrom.setText("From:");

        lblTotalAmount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalAmount.setText("Total Amount:");

        lblPaymentDue.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPaymentDue.setText("Payment due:");

        lblSelectPayment.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSelectPayment.setText("Select a payment method:");

        cbxSelectPayment.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbxSelectPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Payment" }));

        lblBillNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblBillNumber.setText("Bill Number:");

        btnPayment.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPayment.setText("Make Payment");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        cbxSelectCard.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbxSelectCard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card Number" }));

        txtDepartment.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDepartment.setText("txt");

        txtFrom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFrom.setText("txt");

        txtTotalAmount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTotalAmount.setText("txt");

        txtPaymentDue.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPaymentDue.setText("txt");

        txtBillNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBillNumber.setText("txt");

        btnViewPosition.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnViewPosition.setText("View Position");
        btnViewPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPositionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBillNumber)
                            .addComponent(lblPaymentDue)
                            .addComponent(lblTotalAmount)
                            .addComponent(lblFrom)
                            .addComponent(lblDepartment)
                            .addComponent(enterpriseLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPaymentDue)
                            .addComponent(txtFrom)
                            .addComponent(txtDepartment)
                            .addComponent(txtTotalAmount)
                            .addComponent(txtBillNumber))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSelectPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxSelectPayment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxSelectCard, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnViewPosition)))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPayment, btnViewPosition});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterpriseLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDepartment)
                            .addComponent(txtDepartment))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFrom))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalAmount)
                            .addComponent(txtTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPaymentDue)
                            .addComponent(txtPaymentDue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSelectPayment)
                        .addGap(18, 18, 18)
                        .addComponent(cbxSelectPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxSelectCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBillNumber)
                    .addComponent(txtBillNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPayment)
                    .addComponent(btnViewPosition))
                .addGap(159, 159, 159))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        // TODO add your handling code here:
        String id = txtBillNumber.getText();
        if(os.finishPay(id)>0){
           infoBox("Payment finished!!", "Valid");
        }else{
           infoBox("Payment fail!!", "invalid");
        }
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CustomerWorkAreaJPanel cp = new CustomerWorkAreaJPanel(splitPanel,user);
        splitPanel.setRightComponent(cp);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPositionActionPerformed
        // TODO add your handling code here: try {
        //String addr = "-71.0854323, 42.3474595";
        String addr = os.getAddrById(orderId);
        System.out.println(addr);
        try{
          File myObj = new File("src/a.html");
          if (myObj.exists()) {
              myObj.delete();
          }
          myObj.createNewFile();
          FileWriter myWriter = new FileWriter(myObj);
          myWriter.write("<html><body>\n" +
"  <div id=\"mapdiv\"></div>\n" +
"  <script src=\"http://www.openlayers.org/api/OpenLayers.js\"></script>\n" +
"  <script>\n" +
"    map = new OpenLayers.Map(\"mapdiv\");\n" +
"    map.addLayer(new OpenLayers.Layer.OSM());\n" +
"\n" +
"        var lonLat = new OpenLayers.LonLat(" + addr + " )\n" +
"          .transform(\n" +
"            new OpenLayers.Projection(\"EPSG:4326\"), // transform from WGS 1984\n" +
"            map.getProjectionObject() // to Spherical Mercator Projection\n" +
"          );\n" +
"        \n" +
"    var zoom=16;\n" +
"\n" +
"    var markers = new OpenLayers.Layer.Markers( \"Markers\" );\n" +
"    map.addLayer(markers);\n" +
"    \n" +
"    markers.addMarker(new OpenLayers.Marker(lonLat));\n" +
"    \n" +
"    map.setCenter (lonLat, zoom);\n" +
"  </script>\n" +
"</body></html>");
          myWriter.close();
      } catch (IOException e) {
          e.printStackTrace();
          return;
      }
        Application.launch(CustomerViewPosition.class);
    }//GEN-LAST:event_btnViewPositionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnViewPosition;
    private javax.swing.JComboBox<String> cbxSelectCard;
    private javax.swing.JComboBox<String> cbxSelectPayment;
    private javax.swing.JLabel enterpriseLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblPaymentDue;
    private javax.swing.JLabel lblSelectPayment;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel txtBillNumber;
    private javax.swing.JLabel txtDepartment;
    private javax.swing.JLabel txtFrom;
    private javax.swing.JLabel txtPaymentDue;
    private javax.swing.JLabel txtTotalAmount;
    // End of variables declaration//GEN-END:variables

   

    
}
