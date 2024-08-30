package library_management_system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ReturnBook extends javax.swing.JFrame {

    public ReturnBook() {
        initComponents();
    }
    
    // to catch the issue book details from the databese and display
    public void getIssueBookDetails(){        
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection conn = DbConnection.connect();
            String sql = "select * from issue_book where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setInt(1 , bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "Pending");
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                
                lbl_IssueId.setText(rs.getString("id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_studentName.setText(rs.getString("student_name"));
                lbl_IssueDate.setText(rs.getString("issue_date"));
                lbl_DueDate.setText(rs.getString("due_date"));
                lbl_bookError.setText("");
            }else{
                lbl_bookError.setText("NO RECORD FOUND!!");
                lbl_IssueId.setText("");
                lbl_bookName.setText("");
                lbl_studentName.setText("");
                lbl_IssueDate.setText("");
                lbl_DueDate.setText("");
                                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    //return the book
    public boolean returnBook(){
        boolean isReturned = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection conn = DbConnection.connect();
            String sql = "update issue_book set status = ? where student_id = ? and book_id = ? and status = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, "Returned");
            pst.setInt(2, studentId);
            pst.setInt(3, bookId);
            pst.setString(4, "Pending");
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
                isReturned = true;
            }else{
                isReturned = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReturned;
    }

    //updating book count
    
    public void updateBookCount(){
        int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            Connection conn = DbConnection.connect();
            String sql = "Update book_details set quantity = quantity + 1 where book_id = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setInt(1 , bookId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
                JOptionPane.showMessageDialog(this, "Book count Updated");
            }else{
                JOptionPane.showMessageDialog(this, "Book Can not Updated!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //update return date
   
    public void updateReturnDate(){
        //boolean isupdateReturnDate = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        Date returnDate = combo_returnDate.getDate();
        long rd = returnDate.getTime();
        java.sql.Date sreturnDate = new java.sql.Date(rd);
        
        try {
            Connection conn = DbConnection.connect();
            String sql = "update issue_book set return_date = ? where student_id = ? and book_id = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setDate(1, sreturnDate);
            pst.setInt(2, studentId);
            pst.setInt(3, bookId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
                JOptionPane.showMessageDialog(this, "Return date Updated");
            }else{
                JOptionPane.showMessageDialog(this, "Return date Updated Failed!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return isupdateReturnDate;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txt_bookId = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_IssueId = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_bookName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_DueDate = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_IssueDate = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel26 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        combo_returnDate = new de.wannawork.jcalendar.JCalendarComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 1010));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 370, 2));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 51));
        jLabel22.setText("Book ID :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 80, 30));

        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_bookIdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_bookIdMouseEntered(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, 330, 30));

        jLabel21.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/issuebook.png"))); // NOI18N
        jLabel21.setText("Return  book");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 290, 80));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 51));
        jLabel23.setText("Student ID :");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 110, 30));

        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_studentIdMouseClicked(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, 330, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 0, 51));
        rSMaterialButtonCircle1.setText("Return  Book");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 570, 440, 60));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/managebooks.png"))); // NOI18N
        jLabel1.setText("Book  Details");

        jPanel4.setBackground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Issue ID :");

        lbl_IssueId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_IssueId.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lbl_bookName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Name :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Student Name :");

        lbl_studentName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));

        lbl_DueDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_DueDate.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Due Date :");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Issue Date : ");

        lbl_IssueDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_IssueDate.setForeground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_IssueId, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addGap(35, 35, 35)
                .addComponent(lbl_IssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addGap(48, 48, 48)
                .addComponent(lbl_DueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_IssueId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_IssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_DueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 400, 650));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(51, 153, 0));
        rSMaterialButtonCircle2.setText("Find");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, 440, 60));

        jLabel26.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/back.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 60, 50));

        lbl_bookError.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 0, 0));
        lbl_bookError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 400, 40));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 0, 51));
        jLabel24.setText("Reurn Date :");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 100, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/wr.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 40, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/min.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 40, 40));

        combo_returnDate.setDate(null);
        jPanel1.add(combo_returnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, 340, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 720));

        setSize(new java.awt.Dimension(1362, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        

    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_bookIdMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_bookIdMouseClicked

    private void txt_bookIdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_bookIdMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdMouseEntered

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_studentIdMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_studentIdMouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
       if(returnBook()== true){           
           JOptionPane.showMessageDialog(this, "Book Returned Successfully");
           updateBookCount();
           updateReturnDate();
           lbl_IssueId.setText("");
           lbl_bookName.setText("");
           lbl_studentName.setText("");
           lbl_IssueDate.setText("");
           lbl_DueDate.setText("");
           txt_bookId.setText("");
           txt_studentId.setText("");
        }else{
           JOptionPane.showMessageDialog(this, "Book Returned Failed!!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        Dashboard dash = new Dashboard();
        dash.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(IssueBook.ICONIFIED);
    }//GEN-LAST:event_jLabel15MouseClicked

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private de.wannawork.jcalendar.JCalendarComboBox combo_returnDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbl_DueDate;
    private javax.swing.JLabel lbl_IssueDate;
    private javax.swing.JLabel lbl_IssueId;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_studentName;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private javax.swing.JTextField txt_bookId;
    private javax.swing.JTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
