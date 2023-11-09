
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {
    
    private static final String SQL_CONSULTA_NUMEROSERIE = "SELECT MAX (NumeroSerie) FROM ventas";
    String numeroSerie;
    String numero;
    public String generarSerie(){
        Conexion conexion = new Conexion();
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        //String numeroserie = "";
        try {
            conn = conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_CONSULTA_NUMEROSERIE);
            rs = pstmt.executeQuery();
            while (rs.next()) {                
                numeroSerie = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroSerie;
    }
   public String convertirNumeroSerie(int numeroSerie){
       int numero_Serie = numeroSerie + 1;
              
       if((numeroSerie>10)&&(numeroSerie<100)){
           numero = "000000" + numero_Serie;
       }
       if((numeroSerie>100) && (numeroSerie<1000)){
       numero = "00000" + numero_Serie;
       }
       
       return numero;
   }
}
