
package Modelo;

import java.sql.Date;

public class Venta {  

          
    private int idVentas;
    private int idCliente;
    private int idEmpleado;
    private String numeroSerie;
    private Date fechaVenta;
    private double monto;
    private String estado;
    private int item;
    private int idProducto;
    private String descripcion;
    private double precio;
    private int cantidad;
    private double subtotal;
   
    
    public Venta(){
        
    }   

    public Venta(int item, int idProducto, String descripcion, double precio, int cantidad, double subtotal) {
        this.item = item;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
    
    
    public Venta(int idVentas, int idCliente, int idEmpleado, String numeroSerie, Date fechaVenta, double monto, String estado) {
        // se creo el constructor
        this.idVentas = idVentas;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.numeroSerie = numeroSerie;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
        this.estado = estado;
        
    }

    public Venta(int idCliente, int idEmpleado, String numeroSerie, Date fechaVenta, double monto, String estado) {
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.numeroSerie = numeroSerie;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
        this.estado = estado;
    }

    /**
     * @return the idVentas
     */
    public int getIdVentas() {
        return idVentas;
    }

    /**
     * @param idVentas the idVentas to set
     */
    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * @return the numeroSerie
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * @param numeroSerie the numeroSerie to set
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * @return the fechaVenta
     */
    public Date getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @param fechaVenta the fechaVenta to set
     */
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    /**
     * @return the item
     */
    public int getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(int item) {
        this.item = item;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
       
}
