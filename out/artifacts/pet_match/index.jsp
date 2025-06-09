<%--
  Created by IntelliJ IDEA.
  User: ander
  Date: 9/6/2025
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true" %>
<%@ page import="models.Usuario" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario != null) {
        response.sendRedirect("home.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Bienvenido a Pet Match</title>
    <style>
        body {
            margin: 0;
            font-family: 'Arial Black', sans-serif;
            background: #ffccff;
        }

        .navbar {
            background-color: #cc00ff;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 40px;
        }

        .navbar .left,
        .navbar .right {
            display: flex;
            align-items: center;
            gap: 25px;
        }

        .navbar a {
            text-decoration: none;
            color: white;
            font-weight: bold;
            font-size: 14px;
        }

        .navbar .right a.login {
            color: black;
            font-weight: bold;
        }

        .navbar .right a.register {
            background-color: white;
            color: black;
            padding: 8px 16px;
            border-radius: 5px;
            font-weight: bold;
            text-decoration: none;
        }

        .hero {
            text-align: left;
            padding: 50px 40px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .hero-text {
            max-width: 600px;
        }

        .hero h1 {
            font-size: 60px;
            color: #cc00ff;
            margin-bottom: 10px;
        }

        .hero p {
            font-size: 20px;
            font-weight: bold;
            line-height: 1.5;
            color: black;
        }

        .hero p span {
            color: #cc00ff;
        }

        .hero-img {
            max-width: 600px;
        }

        .hero-img img {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>

<div class="navbar">
    <div class="left">
        <img src="img/logo1.jpg" alt="Logo" width="30" height="30"> <!-- Reemplaza por tu logo -->
        <a href="#">ACERCA DE NOSOTROS</a>
        <a href="#">ASISTENCIA</a>
        <a href="#">SEGURIDAD</a>
        <a href="#">DESCARGA</a>
    </div>
    <div class="right">
        <a class="login" href="login.jsp">LOGIN</a>
        <a class="register" href="registro.jsp">REGISTER</a>
    </div>
</div>

<div class="hero">
    <div class="hero-text">
        <h1>PET MATCH</h1>
        <p>
            Bienvenido a <span>Pet Match</span>, la app donde las mascotas hacen match y viven nuevas aventuras.
            Aqui tu mascota encontrara nuevos amigos, companeros de juegos y algo mas...
        </p>
    </div>
    <div class="hero-img">
        <img src="img/img1.jpg" alt="Mascotas"> <!-- Reemplaza con tu imagen -->
    </div>
</div>

</body>
</html>
