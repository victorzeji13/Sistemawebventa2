
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ClienteDAO {
    
    private static final String SQL_CONSULTA_IDCLIENTE = "SELECT * FROM cliente WHERE dni = ?";
    
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
                String dnicliente = rs.getString("Dni");
                String nombre = rs.getString("Nombres");
                String direccion = rs.getString("Direccion");
                String estado = rs.getString("Estado");
                cliente = new Cliente(dnicliente, nombre, direccion, estado);
            }
        } catch (Exception e) {
        }
        return cliente;
    }
}
