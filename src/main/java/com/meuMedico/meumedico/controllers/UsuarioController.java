package com.meuMedico.meumedico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuMedico.meumedico.dto.UsuarioDTO;
import com.meuMedico.meumedico.services.UsuarioService;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 
	
	
	@GetMapping
	public List<UsuarioDTO> findAll() {
		List<UsuarioDTO> result = usuarioService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public UsuarioDTO findById(@PathVariable Long id) {
		UsuarioDTO result = usuarioService.findById(id);
		return result;
	}
	
}
