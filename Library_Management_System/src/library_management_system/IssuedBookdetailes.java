package library_management_system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class IssuedBookdetailes extends javax.swing.JFrame {

    DefaultTableModel model;
    public IssuedBookdetailes() {
        initComponents();
        setIssueBookDetailsToTable();
    }
    
        public void setIssueBookDetailsToTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managemnt_system", "root", "");
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book where status = '"+"Pending"+"'");

            while (rs.next()) {
                String IssuId = rs.getString("id");
                String BookName = rs.getString("book_name");
                String studentId = rs.getString("student_id");
                String studentname = rs.getString("student_name");
                String IssuDate = rs.getString("issue_date");
                String DueDate = rs.getString("due_date");
                String Status = rs.getString("status");

                Object[] obj = {IssuId, BookName, studentId, studentname, IssuDate, DueDate, Status};
                model = (DefaultTableModel) tbl_issubookdetails.getModel();
                model.addRow(obj);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageStudents.class.getName()).log(Level.SEVERE, null, ex);
            //ex.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issubookdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 102));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/book-64.png"))); // NOI18N
        jLabel21.setText("  Pending  list");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 250, 110));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 340, 1));

        jLabel26.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/back.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 60, 50));

        tbl_issubookdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue ID", "Book Name", "Student ID", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issubookdetails.setColorBackgoundHead(new java.awt.Color(0, 153, 102));
        tbl_issubookdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_issubookdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_issubookdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_issubookdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_issubookdetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_issubookdetails.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_issubookdetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_issubookdetails.setRowHeight(40);
        tbl_issubookdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_issubookdetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_issubookdetails);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 1310, 490));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/minimize.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 40, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/wrong.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 40, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 720));

        setSize(new java.awt.Dimension(1362, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        Dashboard dash = new Dashboard();
        dash.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void tbl_issubookdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_issubookdetailsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_issubookdetailsMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(viewRecords.ICONIFIED);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(IssuedBookdetailes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBookdetailes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBookdetailes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBookdetailes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBookdetailes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tbl_issubookdetails;
    // End of variables declaration//GEN-END:variables
}
