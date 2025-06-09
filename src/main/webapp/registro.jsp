<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro - MatchPet</title>
</head>
<body>
<h2>Registro de Usuario</h2>

<form action="registro" method="post">
    <input type="text" name="nombre" placeholder="Nombre" required><br>
    <input type="email" name="correo" placeholder="Correo electrónico" required><br>
    <input type="password" name="contraseña" placeholder="Contraseña" required><br>
    <input type="text" name="telefono" placeholder="Teléfono" required><br>
    <input type="text" name="ubicacion" placeholder="Ubicación" required><br>

    <label>Género:</label>
    <select name="genero" required>
        <option value="">Seleccione...</option>
        <option value="Masculino">Masculino</option>
        <option value="Femenino">Femenino</option>
        <option value="Prefiero no decirlo">Prefiero no decirlo</option>
    </select><br>

    <label>Fecha de nacimiento:</label>
    <input type="date" name="fechaNacimiento" required><br>

    <button type="submit">Registrarse</button>
</form>

<p style="color:red;">
    <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
</p>
</body>
</html>
