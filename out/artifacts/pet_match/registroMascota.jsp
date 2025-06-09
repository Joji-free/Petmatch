<%--
  Created by IntelliJ IDEA.
  User: ander
  Date: 5/6/2025
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true" %>
<%@ page import="models.Usuario" %>
<%
  Usuario usuario = (Usuario) session.getAttribute("usuario");
  if (usuario == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>
<!DOCTYPE html>
<html>
<head>
  <title>Registrar Mascota</title>
</head>
<body>
<h2>Registrar nueva mascota</h2>
<form action="registrarMascota" method="post">
  <input type="text" name="nombre" placeholder="Nombre" required><br>
  <input type="number" name="edad" placeholder="Edad" required min="0"><br>
  <input type="text" name="raza" placeholder="Raza" required><br>

  <label>Sexo:</label>
  <select name="sexo" required>
    <option value="Macho">Macho</option>
    <option value="Hembra">Hembra</option>
  </select><br>

  <label>Tamaño:</label>
  <select name="tamaño" required>
    <option value="Pequeño">Pequeño</option>
    <option value="Mediano">Mediano</option>
    <option value="Grande">Grande</option>
  </select><br>

  <input type="text" name="ubicacion" placeholder="Ubicación" required><br>
  <input type="text" name="fotoUrl" placeholder="URL de la foto" required><br>

  <label>Estado:</label>
  <select name="estado" required>
    <option value="En_celo">En celo</option>
    <option value="Adopcion">Adopción</option>
    <option value="Disponible_Socializacion">Disponible para socializar</option>
  </select><br>

  <button type="submit">Registrar Mascota</button>
</form>

<p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
</body>
</html>
