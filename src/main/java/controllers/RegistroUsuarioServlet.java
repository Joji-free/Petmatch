package controllers;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Usuario;
import repository.UsuarioRepository;
import util.HashUtil;
import util.CorreoUtil;

import java.io.IOException;

@WebServlet("/registro")
public class RegistroUsuarioServlet extends HttpServlet {
    private final UsuarioRepository usuarioRepo = new UsuarioRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setCorreo(request.getParameter("correo"));
        usuario.setContraseña(HashUtil.hashPassword(request.getParameter("contraseña")));
        usuario.setTelefono(request.getParameter("telefono"));
        usuario.setUbicacion(request.getParameter("ubicacion"));
        usuario.setGenero(request.getParameter("genero"));
        usuario.setFechaNacimiento(request.getParameter("fechaNacimiento"));
        usuario.setRol("Usuario");
        usuario.setVerificado(false);

        boolean exito = usuarioRepo.registrar(usuario);
        if (exito) {
            CorreoUtil.enviarVerificacion(usuario.getCorreo());
            response.sendRedirect("verificacion.jsp");
        } else {
            request.setAttribute("error", "No se pudo registrar.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}
