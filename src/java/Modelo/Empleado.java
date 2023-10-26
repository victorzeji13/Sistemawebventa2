
package Modelo;


public class Empleado {
   
    private int idEmpleado;
    private String dni;
    private String nombre;
    private String telefono;
    private String estado;
    private String user;

    public Empleado() {
        
    }

    public Empleado(int idEmpleado, String dni, String nombre, String telefono, String estado, String user) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
        this.user = user;
    }
    public Empleado(String dni, String nombre, String telefono, String estado, String user) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
        this.user = user;
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

    
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
          
}
