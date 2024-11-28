package com.meuMedico.meumedico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuMedico.meumedico.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
	
	
}
