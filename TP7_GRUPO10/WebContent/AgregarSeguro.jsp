<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="">Inicio </a><a href="">Agregar seguro </a><a href="">Listar seguros</a>
<h1>Agregar seguros</h1>

<%! String id = "0"; %>

Id seguro   <%=id %> <br>
<form>
Descripcion <input type="text" name="txtDescripcion"><br>
Tipo seguro <select name="tipoSeguro">
				<option>Seguro de casas</option>
			</select> <br>
Costo contratacion <input type="text" name="txtContratacion"><br>
Costo Maxio asegurado <input type="text" name="txtCostoMax"><br>
<input type="submit" name="btnEnviar" value="Enviar">

			

			
</form>


</body>
</html>