<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> formulario actualizar</h1>
	
	<form name="form1" action="ControladorProductos" method="get">
     <input  type="hidden" name="instrucion" value="cargarBBDD">
       <input  type="hidden" name="codigoarticulo" value="producto_actaulizar">
     
		<table width="35%" border="0">
		
			<tr>
				<td width="13%"><label for="apellido">Seccion:</label></td>
				<td width="87%"><input type="text" name="seccion"
					id="seccion"></td>
			</tr>
			<tr>
				<td width="13%"><label for="usuario">Nombre_Articulo:</label></td>
				<td width="87%"><input type="text" name="nombrearticulo" id="nombrearticulo"></td>
			</tr>
			<tr>
				<td width="13%"><label for="contra">fecha:</label></td>
				<td width="87%"><input type="text" name="fecha" id="fecha""></td>
			</tr>

			<tr>
				<td width="13%"><label for="contra">Precio:</label></td>
				<td width="87%"><input type="text" name="precio" id="precio"></td>
			</tr>
		
	
			<tr>
				<td width="13%"><label for="contra">PaisOrigen:</label></td>
				<td width="87%"><input type="text" name="paisorigen" id="paisorigen"></td>
			</tr>
		
		
			<tr>
				<td colspan="2" align="center"><input type=submit name="enviar"
					id="button" value="Enviar"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type=submit name="restablecer"
					id="button" value="restablecer"></td>
			</tr>
			<p>
				<br>
			</p>
		</table>

	</form>


</body>
</html>