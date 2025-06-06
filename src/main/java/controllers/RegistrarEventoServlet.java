package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Evento;
import repository.EventoRepository;

import java.io.IOException;

@WebServlet("/evento/registrar")
public class RegistrarEventoServlet extends HttpServlet {
    private final EventoRepository eventoRepo = new EventoRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        models.Usuario usuario = (models.Usuario) session.getAttribute("usuario");

        Evento evento = new Evento();
        evento.setTitulo(request.getParameter("titulo"));
        evento.setDescripcion(request.getParameter("descripcion"));
        evento.setUbicacion(request.getParameter("ubicacion"));
        evento.setFecha(request.getParameter("fecha"));
        evento.setTipo(request.getParameter("tipo"));
        evento.setIdCreador(usuario.getIdusuario());

        boolean exito = eventoRepo.registrar(evento);
        if (exito) {
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("error", "Error al registrar evento.");
            request.getRequestDispatcher("registroEvento.jsp").forward(request, response);
        }
    }
}
