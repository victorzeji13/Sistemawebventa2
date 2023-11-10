
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {
    
    private static final String sql = "select max(NumeroSerie) from ventas";
  
    String numero;
    int dato;
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
                       
       dato= numeroSerie+1;
        
       if((this.dato>=10000000)&&(this.dato<100000000)){
            numero=""+this.dato;
        }        
        else if((this.dato>=1000000)&&(this.dato<10000000)){
            numero="0"+this.dato;
        }        
        else if((this.dato>=100000)&&(this.dato<1000000)){
            numero="00"+this.dato;
        }
        else if((this.dato>=10000)&&(this.dato<100000)){
            numero="000"+this.dato;
        }
        else if((this.dato>=1000)&&(this.dato<10000)){
            numero="0000"+this.dato;
        }
        else if((this.dato>=100)&&(this.dato<1000)){
            numero="00000"+this.dato;
        }
        else if((this.dato>=10)&&(this.dato<100)){
            numero="000000"+this.dato;
        }
        else if(this.dato<10){
            numero="00000000"+this.dato;
        }
       return numero;
     }
}