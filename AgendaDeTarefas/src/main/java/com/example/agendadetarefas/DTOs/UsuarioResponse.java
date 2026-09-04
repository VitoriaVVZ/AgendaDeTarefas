package com.example.agendadetarefas.DTOs;

public class UsuarioResponse {
    private Long id;
    private String nome;
    private String tituloTarefa;

    public UsuarioResponse(Long id, String nome, String tituloTarefa) {
        this.id = id;
        this.nome = nome;
        this.tituloTarefa = tituloTarefa;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getTituloTarefa() {
        return tituloTarefa;
    }
}