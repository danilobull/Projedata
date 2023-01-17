package com.projedata.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa implements Comparable<Funcionario>{

	private BigDecimal salario;
	
	private String funcao;
	
	public Funcionario(String nomeFuncionario, LocalDate dataNascimentoFuncionario, BigDecimal salarioFuncionario, String funcaoFuncionario){
		super(nomeFuncionario, dataNascimentoFuncionario);
		this.salario = salarioFuncionario;
		this.funcao = funcaoFuncionario;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	/**
	 * realiza a comparação de nomes, para poder gerar a lista em ordem alfabética
	 */
	@Override
	public int compareTo(Funcionario o) {
		return this.getNome().compareTo(o.getNome());
	}
	
}
