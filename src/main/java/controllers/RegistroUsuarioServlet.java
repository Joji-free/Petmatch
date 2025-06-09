package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Usuario;
import repository.UsuarioRepository;
import util.CorreoUtil;
import util.HashUtil;

import java.io.IOException;

@WebServlet("/registro")
public class RegistroUsuarioServlet extends HttpServlet {
    private final UsuarioRepository usuarioRepo = new UsuarioRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String contraseña = request.getParameter("contraseña");
            String telefono = request.getParameter("telefono");
            String ubicacion = request.getParameter("ubicacion");
            String genero = request.getParameter("genero");
            String fechaNac = request.getParameter("fechaNacimiento"); // yyyy-MM-dd

            // Validación básica
            if (nombre == null || correo == null || contraseña == null || telefono == null ||
                    ubicacion == null || genero == null || fechaNac == null ||
                    nombre.isEmpty() || correo.isEmpty() || contraseña.isEmpty() ||
                    telefono.isEmpty() || ubicacion.isEmpty() || genero.isEmpty() || fechaNac.isEmpty()) {
                request.setAttribute("error", "Todos los campos son obligatorios.");
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                return;
            }
            // Validar correo duplicado antes de registrar
            if (usuarioRepo.buscarPorCorreo(correo) != null) {
                request.setAttribute("error", "Este correo ya está registrado.");
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                return;
            }


            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setCorreo(correo);
            usuario.setContraseña(HashUtil.hashPassword(contraseña));
            usuario.setTelefono(telefono);
            usuario.setUbicacion(ubicacion);
            usuario.setGenero(genero);
            usuario.setFechaNacimiento(fechaNac); // se convierte después
            usuario.setVerificado(false);
            usuario.setRol("Usuario");

            boolean registrado = usuarioRepo.registrar(usuario);

            if (registrado) {
                CorreoUtil.enviarVerificacion(correo);
                response.sendRedirect("verificacion.jsp");
            } else {
                request.setAttribute("error", "No se pudo registrar.");
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error interno en el servidor.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}
