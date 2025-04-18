/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import DAO.MayTinhDAO;
import DAO.TaiKhoanDAO;
import Utils.AudioPlayer;
import Utils.GlobalState;
import Utils.TimerManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author cunhp
 */
public class ThoiGianChoi extends javax.swing.JFrame {

    /**
     * Creates new form ThoiGianChoi
     */
    public ThoiGianChoi() {
        this.preInit();
        initComponents();
        this.loadSoDu();
        this.loadTen();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = this.getWidth();
        int height = this.getHeight();
        this.setLocation(screenSize.width - width, 0);
        this.doiMauLienTuc();
        this.TruSoDu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSoDu = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSoPhut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnTat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTat.setForeground(new java.awt.Color(255, 153, 153));
        btnTat.setText("Tắt");
        btnTat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("Học không chơi đánh rơi tuổi trẻ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Hôm nay bạn rất đẹp trai :Đ");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Tên Đăng Nhập:");

        lblTen.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Thời Gian Chơi Còn Lại:");

        lblSoDu.setText("jLabel1");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel5.setText("Số Dư:");

        lblSoPhut.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSoPhut, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSoDu, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoDu)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSoPhut))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btnTat)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void doiMauLienTuc() {
        Timer timer = new Timer(500, e -> {
            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            jLabel1.setForeground(new Color(r, g, b));
            jLabel4.setForeground(new Color(r, g, b));
            this.checkAccStatus();
        });
        timer.start();
    }

    public void loadTen() {
        lblTen.setText(GlobalState.ten_dang_nhap);
    }
    public void checkAccStatus(){
        boolean status = GlobalState.accountStatus;
        if (status == false){
            this.dispose();
        }
    }

    public void loadSoDu() {
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        MayTinhDAO mtDAO = new MayTinhDAO();

        int so_du = tkDAO.getSoDu();
        int soDu = tkDAO.getSoDu();
        int moneyRequired = mtDAO.getMoney(GlobalState.ten_may);

        int remainingMinutes = soDu / moneyRequired;
        int hours = remainingMinutes / 60;
        int minutes = remainingMinutes % 60;

        DecimalFormat formatter = new DecimalFormat("#,###");
        String soDuFormatted = formatter.format(so_du).replace(",", ".");
        String timeFormatted = String.format("%d:%02d", hours, minutes);

        lblSoDu.setText(soDuFormatted);
        lblSoPhut.setText(timeFormatted);
    }

    public void TruSoDu() {
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        MayTinhDAO mtDAO = new MayTinhDAO();

        TimerManager.timer = new Timer(10000, e -> {
            int soDu = tkDAO.getSoDu();
            int moneyRequired = mtDAO.getMoney(GlobalState.ten_may);
            int remainingMinutes = soDu / moneyRequired;

            if (remainingMinutes == 5) {
                AudioPlayer.playSound("src\\Libs\\Five-mins.mp3");
                JOptionPane.showMessageDialog(this, "Bạn còn 5 phút chơi!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            }
            if (remainingMinutes == 2) {
                AudioPlayer.playSound("src\\Libs\\Two-mins.mp3");
                JOptionPane.showMessageDialog(this, "Bạn còn 2 phút chơi!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            }

            if (soDu < moneyRequired) {
                tkDAO.updateSoDu(soDu);
                ((Timer) e.getSource()).stop();
                GlobalState.accountStatus = false;
                this.dispose();
            } else {
                int currentMoney = soDu - moneyRequired;
                tkDAO.updateSoDu(currentMoney);
                loadSoDu();
            }

        });
        TimerManager.timer.start();
    }

//    public void thongBao() {
//        MayTinhDAO mtDAO = new MayTinhDAO();
//        if(Integer.parseInt(lblSoDu.getText()) < mtDAO.getMoney(GlobalState.ten_may) * 31
//                && Integer.parseInt(lblSoDu.getText()) > ( + mtDAO.getMoney(GlobalState.ten_may) * 29)){
//            JOptionPane.showMessageDialog(rootPane, "Tài khoản bạn còn 5p");
//        }
//    }
    private void btnTatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnTatActionPerformed

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
            java.util.logging.Logger.getLogger(ThoiGianChoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThoiGianChoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThoiGianChoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThoiGianChoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThoiGianChoi().setVisible(true);
            }
        });
    }

    private void preInit() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSoDu;
    private javax.swing.JLabel lblSoPhut;
    private javax.swing.JLabel lblTen;
    // End of variables declaration//GEN-END:variables
}
