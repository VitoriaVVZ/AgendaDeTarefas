package com.example.agendadetarefas.controllers;

import com.example.agendadetarefas.DTOs.TarefaRequest;
import com.example.agendadetarefas.DTOs.TarefaResponse;
import com.example.agendadetarefas.services.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public String criarTarefa(@RequestBody TarefaRequest request) {
        return tarefaService.criarTarefa(request);
    }

    @GetMapping
    public List<TarefaResponse> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @PutMapping("/{id}")
    public String atualizarTarefa(@PathVariable Long id, @RequestBody TarefaRequest request) {
        return tarefaService.atualizarTarefa(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletarTarefa(@PathVariable Long id) {
        return tarefaService.deletarTarefa(id);
    }
}
