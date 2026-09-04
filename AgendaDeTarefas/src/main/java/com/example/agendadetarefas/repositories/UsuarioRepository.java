package com.example.agendadetarefas.repositories;

import com.example.agendadetarefas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
