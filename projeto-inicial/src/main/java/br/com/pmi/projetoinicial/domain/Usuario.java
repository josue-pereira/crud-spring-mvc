package br.com.pmi.projetoinicial.domain;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Usuario {
	
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String nome;
	
	@NotBlank
	@Size(min = 3, max = 50, message = "Campo requerido entre {min} e {max} caracteres.")
	private String sobrenome;
	
	@NotNull(message = "O campo 'data de nascimento' é requerido.")
	@DateTimeFormat(iso = ISO.DATE)
	private String data_nascimento;
	
	
	public Usuario() {
		super();
		
	}
	
	public Usuario(Long id, String nome, String sobrenome, String data_nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.data_nascimento = data_nascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String date) {
		this.data_nascimento = date;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}
	
	
	

}
