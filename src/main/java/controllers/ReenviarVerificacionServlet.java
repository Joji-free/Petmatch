package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.UsuarioRepository;
import util.CorreoUtil;

import java.io.IOException;

@WebServlet("/reenviar-verificacion")
public class ReenviarVerificacionServlet extends HttpServlet {
    private final UsuarioRepository usuarioRepo = new UsuarioRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");

        if (usuarioRepo.buscarPorCorreo(correo) != null) {
            CorreoUtil.enviarVerificacion(correo);
            request.setAttribute("mensaje", "Correo de verificación reenviado.");
        } else {
            request.setAttribute("error", "El correo no está registrado.");
        }

        request.getRequestDispatcher("verificacion.jsp").forward(request, response);
    }
}
