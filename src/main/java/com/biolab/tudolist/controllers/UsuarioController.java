package com.biolab.tudolist.controllers;

import com.biolab.tudolist.DTOs.UsuarioReponsive;
import com.biolab.tudolist.DTOs.UsuarioRequest;
import com.biolab.tudolist.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> salvarUsu(@RequestBody UsuarioReponsive dto) {
        return ResponseEntity.ok(service.criarUsuario(dto));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioRequest>> listarUsuarios() {
        return ResponseEntity.ok(service.listarUsuarios());
    }

    @DeleteMapping("/deletarUsuario/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable long id) {
        service.deletarUsuario(id);
        return ResponseEntity.ok("Usuario deletado com sucesso!");
    }

    @PutMapping("/alterarUsuario/{id}")
    public ResponseEntity<?> editarUsuario(@Valid @PathVariable long id,@RequestBody UsuarioReponsive dto) {
        service.alterarUsuario(id,dto);
        return ResponseEntity.ok("Usuario alterado com sucesso!");
    }
}
