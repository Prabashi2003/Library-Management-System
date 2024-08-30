package library_management_system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginPage extends javax.swing.JFrame {
    public LoginPage() {
        initComponents();
        setLocationRelativeTo(null);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Login_button = new rojerusan.RSMaterialButtonCircle();
        jLabel4 = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        lblMinimize = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1390, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1390, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Login Page");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 350, 80));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 90, 20));

        txt_username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 320, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/username.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 60, 60));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 90, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/icons8-password-50.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 50, 60));

        Login_button.setBackground(new java.awt.Color(0, 204, 0));
        Login_button.setText("LOGIN");
        Login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(Login_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 390, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/logg.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 150, 140));

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/wrong.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        jPanel2.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 40, 50));
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 320, 40));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/minimize.png"))); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });
        jPanel2.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 40, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 610, 720));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/Library-Lovers-1120x630.jpg"))); // NOI18N
        jLabel5.setText("nnn");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, 130, 970, 590));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setFocusable(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Library Management System");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 720, 90));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_buttonActionPerformed
        try {
            Connection conn = DbConnection.connect();
            PreparedStatement pst = null;
            ResultSet rs = null;
            
            String username = txt_username.getText().trim();
            String password = txt_password.getText();
            
            String sql = "Select username , password from users where username=? and password=?";
            pst = (PreparedStatement)conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            
            if(pst.executeQuery().next()){
                System.out.println("User found!");
                Dashboard db1 = new Dashboard();
                db1.user(username);
                db1.setVisible(true);
                this.dispose();
            }else{
                System.err.println("Invalid username or password");
                JOptionPane.showMessageDialog(null,"Invalid username or password","Error",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Login_buttonActionPerformed

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        this.setExtendedState(LoginPage.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Login_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
