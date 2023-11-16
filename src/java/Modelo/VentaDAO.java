
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {
    
    private static final String sql = "select max(NumeroSerie) from ventas";
    private static final String SQL_IDVENTA = "select max(idVentas) from ventas";
    private static final String SQL_INSERT = "INSERT INTO ventas (idCliente , idEmpleado , NumeroSerie , Fechaventa , Monto , Estado) VALUES(? , ? , ? , ? , ?, ?)";
    private static final String SQL_INSERT_DETALLE = "INSERT INTO detalleventa(idVentas , idProducto , Cantidad , Precioventa) VALUES (? , ? , ? , ?)";
          
    String numero;
            
    public int guardarVenta (Venta venta){
        
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
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
        ResultSet rs;
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
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {     
                numeroSerie = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        
        return numeroSerie;
    }
     public String convertirNumeroSerie(int numeroSerie){
      int dato= numeroSerie+1;
        
       if((dato>=10000000)&&(dato<100000000)){
            numero=""+dato;
        }        
        else if((dato>=1000000)&&(dato<10000000)){
            numero="0"+dato;
        }        
        else if((dato>=100000)&&(dato<1000000)){
            numero="00"+dato;
        }
        else if((dato>=10000)&&(dato<100000)){
            numero="000"+dato;
        }
        else if((dato>=1000)&&(dato<10000)){
            numero="0000"+dato;
        }
        else if((dato>=100)&&(dato<1000)){
            numero="00000"+dato;
        }
        else if((dato>=10)&&(dato<100)){
            numero="000000"+dato;
        }
        else if(dato<10){
            numero="00000000"+dato;
        }
       return numero;
     }
}