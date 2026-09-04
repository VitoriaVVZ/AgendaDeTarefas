package com.example.agendadetarefas.services;

import com.example.agendadetarefas.DTOs.TarefaRequest;
import com.example.agendadetarefas.DTOs.TarefaResponse;
import com.example.agendadetarefas.entities.Tarefa;
import com.example.agendadetarefas.entities.Usuario;
import com.example.agendadetarefas.repositories.TarefaRepository;
import com.example.agendadetarefas.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public String criarTarefa(TarefaRequest request) {
        Usuario usuario = null;
        if (request.getUsuarioId() != null) {
            usuario = usuarioRepository.findById(request.getUsuarioId()).orElse(null);
        }

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(request.getTitulo());
        tarefa.setDescricao(request.getDescricao());
        tarefa.setDataHora(request.getDataHora());
        tarefa.setConcluida(request.isConcluida());
        tarefa.setUsuario(usuario);

        tarefaRepository.save(tarefa);
        return "Tarefa agendada com sucesso!";
    }

    public List<TarefaResponse> listarTarefas() {
        return tarefaRepository.findAll().stream()
                .map(tarefa -> new TarefaResponse(
                        tarefa.getId(),
                        tarefa.getTitulo(),
                        tarefa.getDescricao(),
                        tarefa.getDataHora(),
                        tarefa.isConcluida(),
                        tarefa.getUsuario() != null ? tarefa.getUsuario().getNome() : "Sem usuário"))
                .toList();
    }

    public String atualizarTarefa(Long id, TarefaRequest request) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa == null) return "Tarefa não encontrada";

        tarefa.setTitulo(request.getTitulo());
        tarefa.setDescricao(request.getDescricao());
        tarefa.setDataHora(request.getDataHora());
        tarefa.setConcluida(request.isConcluida());

        if (request.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(request.getUsuarioId()).orElse(null);
            tarefa.setUsuario(usuario);
        }

        tarefaRepository.save(tarefa);
        return "Tarefa atualizada com sucesso!";
    }

    public String deletarTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa == null) return "Tarefa não encontrada";

        tarefaRepository.deleteById(id);
        return "Tarefa deletada com sucesso!";
    }
}