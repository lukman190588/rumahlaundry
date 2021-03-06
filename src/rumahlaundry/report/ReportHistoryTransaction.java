/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahlaundry.report;

import rumahlaundry.Home;
import rumahlaundry.Login;
import rumahlaundry.master.Customer;
import rumahlaundry.master.Employee;
import rumahlaundry.master.MasterPackage;
import rumahlaundry.master.MasterService;
import rumahlaundry.master.setting.ChangePassword;
import rumahlaundry.master.setting.Profile;
import rumahlaundry.transaction.TransactionClose;
import rumahlaundry.transaction.TransactionOrder;
import rumahlaundry.transaction.TransactionPayment;
import rumahlaundry.transaction.TransactionService;

/**
 *
 * @author lukman.arizal
 */
public class ReportHistoryTransaction extends javax.swing.JFrame {

    /**
     * Creates new form ReportHistoryTransaction
     */
    public ReportHistoryTransaction() {
        initComponents();
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
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenuTransaksi1 = new javax.swing.JMenu();
        jMenuItemTransaksiBaru1 = new javax.swing.JMenuItem();
        jMenuItemPembayaranTransaksi = new javax.swing.JMenuItem();
        jMenuItemTransaksiLayanan = new javax.swing.JMenuItem();
        jMenuItemTransaksiSelesai = new javax.swing.JMenuItem();
        jMenuLaporan = new javax.swing.JMenu();
        jMenuItemLaporanPelanggan = new javax.swing.JMenuItem();
        jMenuItemLaporanTransaksi = new javax.swing.JMenuItem();
        jMenuItemRiwayatTransasiPelanggan = new javax.swing.JMenuItem();
        jMenuMaster = new javax.swing.JMenu();
        jMenuItemDataKaryawan = new javax.swing.JMenuItem();
        jMenuItemDataPelanggan = new javax.swing.JMenuItem();
        jMenuItemDataPaket = new javax.swing.JMenuItem();
        jMenuItemDataLayanan = new javax.swing.JMenuItem();
        jMenuPengaturan = new javax.swing.JMenu();
        jMenuItemProfile = new javax.swing.JMenuItem();
        jMenuItemGantiPassword = new javax.swing.JMenuItem();
        jMenuItemKeluar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        jMenuBar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jMenuBar2.setMinimumSize(new java.awt.Dimension(64, 30));

        jMenuTransaksi1.setText("Transaksi");
        jMenuTransaksi1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N

        jMenuItemTransaksiBaru1.setText("Transaksi Baru");
        jMenuItemTransaksiBaru1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransaksiBaru1ActionPerformed(evt);
            }
        });
        jMenuTransaksi1.add(jMenuItemTransaksiBaru1);

        jMenuItemPembayaranTransaksi.setText("Pembayaran Transaksi");
        jMenuItemPembayaranTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPembayaranTransaksiActionPerformed(evt);
            }
        });
        jMenuTransaksi1.add(jMenuItemPembayaranTransaksi);

        jMenuItemTransaksiLayanan.setText("Transaksi Layanan");
        jMenuItemTransaksiLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransaksiLayananActionPerformed(evt);
            }
        });
        jMenuTransaksi1.add(jMenuItemTransaksiLayanan);

        jMenuItemTransaksiSelesai.setText("Transaksi Selesai");
        jMenuItemTransaksiSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransaksiSelesaiActionPerformed(evt);
            }
        });
        jMenuTransaksi1.add(jMenuItemTransaksiSelesai);

        jMenuBar2.add(jMenuTransaksi1);

        jMenuLaporan.setText("Laporan");
        jMenuLaporan.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N

        jMenuItemLaporanPelanggan.setText("Laporan Pelanggan");
        jMenuItemLaporanPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLaporanPelangganActionPerformed(evt);
            }
        });
        jMenuLaporan.add(jMenuItemLaporanPelanggan);

        jMenuItemLaporanTransaksi.setText("Laporan Transaksi");
        jMenuItemLaporanTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLaporanTransaksiActionPerformed(evt);
            }
        });
        jMenuLaporan.add(jMenuItemLaporanTransaksi);

        jMenuItemRiwayatTransasiPelanggan.setText("Riwayat Transaksi Pelanggan");
        jMenuItemRiwayatTransasiPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRiwayatTransasiPelangganActionPerformed(evt);
            }
        });
        jMenuLaporan.add(jMenuItemRiwayatTransasiPelanggan);

        jMenuBar2.add(jMenuLaporan);

        jMenuMaster.setText("Master");
        jMenuMaster.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N

        jMenuItemDataKaryawan.setText("Data Karyawan");
        jMenuItemDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDataKaryawanActionPerformed(evt);
            }
        });
        jMenuMaster.add(jMenuItemDataKaryawan);

        jMenuItemDataPelanggan.setText("Data Pelanggan");
        jMenuItemDataPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDataPelangganActionPerformed(evt);
            }
        });
        jMenuMaster.add(jMenuItemDataPelanggan);

        jMenuItemDataPaket.setText("Data Paket");
        jMenuItemDataPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDataPaketActionPerformed(evt);
            }
        });
        jMenuMaster.add(jMenuItemDataPaket);

        jMenuItemDataLayanan.setText("Data Layanan");
        jMenuItemDataLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDataLayananActionPerformed(evt);
            }
        });
        jMenuMaster.add(jMenuItemDataLayanan);

        jMenuBar2.add(jMenuMaster);

        jMenuPengaturan.setText("Pengaturan");
        jMenuPengaturan.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N

        jMenuItemProfile.setText("Profile");
        jMenuItemProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProfileActionPerformed(evt);
            }
        });
        jMenuPengaturan.add(jMenuItemProfile);

        jMenuItemGantiPassword.setText("Ganti Password");
        jMenuItemGantiPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGantiPasswordActionPerformed(evt);
            }
        });
        jMenuPengaturan.add(jMenuItemGantiPassword);

        jMenuItemKeluar.setText("Keluar");
        jMenuItemKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemKeluarActionPerformed(evt);
            }
        });
        jMenuPengaturan.add(jMenuItemKeluar);

        jMenuBar2.add(jMenuPengaturan);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemTransaksiBaru1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTransaksiBaru1ActionPerformed
        TransactionOrder transactionOrder = new TransactionOrder();
        transactionOrder.setVisible(true);
        transactionOrder.pack();
        transactionOrder.setLocationRelativeTo(null);
        transactionOrder.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemTransaksiBaru1ActionPerformed

    private void jMenuItemPembayaranTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPembayaranTransaksiActionPerformed
        TransactionPayment transactionPayment = new TransactionPayment();
        transactionPayment.setVisible(true);
        transactionPayment.pack();
        transactionPayment.setLocationRelativeTo(null);
        transactionPayment.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemPembayaranTransaksiActionPerformed

    private void jMenuItemTransaksiLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTransaksiLayananActionPerformed
        TransactionService transactionService = new TransactionService();
        transactionService.setVisible(true);
        transactionService.pack();
        transactionService.setLocationRelativeTo(null);
        transactionService.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemTransaksiLayananActionPerformed

    private void jMenuItemTransaksiSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTransaksiSelesaiActionPerformed
        TransactionClose transactionClose = new TransactionClose();
        transactionClose.setVisible(true);
        transactionClose.pack();
        transactionClose.setLocationRelativeTo(null);
        transactionClose.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemTransaksiSelesaiActionPerformed

    private void jMenuItemLaporanPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLaporanPelangganActionPerformed
        ReportCustomer reportCustomer = new ReportCustomer();
        reportCustomer.setVisible(true);
        reportCustomer.pack();
        reportCustomer.setLocationRelativeTo(null);
        reportCustomer.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemLaporanPelangganActionPerformed

    private void jMenuItemLaporanTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLaporanTransaksiActionPerformed
        ReportTransaction reportTransaction = new ReportTransaction();
        reportTransaction.setVisible(true);
        reportTransaction.pack();
        reportTransaction.setLocationRelativeTo(null);
        reportTransaction.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemLaporanTransaksiActionPerformed

    private void jMenuItemRiwayatTransasiPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRiwayatTransasiPelangganActionPerformed
        ReportHistoryTransaction reportHistoryTransaction = new ReportHistoryTransaction();
        reportHistoryTransaction.setVisible(true);
        reportHistoryTransaction.pack();
        reportHistoryTransaction.setLocationRelativeTo(null);
        reportHistoryTransaction.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemRiwayatTransasiPelangganActionPerformed

    private void jMenuItemDataKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDataKaryawanActionPerformed
        Employee employee = new Employee();
        employee.setVisible(true);
        employee.pack();
        employee.setLocationRelativeTo(null);
        employee.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemDataKaryawanActionPerformed

    private void jMenuItemDataPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDataPelangganActionPerformed
        Customer customer = new Customer();
        customer.setVisible(true);
        customer.pack();
        customer.setLocationRelativeTo(null);
        customer.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemDataPelangganActionPerformed

    private void jMenuItemDataPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDataPaketActionPerformed
        MasterPackage masterPackage = new MasterPackage();
        masterPackage.setVisible(true);
        masterPackage.pack();
        masterPackage.setLocationRelativeTo(null);
        masterPackage.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemDataPaketActionPerformed

    private void jMenuItemDataLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDataLayananActionPerformed
        MasterService service = new MasterService();
        service.setVisible(true);
        service.pack();
        service.setLocationRelativeTo(null);
        service.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemDataLayananActionPerformed

    private void jMenuItemProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProfileActionPerformed
        Profile profile = new Profile();
        profile.setVisible(true);
        profile.pack();
        profile.setLocationRelativeTo(null);
        profile.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemProfileActionPerformed

    private void jMenuItemGantiPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGantiPasswordActionPerformed
        ChangePassword changePassword = new ChangePassword();
        changePassword.setVisible(true);
        changePassword.pack();
        changePassword.setLocationRelativeTo(null);
        changePassword.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemGantiPasswordActionPerformed

    private void jMenuItemKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKeluarActionPerformed
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(ReportHistoryTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportHistoryTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportHistoryTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportHistoryTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportHistoryTransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItemDataKaryawan;
    private javax.swing.JMenuItem jMenuItemDataLayanan;
    private javax.swing.JMenuItem jMenuItemDataPaket;
    private javax.swing.JMenuItem jMenuItemDataPelanggan;
    private javax.swing.JMenuItem jMenuItemGantiPassword;
    private javax.swing.JMenuItem jMenuItemKeluar;
    private javax.swing.JMenuItem jMenuItemLaporanPelanggan;
    private javax.swing.JMenuItem jMenuItemLaporanTransaksi;
    private javax.swing.JMenuItem jMenuItemPembayaranTransaksi;
    private javax.swing.JMenuItem jMenuItemProfile;
    private javax.swing.JMenuItem jMenuItemRiwayatTransasiPelanggan;
    private javax.swing.JMenuItem jMenuItemTransaksiBaru1;
    private javax.swing.JMenuItem jMenuItemTransaksiLayanan;
    private javax.swing.JMenuItem jMenuItemTransaksiSelesai;
    private javax.swing.JMenu jMenuLaporan;
    private javax.swing.JMenu jMenuMaster;
    private javax.swing.JMenu jMenuPengaturan;
    private javax.swing.JMenu jMenuTransaksi1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
