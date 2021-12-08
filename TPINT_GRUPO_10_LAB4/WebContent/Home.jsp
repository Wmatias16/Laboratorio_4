<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Home</title>


    <style>
        .container-main{
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            
        }

        .container-img{
            width:90%;
            height: 90vh;
            margin-top: 25px;
        }

        .container-img img{
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 25px;
            margin: auto;
        }
        
    </style>

</head>
<body>
<div class="container text-center mx-auto">
       <div class="row">
           <div class="col-sm-6">
                <div class="container-img">
                    <img src="img/img.jpg">
                </div>
            </div>
            <div class="col-sm-6">
                <div class="container-main">
                    <div class="logo">
                        <img src="./img/UTN_logo-removebg-preview.png" alt="" width="85">
                    </div>
                     <h1 class="jumbotron-heading">¡Bienvenido!</h1>
                     <p class="lead text-muted">Para iniciar sesión seleccione qué tipo de usuario desea utilizar</p>
                     <p>
                         <a href="LoginAdministrador.jsp" class="btn btn-primary my-2">Administrador</a>
        				 <a href="LoginDocente.jsp" class="btn btn-secondary my-2">Docente</a>
                     </p>
                </div>
            </div>
       </div> 
    </div>    

</body>
</html>