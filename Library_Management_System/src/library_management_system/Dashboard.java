package library_management_system;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


public class Dashboard extends javax.swing.JFrame {

    DefaultTableModel model;
    String curr_user = null;

    public Dashboard() {
        initComponents();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screensize.width, screensize.height - 45);
        setLocationRelativeTo(null);
        showPieChart();
        setpendingBookDetailsToTable();
        setDataToCard();
    }

    public void setpendingBookDetailsToTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managemnt_system", "root", "");
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book where status = '" + "Pending" + "'");

            while (rs.next()) {

                String BookName = rs.getString("book_name");

                String studentname = rs.getString("student_name");
                String IssuDate = rs.getString("issue_date");
                String DueDate = rs.getString("due_date");
                String Status = rs.getString("status");

                Object[] obj = {BookName, studentname, IssuDate, DueDate, Status};
                model = (DefaultTableModel) tbl_pendingbookdetails.getModel();
                model.addRow(obj);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setDataToCard() {
        Statement st = null;
        ResultSet rs = null;

        long L = System.currentTimeMillis();
        Date todaysDate = new Date(L);

        try {
            Connection conn = DbConnection.connect();
            st = (Statement) conn.createStatement();
            rs = st.executeQuery("select * from book_details");
            rs.last();
            lbl_totbooks.setText((Integer.toString(rs.getRow())));

            rs = st.executeQuery("select * from student_details");
            rs.last();
            lbl_totstudent.setText((Integer.toString(rs.getRow())));

            rs = st.executeQuery("select * from issue_book where status = '" + "Pending" + "'");
            rs.last();
            lbl_totissued.setText((Integer.toString(rs.getRow())));

            rs = st.executeQuery("select * from issue_book where status = '" + "Returned" + "'");
            rs.last();
            lbl_received.setText((Integer.toString(rs.getRow())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showPieChart() {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
        try {
            Connection conn = DbConnection.connect();
            String sql = "select book_name,count(*) as issue_count from issue_book group by book_id";
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Book Issue", barDataset, true, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelpiechart.removeAll();
        panelpiechart.add(barChartPanel, BorderLayout.CENTER);
        panelpiechart.validate();
    }

    public void user(String user) {
        this.curr_user = user;
        jLabel8.setText("Welcome " + user + " !");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        lblManageStudent = new javax.swing.JLabel();
        lblIssuebook = new javax.swing.JLabel();
        lblPendingDetails = new javax.swing.JLabel();
        lblDashboard = new javax.swing.JLabel();
        lblManagebooks = new javax.swing.JLabel();
        lblReturnBook = new javax.swing.JLabel();
        lblViewrecords = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl_totbooks = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_totstudent = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbl_totissued = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lbl_received = new javax.swing.JLabel();
        panelpiechart = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_pendingbookdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/library-managemnt-system-high-resolution-logo-black-on-white-background (1).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 70));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Library Management System");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 600, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/Turn-Off-icon.png"))); // NOI18N
        jLabel3.setText(" LOGOUT");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, 90, 40));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 190, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/minimize.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 20, 30, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 70));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/logoutt.png"))); // NOI18N
        lblLogout.setText("  LogOut");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        lblManageStudent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblManageStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/manage students.png"))); // NOI18N
        lblManageStudent.setText("  Manage Students");
        lblManageStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageStudentMouseClicked(evt);
            }
        });

        lblIssuebook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIssuebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/issue book.png"))); // NOI18N
        lblIssuebook.setText("  Issue Books");
        lblIssuebook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIssuebookMouseClicked(evt);
            }
        });

        lblPendingDetails.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPendingDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/pending.png"))); // NOI18N
        lblPendingDetails.setText("  Pending Details");
        lblPendingDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPendingDetailsMouseClicked(evt);
            }
        });

        lblDashboard.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/library.png"))); // NOI18N
        lblDashboard.setText("  LMS Dashboard");
        lblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDashboardMouseClicked(evt);
            }
        });

        lblManagebooks.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblManagebooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/manage books.png"))); // NOI18N
        lblManagebooks.setText("  Manage Books");
        lblManagebooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManagebooksMouseClicked(evt);
            }
        });

        lblReturnBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblReturnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/return book png.png"))); // NOI18N
        lblReturnBook.setText("  Return Books");
        lblReturnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReturnBookMouseClicked(evt);
            }
        });

        lblViewrecords.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblViewrecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/viewrecords.png"))); // NOI18N
        lblViewrecords.setText("  view Records");
        lblViewrecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewrecordsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblManagebooks, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblManageStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIssuebook, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReturnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblViewrecords, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPendingDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblManagebooks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblManageStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblIssuebook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblReturnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblViewrecords, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblPendingDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 700));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(35, 0, 0, 0, new java.awt.Color(102, 0, 255)));
        jPanel5.setPreferredSize(new java.awt.Dimension(260, 100));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Sitka Display", 1, 25)); // NOI18N
        jLabel6.setText("Total Books");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 40));

        lbl_totbooks.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_totbooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/book.png"))); // NOI18N
        lbl_totbooks.setText(" 10");
        jPanel5.add(lbl_totbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 120, 60));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 220, 140));

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(35, 0, 0, 0, new java.awt.Color(102, 0, 255)));
        jPanel6.setPreferredSize(new java.awt.Dimension(260, 100));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Sitka Display", 1, 25)); // NOI18N
        jLabel13.setText("Total Students");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 180, 40));

        lbl_totstudent.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_totstudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/student.png"))); // NOI18N
        lbl_totstudent.setText(" 10");
        jPanel6.add(lbl_totstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 60));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 220, 140));

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(35, 0, 0, 0, new java.awt.Color(102, 0, 255)));
        jPanel7.setPreferredSize(new java.awt.Dimension(260, 100));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Sitka Display", 1, 25)); // NOI18N
        jLabel15.setText("Total Pending");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 160, 40));

        lbl_totissued.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_totissued.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/issue.png"))); // NOI18N
        lbl_totissued.setText(" 10");
        jPanel7.add(lbl_totissued, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 120, 60));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 220, 140));

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(35, 0, 0, 0, new java.awt.Color(102, 0, 255)));
        jPanel8.setPreferredSize(new java.awt.Dimension(260, 100));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Sitka Display", 1, 25)); // NOI18N
        jLabel17.setText("Total Received");
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 160, 40));

        lbl_received.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_received.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/received.png"))); // NOI18N
        lbl_received.setText("10");
        jPanel8.add(lbl_received, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 60));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 220, 140));

        panelpiechart.setLayout(new java.awt.BorderLayout());
        jPanel4.add(panelpiechart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 500, 340));

        tbl_pendingbookdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_pendingbookdetails.setColorBackgoundHead(new java.awt.Color(0, 153, 102));
        tbl_pendingbookdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_pendingbookdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        tbl_pendingbookdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        tbl_pendingbookdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        tbl_pendingbookdetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        tbl_pendingbookdetails.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_pendingbookdetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_pendingbookdetails.setRowHeight(40);
        tbl_pendingbookdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pendingbookdetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_pendingbookdetails);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 590, 310));

        jLabel21.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/book-64.png"))); // NOI18N
        jLabel21.setText("  Pending  list");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 220, 70));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 1160, 690));

        setSize(new java.awt.Dimension(1366, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblManagebooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManagebooksMouseClicked

        ManageBook books = new ManageBook();
        books.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblManagebooksMouseClicked

    private void lblManageStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageStudentMouseClicked
        ManageStudents students = new ManageStudents();
        students.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblManageStudentMouseClicked

    private void lblIssuebookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIssuebookMouseClicked
        // TODO add your handling code here:
        IssueBook Issuebook = new IssueBook();
        Issuebook.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblIssuebookMouseClicked

    private void lblPendingDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPendingDetailsMouseClicked
        // TODO add your handling code here:
        IssuedBookdetailes pending = new IssuedBookdetailes();
        pending.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblPendingDetailsMouseClicked

    private void lblReturnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnBookMouseClicked
        // TODO add your handling code here:
        ReturnBook returnbook = new ReturnBook();
        returnbook.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblReturnBookMouseClicked

    private void lblViewrecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewrecordsMouseClicked
        // TODO add your handling code here:
        viewRecords viewrecords = new viewRecords();
        viewrecords.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblViewrecordsMouseClicked

    private void tbl_pendingbookdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pendingbookdetailsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_pendingbookdetailsMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        // TODO add your handling code here:
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseClicked
        // TODO add your handling code here:
        Dashboard db = new Dashboard();
        db.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblDashboardMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(LoginPage.ICONIFIED);
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblIssuebook;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblManageStudent;
    private javax.swing.JLabel lblManagebooks;
    private javax.swing.JLabel lblPendingDetails;
    private javax.swing.JLabel lblReturnBook;
    private javax.swing.JLabel lblViewrecords;
    private javax.swing.JLabel lbl_received;
    private javax.swing.JLabel lbl_totbooks;
    private javax.swing.JLabel lbl_totissued;
    private javax.swing.JLabel lbl_totstudent;
    private javax.swing.JPanel panelpiechart;
    private rojeru_san.complementos.RSTableMetro tbl_pendingbookdetails;
    // End of variables declaration//GEN-END:variables

}
