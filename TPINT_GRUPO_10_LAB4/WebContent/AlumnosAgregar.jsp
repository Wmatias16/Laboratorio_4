<%@page import="dominio.Alumno"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Alta alumnos</title>
</head>
<body>
<% 
	Alumno alum = null;
	if(request.getAttribute("AlumnoEditar")!=null)
	{
		alum = (Alumno)request.getAttribute("AlumnoEditar");
	}
	
 %>



	 <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">TP FINAL LABORATORIO</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown" style="justify-content: end; margin-right: 15px;">
          <ul class="navbar-nav" >
            <li class="nav-item dropdown" >
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Administrador
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="#">Salir</a>
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
                          <input type="text" value=<%=alum.getNombre()%> name="nombre"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nombre">
                        </div>
                       <div class="form-group">
                        <label for="exampleInputEmail1">Dni</label>
                        <input type="text"  value=<%=alum.getDni()%> name="dni" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese dni">
                      </div>
                       <div class="form-group">
                          <label for="exampleInputEmail1">Fecha de nacimiento</label>
                          <input type="date" name="fecha"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese fecha de nacimiento">
                        </div>
                         <div class="form-group">
                        <label for="exampleInputEmail1">Telefono</label>
                        <input type="text" value=<%=alum.getTelefono()%> name="telefono"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese telefono">
                      </div>
                     
                </div>

                <div class="col-sm-6">
                   
                   <div class="form-group">
						<label for="exampleInputEmail1">Email</label>
                        <input type="email" value=<%=alum.getEmail()%> class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" placeholder="Ingrese email">
                      </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Apellido</label>
                          <input type="text" value=<%=alum.getApellido()%> name="apellido" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese apellido">
                        </div>
                        
                        <div class="form-group">
                        <label for="exampleInputEmail1">Direccion</label>
                        <input type="text" value=<%=alum.getDireccion()%> name="direccion"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese direccion">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Localidad</label>
                        <input type="text" value=<%=alum.getLocalidad()%> name="localidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese localidad">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Nacionalidad</label>
                        <input type="text" value=<%=alum.getNacionalidad()%> name="nacionalidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nacionalidad">
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
                        <input type="email"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" placeholder="Ingrese email">
                      </div>
                </div>

                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Dni</label>
                        <input type="text"  name="dni" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese dni">
                      </div>
                      <div class="form-group">
                          <label for="exampleInputEmail1">Nombre</label>
                          <input type="text"name="nombre"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nombre">
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Apellido</label>
                          <input type="text" name="apellido" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese apellido">
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Fecha de nacimiento</label>
                          <input type="date" name="fecha"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese fecha de nacimiento">
                        </div>
                </div>

                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Direccion</label>
                        <input type="text" name="direccion"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese direccion">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Localidad</label>
                        <input type="text"  name="localidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese localidad">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Nacionalidad</label>
                        <input type="text"  name="nacionalidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nacionalidad">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Telefono</label>
                        <input type="text"  name="telefono"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese telefono">
                      </div>
                    
              </div>
              <div class="col-sm-12" style="text-align: center;">
                <button type="submit" name="altaAlumno" class="btn btn-success btn-lg btn-block" style="text-align: center; margin-top: 10px; width: 100%;">Aceptar</button>
              </div>
            </div>
                
          </form>
    	</div>
      <%} %>
</body>
</html>