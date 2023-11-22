package com.example.projetoaulaAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoaulaAPI.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
