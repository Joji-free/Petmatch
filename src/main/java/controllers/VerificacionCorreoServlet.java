package controllers;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.UsuarioRepository;

import java.io.IOException;

@WebServlet("/verificar")
public class VerificacionCorreoServlet extends HttpServlet {
    private final UsuarioRepository usuarioRepo = new UsuarioRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        boolean exito = usuarioRepo.verificarCorreo(correo);

        if (exito) {
            request.setAttribute("mensaje", "Cuenta verificada. Ahora puedes iniciar sesión.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "No se pudo verificar el correo.");
            request.getRequestDispatcher("verificacion.jsp").forward(request, response);
        }
    }
}
