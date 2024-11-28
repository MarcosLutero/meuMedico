package com.meuMedico.meumedico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.meuMedico.meumedico.dto.UsuarioDTO;
import com.meuMedico.meumedico.entities.Usuario;
import com.meuMedico.meumedico.repositories.UsuarioRepository;
import com.meuMedico.meumedico.services.exceptions.DatabaseException;
import com.meuMedico.meumedico.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


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
	
	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		copyDtoToEntity(dto, entity);
		return new UsuarioDTO(entity);
	}

	@Transactional
	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		try {
			Usuario entity = usuarioRepository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			return new UsuarioDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recuso não encontrado");
		}

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!usuarioRepository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		try {
			usuarioRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}
	}

	private void copyDtoToEntity(UsuarioDTO dto, Usuario entity) {
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setMatricula(dto.getMatricula());
		entity.setTipo(dto.getTipo());
		entity.setSenha(dto.getSenha());
		entity = usuarioRepository.save(entity);

	}


}
