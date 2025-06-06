package repository;


import models.Mascota;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaRepository {

    public boolean registrar(Mascota mascota) {
        String sql = "INSERT INTO mascota (nombre, edad, raza, sexo, tamaño, ubicacion, foto_url, estado, id_usuario) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, mascota.getNombre());
            stmt.setInt(2, mascota.getEdad());
            stmt.setString(3, mascota.getRaza());
            stmt.setString(4, mascota.getSexo());
            stmt.setString(5, mascota.getTamaño());
            stmt.setString(6, mascota.getUbicacion());
            stmt.setString(7, mascota.getFotoUrl());
            stmt.setString(8, mascota.getEstado());
            stmt.setInt(9, mascota.getIdUsuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public List<Mascota> listarPorUsuario(int idUsuario) {
        List<Mascota> mascotas = new ArrayList<>();
        String sql = "SELECT * FROM mascota WHERE id_usuario = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Mascota m = new Mascota();
                m.setIdmascota(rs.getInt("idmascota"));
                m.setNombre(rs.getString("nombre"));
                m.setEdad(rs.getInt("edad"));
                m.setRaza(rs.getString("raza"));
                m.setSexo(rs.getString("sexo"));
                m.setTamaño(rs.getString("tamaño"));
                m.setUbicacion(rs.getString("ubicacion"));
                m.setFotoUrl(rs.getString("foto_url"));
                m.setEstado(rs.getString("estado"));
                m.setIdUsuario(rs.getInt("id_usuario"));
                mascotas.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mascotas;
    }

}
