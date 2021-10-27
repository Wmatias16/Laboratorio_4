<%@page import="dominio.TipoSeguro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.TipoSeguroDao"%>
<%@page import="dominio.Seguro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="inicio.jsp">Inicio </a><a href="">Agregar seguro </a><a href="">Listar seguros</a>
<h1>Agregar seguros</h1>

<%! String id = "0"; %>

Id seguro   <%=id %> <br>
<form action="servletSeguro" method="get">
Descripción <input type="text" name="txtDescripcion"><br>
Tipo seguro
<select name="tipoSeguro">
	<%  
		TipoSeguroDao tipoSegDao = new TipoSeguroDao();
		ArrayList<TipoSeguro> listTipoSeg = tipoSegDao.getAllTipoSeguro();
		
		if(listTipoSeg!=null)
		for(TipoSeguro tipoSeg : listTipoSeg) 
		{
	%>
		<option value=<%=tipoSeg.getId() %>><%=tipoSeg.getDescripcion()%></option>
		
	<%} %>
	 </select>
	 <br>
Costo contratación <input type="text" name="txtContratacion"><br>
Costo máximo asegurado <input type="text" name="txtCostoMax"><br>
<input type="submit" name="btnEnviar" value="Enviar">

				
</form>


	<%
	int filas = 0;
	if(request.getAttribute("CantFilas")!=null){
		filas = Integer.parseInt(request.getAttribute("CantFilas").toString());				
	}
%>

<%if(filas == 1){ %>
	Seguro Agregado Con Exito
<%} %>	

</body>
</html>