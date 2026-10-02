package com.biolab.tudolist.repositories;

import com.biolab.tudolist.entities.Tarefa;
import com.biolab.tudolist.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
