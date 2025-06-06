package filtro;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import models.Usuario;

import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*", "/evento/registrar"})
public class RolFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuario") : null;

        if (usuario == null) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        String uri = req.getRequestURI();

        if (uri.contains("/admin") && !usuario.getRol().equals("Admin")) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "Acceso denegado");
            return;
        }

        if (uri.contains("/evento/registrar") && !(usuario.getRol().equals("Asociacion") || usuario.getRol().equals("Admin"))) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "Solo asociaciones o administradores pueden crear eventos.");
            return;
        }

        chain.doFilter(request, response);
    }
}
