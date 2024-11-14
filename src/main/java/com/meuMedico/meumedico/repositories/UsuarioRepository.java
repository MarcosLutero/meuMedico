package com.meuMedico.meumedico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuMedico.meumedico.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
}
