<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dominio.Administrador"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="LoginStyle.css" rel="stylesheet" >

<title>Login</title>
</head>
<body>
<%
	Administrador administrador = null;
	if (request.getAttribute("AdministradorLogin") != null) {
		administrador = (Administrador)request.getAttribute("AdministradorLogin");
		session.setAttribute("usuarioSession", administrador.getNombre() + " " + administrador.getApellido());
		response.sendRedirect("VistaAdministrador.jsp");
	}
%>
	 <div class="container">
        <div class="row">
          <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card border-0 shadow rounded-3 my-5">
              <div class="card-body p-4 p-sm-5">
                <h5 class="card-title text-center mb-5 fw-light fs-5">Login</h5>
                <form>
                  <div class="form-floating mb-3">
                    <input type="email" class="form-control" id="loginEmailAdministrador" placeholder="name@example.com">
                    <label for="loginEmailAdministrador">Email</label>
                  </div>
                  <div class="form-floating mb-3">
                    <input type="password" class="form-control" id="loginPasswordAdministrador" placeholder="Password">
                    <label for="loginPasswordAdministrador">Contraseña</label>
                  </div>
                  <div class="d-grid">
                    <a class="btn btn-primary btn-login text-uppercase fw-bold" id="btnIniciarSesionAdministrador" type="submit">
                        Iniciar sesión
                    </a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
<script>
	const btnIniciarSesion = document.getElementById('btnIniciarSesionAdministrador');
	btnIniciarSesion.addEventListener('click', function(e) {
		let email = document.getElementById('loginEmailAdministrador').value;
		let contrasenia = document.getElementById('loginPasswordAdministrador').value;
		btnIniciarSesion.href = "servletAdministrador?loguearAdmin=true&email="+email+"&contrasenia="+contrasenia;
	});
</script>
</body>
</html>