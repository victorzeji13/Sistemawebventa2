<%-- 
    Document   : Reporte
    Created on : 29 nov. 2023, 15:26:43
    Author     : Lenovo
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>     
           <table class="table table-hover">
                    <thead>
                        <tr>  
                            <th scope="col">IDVENTAS</th>
                            <th scope="col">CLIENTE</th>
                            <th scope="col">EMPLEADO</th>
                            <th scope="col">NUMERO SERIE</th>
                            <th scope="col">MONTO</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="venta" items="${listaVentas}">
                         <tr>  
                            <td>${venta.getIdVentas()}</td> 
                            <td>${venta.getNombreCliente()}</td> 
                            <td>${venta.getNombreEmpleado()}</td> 
                            <td>${venta.getNumeroSeriep()}</td>
                            <td>${venta.getMonto()}</td>                                                      
                        </tr> 
                       </c:forEach>                                          
                    </tbody>
                </table>
               
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>   
</html>
