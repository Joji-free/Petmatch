package controllers;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Usuario;
import repository.UsuarioRepository;
import util.HashUtil;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UsuarioRepository usuarioRepo = new UsuarioRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String password = request.getParameter("contraseña");

        Usuario usuario = usuarioRepo.buscarPorCorreo(correo);
        if (usuario != null && HashUtil.checkPassword(password, usuario.getContraseña())) {
            if (!usuario.isVerificado()) {
                request.setAttribute("mensaje", "Verifica tu correo antes de iniciar sesión.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }

            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("error", "Correo o contraseña incorrectos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
