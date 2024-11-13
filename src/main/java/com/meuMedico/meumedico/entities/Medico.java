package com.meuMedico.meumedico.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String crm;
	private String nome;

	@Column(columnDefinition = "TEXT")
	private String endereco;
	private String especialidade;
	private String telefone;
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", updatable = false)
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", updatable = false)
	private Date updatedAt;

	public Medico() {

	}

	public Medico(String crm, String nome, String endereco, String especialidade, String telefone, String email,
			Date createdAt, Date updatedAt) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.endereco = endereco;
		this.especialidade = especialidade;
		this.telefone = telefone;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(id, other.id);
	}

}
