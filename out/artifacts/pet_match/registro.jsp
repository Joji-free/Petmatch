<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registro</title>
</head>
<body>
<h2>Registrarse</h2>
<form action="registro" method="post" onsubmit="return validarFormulario()">
    <input type="text" name="nombre" placeholder="Nombre" required><br>
    <input type="email" name="correo" placeholder="Correo" required><br>
    <input type="password" name="contraseña" placeholder="Contraseña" required minlength="6"><br>
    <input type="text" name="telefono" placeholder="Teléfono" required><br>
    <input type="text" name="ubicacion" placeholder="Ubicación" required><br>
    <select name="genero" required>
        <option value="">Selecciona género</option>
        <option value="Masculino">Masculino</option>
        <option value="Femenino">Femenino</option>
        <option value="Prefiero no decirlo">Prefiero no decirlo</option>
    </select><br>
    <input type="date" name="fechaNacimiento" required><br>
    <button type="submit">Registrarme</button>
</form>

<p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>

<script>
    function validarFormulario() {
        const pass = document.querySelector('input[name="contraseña"]').value;
        if (pass.length < 6) {
            alert("La contraseña debe tener al menos 6 caracteres.");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
