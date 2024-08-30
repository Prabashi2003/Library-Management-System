package library_management_system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class viewRecords extends javax.swing.JFrame {

    DefaultTableModel model;

    public viewRecords() {
        initComponents();
        setIssueBookDetailsToTable();
    }

    public void setIssueBookDetailsToTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managemnt_system", "root", "");
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book");

            while (rs.next()) {
                String IssuId = rs.getString("id");
                String BookName = rs.getString("book_name");
                String studentId = rs.getString("student_id");
                String studentname = rs.getString("student_name");
                String IssuDate = rs.getString("issue_date");
                String DueDate = rs.getString("due_date");
                String returnDate = rs.getString("return_date");
                String Status = rs.getString("status");

                Object[] obj = {IssuId, BookName, studentId, studentname, IssuDate, DueDate, returnDate, Status};
                model = (DefaultTableModel) tbl_issubookdetails.getModel();
                model.addRow(obj);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageStudents.class.getName()).log(Level.SEVERE, null, ex);
            //ex.printStackTrace();
        }
    }

    //clear table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_issubookdetails.getModel();
        model.setRowCount(0);
    }

    //catch data through data filed
    public void search() {
        Date uFromDate = From_date.getDate();
        Date uToDate = To_date.getDate();

        long L1 = uFromDate.getTime();
        long L2 = uToDate.getTime();

        java.sql.Date FromDate = new java.sql.Date(L1);
        java.sql.Date ToDate = new java.sql.Date(L2);

        try {
            Connection conn = DbConnection.connect();
            String sql = "select * from issue_book where issue_date BETWEEN ? and ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setDate(1, FromDate);
            pst.setDate(2, ToDate);

            ResultSet rs = pst.executeQuery();
            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "No Record found Between these days!!");
            } else {
                while (rs.next()) {
                    String IssuId = rs.getString("id");
                    String BookName = rs.getString("book_name");
                    String studentId = rs.getString("student_id");
                    String studentname = rs.getString("student_name");
                    String IssuDate = rs.getString("issue_date");
                    String DueDate = rs.getString("due_date");
                    String returnDate = rs.getString("return_date");
                    String Status = rs.getString("status");

                    Object[] obj = {IssuId, BookName, studentId, studentname, IssuDate, DueDate, returnDate, Status};
                    model = (DefaultTableModel) tbl_issubookdetails.getModel();
                    model.addRow(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issubookdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        To_date = new de.wannawork.jcalendar.JCalendarComboBox();
        From_date = new de.wannawork.jcalendar.JCalendarComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/book-64.png"))); // NOI18N
        jLabel21.setText(" All  book  details");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 360, 110));

        jLabel26.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/back.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 60, 50));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Issue Date :");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 110, 40));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Due Date :");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 100, 40));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(51, 153, 0));
        rSMaterialButtonCircle2.setText("Search");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 160, 290, 60));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 390, 1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1360, 2));

        tbl_issubookdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue ID", "Book Name", "Student ID", "Student Name", "Issue Date", "Due Date", "Return Date", "Status"
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 1310, 400));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/wr.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 40, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/min.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 40, 40));
        jPanel1.add(To_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 300, 40));
        jPanel1.add(From_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 300, 40));

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

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        clearTable();
        search();
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void tbl_issubookdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_issubookdetailsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_issubookdetailsMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ReturnBook.ICONIFIED);
    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(viewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private de.wannawork.jcalendar.JCalendarComboBox From_date;
    private de.wannawork.jcalendar.JCalendarComboBox To_date;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojeru_san.complementos.RSTableMetro tbl_issubookdetails;
    // End of variables declaration//GEN-END:variables
}
