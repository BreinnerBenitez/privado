<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORMULARIO DEL REGISTRO</title>
</head>
<body>


<form:form action="procesarFormulario" modelAttribute="elalumno">

 Nombre: <form:input path="nombre"/>
 
 <br/> <br/> <br/>

Apellido: <form:input path="apellidos"/>
 
 <br/> <br/> <br/>
 
edad: <form:input path="edad"/>
<form:errors path="edad" style="color:red"></form:errors>
 
 <br/> <br/> <br/>
 
 email: <form:input path="email"/>
<form:errors path="email" style="color:red"></form:errors>
 
 <br/> <br/> <br/>
 
 
 
  codigopostal: <form:input path="codigopostal"/>
<form:errors path="codigopostal" style="color:red"></form:errors>
 
 <br/> <br/> <br/>
 
 
 Asignaturas Operativas: <br/>

<form:select path="optativa">

<form:option value="Diseño" label="Diseño"></form:option>
<form:option value="desarrollo" label="desarollo"></form:option>
<form:option value="linux" label="linux"></form:option>
	
		
</form:select>

<br/> <br/> <br/>
 
  cali<form:radiobutton path="ciudadesestudio" value="cali"/>
 palmira<form:radiobutton path="ciudadesestudio" value="palmira"/>
 gorgona<form:radiobutton path="ciudadesestudio" value="gorgona"/>
 candelaria<form:radiobutton path="ciudadesestudio" value="candelaria"/>
 
 <br/> <br/> <br/>
 
 
  ingles<form:checkbox path="idiomas" value="ingles"/>
  mandarin<form:checkbox path="idiomas" value="mandarin"/>
  frances<form:checkbox path="idiomas" value="frances"/>
  español<form:checkbox path="idiomas" value="español"/>
 
 <br/> <br/> <br/>

<input type="submit" value ="enviar">


</form:form>

<br/>



</body>
</html>