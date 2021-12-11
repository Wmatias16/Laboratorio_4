<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dominio.Curso"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursos</title>

 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
  <!-- Google Fonts Roboto -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!-- Material Design Bootstrap -->
  <link rel="stylesheet" href="css/mdb.min.css">
  <!-- Your custom styles (optional) -->
  <link rel="stylesheet" href="css/style.css">
  <!-- MDBootstrap Datatables  -->
<link href="css/addons/datatables.min.css" rel="stylesheet">

</head>
<body>
<% if (!session.getAttribute("tipoUsuario").equals("Docente")) {
	response.sendRedirect("Home.jsp");
	}
	List<Curso> listaCursos = null;
	if (request.getAttribute("listaCursos") != null) {
		listaCursos = (List<Curso>)request.getAttribute("listaCursos");
	}
%>
 <nav class="navbar navbar-expand-lg navbar-light " style="background:#404E67;">
        <a class="navbar-brand" href="Home.jsp" style="color:white;">TP FINAL LABORATORIO</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown" style="justify-content: end; margin-right: 15px;">
          <ul class="navbar-nav" >
            <li class="nav-item dropdown" >
              <a class="nav-link dropdown-toggle" style="color:white;"href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%= session.getAttribute("usuarioSession") %>
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="SessionCerrada.jsp">Salir</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>



    <div class="grey-bg container">
        <section id="minimal-statistics">
          <div class="row">
            <div class="col-12 mt-3 mb-1">
              <h4 class="text-uppercase">Cursos</h4>
              <p></p>
            </div>
          </div>
          <div class="row">
          <% if (listaCursos != null) {
        	  	for (Curso curso : listaCursos) {
        	  		%>     
            <div class="col-xl-3 col-sm-6 col-12"> 
                <div class="card">
                  <div class="card-content">
                    <div class="card-body">
                      <div class="media d-flex">
                        <div class="align-self-center">
                          <i class="fas fa-marker blue-text fa-3x"></i>
                        </div>
                        <div class="media-body text-right">
                          <h4><%=curso.getMateria().getNombre()%></h4>
                          <h5><%=curso.getSemestre() %> - <%=curso.getAnio() %></h5>
                        </div>

                      </div>
                    </div>
                    <div class="card-footer text-muted">
                      <a href="servletAlumnosXCurso?listar=true&idCurso=<%=curso.getId() %>" class="btn btn-primary btn-block" >Ver curso</a>
                   </div>
                  </div>
                </div>            
            </div>
         <%}} %>
        </div>
        </section>
        </div>
        
        <!-- DataTables JS -->
 <!-- jQuery -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>
  <!-- MDBootstrap Datatables  -->
<script type="text/javascript" src="js/addons/datatables.min.js"></script>
        

</body>
</html>