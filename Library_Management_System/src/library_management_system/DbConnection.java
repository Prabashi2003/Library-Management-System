package library_management_system;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection connect(){
        Connection conn = null;
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managemnt_system","root","");
            System.out.println(conn);

        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }
        return conn;       
    }
}
