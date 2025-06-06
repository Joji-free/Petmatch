package repository;


import models.Evento;
import util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventoRepository {

    public boolean registrar(Evento evento) {
        String sql = "INSERT INTO evento (titulo, descripcion, ubicacion, fecha, tipo, idcreador) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, evento.getTitulo());
            stmt.setString(2, evento.getDescripcion());
            stmt.setString(3, evento.getUbicacion());
            stmt.setString(4, evento.getFecha());
            stmt.setString(5, evento.getTipo());
            stmt.setInt(6, evento.getIdCreador());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}

