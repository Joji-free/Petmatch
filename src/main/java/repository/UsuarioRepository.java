package repository;

import models.Usuario;
import repository.IUsuarioRepository;
import util.ConexionBD;

import java.sql.*;

public class UsuarioRepository implements IUsuarioRepository {

    @Override
    public boolean registrar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, correo, contraseña, telefono, ubicacion, verificado, rol, Genero, fecha_de_nacimiento) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContraseña());
            stmt.setString(4, usuario.getTelefono());
            stmt.setString(5, usuario.getUbicacion());
            stmt.setBoolean(6, usuario.isVerificado());
            stmt.setString(7, usuario.getRol());
            stmt.setString(8, usuario.getGenero());
            stmt.setString(9, usuario.getFechaNacimiento());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        String sql = "SELECT * FROM usuario WHERE correo = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdusuario(rs.getInt("idusuario"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setContraseña(rs.getString("contraseña"));
                u.setTelefono(rs.getString("telefono"));
                u.setUbicacion(rs.getString("ubicacion"));
                u.setVerificado(rs.getBoolean("verificado"));
                u.setRol(rs.getString("rol"));
                u.setGenero(rs.getString("Genero"));
                u.setFechaNacimiento(rs.getString("fecha_de_nacimiento"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean verificarCorreo(String correo) {
        String sql = "UPDATE usuario SET verificado = 1 WHERE correo = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
