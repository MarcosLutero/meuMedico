package com.meuMedico.meumedico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.meuMedico.meumedico.dto.UsuarioDTO;
import com.meuMedico.meumedico.entities.Usuario;
import com.meuMedico.meumedico.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<UsuarioDTO> findAll() {
		List<Usuario> result = usuarioRepository.findAll();
		return result.stream().map(UsuarioDTO::new).toList();
	}
	
	

	public UsuarioDTO findById(@PathVariable Long listId) {
		Usuario result = usuarioRepository.findById(listId).get();
		return new UsuarioDTO(result);
	}

}
