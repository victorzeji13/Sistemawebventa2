
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    private final String JDBC__URL = "jdbc:mysql://localhost:3306/venta";
    private final String JDBC__USER = "root";
    private final String JDBC_PASSWORD = "admin";
    Connection con;
    
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBC__URL, JDBC__USER, JDBC_PASSWORD);
        } catch (Exception e) {
            
        }
        return con;
    }
    
//    public static void close(ResultSet rs) throws SQLException{
//        rs.close();
//    }
    
    
//    
//    public static void close(Statement smtm) throws SQLException{
//        smtm.close();
//    }
//    
//    public static void close(PreparedStatement smtm) throws SQLException{
//        smtm.close();
//    }
//    
//    public static void close(Connection con) throws SQLException{
//        con.close();
//    }
}
