<%--
  Created by IntelliJ IDEA.
  User: ander
  Date: 9/6/2025
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Verificación de Correo</title>
</head>
<body>
<h2>Verificación de Correo</h2>

<% if (request.getAttribute("mensaje") != null) { %>
<p style="color:green;"><%= request.getAttribute("mensaje") %></p>
<% } %>

<% if (request.getAttribute("error") != null) { %>
<p style="color:red;"><%= request.getAttribute("error") %></p>
<% } %>

<p>Si ya hiciste clic en el enlace enviado a tu correo:</p>
<a href="login.jsp">Iniciar sesión</a>

<p>¿No recibiste el correo?</p>
<form action="reenviar-verificacion" method="post">
    <input type="email" name="correo" placeholder="Correo electrónico" required>
    <button type="submit">Reenviar Verificación</button>
</form>
</body>
</html>
