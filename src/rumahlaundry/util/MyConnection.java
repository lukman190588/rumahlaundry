package rumahlaundry.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MyConnection {
    private Connection connection;
    
    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Success Open Connection");
        } catch (ClassNotFoundException ex){
            System.out.println("Connection Problem " + ex);
        }
        
        String url = "jdbc:mysql://localhost/rumahlaundry";
        try {
            connection = DriverManager.getConnection(url, "root", "");
            System.out.println("Success Open Connection ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Check Your Connection ");
            System.out.println("Connection Problem " + ex);
        }
        return connection;
    }

}
