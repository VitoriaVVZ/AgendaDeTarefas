package com.example.agendadetarefas.controllers;

import com.example.agendadetarefas.DTOs.UsuarioRequest;
import com.example.agendadetarefas.DTOs.UsuarioResponse;
import com.example.agendadetarefas.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public String criarUsuario(@RequestBody UsuarioRequest request) {
        return usuarioService.criarUsuario(request);
    }

    @GetMapping
    public List<UsuarioResponse> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PutMapping("/{id}")
    public String atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequest request) {
        return usuarioService.atualizarUsuario(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        return usuarioService.deletarUsuario(id);
    }
}
