<%--
  Created by IntelliJ IDEA.
  User: ander
  Date: 5/6/2025
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true" %>
<%@ page import="models.Usuario" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null || (!usuario.getRol().equals("Admin") && !usuario.getRol().equals("Asociacion"))) {
        response.sendError(403, "Acceso denegado");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Crear Evento</title>
</head>
<body>
<h2>Registrar Evento</h2>
<form action="evento/registrar" method="post">
    <input type="text" name="titulo" placeholder="Título" required><br>
    <textarea name="descripcion" placeholder="Descripción" required></textarea><br>
    <input type="text" name="ubicacion" placeholder="Ubicación" required><br>
    <input type="datetime-local" name="fecha" required><br>
    <label>Tipo:</label>
    <select name="tipo" required>
        <option value="Paseo">Paseo</option>
        <option value="Feria">Feria</option>
        <option value="Otro">Otro</option>
    </select><br>
    <button type="submit">Registrar Evento</button>
</form>

<p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
</body>
</html>

