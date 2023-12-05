
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    
    private static final String SQL_CONSULTA_DNI = "SELECT * FROM cliente WHERE dni = ?";
    private static final String SQL_CONSULTA_CLIENTES = "SELECT * FROM cliente";
    private static final String SQL_INSERT_CLIENTE = "INSERT INTO cliente ( Dni , Nombres , Direccion , Estado ) VALUES (? , ? , ? , ? )";
    private static final String SQL_CONSULTA_IDCLIENTE = "SELECT * FROM cliente WHERE idCliente  = ?";
    private static final String SQL_DELETE_CLIENTE = "DELETE FROM cliente WHERE idCliente = ?";
    private static final String SQL_CONSULTA_UPDATE_CLIENTE = "UPDATE cliente SET Dni= ? , Nombres = ? , Direccion = ? , Estado = ? WHERE idCliente = ?";
    
    public int guardarClientes(Cliente cliente){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        int registros = 0;
        
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_INSERT_CLIENTE);
            pstm.setString(1, cliente.getDni());
            pstm.setString(2, cliente.getNombres());
            pstm.setString(3, cliente.getDireccion());
            pstm.setString(4, cliente.getEstado());
            registros = pstm.executeUpdate();
                    
                    
        } catch (Exception e) {
        }
        
        return registros;
    }
    
    public int actualizarCliente(Cliente cliente){
        Conexion conexion = new Conexion();
        Connection conn ;
        PreparedStatement pstm;
        int registros = 0;
        
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_CONSULTA_UPDATE_CLIENTE);
            pstm.setString(1, cliente.getDni());
            pstm.setString(2, cliente.getNombres());
            pstm.setString(3, cliente.getDireccion());
            pstm.setString(4, cliente.getEstado());
            pstm.setInt(5, cliente.getIdCliente());
            registros = pstm.executeUpdate();
            
        } catch (Exception e) {
        }
         return registros;
    }
            
    public List<Cliente> listarClientes(){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_CONSULTA_CLIENTES);
            rs = pstm.executeQuery();
            while (rs.next()) {
               int idCliente = rs.getInt("idCliente");
               String dni = rs.getString("Dni");
               String nombre = rs.getString("Nombres");
               String direccion = rs.getString("Direccion");
               String estado = rs.getString("Estado");
               Cliente cliente = new Cliente(idCliente, dni, nombre, direccion, estado);
               listaClientes.add(cliente);
            }
        } catch (Exception e) {
        }
        return listaClientes;
        
    }
    
    public Cliente listarIdCliente(int idCliente){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        Cliente cliente = null;
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_CONSULTA_IDCLIENTE);
            pstm.setInt(1, idCliente);
            rs = pstm.executeQuery();
            while (rs.next()) {                
                String dni = rs.getString("Dni");
                String nombre = rs.getString("Nombres");
                String Direccion = rs.getString("Direccion");
                String estado = rs.getString("Estado");
                cliente = new Cliente(dni, nombre, Direccion, estado);
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    
    public Cliente listarCliente(String dni){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        Cliente cliente = null;
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_CONSULTA_DNI);
            pstm.setString(1, dni);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                String dnicliente = rs.getString("Dni");
                String nombre = rs.getString("Nombres");
                String direccion = rs.getString("Direccion");
                String estado = rs.getString("Estado");
                cliente = new Cliente(idCliente, dnicliente, nombre, direccion, estado);
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    
    public void eliminarCliente(Cliente cliente){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE_CLIENTE);
            pstm.setInt(1, cliente.getIdCliente());
            pstm.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    
    
}
