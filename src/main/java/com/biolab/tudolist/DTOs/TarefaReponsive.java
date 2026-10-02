package com.biolab.tudolist.DTOs;

import com.biolab.tudolist.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarefaReponsive {
    private long id;
    private String titulo;
    private String descricao;
    private LocalDate dt_inicio;
    private LocalDate dt_termino;
    private Status status;
    private long idUsuario;

    public TarefaReponsive(String titulo, String descricao, LocalDate dt_inicio, LocalDate dt_termino, Status status, long idUsuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dt_inicio = dt_inicio;
        this.dt_termino = dt_termino;
        this.status = status;
        this.idUsuario = idUsuario;
    }

    public TarefaReponsive(long id, String titulo, String descricao, LocalDate dt_inicio, LocalDate dt_termino, Status status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dt_inicio = dt_inicio;
        this.dt_termino = dt_termino;
        this.status = status;
    }
}
