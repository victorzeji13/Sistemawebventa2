
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    
    private static final String SQL_SERIE = "select max(NumeroSerie) from ventas";
    private static final String SQL_IDVENTA = "select max(idVentas) from ventas";
    private static final String SQL_INSERT = "INSERT INTO ventas (idCliente , idEmpleado , NumeroSerie , Fechaventa , Monto , Estado) VALUES(? , ? , ? , ? , ?, ?)";
    private static final String SQL_INSERT_DETALLE = "INSERT INTO detalleventa(idVentas , idProducto , Cantidad , Precioventa) VALUES (? , ? , ? , ?)";
    private static final String SQL_LISTAR_VENTA = "SELECT ventas.idVentas, cliente.Nombres, empleado.Nombres, ventas.NumeroSerie, ventas.Monto FROM ventas INNER JOIN cliente ON ventas.idCliente = cliente.idCliente INNER JOIN empleado ON ventas.idEmpleado = empleado.idEmpleado ORDER BY idVentas ASC";
    
    public List<Venta> listarVentas(){
        
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        List<Venta> listaVentas = new ArrayList<>();
        Venta venta = null;
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_LISTAR_VENTA);
            rs = pstm.executeQuery();
            while (rs.next()) {  
                 int ventas = rs.getInt(1);
                String nombreCliente = rs.getString(2);
                String nombreEmpleado = rs.getString(3);
                int numeroSerie = rs.getInt(4);
                double monto = rs.getDouble(5);
                venta = new Venta(ventas, nombreCliente , nombreEmpleado , numeroSerie, monto);
                listaVentas.add(venta);
            }
            
        } catch (Exception e) {
        }
        return listaVentas;
    }
    
    
    public int guardarVenta (Venta venta){
        
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        int registros = 0;
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_INSERT);
            pstm.setInt(1, venta.getIdCliente());
            pstm.setInt(2, venta.getIdEmpleado());
            pstm.setString(3, venta.getNumeroSerie());
            pstm.setDate(4, venta.getFechaVenta());
            pstm.setDouble(5, venta.getMonto());
            pstm.setString(6, venta.getEstado());
            registros = pstm.executeUpdate();
        } catch (Exception e) {
        }
        
        return registros;
        
    }
    
    public int guardarVentadetalle(Venta venta){
        
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        int registros = 0;
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_INSERT_DETALLE);
            pstm.setInt(1, venta.getIdVentas());
            pstm.setInt(2, venta.getIdProducto());
            pstm.setInt(3, venta.getCantidad());
            pstm.setDouble(4, venta.getPrecio());
            registros = pstm.executeUpdate();
        } catch (Exception e) {
        }
        
        return registros;
    }   
   
    public int generarIdventa(){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        int idVenta = 0;       
        try {
            conn = conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_IDVENTA);
            rs = pstmt.executeQuery();
            while (rs.next()) {     
                idVenta = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        
        return idVenta;
    }
    
    public int generarSerie(){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        int numeroSerie = 0; 
        try {
            conn = conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SERIE);
            rs = pstmt.executeQuery();
            while (rs.next()) {     
                numeroSerie = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        
        return numeroSerie;
    }
     public String convertirNumeroSerie(int numeroSerie){
      
         String numero;
         int dato= numeroSerie+1;
         numero = "" + dato;
         return numero ;
      
     }
}