
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    
    private static final String SQL_CONSULTA_IDPRODUCTO = "SELECT * FROM producto WHERE idProducto = ?";
    private static final String SQL_STOCK_PRODUCTO = "UPDATE producto SET Stock=? WHERE idProducto = ?";
    private static final String SQL_INSERT_PRODUCTO ="INSERT INTO producto (Nombres , Precio , Stock ,Estado) VALUES (? , ? , ? ,?)";
    private static final String SQL_CONSULTA_PRODUCTOS ="SELECT * FROM producto"; 
    private static final String SQL_UPDATE_PRODUCTO = "UPDATE producto SET Nombres = ? ,Precio = ? , Stock = ? , Estado = ? WHERE idProducto = ?";
    private static final String SQL_DELETE_PRODUCTO = "DELETE FROM producto WHERE idProducto = ?";    
    
  public List<Producto> listarProducto(){
      Conexion conexion = new Conexion();
      Connection conn;
      PreparedStatement pstm; 
      ResultSet rs;
      Producto producto = null;
      List<Producto> listaProducto = new ArrayList<>();
      try {
         conn = conexion.getConnection(); 
         pstm = conn.prepareStatement(SQL_CONSULTA_PRODUCTOS);
         rs = pstm.executeQuery();
          while (rs.next()) {              
              int idProducto = rs.getInt("idProducto");
              String nombre = rs.getString("Nombres");
              double precio = rs.getDouble("Precio");
              int stock = rs.getInt("Stock");
              String estado = rs.getString("Estado");
              producto = new Producto(idProducto, nombre, precio, stock, estado);
              listaProducto.add(producto);
          }
      }  catch (Exception e) {
      }
          return listaProducto;
  }   
    
   public int insertarProducto(Producto producto){
       Conexion conexion = new Conexion();
       Connection conn;
       PreparedStatement pstm;
       int registros = 0;
       try {
           conn = conexion.getConnection();
           pstm = conn.prepareStatement(SQL_INSERT_PRODUCTO);
           pstm.setString(1, producto.getNombres());
           pstm.setDouble(2, producto.getPrecio());
           pstm.setInt(3, producto.getStock());
           pstm.setString(4, producto.getEstado());
           registros = pstm.executeUpdate();
           
       } catch (Exception e) {
       }
        return registros;        
      
   }
   
   public int actualizarProducto(Producto producto){
       Conexion conexion = new Conexion();
       Connection conn;
       PreparedStatement pstm;
       int registros = 0;
       try {
           conn = conexion.getConnection();
           pstm = conn.prepareStatement(SQL_UPDATE_PRODUCTO);
           pstm.setString(1, producto.getNombres());
           pstm.setDouble(2, producto.getPrecio());
           pstm.setInt(3, producto.getStock());
           pstm.setString(4, producto.getEstado());
           pstm.setInt(5, producto.getIdProducto());
           registros = pstm.executeUpdate();
           
       } catch (Exception e) {
       }
          return registros;
   }
    
    public Producto buscarProducto(int idProducto){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        Producto producto = null;
        
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_CONSULTA_IDPRODUCTO);
            pstm.setInt(1, idProducto);
            rs = pstm.executeQuery();
            while (rs.next()) {                
                int codigoproducto = rs.getInt("idProducto");
                String nombre = rs.getString("Nombres");
                double precio = rs.getDouble("Precio");
                int stock = rs.getInt("Stock");
                String estado = rs.getString("Estado");
                producto = new Producto(codigoproducto, nombre, precio, stock, estado);
                
            }
        } catch (Exception e) {
        }
        return producto;
    }
    public void eliminarProducto(Producto producto){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE_PRODUCTO);
            pstm.setInt(1, producto.getIdProducto());
            pstm.executeUpdate();
        } catch (Exception e) {
        }
    }
    
     public int stockProducto(int cantidad, int idProducto){
        
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstm;
        int registros = 0;
        try {
            conn = conexion.getConnection();
            pstm = conn.prepareStatement(SQL_STOCK_PRODUCTO);
            pstm.setInt(1, cantidad);
            pstm.setInt(2, idProducto);
            registros = pstm.executeUpdate();
            
        } catch (Exception e) {
        }
           return registros;
    }
    
}
