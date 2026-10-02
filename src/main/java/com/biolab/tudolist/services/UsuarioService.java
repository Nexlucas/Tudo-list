package com.biolab.tudolist.services;

import com.biolab.tudolist.DTOs.UsuarioReponsive;
import com.biolab.tudolist.DTOs.UsuarioRequest;
import com.biolab.tudolist.entities.Usuario;
import com.biolab.tudolist.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String criarUsuario(UsuarioReponsive dto) {
        Usuario u = new Usuario();
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setSenha(dto.getSenha());
        usuarioRepository.save(u);
        return "salvo com sucesso!";
    }

    public String alterarUsuario(long id, UsuarioReponsive dto) {
        Usuario u = usuarioRepository.findById(id).orElseThrow();
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setSenha(dto.getSenha());
        usuarioRepository.save(u);
        return "Usuario alterado com sucesso!";
    }

    public String deletarUsuario(long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuarioRepository.deleteById(id);
        return "Usuario deletado com sucesso!";
    }

    public List<UsuarioRequest> listarUsuarios() {
        List<UsuarioRequest> usuarios = usuarioRepository.findAll().stream().map(usuario -> new UsuarioRequest(usuario.getId(),usuario.getNome(),usuario.getEmail())).toList();
        return usuarios;
    }
}
