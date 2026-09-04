package com.example.agendadetarefas.DTOs;

import java.time.LocalDateTime;

public class TarefaResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHora;
    private boolean concluida;
    private String nomeUsuario;

    public TarefaResponse(Long id, String titulo, String descricao, LocalDateTime dataHora, boolean concluida, String nomeUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.concluida = concluida;
        this.nomeUsuario = nomeUsuario;
    }

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public boolean isConcluida() {
        return concluida;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
}