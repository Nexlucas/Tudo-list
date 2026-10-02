package com.biolab.tudolist.controllers;

import com.biolab.tudolist.DTOs.TarefaReponsive;
import com.biolab.tudolist.DTOs.TarefaRequest;
import com.biolab.tudolist.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefa")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<?> salvarTarefa(@RequestBody TarefaReponsive dto) {
        return ResponseEntity.ok(tarefaService.criarTarefa(dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaRequest>> mostrarTarefa(){
        return ResponseEntity.ok(tarefaService.verTarefas());
    }

    @PutMapping("/alterarTarefa/{id}")
    public ResponseEntity<?> alterarTarefa(@Valid @PathVariable long id, @RequestBody TarefaReponsive dto){
        return ResponseEntity.ok(tarefaService.alterarTarefa(id,dto));
    }

    @DeleteMapping("/deletarTarefa/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable long id){
        return ResponseEntity.ok(tarefaService.excluirTarefa(id));
    }
}
