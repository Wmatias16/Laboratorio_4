<%@page import="dominio.Alumno"%>
<%@page import="dominio.Profesor"%>
<%@page import="dominio.Materia"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Cursos</title>
</head>
<body>
<style>
  .modal-body{
    overflow:scroll;
     height:450px;
  }
</style>

<% 
	if (!session.getAttribute("tipoUsuario").equals("Administrador")) {
		response.sendRedirect("Home.jsp");
	}

	ArrayList<Alumno> listaAlumnos = null;
	if(request.getAttribute("listaAlumnos")!=null)
	{
		listaAlumnos = (ArrayList<Alumno>)request.getAttribute("listaAlumnos");
	}
	
	
	ArrayList<Profesor> listarProfesor = null;
	if(request.getAttribute("listaProfesor") != null){
		listarProfesor = (ArrayList<Profesor>)request.getAttribute("listaProfesor");
	 }
	
	ArrayList<Materia> listarMateria = null;
	if(request.getAttribute("listaMateria") != null){
		listarMateria = (ArrayList<Materia>)request.getAttribute("listaMateria");
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



    <div class="container" style="margin-top: 100px; width: 700px;">
        <h1 style="text-align: center;">Alta cursos</h1>
        <form method="get">
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <label for="inputState">Profesor</label>
                        <select id="inpProfesor" class="form-control">
                          <option selected>Seleccionar...</option>
                          
                           <%
				            	if(listarProfesor!=null)
				            		for(Profesor profe : listarProfesor)
				            		{
				            %>
								            
								      <option value=<%=profe.getLegajo()%> ><%=profe.getNombre()%></option>
								           
         					<% } %>
                          
                          
                          
                        </select>
                      </div>
                </div>

                <div class="col-sm-6">
                    
                </div>

                <div class="col-sm-12">
                    
                      <div class="form-group">
                        <label for="inputState">Materias</label>
                        <select id="inpMateria" class="form-control">
                          <option selected>Seleccionar...</option>
                          <%
				            	if(listarMateria!=null)
				            		for(Materia materia : listarMateria)
				            		{
				            %>
								            
								      <option value=<%=materia.getId()%>><%=materia.getNombre()%></option>
								           
         					<% } %>
                        </select>
                      </div>
                                     
              </div>
              <div class="col-sm-12">
                <label for="inputState">Alumnos</label>
                <button type="button" class="btn btn-outline-secondary form-control" data-toggle="modal" data-target="#exampleModal">
                  Seleccionar alumnos
                </button>
              </div>
              
        </div>     

        <div class="col-sm-12" style="text-align: center;">
            <a type="button" id="btn"class="btn btn-success btn-lg btn-block" style="text-align: center; margin-top: 10px; width: 100%;">Aceptar</a>
          </div>   
            
          </form>
    </div>
    <!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Alumnos</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <input type="text" id="myInput"class="form-control" placeholder="Buscar...">
        <table class="table" id="myTable">
          <thead>
            <tr>
              	<th scope="col"><input id="MarcarTodas" value="0" type="checkbox"></th>
                <th scope="col">Legajo</th>
                <th scope="col">DNI</th>
                <th scope="col">Fecha de nacimiento</th>
                <th scope="col">Direcci�n</th>
                <th scope="col">Nacionalidad</th>
                <th scope="col">Provincia</th>
                <th scope="col">Email</th>
                <th scope="col">Tel�fono</th>
            </tr>
          </thead>
          <tbody>
           <%  if(listaAlumnos!=null)
					for(Alumno alum : listaAlumnos) 
					{
			  %>
            <tr class="registroAlumno">
               <td><input type="checkbox" value=<%=alum.getLegajo() %>></td>
               <td class="legajo"><%=alum.getLegajo() %></td>  
               <td><%=alum.getDni() %></td>  
               <td>12-12-12</td>  
               <td><%=alum.getDireccion() %></td>  
               <td><%=alum.getNacionalidad() %></td>  
               <td><%=alum.getLocalidad() %></td>  
               <td><%=alum.getEmail() %></td>  
               <td><%=alum.getTelefono() %></td>  
					
            </tr>
            
            <%} %>
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Aplicar</button>
      </div>
    </div>
  </div>
</div>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<script>
  const btn = document.getElementById("btn");
 	
  
	  $("#MarcarTodas").click(function (x) {
		  if(document.getElementById('MarcarTodas').checked){
	 		$("input[type=checkbox]").each(function(cant,e) {
	 			$(this).prop("checked", true);
	        }); 
		  }else{
			 $("input[type=checkbox]").each(function(cant,e) {
	 			$(this).prop("checked", false);
	        }); 
		  }
	});

  btn.addEventListener('click',() => {
     
      const selectMateria = document.getElementById("inpMateria");
      const selectProfesor = document.getElementById("inpProfesor");

      let cantCheck = [];
      let legajoSeleccionado = [];
       // JQUERY recorre todos los checkbox en estado true
       $("input[type=checkbox]:checked").each(function(cant,e) {
           // Guarda cantidad de checkbox en estado true
           if(e.value!=0){
	           legajoSeleccionado.push(e.value);
	           cantCheck.push(cant);
           }
       });



       console.log(selectMateria.value);
       console.log(selectProfesor.value);
       console.log(legajoSeleccionado);

       btn.href = "servletCursos?curso=true&idMateria="+selectMateria.value+"&legajoProfesor="+selectProfesor.value+"&"+"legajos="+legajoSeleccionado;
  })





  $(document).ready(function(){
    $("#myInput").on("keyup", function() {
      var value = $(this).val().toLowerCase();
      $("#myTable tr").filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  });
  </script>
</body>
</html>