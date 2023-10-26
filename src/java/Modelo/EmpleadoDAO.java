package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.Conexion;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    

    private static final String SQL_CONSULTA = "SELECT * FROM empleado WHERE User = ? and Dni = ?";
    private static final String SQL_SELECT = "SELECT * FROM empleado";
    private static final String SQL_INSERT = "INSERT INTO empleado(Dni , Nombres , Telefono , Estado , User) VALUES (? , ? , ? , ? , ?)"; 
    private static final String SQL_CONSULTA_IDEMPLEADO = "SELECT * FROM empleado WHERE idEmpleado = ?";
    private static final String SQL_UPDATE = "UPDATE empleado SET Dni = ? , Nombres = ? , Telefono = ? , Estado = ? , User = ?  WHERE idEmpleado = ?";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE idEmpleado = ?";
    
    public Empleado validar(String user, String password) {
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        Empleado empleado = null;
        try {
            conn = conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_CONSULTA);
            pstmt.setString(1, user);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String dni = rs.getString("Dni");
                String nombres = rs.getString("Nombres");
                String telefono = rs.getString("Telefono");
                String estado = rs.getString("Estado");
                String usuario = rs.getString("User");
                empleado = new Empleado(idEmpleado, dni, nombres, telefono, estado, usuario);
            }

        } catch (Exception e) {

        }
        return empleado;
    }
    
    public int registrar(Empleado empleado){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        int registros = 0;
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_INSERT);
            pstm.setString(1, empleado.getDni());
            pstm.setString(2, empleado.getNombre());
            pstm.setString(3, empleado.getTelefono());
            pstm.setString(4, empleado.getEstado());
            pstm.setString(5, empleado.getUser());
            registros = pstm.executeUpdate();
        } catch (Exception e) {
                    }
        return registros;
    }
    
    public int actualizar(Empleado empleado){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        int registros = 0;
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, empleado.getDni());
            pstm.setString(2, empleado.getNombre());
            pstm.setString(3, empleado.getTelefono());
            pstm.setString(4, empleado.getEstado());
            pstm.setString(5, empleado.getUser());
            pstm.setInt(6, empleado.getIdEmpleado());
            registros = pstm.executeUpdate();
        } catch (Exception e) {
        }
        
        return registros;
    }  
    
    public void eliminar(Empleado empleado){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE);
            pstm.setInt(1, empleado.getIdEmpleado());
            pstm.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    
    public Empleado listarIdempleado(int idempleado){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        Empleado empleado = null;       
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_CONSULTA_IDEMPLEADO);
            pstm.setInt(1, idempleado);
            rs = pstm.executeQuery();
            while(rs.next()){
               int idEmpleado = rs.getInt("idEmpleado");
               String dni = rs.getString("Dni");
               String nombres = rs.getString("Nombres");
               String telefono = rs.getString("Telefono");
               String estado = rs.getString("Estado");
               String usuario = rs.getString("User");  
               empleado = new Empleado(idEmpleado, dni, nombres, telefono, estado, usuario);
            }
        } catch (Exception e) {
        }
        return empleado;
    }

    public List<Empleado> listarEmpleado() {
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        Empleado empleado = null;
        List<Empleado> listaEmpleados = new ArrayList<>();
        try {
            conn = conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String dni = rs.getString("Dni");
                String nombres = rs.getString("Nombres");
                String telefono = rs.getString("Telefono");
                String estado = rs.getString("Estado");
                String usuario = rs.getString("User");
                empleado = new Empleado(idEmpleado, dni, nombres, telefono, estado, usuario);
                listaEmpleados.add(empleado);
            }
        } catch (Exception e) {

        }
          return listaEmpleados;

    }
}
