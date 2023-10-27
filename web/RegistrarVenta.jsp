<%-- 
    Document   : RegistrarVenta
    Created on : 5 oct. 2023, 11:39:25
    Author     : Lenovo
--%>

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
            <div class="card col-sm-5">
                <form action="Controlador?menu=NuevaVenta" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos del Cliente</label>
                        </div>                   
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" value="${cliente.dni}" name="codigoCliente" class="form-control" placeholder="Codigo"> 
                                <input type="submit" name="accion" value="Buscar"  class="btn btn-outline-info">  
                            </div>
                            <div class="col-sm-6">
                                <input type="text" value="${cliente.nombres}" name="nombreCliente" placeholder="Datos Cliente" class="form-control">                
                            </div>  
                        </div>  
                        <div class="form-group">
                            <label>Datos del Producto</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" value="${producto.idProducto}" name="codigoProducto" class="form-control" placeholder="Codigo"> 
                                <input type="submit" name="accion" value="BuscarProducto"  class="btn btn-outline-info">  
                            </div>
                            <div class="col-sm-6">
                                <input type="text" value="${producto.nombres}" name="nombreProducto" placeholder="Datos Producto" class="form-control">                
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 ">
                                <input type="text" name="precio" class="form-control" placeholder="S/0.00">                              
                            </div>
                            <div class="col-sm-3">
                                <input type="number" name="cantidad"  class="form-control">                          
                            </div>
                            <div class="col-sm-3">
                                <input type="text" name="stock" class="form-control" placeholder="Stock">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info">
                    </div>                    
                </form>
            </div>
            <div class="card col-sm-7">
                <div class="card-body">
                    <div class="form-group col-sm-6 d-flex ml-auto">
                        <label>NumeroSerie</label>
                        <input type="text" name="NroSerie" class="form-control">
                    </div>
                    <br>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Nro</th>
                                <th>Codigo</th>
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>SubTotal</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer">
                    <input type="submit" name="accion" value="GenerarVenta" class="btn btn-success">
                    <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                </div>
            </div>

        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
