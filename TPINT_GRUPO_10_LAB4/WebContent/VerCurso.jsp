<%@page import="dominio.AlumnoXCurso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ver curso</title>
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
                <a class="dropdown-item" href="SessionCerrada.jsp">Salir</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>
      
      
<% if (listaAlumnosXCurso != null) {%>

	<div class="container" style="margin-top: 100px;">
    	<h1><%=listaAlumnosXCurso.get(0).getCurso().getMateria().getNombre() %></h1>
    	<div class="row">
        <div class="col-sm" style="margin-bottom: 10px; text-align:right;" >
            <button class="btn btn-success" data-toggle="modal" data-target="#calificarModal" style="margin: 5px;">Calificar</button>        
        </div> 
            
    <div class="col-sm-12">    
    
   <table id="dtBasicExample" class="table" cellspacing="0" width="100%">
  <thead>
    <tr>
     <th  class="th-sm">ID</th>
     <th class="th-sm">DNI</th>
     <th class="th-sm">Apellido</th>
     <th  class="th-sm">Nombre</th>
     <th  class="th-sm">Email</th>
     <th  class="th-sm">Parcial 1</th>
     <th  class="th-sm">Parcial 2</th>
     <th  class="th-sm">Recuperatorio Parcial 1</th>
     <th  class="th-sm">Recuperatorio Parcial 2</th>
     <th  class="th-sm">Regularidad</th>
    
    </tr>
  </thead>
  <tbody>
        <% for (AlumnoXCurso alumnoXCurso : listaAlumnosXCurso) {
            	%>
            <tr>
            	<td><%=alumnoXCurso.getNroInscripcion() %></td>
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
  <tfoot>
    <tr>
      <th>Legajo</th>
     <th>DNI</th>
     <th>Apellido</th>
     <th>Nombre</th>
     <th>Email</th>
     <th>Parcial 1</th>
     <th>Parcial 2</th>
     <th>Recuperatorio Parcial 1</th>
     <th>Recuperatorio Parcial 2</th>
     <th>Regularidad</th>
    </tr>
  </tfoot>
</table>
<%} %>
</div>
<!-- Modal -->
<div class="modal fade bd-example-modal-lg" id="calificarModal" tabindex="-1" role="dialog" aria-labelledby="calificarModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="calificarModalLabel">Calificaci�n de Alumnos</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <input type="text" id="myInput"class="form-control" placeholder="Buscar...">
        <table class="table" id="myTable">
          <thead>
            <tr>
            	<th scope="col">ID</th>
                <th scope="col">Legajo</th>
                <th scope="col">DNI</th>
                <th scope="col">Parcial 1</th>
                <th scope="col">Parcial 2</th>
                <th scope="col">Recuperatorio Parcial 1</th>
                <th scope="col">Recuperatorio Parcial 2</th>
                <th scope="col">Regularidad</th>
            </tr>
          </thead>
          <tbody>
           <%  if(listaAlumnosXCurso != null)
					for(AlumnoXCurso alumnoXCurso : listaAlumnosXCurso) 
					{
			  %>
            <tr class="registroAlumno">
            	<td><%=alumnoXCurso.getNroInscripcion() %></td>
                <td><%=alumnoXCurso.getAlumno().getLegajo() %></td>
                <td><%=alumnoXCurso.getAlumno().getDni() %></td>
                <td><input type="number" min="0" max="10" step="0.5" class="form-control text-right" oninput="validity.valid||(value=0)" value="<%=alumnoXCurso.getNotaPrimerParcial() %>"></input></td>
                <td><input type="number" min="0" max="10" step="0.5" class="form-control text-right" oninput="validity.valid||(value=0)" value="<%=alumnoXCurso.getNotaSegundoParcial() %>"></input></td>
                <td><input type="number" min="0" max="10" step="0.5" class="form-control text-right" oninput="validity.valid||(value=0)" value="<%=alumnoXCurso.getNotaPrimerRecuperatorio() %>"></input></td>  
                <td><input type="number" min="0" max="10" step="0.5" class="form-control text-right" oninput="validity.valid||(value=0)" value="<%=alumnoXCurso.getNotaSegundoRecuperatorio() %>"></input></td>    
                <td><input type="text" class="form-control text-right" list="opcionesRegularidad" pattern="^(Regular|Libre)$" value="<%=alumnoXCurso.getRegularidad() %>">
                	<datalist id="opcionesRegularidad">
                		<option value="Regular">Regular</option>
                		<option value="Libre">Libre</option>
                	</datalist>
                </td>					
            </tr>            
            <%} %>
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <a id="btn" href="" class="btn btn-primary">Confirmar</a>
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

<script type="text/javascript">
	$(document).ready(function () {
	 	 $('#dtBasicExample').DataTable();
	  	$('.dataTables_length').addClass('bs-select');
	});

	let btn = document.getElementById("btn");
	
	btn.addEventListener('click',function(){
		let table = [];
		let id;
		
		$("#myTable tbody").each(function () {
          	$(this).children("tr").each(function () { // Recorre cada TR de la tabla 		
          		
          		if($(this).find('input[type=number]').val() != undefined){
          			let notas = [];
          			id = $(this).find('td:first-child').text(); //Busca el ID en el primer td
          			
          			$(this).find('input[type=number]').each(function(i){ // Busca todos los input tipo number
          				notas[i] = $(this).val(); // Guarda las notas
          			})
        
          			notas.push(id); // Agregamos el ID en el array de notas
          			table.push(notas)
          		}
            		
       		})
       		console.log(table);
       		btn.href="servletAlumnosXCurso?actualizarNotas?"+table;
		})
       
	})
			      		
</script>

</body>
</html>