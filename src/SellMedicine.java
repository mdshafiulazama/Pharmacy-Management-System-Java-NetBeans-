
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dao.ConnectionProvider;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.TableModel;
import java.util.Calendar;
import java.util.Date;
import dao.PharmacyUtils;
import java.io.FileOutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author mdsha
 */
public class SellMedicine extends javax.swing.JFrame {

    public String numberPattern = "^[0-9]*$";
    private int finalTotalPrice = 0;
    private String billID = "";
    private String username = "";

    /**
     * Creates new form SellMedicine
     */
    public SellMedicine() {
        initComponents();
    }

    public SellMedicine(String tempUsername) {
        initComponents();
        username = tempUsername;
        setLocationRelativeTo(null);
    }

    private void medicineName(String nameOrUniqueId) {
        DefaultTableModel model = (DefaultTableModel) medicinesTable.getModel();
        model.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from medicine where name like '" + nameOrUniqueId + "%' or uniqueId like '" + nameOrUniqueId + "%'");
            //ResultSet rs = st.executeQuery("SELECT * FROM medicine WHERE name LIKE '" + nameOrUniqueId + "%' OR uniqueId LIKE '" + nameOrUniqueId + "%'");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("uniqueId") + "- " + rs.getString("name")});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void clearMedicineFields() {
        txtUniqueId.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtPricePerUnit.setText("");
        txtNumberOfUnits.setText("");
        txtTotalPrice.setText("");
    }

    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
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
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicinesTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtUniqueId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPricePerUnit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNumberOfUnits = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("Sell Medicine");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 14, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 1570, 10));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1538, 14, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jLabel2.setText("Search");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 122, -1, -1));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 148, 299, -1));

        medicinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Medicine"
            }
        ));
        medicinesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicinesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medicinesTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 221, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Medicine ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 130, -1, -1));

        txtUniqueId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUniqueIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtUniqueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 153, 300, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 193, -1, -1));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 226, 300, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Company Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 266, -1, -1));
        getContentPane().add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 301, 300, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Price Per Unit");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1127, 130, -1, -1));
        getContentPane().add(txtPricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1127, 153, 300, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Number Of Units");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1127, 193, -1, -1));

        txtNumberOfUnits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberOfUnitsActionPerformed(evt);
            }
        });
        txtNumberOfUnits.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumberOfUnitsKeyReleased(evt);
            }
        });
        getContentPane().add(txtNumberOfUnits, new org.netbeans.lib.awtextra.AbsoluteConstraints(1127, 226, 300, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Total Price");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1127, 266, -1, -1));

        txtTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1127, 301, 300, -1));

        cartTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Medicine ID", "Name", "Company Name", "Price Per Unit", "Number of Units", "Total Price"
            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cartTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 395, 693, 253));

        btnAddToCart.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1286, 341, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("BDT");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 679, -1, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblFinalTotalPrice.setText("00");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 679, 280, 16));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        jButton3.setText("Purchase & Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1266, 674, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtUniqueIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUniqueIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUniqueIdActionPerformed

    private void txtNumberOfUnitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberOfUnitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberOfUnitsActionPerformed

    private void txtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPriceActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        medicineName("");
        txtUniqueId.setEditable(false);
        txtName.setEditable(false);
        txtCompanyName.setEditable(false);
        txtPricePerUnit.setEditable(false);
        txtTotalPrice.setEditable(false);
    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String search = txtSearch.getText();
        medicineName(search);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void medicinesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicinesTableMouseClicked
        // TODO add your handling code here:
        int index = medicinesTable.getSelectedRow();
        TableModel model = medicinesTable.getModel();
        String nameOrUniqueId = model.getValueAt(index, 0).toString();

        String uniqueId[] = nameOrUniqueId.split("-", 0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM medicine WHERE uniqueId = '" + uniqueId[0] + "'");
            while (rs.next()) {
                txtUniqueId.setText(uniqueId[0]);
                txtName.setText(rs.getString("name"));
                txtCompanyName.setText(rs.getString("companyName"));
                txtPricePerUnit.setText(rs.getString("price"));
                txtNumberOfUnits.setText("");
                txtTotalPrice.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_medicinesTableMouseClicked

    private void txtNumberOfUnitsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberOfUnitsKeyReleased
        // TODO add your handling code here:
        String NumberOfUnits = txtNumberOfUnits.getText();
        if (!NumberOfUnits.equals("")) {
            String price = txtPricePerUnit.getText();
            if (!NumberOfUnits.matches(numberPattern)) {
                JOptionPane.showMessageDialog(null, "Number of Units field is invalid !");
            }
            int totalPrice = Integer.parseInt(NumberOfUnits) * Integer.parseInt(price);
            txtTotalPrice.setText(String.valueOf(totalPrice));
        } else {
            txtTotalPrice.setText("");
        }
    }//GEN-LAST:event_txtNumberOfUnitsKeyReleased

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String numberOfUnits = txtNumberOfUnits.getText();
        String uniqueId = txtUniqueId.getText();

        if (!numberOfUnits.equals("") && !uniqueId.equals("")) {
            String name = txtName.getText();
            String companyName = txtCompanyName.getText();
            String pricePerUnit = txtPricePerUnit.getText();
            String totalPrice = txtTotalPrice.getText();
            int cheakStock = 0;
            int cheakMedicineAlreadyExistInCart = 0;

            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM medicine WHERE uniqueId = " + uniqueId);
                while (rs.next()) {
                    int availableQuantity = rs.getInt("quantity");
                    if (availableQuantity >= Integer.parseInt(numberOfUnits)) {
                        cheakStock = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Medicine Out Of Stock !!! only " + availableQuantity + " Left");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            if (cheakStock == 1) {
                DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
                if (cartTable.getRowCount() != 0) {
                    for (int i = 0; i < cartTable.getRowCount(); i++) {
                        Object value = dtm.getValueAt(i, 0);
                        if (value != null && Integer.parseInt(value.toString()) == Integer.parseInt(uniqueId)) {
                            cheakMedicineAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null, "Medicine already exists in the cart.");
                        }
                    }
                }
                if (cheakMedicineAlreadyExistInCart == 0) {
                    dtm.addRow(new Object[]{uniqueId, name, companyName, pricePerUnit, numberOfUnits, totalPrice});
                    finalTotalPrice += Integer.parseInt(totalPrice);
                    lblFinalTotalPrice.setText("Total Price: " + finalTotalPrice);
                    JOptionPane.showMessageDialog(null, "Added Successfully !");
                }
                clearMedicineFields();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Number of Units and Medicine ID field are required !");
        }

    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked
        // TODO add your handling code here:
        int index = cartTable.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this Medicine", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = cartTable.getModel();
            String total = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice - Integer.parseInt(total);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) cartTable.getModel()).removeRow(index);
        }

    }//GEN-LAST:event_cartTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   // TODO add your handling code here:
    if (finalTotalPrice != 0) {
        billID = getUniqueId("Bill-");

        DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
        if (cartTable.getRowCount() != 0) {
            for (int i = 0; i < cartTable.getRowCount(); i++) {
                try {
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    st.executeUpdate("update medicine set quantity = quantity-" + Integer.parseInt(dtm.getValueAt(i, 4).toString()) + " where uniqueId=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
        try {
            SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
            Calendar cal = Calendar.getInstance();
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("Insert into bill(billID,billDate,totalPaid,generated) values(?,?,?,?)");
            ps.setString(1, billID);
            ps.setString(2, myFormat.format(cal.getTime()));
            ps.setInt(3, finalTotalPrice);
            ps.setString(4, username);
            ps.executeUpdate();

            //create Bill
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            PdfWriter.getInstance(doc, new FileOutputStream(PharmacyUtils.billPath + "" + billID + ".pdf"));
            doc.open();
            Paragraph pharmacyName = new Paragraph("Janata Pharmacy \n");
            doc.add(pharmacyName);
            Paragraph starLine = new Paragraph("*********************************************************************************");
            doc.add(starLine);
            Paragraph details = new Paragraph("\tBill ID: " + billID + "\nDate: " + new Date() + "\nTotal Paid: " + finalTotalPrice);
            doc.add(details);
            doc.add(starLine);
            PdfPTable tbl = new PdfPTable(6);
            tbl.addCell("Medicine ID");
            tbl.addCell("Name");
            tbl.addCell("Company Name");
            tbl.addCell("Price Per Unit");
            tbl.addCell("Number Of Units");
            tbl.addCell("Sub Total Price");
           for (int i = 0; i < cartTable.getRowCount(); i++) {
    String a = "";
    String b = "";
    String c = "";
    String d = "";
    String e = "";
    String f = "";
    
    if (dtm.getValueAt(i, 0) != null) a = dtm.getValueAt(i, 0).toString();
    if (dtm.getValueAt(i, 1) != null) b = dtm.getValueAt(i, 1).toString();
    if (dtm.getValueAt(i, 2) != null) c = dtm.getValueAt(i, 2).toString();
    if (dtm.getValueAt(i, 3) != null) d = dtm.getValueAt(i, 3).toString();
    if (dtm.getValueAt(i, 4) != null) e = dtm.getValueAt(i, 4).toString();
    if (dtm.getValueAt(i, 5) != null) f = dtm.getValueAt(i, 5).toString();

    tbl.addCell(a);
    tbl.addCell(b);
    tbl.addCell(c);
    tbl.addCell(d);
    tbl.addCell(e);
    tbl.addCell(f);
}
            doc.add(tbl);
            doc.add(starLine);
            Paragraph thanksMsg = new Paragraph("Thank You, Please Visit Again");
            doc.add(thanksMsg);
            //Open pdf
            OpenPdf.openById(String.valueOf(billID));
            doc.close();
            setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable medicinesTable;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberOfUnits;
    private javax.swing.JTextField txtPricePerUnit;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUniqueId;
    // End of variables declaration//GEN-END:variables
}