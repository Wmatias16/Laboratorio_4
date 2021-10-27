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
<title>Listar seguros</title>
</head>
<body>

<a href="inicio.jsp">Inicio </a><a href="AgregarSeguro.jsp">Agregar seguro </a><a href="servletSeguro?Param=3">Listar seguros</a>

<h3>Tipo de seguros de la base de datos</h3>

<form method="GET" action="servletSeguro">
	Busqueda por tipo de seguros: 
	
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
	 
	<input type="submit" name="btnFiltrar"value="Filtrar">
</form>

<% 
	List<Seguro> listaSeguros = null;
	if(request.getAttribute("listaSeguros")!=null)
	{
		listaSeguros = (List<Seguro>)request.getAttribute("listaSeguros");
	}

 %>


<table id="table_id" class="display">
    <thead>
        <tr>
            <th>ID</th>
            <th>Descripcion</th>
            <th>Tipo seguro</th>
            <th>Costo contratacion</th>
            <th>Costo asegurado</th>
        </tr>
    </thead>
    <tbody>
       <%  if(listaSeguros!=null)
		for(Seguro seg : listaSeguros) 
		{
	%>
		<tr>  
				<td><%=seg.getIdSeguro() %></td> 
				<td><%=seg.getDescripcion()%></td>   
				<td><%=seg.getTipoSeguro().getId()%></td>
				<td><%=seg.getCostoContratacion()%></td>  
				<td><%=seg.getCostoAsegurado() %></td>   
		</tr>
	<%  } %>
    </tbody>
</table>




</body>
</html>