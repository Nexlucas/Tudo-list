package com.biolab.tudolist.DTOs;

import com.biolab.tudolist.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarefaRequest {
    private String titulo;
    private String descricao;
    private LocalDate dt_inicio;
    private LocalDate dt_termino;
    private Status status;
    private long idUsuario;
}
