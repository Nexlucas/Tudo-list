package com.biolab.tudolist.services;

import com.biolab.tudolist.DTOs.TarefaReponsive;
import com.biolab.tudolist.DTOs.TarefaRequest;
import com.biolab.tudolist.entities.Tarefa;
import com.biolab.tudolist.entities.Usuario;
import com.biolab.tudolist.entities.enums.Status;
import com.biolab.tudolist.repositories.TarefaRepository;
import com.biolab.tudolist.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    public final TarefaRepository tarefaRepository;
    public final UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public String criarTarefa(TarefaReponsive dto) {
        Tarefa t = new Tarefa();
        Usuario u = usuarioRepository.findById(dto.getIdUsuario()).orElseThrow();

        t.setTitulo(dto.getTitulo());
        t.setDescricao(dto.getDescricao());
        t.setDt_inicio(dto.getDt_inicio());
        t.setDt_termino(dto.getDt_termino());
        t.setUsuario(u);
        t.setStatus(Status.Baxa);
        tarefaRepository.save(t);
        return "Tarefa criada com sucesso!";
    }
    public List<TarefaRequest> verTarefas() {
        return tarefaRepository.findAll().stream().map(tarefa -> new TarefaRequest(tarefa.getTitulo(),tarefa.getDescricao(),tarefa.getDt_inicio(),tarefa.getDt_termino(),tarefa.getStatus(),tarefa.getUsuario().getId())).toList();
    }

    public String alterarTarefa(long id,TarefaReponsive dto) {
        Tarefa t = tarefaRepository.findById(id).orElseThrow();
        t.setTitulo(dto.getTitulo());
        t.setDescricao(dto.getDescricao());
        t.setDt_inicio(dto.getDt_inicio());
        t.setDt_termino(dto.getDt_termino());
        tarefaRepository.save(t);
        return "Tarefa alterada com sucesso!";
    }

    public String excluirTarefa(long id) {
        Tarefa t = tarefaRepository.findById(id).orElseThrow();
        tarefaRepository.deleteById(id);
        return "Tarefa excluida com sucesso!";
    }



}
