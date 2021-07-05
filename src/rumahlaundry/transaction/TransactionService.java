/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahlaundry.transaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rumahlaundry.Home;
import rumahlaundry.Login;
import rumahlaundry.master.Customer;
import rumahlaundry.master.Employee;
import rumahlaundry.master.MasterPackage;
import rumahlaundry.master.MasterService;
import rumahlaundry.master.setting.ChangePassword;
import rumahlaundry.master.setting.Profile;
import rumahlaundry.model.CustomerDto;
import rumahlaundry.model.PackageDto;
import rumahlaundry.model.ServiceDto;
import rumahlaundry.model.TransactionDto;
import rumahlaundry.report.ReportCustomer;
import rumahlaundry.report.ReportHistoryTransaction;
import rumahlaundry.report.ReportTransaction;
import rumahlaundry.util.MyConnection;
import rumahlaundry.util.MyHelper;

/**
 *
 * @author lukman.arizal
 */
public class TransactionService extends javax.swing.JFrame {

    private final Connection connection = new MyConnection().connect();
    /**
     * Creates new form TransactionOrder
     */
    MasterService laundryService;
    
    public TransactionService() {
        initComponents();
        System.out.println("Init Components");
        try {
            System.out.println("Try Load Data");
            loadTransaction();
            System.out.println("Load Transaction");
            loadPackage();
            System.out.println("Load Package");
            loadServices();
            loadCustomer();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBoxTransaksi.addActionListener(new ComboBoxListenerTransaction());
        jComboBoxPelanggan.addActionListener(new ComboBoxListenerPelanggan());
        jComboBoxPackage.addActionListener(new ComboBoxListenerPackage());
        jComboBoxService.addActionListener(new ComboBoxListenerServices());
        textTotalBerat.addActionListener(new TextTotalBeratListner());
    }

    private class TextTotalBeratListner implements ActionListener{
 
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!"".equals(textTotalBerat.getText())) {
                double totalBerat = Double.parseDouble(textTotalBerat.getText());
                double harga = Double.parseDouble(textHargaPaket.getText());
                double totalHarga = totalBerat * harga;
                textTotalHarga.setText(String.valueOf(totalHarga));
            }
        }
    }
    
    private class ComboBoxListenerTransaction implements ActionListener{
 
        @Override
        public void actionPerformed(ActionEvent e) {
            if (jComboBoxTransaksi.getSelectedItem() != null) {
                TransactionDto transactionDto = hTransaction.get(jComboBoxTransaksi.getSelectedItem());
                System.out.println(hTransaction);
                jComboBoxPelanggan.setSelectedItem(transactionDto.getCustomerId());
                jComboBoxService.setSelectedItem(transactionDto.getServiceId());
                jComboBoxPackage.setSelectedItem(transactionDto.getPackageId());
                textTotalBerat.setText(transactionDto.getTotalWeight());
                jDateTransaksi.setDate(transactionDto.getDate());
                textTotalHarga.setText(transactionDto.getTotalHarga());
                
            }
        }
    }
    
    private class ComboBoxListenerPelanggan implements ActionListener{
 
        @Override
        public void actionPerformed(ActionEvent e) {
            if (jComboBoxPelanggan.getSelectedItem() != null) {
                CustomerDto customerDto = hCustomer.get(jComboBoxPelanggan.getSelectedItem());
                textNamaPelanggan.setText(customerDto.getName());
                textKontakPelanggan.setText(customerDto.getContact());
                textAreaAlamat.setText(customerDto.getAddress());
            }
        }
    }
    
    double hargaPaket = 0;
    
    private class ComboBoxListenerPackage implements ActionListener{
 
        @Override
        public void actionPerformed(ActionEvent e) {
            if (jComboBoxPackage.getSelectedItem() != null) {
                PackageDto packageDto = hPackage.get(jComboBoxPackage.getSelectedItem());
                hargaPaket = Double.parseDouble(packageDto.getPrice());
                textHargaPaket.setText(String.valueOf(hargaPaket + hargaServices));
            }
        }
    }
    
    double hargaServices = 0;
    
    private class ComboBoxListenerServices implements ActionListener{
 
        @Override
        public void actionPerformed(ActionEvent e) {
            if (jComboBoxService.getSelectedItem() != null) {
                ServiceDto serviceDto = hService.get(jComboBoxService.getSelectedItem());
                hargaServices = Double.parseDouble(serviceDto.getPrice());
                textHargaPaket.setText(String.valueOf(hargaPaket + hargaServices));
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelKodePaket = new javax.swing.JLabel();
        jLabelNamaPaket = new javax.swing.JLabel();
        jLabelHargaPaket = new javax.swing.JLabel();
        textNamaPelanggan = new javax.swing.JTextField();
        jLabelKeterangan = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        textTotalBerat = new javax.swing.JTextField();
        jLabelKeterangan1 = new javax.swing.JLabel();
        textHargaPaket = new javax.swing.JTextField();
        jLabelKeterangan2 = new javax.swing.JLabel();
        textTotalHarga = new javax.swing.JTextField();
        jLabelKeterangan3 = new javax.swing.JLabel();
        jDateTransaksi = new com.toedter.calendar.JDateChooser();
        jLabelLayanan = new javax.swing.JLabel();
        jComboBoxService = new javax.swing.JComboBox<>();
        jComboBoxPelanggan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        textKontakPelanggan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaAlamat = new javax.swing.JTextArea();
        jLabelPaket = new javax.swing.JLabel();
        jComboBoxPackage = new javax.swing.JComboBox<>();
        jComboBoxTransaksi = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuTransaksi = new javax.swing.JMenu();
        jMenuItemTransaksiBaru = new javax.swing.JMenuItem();
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
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 537));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Transaksi Layanan Delivery");

        jLabelKodePaket.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabelKodePaket.setText("Kode Transaksi");

        jLabelNamaPaket.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabelNamaPaket.setText("Kode Pelanggan");

        jLabelHargaPaket.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabelHargaPaket.setText("Nama Pelanggan");

        textNamaPelanggan.setEnabled(false);
        textNamaPelanggan.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        textNamaPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaPelangganActionPerformed(evt);
            }
        });

        jLabelKeterangan.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabelKeterangan.setText("Total Berat");

        buttonSave.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        buttonSave.setText("SAVE");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonReset.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        buttonReset.setText("CLEAR");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        textTotalBerat.setEnabled(false);
        textTotalBerat.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        textTotalBerat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTotalBeratActionPerformed(evt);
            }
        });

        jLabelKeterangan1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabelKeterangan1.setText("Harga Per Satuan");

        textHargaPaket.setEnabled(false);
        textHargaPaket.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        textHargaPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHargaPaketActionPerformed(evt);
            }
        });

        jLabelKeterangan2.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabelKeterangan2.setText("Total Harga");

        textTotalHarga.setEnabled(false);
        textTotalHarga.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        textTotalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTotalHargaActionPerformed(evt);
            }
        });

        jLabelKeterangan3.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabelKeterangan3.setText("Tanggal Transaksi");

        jDateTransaksi.setEnabled(false);
        jDateTransaksi.setDateFormatString("yyyy-MM-dd");
        jDateTransaksi.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        jLabelLayanan.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabelLayanan.setText("Jenis Layanan");

        jComboBoxService.setEnabled(false);

        jComboBoxPelanggan.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel5.setText("Kontak Pelanggan");

        textKontakPelanggan.setEnabled(false);
        textKontakPelanggan.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        textKontakPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textKontakPelangganActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel6.setText("Alamat Pelanggan");

        textAreaAlamat.setEnabled(false);
        textAreaAlamat.setColumns(20);
        textAreaAlamat.setRows(5);
        jScrollPane1.setViewportView(textAreaAlamat);

        jLabelPaket.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabelPaket.setText("Jenis Paket");

        jComboBoxPackage.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(buttonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonReset))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelKodePaket, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKeterangan3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabelKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(textTotalHarga))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabelKeterangan1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(textHargaPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTotalBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxService, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHargaPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNamaPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textKontakPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jComboBoxPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKodePaket)
                    .addComponent(jComboBoxTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelKeterangan3)
                    .addComponent(jDateTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNamaPaket)
                    .addComponent(jComboBoxPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHargaPaket)
                    .addComponent(textNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textKontakPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPaket)
                    .addComponent(jComboBoxPackage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLayanan)
                    .addComponent(jComboBoxService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKeterangan)
                    .addComponent(textTotalBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKeterangan1)
                    .addComponent(textHargaPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKeterangan2)
                    .addComponent(textTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSave)
                    .addComponent(buttonReset))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(64, 30));

        jMenuTransaksi.setText("Transaksi");
        jMenuTransaksi.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N

        jMenuItemTransaksiBaru.setText("Transaksi Baru");
        jMenuItemTransaksiBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransaksiBaruActionPerformed(evt);
            }
        });
        jMenuTransaksi.add(jMenuItemTransaksiBaru);

        jMenuItemPembayaranTransaksi.setText("Pembayaran Transaksi");
        jMenuItemPembayaranTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPembayaranTransaksiActionPerformed(evt);
            }
        });
        jMenuTransaksi.add(jMenuItemPembayaranTransaksi);

        jMenuItemTransaksiLayanan.setText("Transaksi Layanan");
        jMenuItemTransaksiLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransaksiLayananActionPerformed(evt);
            }
        });
        jMenuTransaksi.add(jMenuItemTransaksiLayanan);

        jMenuItemTransaksiSelesai.setText("Transaksi Selesai");
        jMenuItemTransaksiSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransaksiSelesaiActionPerformed(evt);
            }
        });
        jMenuTransaksi.add(jMenuItemTransaksiSelesai);

        jMenuBar1.add(jMenuTransaksi);

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

        jMenuBar1.add(jMenuLaporan);

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

        jMenuBar1.add(jMenuMaster);

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

        jMenuBar1.add(jMenuPengaturan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    HashMap<String, TransactionDto> hTransaction = new HashMap<>();
    
    private void loadTransaction() throws SQLException{
        jComboBoxTransaksi.removeAllItems();
        jComboBoxTransaksi.addItem("");
        Statement stat = connection.createStatement();
        String sql = "SELECT * FROM TRANSACTION_LAUNDRY WHERE SERVICE_ID = 'DELIVERY' AND FINISH_DATE IS NULL ORDER BY PACKAGE_ID";
        ResultSet result = stat.executeQuery(sql);
        while (result.next()) {
            TransactionDto laudryTransaction = new TransactionDto();
            laudryTransaction.setId(result.getString("transaction_id"));
            laudryTransaction.setDate(result.getDate("transaction_date"));
            laudryTransaction.setCustomerId(result.getString("customer_id"));
            laudryTransaction.setPackageId(result.getString("package_id"));
            laudryTransaction.setServiceId(result.getString("service_id"));
            laudryTransaction.setTotalWeight(result.getString("total_weight"));
            laudryTransaction.setTotalHarga(result.getString("total_price"));
            hTransaction.put(laudryTransaction.getId(), laudryTransaction);
            jComboBoxTransaksi.addItem(laudryTransaction.getId());
        }
    }
    
    HashMap<String, PackageDto> hPackage = new HashMap<>();
    
    private void loadPackage() throws SQLException{
        jComboBoxPackage.removeAllItems();
        jComboBoxPackage.addItem("");
        Statement stat = connection.createStatement();
        String sql = "SELECT * FROM MASTER_PACKAGE ORDER BY PACKAGE_ID";
        ResultSet result = stat.executeQuery(sql);
        while (result.next()) {
            PackageDto laudryPackage = new PackageDto();
            laudryPackage.setId(result.getString("package_id"));
            laudryPackage.setName(result.getString("package_name"));
            laudryPackage.setPrice(result.getString("package_price"));
            laudryPackage.setDescription(result.getString("package_description"));
            hPackage.put(laudryPackage.getId(), laudryPackage);
            jComboBoxPackage.addItem(laudryPackage.getId());
        }
    }
    
    HashMap<String, ServiceDto> hService = new HashMap<>();
    
    private void loadServices() throws SQLException{
        jComboBoxService.removeAllItems();
        jComboBoxService.addItem("");
        Statement stat = connection.createStatement();
        String sql = "SELECT * FROM MASTER_SERVICE ORDER BY SERVICE_ID";
        ResultSet result = stat.executeQuery(sql);
        while (result.next()) {
            ServiceDto laudryService = new ServiceDto();
            laudryService.setId(result.getString("service_id"));
            laudryService.setName(result.getString("service_name"));
            laudryService.setPrice(result.getString("service_price"));
            laudryService.setDescription(result.getString("service_description"));
            hService.put(laudryService.getId(), laudryService);
            jComboBoxService.addItem(laudryService.getId());
        }
    }
    
    HashMap<String, CustomerDto> hCustomer = new HashMap<>();
    
    private void loadCustomer() throws SQLException{
        jComboBoxPelanggan.removeAllItems();
        jComboBoxPelanggan.addItem("");
        hCustomer.clear();
        Statement stat = connection.createStatement();
        String sql = "SELECT * FROM MASTER_CUSTOMER ORDER BY CUSTOMER_ID";
        ResultSet result = stat.executeQuery(sql);
        while (result.next()) {
            CustomerDto laudryCustomer = new CustomerDto();
            laudryCustomer.setId(result.getString("customer_id"));
            laudryCustomer.setName(result.getString("customer_name"));
            laudryCustomer.setContact(result.getString("customer_contact"));
            laudryCustomer.setAddress(result.getString("customer_address"));
            hCustomer.put(laudryCustomer.getId(), laudryCustomer);
            jComboBoxPelanggan.addItem(laudryCustomer.getId());
        }
        
    }
    
    private void jMenuItemTransaksiBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTransaksiBaruActionPerformed
        TransactionOrder transactionOrder = new TransactionOrder();
        transactionOrder.setVisible(true);
        transactionOrder.pack();
        transactionOrder.setLocationRelativeTo(null);
        transactionOrder.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemTransaksiBaruActionPerformed

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

    private void textNamaPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaPelangganActionPerformed

    public boolean doValidate() {
        boolean valid = false;
        if (MyHelper.validateTextRequired(textNamaPelanggan)
                && MyHelper.validateTextRequired(textTotalBerat)
                && MyHelper.validateTextRequired(textHargaPaket)
                && MyHelper.validateTextRequired(textTotalHarga)) {
            valid = true;
        }

        return valid;
    }
    
    private void doReset() {
        jDateTransaksi.setDate(new Date());
        jComboBoxPelanggan.setSelectedIndex(-1);
        textNamaPelanggan.setText("");
        textKontakPelanggan.setText("");
        textAreaAlamat.setText("");
        jComboBoxPackage.setSelectedIndex(-1);
        jComboBoxService.setSelectedIndex(-1);
        textTotalBerat.setText("");
        textHargaPaket.setText("");
        textTotalHarga.setText("");
    }
    
    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        if (!doValidate()) {
            return;
        }
        try {
            String sql = "UPDATE TRANSACTION_LAUNDRY SET FINISH_DATE = ?, PAYMENT_DATE = ?, DELIVERY_DATE = ?, STATUS = ? "
            + " where TRANSACTION_ID = ?";
            PreparedStatement stat = connection.prepareStatement(sql);

            stat.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            stat.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            stat.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            stat.setString(4, "2");
            stat.setString(5, jComboBoxTransaksi.getSelectedItem().toString());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            doReset();
            jComboBoxPelanggan.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" + e.getMessage());
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        doReset();
    }//GEN-LAST:event_buttonResetActionPerformed

    private void textTotalBeratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTotalBeratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTotalBeratActionPerformed

    private void textHargaPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHargaPaketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHargaPaketActionPerformed

    private void textTotalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTotalHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTotalHargaActionPerformed

    private void textKontakPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textKontakPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textKontakPelangganActionPerformed

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
            java.util.logging.Logger.getLogger(TransactionService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionService().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox<String> jComboBoxPackage;
    private javax.swing.JComboBox<String> jComboBoxPelanggan;
    private javax.swing.JComboBox<String> jComboBoxService;
    private javax.swing.JComboBox<String> jComboBoxTransaksi;
    private com.toedter.calendar.JDateChooser jDateTransaksi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelHargaPaket;
    private javax.swing.JLabel jLabelKeterangan;
    private javax.swing.JLabel jLabelKeterangan1;
    private javax.swing.JLabel jLabelKeterangan2;
    private javax.swing.JLabel jLabelKeterangan3;
    private javax.swing.JLabel jLabelKodePaket;
    private javax.swing.JLabel jLabelLayanan;
    private javax.swing.JLabel jLabelNamaPaket;
    private javax.swing.JLabel jLabelPaket;
    private javax.swing.JMenuBar jMenuBar1;
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
    private javax.swing.JMenuItem jMenuItemTransaksiBaru;
    private javax.swing.JMenuItem jMenuItemTransaksiLayanan;
    private javax.swing.JMenuItem jMenuItemTransaksiSelesai;
    private javax.swing.JMenu jMenuLaporan;
    private javax.swing.JMenu jMenuMaster;
    private javax.swing.JMenu jMenuPengaturan;
    private javax.swing.JMenu jMenuTransaksi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaAlamat;
    private javax.swing.JTextField textHargaPaket;
    private javax.swing.JTextField textKontakPelanggan;
    private javax.swing.JTextField textNamaPelanggan;
    private javax.swing.JTextField textTotalBerat;
    private javax.swing.JTextField textTotalHarga;
    // End of variables declaration//GEN-END:variables
}
