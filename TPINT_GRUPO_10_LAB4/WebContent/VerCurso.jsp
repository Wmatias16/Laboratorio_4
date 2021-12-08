<%@page import="dominio.AlumnoXCurso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Ver curso</title>
</head>
<body>
<% if (!session.getAttribute("tipoUsuario").equals("Docente")) {
	response.sendRedirect("Home.jsp");
	}
	List<AlumnoXCurso> listaAlumnosXCurso = null;
	if (request.getAttribute("listaAlumnosXCurso") != null) {
		listaAlumnosXCurso = (List<AlumnoXCurso>)request.getAttribute("listaAlumnosXCurso");
}
%>
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="Home.jsp">TP FINAL LABORATORIO</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown" style="justify-content: end; margin-right: 15px;">
          <ul class="navbar-nav" >
            <li class="nav-item dropdown" >
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%= session.getAttribute("usuarioSession") %>
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="Home.jsp">Salir</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>
<% if (listaAlumnosXCurso.size() > 0) {
%>
<div class="container" style="margin-top: 100px;">
    <h1><%=listaAlumnosXCurso.get(0).getCurso().getMateria().getNombre() %></h1>
    <div class="row">
        <div class="col-sm" style="margin-bottom: 10px; text-align:right;" >
            <button class="btn btn-success" style="margin: 5px;">Calificar</button>
        </div>     
    <div class="col-sm-12">    
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col"><input type="checkbox"></th>
                <th scope="col">Legajo</th>
                <th scope="col">DNI</th>
                <th scope="col">Apellido</th>
                <th scope="col">Nombre</th>
                <th scope="col">Email</th>
                <th scope="col">Parcial 1</th>
                <th scope="col">Parcial 2</th>
                <th scope="col">Recuperatorio Parcial 1</th>
                <th scope="col">Recuperatorio Parcial 2</th>
                <th scope="col">Regularidad</th>
            </tr>
            </thead>
            <tbody>
            <% for (AlumnoXCurso alumnoXCurso : listaAlumnosXCurso) {
            	%>
            <tr>
                <th scope="row"><input type="checkbox"></th>
                <td><%=alumnoXCurso.getAlumno().getLegajo() %></td>
                <td><%=alumnoXCurso.getAlumno().getDni() %></td>
                <td><%=alumnoXCurso.getAlumno().getApellido() %></td>   
                <td><%=alumnoXCurso.getAlumno().getNombre() %></td>
                <td><%=alumnoXCurso.getAlumno().getEmail() %></td>
                <td><%=alumnoXCurso.getNotaPrimerParcial() %></td>
                <td><%=alumnoXCurso.getNotaSegundoParcial() %></td>
                <td><%=alumnoXCurso.getNotaPrimerRecuperatorio() %></td>  
                <td><%=alumnoXCurso.getNotaSegundoRecuperatorio() %></td>    
                <td><%=alumnoXCurso.getRegularidad() %></td>             
            </tr>
            <%} %>
            </tbody>
            </table>

        </div>
    </div>
<%} %>
</div>
	

</body>


</html>