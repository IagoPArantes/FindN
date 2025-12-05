package controller;

import application.Usuario;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import service.UsuarioService;

import java.util.List;

@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*" ) // Permite requisições do front end



public class UsuarioController {


    private UsuarioService usarioService;

    //Get /api/usuarios - Listar todos
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        List<Usuario> usuario = UsuarioService.listarTodos();
        return ResponseEntity.ok(usuario);
    }

    // GET /api/usuario/{id} = Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorid(@PathVariable int id) {
        Usuario usuario = UsuarioService.buscarPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    //PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = UsuarioService.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    //Put /api/usuario/{id} - Atualizar usuário
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = UsuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        UsuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    //Post /api/usuario/login - Endpoint de login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = UsuarioService.validarLogin(
                loginRequest.getEmail(),
                loginRequest.getSenha()
        );

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Email ou senha inválidos");
    }

    // Classe auxiliar para login
    class LoginRequest {
        private String email;
        private String senha;

        public String getEmail() { return email;}
        public void setEmail(String email) { this.email = email;}
        public String getSenha() { return senha; }
        public void setSenha(String senha) { this.senha = senha;}
    }
}
