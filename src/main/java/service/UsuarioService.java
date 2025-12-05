package service;

import application.Usuario;
import dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private static UsuarioDao usuarioDao;

    @Autowired  // ← Injeção de dependência
    public UsuarioService(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public static List<Usuario> listarTodos() {
        return usuarioDao.listar();
    }

    public static Usuario buscarPorId(int id) {
        return usuarioDao.buscarPorId(id);
    }

    public static Usuario criar(Usuario usuario) {
        usuarioDao.salvarUsuario(usuario);
        return usuario;
    }

    public static Usuario atualizar(int id, Usuario usuario) {
        usuario.setId(id);
        usuarioDao.atualizar(usuario);
        return usuario;
    }

    public static void deletar(int id) {
        usuarioDao.deletar(id);
    }

    public static Usuario validarLogin(String email, String senha) {
        List<Usuario> usuarios = usuarioDao.listar();
        return usuarios.stream()
                .filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha))
                .findFirst()
                .orElse(null);
    }
}