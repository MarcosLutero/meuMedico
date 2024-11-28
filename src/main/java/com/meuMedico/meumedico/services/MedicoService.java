package com.meuMedico.meumedico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.meuMedico.meumedico.dto.MedicoDTO;
import com.meuMedico.meumedico.entities.Medico;
import com.meuMedico.meumedico.repositories.MedicoRepository;


@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	
	public List<MedicoDTO> findAll() {
		List<Medico> result = medicoRepository.findAll();
		return result.stream().map(MedicoDTO::new).toList();
	}
	
	

	public MedicoDTO findById(@PathVariable Long listId) {
		Medico result = medicoRepository.findById(listId).get();
		return new MedicoDTO(result);
	}

}
