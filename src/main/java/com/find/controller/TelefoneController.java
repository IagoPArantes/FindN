package com.find.controller;

import com.find.application.Telefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.find.service.TelefoneService;

import java.util.List;

@RequestMapping("/api/telefone")
@CrossOrigin(origins = "*")
@RestController
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    // GET /api/telefone
    @GetMapping
    public ResponseEntity<List<Telefone>> listarTelefone() {
        List<Telefone> telefones = telefoneService.listarTelefone();
        return ResponseEntity.ok(telefones);
    }

    // GET /api/telefone/{id} - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Telefone> buscarTelefone(@PathVariable int id) {
        Telefone telefone = telefoneService.buscarTelefone(id);
        if (telefone != null) {
            return ResponseEntity.ok(telefone);
        }
        return ResponseEntity.notFound().build();
    }

    // POST /api/telefone - Criar telefone
    @PostMapping
    public ResponseEntity<Telefone> criarTelefone(@RequestBody Telefone telefone) {
        telefoneService.criarTelefone(telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefone);
    }

    // PUT /api/telefone/{id} - Atualizar telefone
    @PutMapping("/{id}")
    public ResponseEntity<Telefone> editarTelefone(@PathVariable int id, @RequestBody Telefone telefone) {
        Telefone telefoneAtualizado = telefoneService.editarTelefone(id, telefone);
        return ResponseEntity.ok(telefoneAtualizado);
    }

    // DELETE /api/telefone/{id} - Deletar telefone
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTelefone(@PathVariable int id) {
        telefoneService.deletarTelefone(id);
        return ResponseEntity.noContent().build();
    }
}