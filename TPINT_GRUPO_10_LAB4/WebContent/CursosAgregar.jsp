<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Cursos</title>
</head>
<body>
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


    <div class="container" style="margin-top: 100px; width: 700px;">
        <h1 style="text-align: center;">Alta cursos</h1>
        <form>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <label for="inputState">Profesor</label>
                        <select id="inputState" class="form-control">
                          <option selected>Seleccionar...</option>
                          <option>...</option>
                        </select>
                      </div>
                </div>

                <div class="col-sm-6">
                    
                </div>

                <div class="col-sm-12">
                    
                      <div class="form-group">
                        <label for="inputState">Materias</label>
                        <select id="inputState" class="form-control">
                          <option selected>Seleccionar...</option>
                          <option>...</option>
                        </select>
                      </div>
                                     
              </div>
              <div class="col-sm-12">
                <div class="form-group">
                    <label for="inputState">Alumnos</label>
                    <select id="inputState" class="form-control">
                      <option selected>Seleccionar...</option>
                      <option>...</option>
                    </select>
                  </div>
              </div>
              
        </div>     

        <div class="col-sm-12" style="text-align: center;">
            <button type="submit" class="btn btn-success btn-lg btn-block" style="text-align: center; margin-top: 10px; width: 100%;">Aceptar</button>
          </div>   
            
          </form>
    </div>

</body>
</html>