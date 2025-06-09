<%--
  Created by IntelliJ IDEA.
  User: ander
  Date: 5/6/2025
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true" %>
<%@ page import="models.Usuario, models.Mascota, repository.MascotaRepository, java.util.List" %>
<%
  Usuario usuario = (Usuario) session.getAttribute("usuario");
  if (usuario == null) {
    response.sendRedirect("login.jsp");
    return;
  }

  MascotaRepository repo = new MascotaRepository();
  List<Mascota> mascotas = repo.listarPorUsuario(usuario.getIdusuario());
%>
<!DOCTYPE html>
<html>
<head>
  <title>Mis Mascotas</title>
</head>
<body>
<h2>Mis Mascotas</h2>
<ul>
  <% for (Mascota m : mascotas) { %>
  <li>
    <strong><%= m.getNombre() %></strong> - <%= m.getRaza() %> - <%= m.getEdad() %> años
    <br>Estado: <%= m.getEstado() %>
    <br><img src="<%= m.getFotoUrl() %>" width="100">
    <hr>
  </li>
  <% } %>
</ul>

<a href="registroMascota.jsp">Agregar nueva mascota</a> |
<a href="home.jsp">Volver al inicio</a>
</body>
</html>
