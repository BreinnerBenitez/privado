<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="springMVC.*"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/estilos/miestilo.css">
</head>
<body>


Hola ${param.nombreAlumno}. Bienvenido al curso de Spring 

<br/> <br/> 

 <%
 String nombrealumno= request.getParameter("nombreAlumno");
 if(nombrealumno==null){
	 
	 nombrealumno="invitado";	
 }
 
 %>
 
 Hola <%=nombrealumno%>. Bienvenido al curso de Spring 
 
 <br/> <br/> 
 
 
 <h2> atencion a todos </h2>
 
 ${mensajeClaro}
 
 
<h2> imagen</h2>

<img alt="foto" src="${pageContext.request.contextPath}/recursos/img/foto.PNG">

</body>
</html>