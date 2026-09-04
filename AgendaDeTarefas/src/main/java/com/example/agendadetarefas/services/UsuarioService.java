package com.example.agendadetarefas.services;

import com.example.agendadetarefas.DTOs.UsuarioRequest;
import com.example.agendadetarefas.DTOs.UsuarioResponse;
import com.example.agendadetarefas.entities.Usuario;
import com.example.agendadetarefas.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String criarUsuario(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuarioRepository.save(usuario);
        return "Usuário cadastrado com sucesso!";
    }

    public List<UsuarioResponse> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioResponse(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getTarefa() != null ? usuario.getTarefa().getTitulo() : "Nenhuma tarefa agendada"))
                .toList();
    }

    public String atualizarUsuario(Long id, UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) return "Usuário não encontrado";

        usuario.setNome(request.getNome());
        usuarioRepository.save(usuario);
        return "Usuário atualizado";
    }

    public String deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) return "Usuário não encontrado";

        usuarioRepository.deleteById(id);
        return "Usuário deletado";
    }
}