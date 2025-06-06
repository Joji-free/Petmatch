package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Mascota;
import repository.MascotaRepository;

import java.io.IOException;

@WebServlet("/registrarMascota")
public class RegistroMascotaServlet extends HttpServlet {
    private final MascotaRepository mascotaRepo = new MascotaRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int idUsuario = ((models.Usuario) session.getAttribute("usuario")).getIdusuario();

        Mascota mascota = new Mascota();
        mascota.setNombre(request.getParameter("nombre"));
        mascota.setEdad(Integer.parseInt(request.getParameter("edad")));
        mascota.setRaza(request.getParameter("raza"));
        mascota.setSexo(request.getParameter("sexo"));
        mascota.setTamaño(request.getParameter("tamaño"));
        mascota.setUbicacion(request.getParameter("ubicacion"));
        mascota.setFotoUrl(request.getParameter("fotoUrl"));
        mascota.setEstado(request.getParameter("estado"));
        mascota.setIdUsuario(idUsuario);

        boolean exito = mascotaRepo.registrar(mascota);
        if (exito) {
            response.sendRedirect("perfil.jsp");
        } else {
            request.setAttribute("error", "Error al registrar mascota.");
            request.getRequestDispatcher("registroMascota.jsp").forward(request, response);
        }
    }
}
