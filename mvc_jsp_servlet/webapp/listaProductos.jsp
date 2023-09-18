<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.breinner.aprende.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>  

table{ 

float:left

}

#contenedorBoton{

margin-left:1000px;
}

</style>

</head>


<%
// optien productos del controlador

List <Productos> losproductos=(List<Productos>)request.getAttribute("listaProductos");


%>



<body>

<table>

<tr>    
<td>   codigo articulo</td>
<td>   seccion</td>
<td>   nombre Articulo</td>
<td>   precio</td>
<td>   fecha</td>
<td>   pais de origen</td>
<td>   Accion</td>
 </tr>



<%for(Productos tempp: losproductos){ %>

<tr> 

<td> <%= tempp.getCodigo_articulo() %> </td>

<td> <%= tempp.getSeccion() %> </td>

<td> <%= tempp.getMombre_articulo() %> </td>

<td> <%= tempp.getPrecio()  %> </td>

<td> <%= tempp.getFecha() %> </td>

<td> <%= tempp.getPais_origen() %> </td>

<td> aqui ira el link eliminar </td>

</tr>

<% }%>

</table> 


<div id="contenedorBoton">


<input type="button" value="InsertarRegistro" onclick="window.location.href='inserta_producto.jsp'"/>


 </div>

</body>
</html>