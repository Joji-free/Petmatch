<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesión - MatchPet</title>
</head>
<body>
<h2>Iniciar Sesión</h2>

<form action="login" method="post">
    <input type="email" name="correo" placeholder="Correo electrónico" required><br>
    <input type="password" name="contraseña" placeholder="Contraseña" required><br>
    <button type="submit">Entrar</button>
</form>

<p style="color:red;">
    <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
</p>

<p style="color:green;">
    <%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %>
</p>

<p>¿No tienes cuenta? <a href="registro.jsp">Regístrate aquí</a></p>

<p>¿No recibiste el correo de verificación? <a href="verificacion.jsp">Haz clic aquí</a></p>
</body>
</html>
