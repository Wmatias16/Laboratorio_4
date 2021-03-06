    <%@page import="dominio.Profesor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
    
<%@page import="java.io.Console"%>
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
  <!-- MDBootstrap Datatables  -->
<link href="css/addons/datatables.min.css" rel="stylesheet">

<title>Docentes</title>
</head>
<body>

	<%
		if (!session.getAttribute("tipoUsuario").equals("Administrador")) {
		response.sendRedirect("Home.jsp");
		}
	
		ArrayList<Profesor> listarProfesor = null;
		if(request.getAttribute("listaProfesor") != null){
			listarProfesor = (ArrayList<Profesor>)request.getAttribute("listaProfesor");
		 }
		
		
		// Cuando carga la pagina por primera ves crea el mensaje vacio y el error lo crea como nulo!
		String mensaje = "";
		Boolean error  = null;
		
		// Si existe alguna error o no creamos el mensaje con el mensaje que nos trae el servletDocente
		
		// Puede ser mensaje de agregado o de error
		if(request.getAttribute("error") != null){
			
			error = (Boolean)request.getAttribute("error");
			mensaje = (String)request.getAttribute("mensaje");
		}
		
		
	%>

	
	
    <% 
    if(error != null)
      {%>
    
    <div class="col-sm-12" style="text-align: center;">
             <div class="alert alert-dark" role="alert">
                 <strong><%=mensaje%></strong>
            </div>
        </div>
    
    <%}%>
    
        

 <nav class="navbar navbar-expand-lg navbar-light " style="background:#404E67;">
    <a class="navbar-brand" href="Home.jsp" style="color:white;">TP FINAL LABORATORIO</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown" style="justify-content: end; margin-right: 15px;">
      <ul class="navbar-nav" >
        <li class="nav-item dropdown" >
          <a class="nav-link dropdown-toggle" href="#"style="color:white;" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <%= session.getAttribute("usuarioSession") %>
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="SessionCerrada.jsp">Salir</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>

<div class="container" style="margin-top: 100px;">
<div class="row">
    <div class="col-sm" style="margin-bottom: 10px; text-align:right;" >
        <a href="DocentesAgregar.jsp" class="btn btn-success" style="margin: 5px;">Alta de docente</a>
        <a id="btnModificar" class="btn btn-warning" style="margin: 5px;">Modificar docente</a>
        <a id="btnEliminar" class="btn btn-danger" style="margin: 5px;">Eliminar docente</a>
    </div>     
<div class="col-sm-12">    
    <table id="dtBasicExample" class="table" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th scope="col"><input type="checkbox" id ="MarcarTodas" value="0" ></th>
            <th scope="col">Legajo</th>
            <th scope="col">DNI</th>
            <th scope="col">Fecha de nacimiento</th>
            <th scope="col">Direccion</th>
            <th scope="col">Nacionalidad</th>
            <th scope="col">Localidad</th>
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
            <th><input type="checkbox" id="check" value=<%=profe.getLegajo()%>></th>
            <td class ="legajo" ><%=profe.getLegajo()%></td>
            <td><%=profe.getDni()%></td>
            <td><%=new SimpleDateFormat("MM/dd/yyyy").format(profe.getFechaNacimiento())%></td>
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

// Boton modificar


const btnModificar = document.getElementById("btnModificar");
const btnEliminar = document.getElementById('btnEliminar');

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
          if(confirm("?Est?s seguro de modificar este usuario?")){
              btnModificar.href="servletDocente?edit=true&legajo="+legajoSeleccionado[0];
           }   
   }else if(cantCheck.length > 1){
       alert("?Debe seleccionar s?lamente un registro!");
   }else{
       alert("?Debe seleccionar un registro!");
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
       if(e.value!=0){
           legajoSeleccionado.push(e.value);
           cantCheck.push(cant);
       }
   });
   
   // Verificamos que no tengan mas de una seleccion
   if(cantCheck.length >= 1){		    	
       if(confirm('?Est?s seguro de eliminar este usuario?')){
           btnEliminar.href="servletDocente?delete=true&legajos="+legajoSeleccionado;
       }
   }else{
       alert("?Debe seleccionar por lo menos un registro!");
   }

});
   
 
</script>

</body>
</html>