<%@page import="java.util.Date"%>
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




    <nav class="navbar navbar-expand-lg navbar-light " style="background:#404E67;">
        <a class="navbar-brand" href="Home.jsp" style="color:white;">TP FINAL LABORATORIO</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown" style="justify-content: end; margin-right: 15px;">
          <ul class="navbar-nav" >
            <li class="nav-item dropdown" >
              <a class="nav-link dropdown-toggle" href="#" style="color:white;"id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <%= session.getAttribute("usuarioSession") %>
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="SessionCerrada.jsp">Salir</a>
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
								            
								      <option value=<%=profe.getLegajo()%> ><%=profe.getNombre()%>  <%=profe.getApellido()%> legajo : <%=profe.getLegajo()%></option>
								           
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
                    
                      <div class="form-group">
                        <label for="inputState">Semestre</label>
                        <select id="inpSemestre" class="form-control">
                          <option selected>Seleccionar...</option>                         							            
								<option value="Primer semestre">Primer semestre</option>
								<option value="Segundo semestre">Segundo semestre</option>
								<option value="Tercer semestre">Tercer semestre</option>
                        </select>
                      </div>
                                     
              </div>
              
               <div class="col-sm-12">
                    
                      <div class="form-group">
                        <label for="inputState">Año De Cursada</label>
                        <select id="inpAnnio" class="form-control">
                          <option selected>Seleccionar...</option>                         							            
															
						      <option value="2018">2018</option>	
						      <option value="2019">2019</option>				           
       						  <option value="2020">2020</option>
       						  <option value="2021">2021</option>
       						  <option value="2022">2022</option>
       						  <option value="2023">2023</option>
       						  <option value="2024">2024</option>
       						  <option value="2025">2025</option>
       						  
                        </select>
                      </div>
                                     
              </div>
              
              
              <div class="col-sm-12">
              <div class="form-group">
	              <label for="inputState">Alumnos</label>
	                <button type="button" class="btn  btn-block btn-outline-primary btn-rounded waves-effect " data-toggle="modal" data-target="#exampleModal">
	                  Seleccionar alumnos
	                </button>
              </div>
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
        <table id="dtBasicExample" class="table" cellspacing="0" width="100%">
          <thead>
            <tr>
              	<th><input id="MarcarTodas" value="0" type="checkbox"></th>
                <th class="th-sm">Legajo</th>
                <th class="th-sm">DNI</th>
                <th class="th-sm">Fecha de nacimiento</th>
                <th class="th-sm">Direcciï¿½n</th>
                <th class="th-sm">Nacionalidad</th>
                <th class="th-sm">Provincia</th>
                <th class="th-sm">Email</th>
                <th class="th-sm">Telefono</th>
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

<script>
  const btn = document.getElementById("btn");
 	
  $(document).ready(function () {
		 $('#dtBasicExample').DataTable();
	 	$('.dataTables_length').addClass('bs-select');
	});
  
  
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

  btn.addEventListener('click', () => {
     
      const selectMateria = document.getElementById("inpMateria");
      const selectProfesor = document.getElementById("inpProfesor");
      const selectSemetre = document.getElementById("inpSemestre");
      const selectAnnio = document.getElementById("inpAnnio");
      
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

       btn.href = "servletCursos?curso=true&idMateria="+selectMateria.value+"&legajoProfesor="+selectProfesor.value+"&SelecSemestre="+selectSemetre.value+"&selectAnnio="+selectAnnio.value+"&"+"legajos="+legajoSeleccionado;
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