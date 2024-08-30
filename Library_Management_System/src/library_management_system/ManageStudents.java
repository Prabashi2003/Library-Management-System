package library_management_system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ManageStudents extends javax.swing.JFrame {

    String studentName, email, studentID;
    int contactNumber;
    DefaultTableModel model;

    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }

    public void setStudentDetailsToTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managemnt_system", "root", "");
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");

            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String studentname = rs.getString("name");
                int Contactnumber = rs.getInt("contact_number");
                String Email = rs.getString("email");

                Object[] obj = {studentId, studentname, Contactnumber, Email};
                model = (DefaultTableModel) tbl_studentDetails.getModel();
                model.addRow(obj);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageStudents.class.getName()).log(Level.SEVERE, null, ex);
            //ex.printStackTrace();
        }
    }

    //add student to Student details database table
    public boolean addStudent() {
        boolean isAded = false;
        studentID = txt_studentId.getText();
        studentName = txt_studentName.getText();
        contactNumber = Integer.parseInt(txt_contactNumber.getText());
        email = txt_email.getText();

        try {
            Connection conn = DbConnection.connect();
            String sql = "insert into student_details values(?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, studentID);
            pst.setString(2, studentName);
            pst.setInt(3, contactNumber);
            pst.setString(4, email);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isAded = true;
            } else {
                isAded = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return isAded;
    }

    //update Student
    public boolean updateStudent() {
        boolean isUpdated = false;
        studentID = txt_studentId.getText();
        studentName = txt_studentName.getText();
        contactNumber = Integer.parseInt(txt_contactNumber.getText());
        email = txt_email.getText();

        try {
            Connection conn = DbConnection.connect();
            String sql = "update student_details set name = ?,contact_number = ?, email = ?  where student_id = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setInt(2, contactNumber);
            pst.setString(3, email);
            pst.setString(4, studentID);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isUpdated = true;
            } else {
                isUpdated = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return isUpdated;
    }

    //delete Student
    public boolean deleteStudent() {
        boolean isDeleted = false;
        studentID = txt_studentId.getText();

        try {
            Connection conn = DbConnection.connect();
            String sql = "delete from student_details where student_id = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, studentID);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isDeleted = true;
            } else {
                isDeleted = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return isDeleted;
    }

    //clear the table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
        model.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_studentName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_contactNumber = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        Delete_Button = new rojerusan.RSMaterialButtonCircle();
        Add_Button = new rojerusan.RSMaterialButtonCircle();
        Update_Button = new rojerusan.RSMaterialButtonCircle();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/back.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 80, 50));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Student ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 130, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/bookid.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 90));

        txt_studentId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 320, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter Student Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 160, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/studentname.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 70, 80));

        txt_studentName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 320, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contact Number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 140, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/contactnumber.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 80, 70));

        txt_contactNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_contactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 320, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email Address");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 130, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/email.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 80, 70));

        txt_email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 320, 30));

        Delete_Button.setText("DELETE");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Delete_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 600, 150, 60));

        Add_Button.setText("ADD");
        Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 150, 60));

        Update_Button.setText("UPDATE");
        Update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Update_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 150, 60));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/wr.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 40, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/min.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 1010));

        jLabel7.setFont(new java.awt.Font("Showcard Gothic", 0, 32)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/studentmanage.png"))); // NOI18N
        jLabel7.setText("  Manage   students ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 430, 80));

        jPanel3.setBackground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 440, 3));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Contact Number", "Email Address"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(0, 153, 102));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 790, 470));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/background (2).jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, -10, -1, 770));

        setSize(new java.awt.Dimension(1362, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Dashboard dash = new Dashboard();
        dash.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ButtonActionPerformed
        // TODO add your handling code here: for add button
        if (addStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Added Successfully!!");
            clearTable();
            setStudentDetailsToTable();
            txt_studentId.setText("");
            txt_studentName.setText("");
            txt_contactNumber.setText("");
            txt_email.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Student Added Failed!!");
        }
    }//GEN-LAST:event_Add_ButtonActionPerformed

    private void Update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_ButtonActionPerformed
        // TODO add your handling code here:
        if (updateStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Updated Successfully!!");
            clearTable();
            setStudentDetailsToTable();
            txt_studentId.setText("");
            txt_studentName.setText("");
            txt_contactNumber.setText("");
            txt_email.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Student Updated Failed!!");
        }
    }//GEN-LAST:event_Update_ButtonActionPerformed

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        // TODO add your handling code here:
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();

        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        txt_contactNumber.setText(model.getValueAt(rowNo, 2).toString());
        txt_email.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        // TODO add your handling code here:
        if (deleteStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Deleted Successfully!!");
            clearTable();
            setStudentDetailsToTable();
            txt_studentId.setText("");
            txt_studentName.setText("");
            txt_contactNumber.setText("");
            txt_email.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Student Deleted Failed!!");
        }
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ManageBook.ICONIFIED);
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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Add_Button;
    private rojerusan.RSMaterialButtonCircle Delete_Button;
    private rojerusan.RSMaterialButtonCircle Update_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private javax.swing.JTextField txt_contactNumber;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_studentId;
    private javax.swing.JTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
