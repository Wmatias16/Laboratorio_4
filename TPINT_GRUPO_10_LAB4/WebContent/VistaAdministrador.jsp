<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">


<title>Admnistrador</title>
</head>
<body>

<% if (!session.getAttribute("tipoUsuario").equals("Administrador")) {
	response.sendRedirect("Home.jsp");
}

	//Mensaje Validacion Curso
	String mensaje = "";
	Boolean error  = null;

	if(request.getAttribute("error") != null){
			
			error = (Boolean)request.getAttribute("error");
			mensaje = (String)request.getAttribute("mensaje");
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
      
      
      <% //Mensaje Validacion
		if(error != null)
		  {%>
		
		<div class="col-sm-12" style="text-align: center;">
		         <div class="alert alert-dark" role="alert">
					 <strong><%=mensaje%></strong>
				</div>
		    </div>
		
		<%}%>
      


    <div class="grey-bg container">
        <section id="minimal-statistics">
          <div class="row">
            <div class="col-12 mt-3 mb-1">
              <h4 class="text-uppercase">Vista Administrador</h4>
              <p></p>
            </div>
          </div>
          <div class="row">      
              <div class="col-xl-3 col-sm-6 col-12"> 
                <div class="card">
                  <div class="card-content">
                    <div class="card-body">
                      <div class="media d-flex">
                        <div class="align-self-center">
                            <i class="icon-book-open primary font-large-2 float-right"></i>                        </div>
                        <div class="media-body text-right">
                          <h3>Alumnos</h3>
                        </div>
                        
                      </div>
                    </div>
                    <div class="card-footer text-muted">
                      <a href="servletAlumnos?listar=true" class="btn btn-primary btn-block" >Ver</a>
                   </div>
                  </div>
                </div>            
            </div>
            <div class="col-xl-3 col-sm-6 col-12"> 
                <div class="card">
                  <div class="card-content">
                    <div class="card-body">
                      <div class="media d-flex">
                        <div class="align-self-center">
                            <i class="icon-book-open primary font-large-2 float-right"></i>                        </div>
                        <div class="media-body text-right">
                          <h3>Profesores</h3>
                        </div>
                        
                      </div>
                    </div>
                    <div class="card-footer text-muted">
                      <a href="servletDocente?listar=true" class="btn btn-primary btn-block" >Ver</a>
                   </div>
                  </div>
                </div>            
            </div>
            <div class="col-xl-3 col-sm-6 col-12"> 
                <div class="card">
                  <div class="card-content">
                    <div class="card-body">
                      <div class="media d-flex">
                        <div class="align-self-center">
                            <i class="icon-book-open primary font-large-2 float-right"></i>                        </div>
                        <div class="media-body text-right">
                          <h3>Cursos</h3>
                        </div>
                        
                      </div>
                    </div>
                    <div class="card-footer text-muted">
                      <a href="servletCursos?getDatos=true" class="btn btn-primary btn-block" >Ver</a>
                   </div>
                  </div>
                </div>            
            </div>
                 
            </div>
        </div>
        </div>
                    
                      
        </section>
        
</body>
</html>