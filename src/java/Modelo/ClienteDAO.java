
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    
    private static final String SQL_CONSULTA_IDCLIENTE = "SELECT * FROM cliente WHERE dni = ?";
    private static final String SQL_CONSULTA_CLIENTES = "SELECT * FROM cliente";
    
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
    
    public Cliente listarCliente(String dni){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        Cliente cliente = null;
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_CONSULTA_IDCLIENTE);
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
}
