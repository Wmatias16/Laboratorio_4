<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Alta alumnos</title>
</head>
<body>
    <div class="container" style="margin-top: 100px; width: 700px;">
        <h1 style="text-align: center;">Alta alumno</h1>
        <form>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese email">
                      </div>
                </div>

                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Dni</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese dni">
                      </div>
                      <div class="form-group">
                          <label for="exampleInputEmail1">Nombre</label>
                          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nombre">
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Apellido</label>
                          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese apellido">
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Fecha de nacimiento</label>
                          <input type="date" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese fecha de nacimiento">
                        </div>
                </div>

                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Direccion</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese direccion">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Localidad</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese localidad">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Nacionalidad</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese nacionalidad">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Telefono</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese telefono">
                      </div>
                    
              </div>
              <div class="col-sm-12" style="text-align: center;">
                <button type="submit" class="btn btn-success btn-lg btn-block" style="text-align: center; margin-top: 10px; width: 100%;">Aceptar</button>
              </div>
            </div>
                
                   
            
          </form>
    </div>
</body>
</html>