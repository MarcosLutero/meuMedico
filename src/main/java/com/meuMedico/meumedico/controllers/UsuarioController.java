package com.meuMedico.meumedico.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meuMedico.meumedico.dto.UsuarioDTO;
import com.meuMedico.meumedico.services.UsuarioService;

import jakarta.validation.Valid;


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
	
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> insert(@Valid @RequestBody UsuarioDTO dto) {
		dto = usuarioService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @Valid @RequestBody UsuarioDTO dto) {
		dto = usuarioService.update(id, dto);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}

	
}
