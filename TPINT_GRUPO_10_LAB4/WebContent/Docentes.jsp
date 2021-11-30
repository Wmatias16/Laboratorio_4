    <%@page import="dominio.Profesor"%>
<%@page import="java.util.ArrayList"%>
    
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Docentes</title>
</head>
<body>

	<%
		ArrayList<Profesor> listarProfesor = null;
		if(request.getAttribute("listaProfesor") != null){
			listarProfesor = (ArrayList<Profesor>)request.getAttribute("listaProfesor");
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

<div class="container" style="margin-top: 100px;">
    <div class="row">
        <div class="col-sm" style="margin-bottom: 10px; text-align:right;" >
            <a href="DocentesAgregar.jsp" lass="btn btn-success" style="margin: 5px;">Alta de docente</a>
            <a id="btnModificar" class="btn btn-warning" style="margin: 5px;">Modificar docente</a>
            <a id="btnEliminar" class="btn btn-danger" style="margin: 5px;">Eliminar docente</a>
        </div>     
    <div class="col-sm-12">    
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col"><input type="checkbox"></th>
                <th scope="col">Legajo</th>
                <th scope="col">Dni</th>
                <th scope="col">Fecha de nacimiento</th>
                <th scope="col">Direccion</th>
                <th scope="col">Nacionalidad</th>
                <th scope="col">Provincia</th>
                <th scope="col">Email</th>
                <th scope="col">Telefono</th>

            </tr>
            </thead>
            <tbody>
            <%
            	if(listarProfesor!=null)
            		for(Profesor profe : listarProfesor)
            		{
            %>
            <tr class="RegistroProfesor">
                <th><input type="checkbox" value=<%=profe.getLegajo()%>></th>
                <td class ="legajo" ><%=profe.getLegajo()%></td>
                <td><%=profe.getDni()%></td>
                <td><%=profe.getFechaNacimiento()%></td>
                <td><%=profe.getDireccion()%></td>
                <td><%=profe.getNacionalidad()%></td>
                <td><%=profe.getLocalidad()%></td>
                <td><%=profe.getEmail()%></td>
                <td><%=profe.getTelefono()%></td>
            </tr>
         		<% } %>
            </tbody>
            </table>

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script>    

// Boton modificar

   const btnModificar = document.getElementById('btnModificar');
   const btnEliminar = document.getElementById('btnEliminar');

	 	
   // El evento click del boton checkeara si no hay mas de un checkbox seleccionado
   btnModificar.addEventListener('click',function(e){
       // Array cantidad checkbox en estado true
       let cantCheck = [];
       let legajoSeleccionado = [];
       // JQUERY recorre todos los checkbox en estado true
       $("input[type=checkbox]:checked").each(function(cant,e) {
           // Guarda cantidad de checkbox en estado true
           legajoSeleccionado.push(e.value);
           cantCheck.push(cant);
       });
       
       // Verificamos que no tengan mas de una seleccion
       if(cantCheck.length == 1){
    	   btnModificar.href="servletDocente?edit=true&legajo="+legajoSeleccionado[0];
       }else if(cantCheck.length > 1){
           alert("Solo debe seleccionar un registro!");
       }else{
           alert("Debe seleccionar un registro!");
       }	
   });
   
   
   ///btn eliminar
   btnEliminar.addEventListener('click',function(e){
       // Array cantidad checkbox en estado true
       let cantCheck = [];
       let legajoSeleccionado = [];
       // JQUERY recorre todos los checkbox en estado true
       $("input[type=checkbox]:checked").each(function(cant,e) {
           // Guarda cantidad de checkbox en estado true
           legajoSeleccionado.push(e.value);
           cantCheck.push(cant);
       });
       
       // Verificamos que no tengan mas de una seleccion
       if(cantCheck.length >= 1){
    	   btnEliminar.href="servletDocente?delete=true&legajos="+legajoSeleccionado;
       }else{
           alert("Debe seleccionar un registro!");
       }	
   });
  
   
   
</script>

	
</body>
</html>