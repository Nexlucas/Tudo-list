package com.biolab.tudolist.DTOs;

import com.biolab.tudolist.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioRequest {
    private int id;
    private String nome;
    private String email;

}
