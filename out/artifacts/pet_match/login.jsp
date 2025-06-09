<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Iniciar Sesión</title>
</head>
<body>
<h2>Login</h2>
<form action="login" method="post">
    <input type="email" name="correo" placeholder="Correo" required><br>
    <input type="password" name="contraseña" placeholder="Contraseña" required><br>
    <button type="submit">Ingresar</button>
</form>

<p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
<p style="color:green;"><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></p>
</body>
</html>
