<%-- 
    Document   : Producto
    Created on : 5 oct. 2023, 11:39:15
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="post">
                        <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" value="${producto.nombres}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                        <label>Precio</label>
                        <input type="text" value="${producto.precio}" name="txtPrecio" class="form-control">
                        </div>
                        <div class="form-group">
                        <label>Stock</label>
                        <input type="text" value="${producto.stock}" name="txtStock" class="form-control">
                        </div>
                        <div class="form-group">
                        <label>Estado</label>
                        <input type="text" value="${producto.estado}" name="txtEstado" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div> 
            </div>
            <div class="card col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">CODIGO</th>
                            <th scope="col">NOMBRES</th>
                            <th scope="col">PRECIO</th>
                            <th scope="col">STOCK</th>
                            <th scope="col">ESTADO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <c:forEach var="pro" items="${listaProducto}">
                            <tr>
                                <td>${pro.getIdProducto()}</td>
                                <td>${pro.getNombres()}</td>
                                <td>${pro.getPrecio()}</td>
                                <td>${pro.getStock()}</td>
                                <td>${pro.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&codigoProducto=${pro.getIdProducto()}">Editar</a>
                                    <a class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
