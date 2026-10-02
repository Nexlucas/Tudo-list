package com.biolab.tudolist.repositories;

import com.biolab.tudolist.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
