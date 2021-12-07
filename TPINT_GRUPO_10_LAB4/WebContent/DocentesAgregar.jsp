<%@page import="dominio.Profesor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Alta docentes</title>
</head>
<body>

	<% 
	Profesor profe = null;
	if(request.getAttribute("ProfesorEditar")!=null)
	{
		profe = (Profesor)request.getAttribute("ProfesorEditar");
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

	<%if(request.getAttribute("ProfesorEditar")!=null){ %>
	<div class="container">
         <form method="POST" action="servletDocente?legajo=<%=profe.getLegajo()%>">
            <div class="row">
            	
                <div class="col-sm-6">
                 	<div class="form-group">
 						<label for="Legajo">Contraseña</label>
                        <input type="text" value=<%=profe.getContrasenia()%> class="form-control" id="idLegajo"  name="Contrasenia">
                      </div>
                       <div class="form-group">
                          <label for="exampleInputEmail1">Nombre</label>
                          <input type="text" value=<%=profe.getNombre()%> name="nombre"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nombre" required>
                        </div>
                       <div class="form-group">
                        <label for="exampleInputEmail1">Dni</label>
                        <input type="text"  value=<%=profe.getDni()%> name="dni" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese dni" required>
                      </div>
                       <div class="form-group">
                          <label for="exampleInputEmail1">Fecha de nacimiento</label>
                          <input type="date" name="fecha"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese fecha de nacimiento" required>
                        </div>
                         <div class="form-group">
                        <label for="exampleInputEmail1">Telefono</label>
                        <input type="text" value=<%=profe.getTelefono()%> name="telefono"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese telefono" required>
                      </div>
                     
                </div>

                <div class="col-sm-6">
                   
                   <div class="form-group">
						<label for="exampleInputEmail1">Email</label>
                        <input type="email" value=<%=profe.getEmail()%> class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" placeholder="Ingrese email" required>
                      </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Apellido</label>
                          <input type="text" value=<%=profe.getApellido()%> name="apellido" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese apellido" required>
                        </div>
                        
                        <div class="form-group">
                        <label for="exampleInputEmail1">Direccion</label>
                        <input type="text" value=<%=profe.getDireccion()%> name="direccion"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese direccion" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Localidad</label>
                        <input type="text" value='<%=profe.getLocalidad()%>' name="localidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese localidad" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Nacionalidad</label>
                        <input type="text" value=<%=profe.getNacionalidad()%> name="nacionalidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nacionalidad" required>
                      </div>
                     
                </div>
				
				<div class="col-sm-12" style="text-align: center;">
                	<div class="alert alert-dark" role="alert">
					  Legajo Docente Nro <%=profe.getLegajo()%>
					</div>
              </div>
                
              <div class="col-sm-12" style="text-align: center;">
                <button type="submit" name="EditProfesor" class="btn btn-success btn-lg btn-block" style="text-align: center; margin-top: 10px; width: 100%;">Aceptar</button>
              </div>
            </div>
                
          </form>
    	</div>
	

	
	<%}else{ %>

		<div class="container" style="margin-top: 100px; width: 700px;">
        <h1 style="text-align: center;">Alta docente</h1>
        <form method="post" action=servletDocente>
            <div class="row">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email</label>
                        <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese email" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Contraseña</label>
                        <input type="password" name="contrasenia" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese Contraseña" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Dni</label>
                        <input type="text" name="dni" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese dni" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Localidad</label>
                        <input type="text" name=localidad class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese localidad" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Nacionalidad</label>
                        <input type="text" name="nacionalidad" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nacionalidad" required>
                      </div>
                </div>
              
                <div class="col-sm-6">                    
                      <div class="form-group">
                          <label for="exampleInputEmail1">Nombre</label>
                          <input type="text" name="nombre" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nombre" required>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Apellido</label>
                          <input type="text" name="apellido" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese apellido" required>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Fecha de nacimiento</label>
                          <input type="date" name="fechaNacimiento" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese fecha de nacimiento" required>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Direccion</label>
                          <input type="text" name="direccion" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese direccion" required>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Telefono</label>
                          <input type="text" name="telefono" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese telefono" required>
                        </div>
                       
                </div>             
              <div class="col-sm-12" style="text-align: center;">
                <button type="submit" name="Alta" class="btn btn-success btn-lg btn-block" style="text-align: center; margin-top: 10px; width: 100%;">Aceptar</button>
              </div>
        </div>
            <%} %>    
                  
          </form>
          
          		 
            	
          
    </div>
</body>
</html>