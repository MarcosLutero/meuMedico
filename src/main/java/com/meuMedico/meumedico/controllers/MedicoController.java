package com.meuMedico.meumedico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuMedico.meumedico.dto.MedicoDTO;
import com.meuMedico.meumedico.services.MedicoService;


@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService; 
	
	
	@GetMapping
	public List<MedicoDTO> findAll() {
		List<MedicoDTO> result = medicoService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public MedicoDTO findById(@PathVariable Long id) {
		MedicoDTO result = medicoService.findById(id);
		return result;
	}
	
}
