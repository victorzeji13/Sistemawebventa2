/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class Controlador extends HttpServlet {

    EmpleadoDAO empleadoDao = new EmpleadoDAO();
    Empleado empleado = new Empleado();
    ClienteDAO clienteDao = new ClienteDAO();
    Cliente cliente = new Cliente();
    ProductoDAO productoDAO = new ProductoDAO();
    Producto producto = new Producto();
    List<Venta> listaventa = new ArrayList<>();
    VentaDAO ventaDAO = new VentaDAO();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cantidad;
    double subtotal;
    int idempleado;
    private double totalPagar;
    String numeroSerie;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String menu = request.getParameter("menu");
         String accion = request.getParameter("accion");
         if(menu.equals("Principal")){
             request.getRequestDispatcher("Principal.jsp").forward(request, response);
         } 
         if(menu.equals("Empleado")){
             switch (accion) {
                 case "Listar":
                     List<Empleado> listaEmpleado = empleadoDao.listarEmpleado();
                     request.setAttribute("listaEmpleado", listaEmpleado);
                     break;                 
                 case "Agregar":
                     String dni = request.getParameter("txtDni");
                     String nombre = request.getParameter("txtNombres");
                     String telefono = request.getParameter("txtTelefono");
                     String estado = request.getParameter("txtEstado");
                     String usuario = request.getParameter("txtUser");
                     Empleado empleadoRegistrado = new Empleado(dni, nombre, telefono, estado, usuario);
                     empleadoDao.registrar(empleadoRegistrado);
                     List<Empleado> listaEmpleado1 = empleadoDao.listarEmpleado();
                     request.setAttribute("listaEmpleado", listaEmpleado1);
                     break;                     
                 case "Editar":
                     idempleado = Integer.parseInt(request.getParameter("idEmpleado")) ;
                     empleado = empleadoDao.listarIdempleado(idempleado);
                     request.setAttribute("empleado", empleado);
                     List<Empleado> listaEmpleado2 = empleadoDao.listarEmpleado();
                     request.setAttribute("listaEmpleado", listaEmpleado2);
                     break; 
                 case "Actualizar":
                     String dniact = request.getParameter("txtDni");
                     String nombreact = request.getParameter("txtNombres");
                     String telefonoact = request.getParameter("txtTelefono");
                     String estadoact = request.getParameter("txtEstado");
                     String usuarioact = request.getParameter("txtUser");
                     empleado = new Empleado(idempleado ,dniact, nombreact, telefonoact, estadoact, usuarioact);
                     empleadoDao.actualizar(empleado);
                     List<Empleado> listaEmpleado3 = empleadoDao.listarEmpleado();
                     request.setAttribute("listaEmpleado", listaEmpleado3);
                     break;
                 case "Eliminar":
                     int idempleadoeliminar = Integer.parseInt(request.getParameter("idEmpleado"));
                     empleado.setIdEmpleado(idempleadoeliminar);
                     empleadoDao.eliminar(empleado);
                     List<Empleado> listaEmpleado4 = empleadoDao.listarEmpleado();
                     request.setAttribute("listaEmpleado", listaEmpleado4);                     
                     break;
                     
                 default:
                     throw new AssertionError();
             }
             request.getRequestDispatcher("Empleado.jsp").forward(request, response);
         }
         if(menu.equals("Cliente")){
             request.getRequestDispatcher("Clientes.jsp").forward(request, response);
         }
         if(menu.equals("Producto")){
             request.getRequestDispatcher("Producto.jsp").forward(request, response);
         }
         if(menu.equals("NuevaVenta")){
             switch (accion) {
                 case "Buscar":
                     String dni = request.getParameter("codigoCliente");
                     cliente = clienteDao.listarCliente(dni);
                     request.setAttribute("cliente", cliente);
                     break;
                 case "BuscarProducto":
                     int codigoProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                     producto = productoDAO.buscarProducto(codigoProducto);
                     request.setAttribute("producto", producto);
                     request.setAttribute("listaventa", listaventa);
                     request.setAttribute("cliente", cliente);
                     break;   
                 case "Agregar":
                     request.setAttribute("cliente", cliente);
                     totalPagar = 0.0 ;
                     item = item + 1;
                     cod = producto.getIdProducto();
                     descripcion = request.getParameter("nombreProducto");
                     precio = Double.parseDouble(request.getParameter("precio"));
                     cantidad = Integer.parseInt(request.getParameter("cantidad"));
                     subtotal = precio * cantidad;                     
                     Venta ventaagregar = new Venta(item, cod, descripcion, precio, cantidad, subtotal);
                     listaventa.add(ventaagregar);
                     for (int i = 0; i < listaventa.size() ; i++) {
                         totalPagar = totalPagar + listaventa.get(i).getSubtotal();
                     }
                     request.setAttribute("totalPagar", totalPagar);
                     request.setAttribute("listaventa", listaventa);
                     
                     
                     break;
                     
                 default:
                    numeroSerie = ventaDAO.generarSerie();
                    if(numeroSerie != null){
                    int incrementar = Integer.parseInt(numeroSerie);
                     numeroSerie = ventaDAO.convertirNumeroSerie(incrementar); 
                    request.setAttribute("numeroSerie", numeroSerie);
                            }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
             }
             request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
         }        
         
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
