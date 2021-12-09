<%@page import="dominio.Alumno"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
  <!-- Google Fonts Roboto -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!-- Material Design Bootstrap -->
  <link rel="stylesheet" href="css/mdb.min.css">
  <!-- Your custom styles (optional) -->
  <link rel="stylesheet" href="css/style.css">
<title>Alta alumnos</title>
</head>
<body>

<% 
	if (!session.getAttribute("tipoUsuario").equals("Administrador")) {
		response.sendRedirect("Home.jsp");
	}

	Alumno alum = null;
	if(request.getAttribute("AlumnoEditar")!=null)
	{
		alum = (Alumno)request.getAttribute("AlumnoEditar");
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

	<%if(request.getAttribute("AlumnoEditar")!=null){%>
		 <div class="container">
         <form method="POST" action="servletAlumnos?legajo=<%=alum.getLegajo()%>">
            <div class="row">
                <div class="col-sm-6">
                 	<div class="form-group">
 						<label for="Legajo">Legajo</label>
                        <input type="text" value=<%=alum.getLegajo()%> class="form-control" id="idLegajo"  name="legajo" disabled>
                      </div>
                       <div class="form-group">
                          <label for="exampleInputEmail1">Nombre</label>
                          <input type="text" value=<%=alum.getNombre()%> name="nombre"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nombre" required>
                        </div>
                       <div class="form-group">
                        <label for="exampleInputEmail1">DNI</label>
                        <input type="text"  value=<%=alum.getDni()%> name="dni" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese dni" required>
                      </div>
                       <div class="form-group">
                          <label for="exampleInputEmail1">Fecha de nacimiento</label>
                          <input type="date" name="fecha"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese fecha de nacimiento" required>
                        </div>
                         <div class="form-group">
                        <label for="exampleInputEmail1">Tel�fono</label>
                        <input type="text" value=<%=alum.getTelefono()%> name="telefono"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese telefono" required>
                      </div>
                     
                </div>

                <div class="col-sm-6">
                   
                   <div class="form-group">
						<label for="exampleInputEmail1">Email</label>
                        <input type="email" value=<%=alum.getEmail()%> class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" placeholder="Ingrese email" required>
                      </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Apellido</label>
                          <input type="text" value=<%=alum.getApellido()%> name="apellido" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese apellido" required>
                        </div>
                        
                        <div class="form-group">
                        <label for="exampleInputEmail1">Direcci�n</label>
                        <input type="text" value=<%=alum.getDireccion()%> name="direccion"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese direccion" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Localidad</label>
                        <input type="text" value=<%=alum.getLocalidad()%> name="localidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese localidad" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Nacionalidad</label>
                        <input type="text" value=<%=alum.getNacionalidad()%> name="nacionalidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nacionalidad" required>
                      </div>
                     
                </div>

                
              <div class="col-sm-12" style="text-align: center;">
                <button type="submit" name="mdAlumnos" class="btn btn-success btn-lg btn-block" style="text-align: center; margin-top: 10px; width: 100%;">Aceptar</button>
              </div>
            </div>
                
          </form>
    	</div>
	

	
	<%}else{ %>
				 <div class="container">
         <form method="POST" action="servletAlumnos">
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email</label>
                        <input type="email"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" placeholder="Ingrese email" required>
                      </div>
                </div>

                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="exampleInputEmail1">DNI</label>
                        <input type="text"  name="dni" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese dni" required>
                      </div>
                      <div class="form-group">
                          <label for="exampleInputEmail1">Nombre</label>
                          <input type="text"name="nombre"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nombre" required>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Apellido</label>
                          <input type="text" name="apellido" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese apellido" required>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Fecha de nacimiento</label>
                          <input type="date" name="fecha"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese fecha de nacimiento" required>
                        </div>
                </div>

                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Direcci�n</label>
                        <input type="text" name="direccion"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese direccion" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Localidad</label>
                        <input type="text"  name="localidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese localidad" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Nacionalidad</label>
                        <input type="text"  name="nacionalidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nacionalidad" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Tel�fono</label>
                        <input type="text"  name="telefono"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese telefono" required>
                      </div>
                    
              </div>
              <div class="col-sm-12" style="text-align: center;">
                <button type="submit" name="altaAlumno" class="btn btn-success btn-lg btn-block" style="text-align: center; margin-top: 10px; width: 100%;">Aceptar</button>
              </div>
            </div>
                
          </form>
    	</div>
      <%} %>
      
      <!-- jQuery -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>