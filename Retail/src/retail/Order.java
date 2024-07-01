/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package retail;

import com.mysql.cj.xdevapi.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author Kadek William Darmawan 2201010631
 */
public class Order extends javax.swing.JFrame {

    DefaultTableModel md = new DefaultTableModel();

    private int productPK = 0;

    /**
     * Creates new form Order
     */
    public Order() throws SQLException {
        initComponents();
        tb_barang.setModel(md);
        md.addColumn("ID");
        md.addColumn("Name");
        md.addColumn("Stock");
        md.addColumn("Category");
        md.addColumn("Price");
        listData();

    }

    private void storeTransaksi() throws SQLException {
        Connection cnn = Koneksi.getConnection();

        OffsetDateTime odt = ZonedDateTime.now(ZoneId.systemDefault())
                .minusDays(1)
                .with(LocalTime.of(19, 0))
                .toOffsetDateTime();

        if (cnn.isClosed()) {
            System.out.println("Connection Failed!!");
        } else {
            String sql = "INSERT INTO tb_transaksi (nama_pelanggan, tgl_transaksi) VALUES (?, ?);";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, cust.getText());
            ps.setObject(2, odt);
            ps.executeUpdate();
        }
    }

    private void listData() throws SQLException {
        Connection cnn = Koneksi.getConnection();
        md.getDataVector().removeAllElements();
        md.fireTableDataChanged();
        if (cnn.isClosed()) {
            System.out.println("Connection Failed!!");
        } else {
            String sql = "SELECT * FROM tb_barang";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] dt = new Object[5];
                dt[0] = rs.getInt("id_barang");
                dt[1] = rs.getString("nama_barang");
                dt[2] = rs.getString("stok");
                dt[3] = rs.getString("kategori");
                dt[4] = rs.getInt("harga");
                md.addRow(dt);
            }
            cnn.close();
        }
    }

    private void clearProduct() {
        productPK = 0;
        tproduct.setText("");
        tcat.setText("");
        tqty.setText("");
        tprice.setText("");
    }

    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

    private void readStock() {

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
        tb_barang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_transaksi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cust = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tcat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tproduct = new javax.swing.JTextField();
        tqty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ttl = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tprice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        badd = new javax.swing.JButton();
        done = new javax.swing.JButton();
        start = new javax.swing.JButton();
        txid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tb_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_barangMouseClicked(evt);
            }
        });
        tb_barang.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tb_barangComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tb_barang);

        tb_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Name", "Quatity", "Category", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_transaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_transaksi);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORDER PAGE");

        cust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custActionPerformed(evt);
            }
        });

        jLabel2.setText("Customer Name");

        jLabel4.setText("Product");

        jLabel5.setText("Category");

        tproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tproductActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantity");

        jLabel6.setText("Harga");

        jLabel9.setText("Total");

        tprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpriceActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Product List");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Cart");

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        badd.setText("Add");
        badd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baddActionPerformed(evt);
            }
        });

        done.setText("Done");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });

        start.setText("Start Order");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        txid.setText("Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cust)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(start)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tproduct)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tcat, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tqty, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(badd))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tprice)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ttl, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(done)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tproduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(start)
                                    .addComponent(txid))
                                .addGap(59, 59, 59))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ttl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(done))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(badd))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void custActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custActionPerformed

    private void tproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tproductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tproductActionPerformed

    private void tpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpriceActionPerformed

    private void tb_barangComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tb_barangComponentShown

    }//GEN-LAST:event_tb_barangComponentShown

    private void tb_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_barangMouseClicked
        int index = tb_barang.getSelectedRow();
        TableModel model = tb_barang.getModel();
        String id = model.getValueAt(index, 0).toString();
        productPK = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        tproduct.setText(name);

        String cat = model.getValueAt(index, 3).toString();
        tcat.setText(cat);

        String price = model.getValueAt(index, 4).toString();
        tprice.setText(price);
    }//GEN-LAST:event_tb_barangMouseClicked

    private void baddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baddActionPerformed
        if (txid.getText().equals("Id")) {
            JOptionPane.showMessageDialog(null, "Please Fill the customer form!");
        } else {
            String noOfUnits = tqty.getText();
            if (!noOfUnits.equals("")) {
                String productname = tproduct.getText();
                String category = tcat.getText();
                int price = Integer.parseInt(tprice.getText());
                int total = Integer.parseInt(tqty.getText()) * Integer.parseInt(tprice.getText());
                int checkStock = 0;
                int checkAlreadyExist = 0;

                try {
                    Connection cnn = Koneksi.getConnection();
                    int id = Integer.parseInt(txid.getText());
                    String name = tproduct.getText();
                    int qty = Integer.parseInt(tqty.getText());
                    String sql = "SELECT * FROM tb_barang where id_barang='" + productPK + "';";
                    String sqlinsert = "INSERT INTO tb_detail_transaksi (id_transaksi, nama_barang, kuantitas, harga, total) VALUES (?,?,?,?,?);";
                    String sqlmin = "UPDATE tb_transaksi SET kuantitas=?, total=? WHERE id_transaksi=?;";
                    String sqlqty = "SELECT SUM(kuantitas) from tb_detail_transaksi where id_transaksi=?";
                    String sqlout = "UPDATE tb_barang SET stok = stok - ? WHERE id_barang=?";
                    PreparedStatement ps = cnn.prepareStatement(sql);
                    PreparedStatement psi = cnn.prepareStatement(sqlinsert);
                    PreparedStatement psm = cnn.prepareStatement(sqlmin);
                    PreparedStatement psq = cnn.prepareStatement(sqlqty);
                    PreparedStatement psout = cnn.prepareStatement(sqlout);

                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        if (rs.getInt("stok") >= Integer.parseInt(noOfUnits)) {
                            checkStock = 1;

                        } else {
                            JOptionPane.showMessageDialog(null, "Product is Out of Stock!");
                        }
                    }
                    psi.setInt(1, id);
                    psi.setString(2, name);
                    psi.setInt(3, qty);
                    psi.setInt(4, price);
                    psi.setInt(5, total);
                    psi.executeUpdate();
                    psq.setInt(1, id);
                    ResultSet rsq = psq.executeQuery();
                    int totalQty = 0;
                    if (rsq.next()) {
                        totalQty = rsq.getInt(1);
                    }
                    psm.setInt(1, totalQty);
                    psm.setInt(2, total);
                    psm.setInt(3, id);
                    psm.executeUpdate();

                    psout.setInt(1, qty);
                    psout.setInt(2, productPK);
                    psout.executeUpdate();
                    ttl.setText(String.valueOf(total));
                } catch (SQLException ex) {
                    Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (checkStock == 1) {
                    DefaultTableModel model = (DefaultTableModel) tb_transaksi.getModel();
                    if (tb_transaksi.getRowCount() != 0) {
                        for (int i = 0; i < tb_transaksi.getRowCount(); i++) {
                            if (Integer.parseInt(model.getValueAt(i, 0).toString()) == productPK) {
                                checkAlreadyExist = 1;
                                JOptionPane.showMessageDialog(null, "Product Already in Cart!");
                            }
                        }
                    }

                    if (checkAlreadyExist == 0) {
                        model.addRow(new Object[]{productPK, productname, noOfUnits, category, total});
                        total = total + price;
                        JOptionPane.showMessageDialog(null, "Added to Cart");
                    }
                    clearProduct();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please add the quantity!");
            }
        }

    }//GEN-LAST:event_baddActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void tb_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_transaksiMouseClicked
        int index = tb_transaksi.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product?", "select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            Connection cnn = Koneksi.getConnection();
            try {
                if (!cnn.isClosed()) {
                    String sql = "DELETE FROM tb_detail_transaksi WHERE id=?;";
                    PreparedStatement ps = cnn.prepareStatement(sql);
                    ps.setInt(1, productPK);
                    ps.executeUpdate();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
            TableModel model = tb_transaksi.getModel();
            ((DefaultTableModel) tb_transaksi.getModel()).removeRow(index);

        }
    }//GEN-LAST:event_tb_transaksiMouseClicked

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
        cust.setText("");
        tproduct.setText("");
        tcat.setText("");
        tqty.setText("");
        tprice.setText("");
        ttl.setText("");
        txid.setText("Id");
        JOptionPane.showMessageDialog(null, "Transaction Saved!");
        home hm = new home();
        hm.show();
        dispose();
        
    }//GEN-LAST:event_doneActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        Connection cnn = Koneksi.getConnection();
        if (cust.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Fill the customer name and date");
        } else {
            try {
                storeTransaksi();
                String sql = "SELECT id_transaksi FROM tb_transaksi WHERE nama_pelanggan = ? ORDER BY id_transaksi DESC";
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setString(1, cust.getText());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String idTransaksi = rs.getString("id_transaksi");
                    txid.setText(idTransaksi);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_startActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cust.setText("");
        tproduct.setText("");
        tcat.setText("");
        tqty.setText("");
        tprice.setText("");
        ttl.setText("");
        txid.setText("Id");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Order().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton badd;
    private javax.swing.JTextField cust;
    private javax.swing.JButton done;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton start;
    private javax.swing.JTable tb_barang;
    private javax.swing.JTable tb_transaksi;
    private javax.swing.JTextField tcat;
    private javax.swing.JTextField tprice;
    private javax.swing.JTextField tproduct;
    private javax.swing.JTextField tqty;
    private javax.swing.JTextField ttl;
    private javax.swing.JLabel txid;
    // End of variables declaration//GEN-END:variables
}
