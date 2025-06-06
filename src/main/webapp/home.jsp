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
    <title>Inicio - MatchPet</title>
</head>
<body>
<h2>Bienvenido, <%= usuario.getNombre() %>!</h2>
<a href="perfil.jsp">Ver mi perfil</a> |
<a href="logout">Cerrar sesión</a>
</body>
</html>
