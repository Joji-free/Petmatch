package repository;


import models.Usuario;

public interface IUsuarioRepository {
    boolean registrar(Usuario usuario);
    Usuario buscarPorCorreo(String correo);
    boolean verificarCorreo(String correo);
}
