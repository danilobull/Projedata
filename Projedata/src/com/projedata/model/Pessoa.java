package com.projedata.model;

import java.time.LocalDate;

public abstract class Pessoa {
	
	private String nome; 
	
	private LocalDate dataNascimento;
	
	protected Pessoa(String nomePessoa, LocalDate dataNascimentoPessoa){
		this.nome = nomePessoa;
		this.dataNascimento = dataNascimentoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
