package com.projedata.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.projedata.model.Funcionario;

public class Projedata {

	public static void main(String[] args) {
		
		//lista de funcionários na ordem especificada pelo projeto
		Set<Funcionario> funcionarios = new LinkedHashSet<Funcionario>();
		// 3.1
		inicializaFuncionarios(funcionarios);
		// 3.2
		removeFuncionario(funcionarios, "João");
		// 3.3
		imprimeFuncionarios(funcionarios);
		// 3.4
		atualizaSalario(funcionarios, new BigDecimal(1.10));
		
		//map com lista de funcionarios por função
		Map<String, Set<Funcionario>> mapFuncionarios = new LinkedHashMap<String, Set<Funcionario>>();
		//3.5
		criarMapFuncionarios(mapFuncionarios, funcionarios);
		// 3.6
		imprimeMapFuncionarios(mapFuncionarios);
		
		//3.8
		imprimeFuncionarios(funcionarios, Month.OCTOBER);
		imprimeFuncionarios(funcionarios, Month.DECEMBER);
		//3.9
		imprimeFuncionarioMaiorIdade(funcionarios);
		// 3.10
		imprimeFuncionariosOrdemAlfabetica(funcionarios);
		// 3.11
		imprimeTotalSalariosFuncionarios(funcionarios);
		// 3.12
		imprimeSalariosMinimos(funcionarios, new BigDecimal(1212.00));
	}
	
	
	/**
	 * função para inicializar a lista de funcionários
	 * @param funcionarios - Lista de funcionarios que será inicializada
	 */
	private static void inicializaFuncionarios(Set<Funcionario> funcionarios) {
		try {		
			//inicialização da lista de funcionários conforme tabela oferecida
			Funcionario funcionario1 = new Funcionario("Maria", LocalDate.of(2000, Month.OCTOBER, 18), new BigDecimal(2009.44), "Operador");
			Funcionario funcionario2 = new Funcionario("João", LocalDate.of(1990, Month.MAY, 12), new BigDecimal(2284.38), "Operador");
			Funcionario funcionario3 = new Funcionario("Caio", LocalDate.of(1961, Month.MAY, 2), new BigDecimal(9836.14), "Coordenador");
			Funcionario funcionario4 = new Funcionario("Miguel", LocalDate.of(1988, Month.OCTOBER, 14), new BigDecimal(19119.88), "Diretor");
			Funcionario funcionario5 = new Funcionario("Alice", LocalDate.of(1995, Month.JANUARY, 5), new BigDecimal(2234.68), "Recepcionista");
			Funcionario funcionario6 = new Funcionario("Heitor", LocalDate.of(1999, Month.NOVEMBER, 19), new BigDecimal(1582.72), "Operador");
			Funcionario funcionario7 = new Funcionario("Arthur", LocalDate.of(1993, Month.MARCH, 31), new BigDecimal(4071.84), "Contador");
			Funcionario funcionario8 = new Funcionario("Laura", LocalDate.of(1994, Month.JULY, 8), new BigDecimal(3017.45), "Gerente");
			Funcionario funcionario9 = new Funcionario("Heloísa", LocalDate.of(2003, Month.MAY, 24), new BigDecimal(1606.85), "Eletricista");
			Funcionario funcionario10 = new Funcionario("Helena", LocalDate.of(1996, Month.SEPTEMBER, 2), new BigDecimal(2799.93), "Gerente");
			
			//adiciona funcionarios criados para a lista de funcionarios
			funcionarios.add(funcionario1);
			funcionarios.add(funcionario2);
			funcionarios.add(funcionario3);
			funcionarios.add(funcionario4);
			funcionarios.add(funcionario5);
			funcionarios.add(funcionario6);
			funcionarios.add(funcionario7);
			funcionarios.add(funcionario8);
			funcionarios.add(funcionario9);
			funcionarios.add(funcionario10);
		} catch(Exception e) {
			System.out.println("Ocorreu um erro inicializar lista de funcionários");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}
	
	/**
	 * Função para remover um funcionario de acordo com o nome
	 * @param funcionarios lista de funcionarios de onde se removerá o funcionário escolhido
	 * @param nomeRemovido nome do funcionário a ser removido
	 */
	private static void removeFuncionario(Set<Funcionario> funcionarios, String nomeRemovido) {
		try {
			for (Funcionario funcionario:funcionarios) {
				if(funcionario.getNome().equals(nomeRemovido)) {
					funcionarios.remove(funcionario);
					break;
				}
			}
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao remover funcionário por nome");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}
	
	/**
	 * função que imprime as informações de funcionários
	 * @param funcionarios lista de funcionários a ser impressa
	 */
	private static void imprimeFuncionarios(Set<Funcionario> funcionarios) {
		try {
			DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			DecimalFormat salarioFormatado = new DecimalFormat("#,##0.##");
			System.out.println("-----IMPRIMINDO LISTA DE FUNCIONÁRIOS-----\n\n");
			for (Funcionario funcionario: funcionarios) {
				System.out.println("Nome: \t\t\t\t"+funcionario.getNome());
				System.out.println("Data de nascimento: \t\t"+funcionario.getDataNascimento().format(dataFormatada));
				System.out.println("Salário: \t\t\t"+salarioFormatado.format(funcionario.getSalario()));
				System.out.println("Função: \t\t\t"+funcionario.getFuncao());
				System.out.println("------------------------------------------\n");
			}
			System.out.println("\n\n-----FIM DA LISTA DE FUNCIONÁRIOS-----\n\n");
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao imprimir funcionários");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}
	
	/**
	 * função para atualizar o salário dos funcionários
	 * @param funcionarios a lista com os funcionários cujo salários serão atualizados
	 * @param mudancaSalario a taxa de atualização do salário
	 */
	public static void atualizaSalario(Set<Funcionario> funcionarios, BigDecimal mudancaSalario) {
		try { 
			for (Funcionario funcionario: funcionarios) {
				BigDecimal novoSalario = funcionario.getSalario().multiply(mudancaSalario);
				funcionario.setSalario(novoSalario);
			}
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao atualizar salário de funcionários");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}
	
	/**
	 * função para criar uma map de funcionários, agrupados por função
	 * @param mapFuncionarios a map que será preenchida
	 * @param funcionarios a lista inicial de funcionários
	 */
	public static void criarMapFuncionarios(Map<String, Set<Funcionario>> mapFuncionarios, Set<Funcionario> funcionarios) {
		try {
			mapFuncionarios.putAll((Map)funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao)));
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao criar map de funcionários por função");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}
	
	/**
	 * função para imprimir a lista de funcionários agrupados por função
	 * @param mapFuncionarios map de funcionários agrupados por função
	 */
	public static void imprimeMapFuncionarios(Map<String, Set<Funcionario>> mapFuncionarios) {
		try {
			DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			DecimalFormat salarioFormatado = new DecimalFormat("#,##0.##");
			System.out.println("-----IMPRIMINDO LISTA DE FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO-----\n\n");
			for (String funcao: mapFuncionarios.keySet()) {
				System.out.println("\n\nFunção: "+funcao+"\n\n");
				ArrayList<Funcionario> funcionariosFuncao = (ArrayList) mapFuncionarios.get(funcao);
				for (Funcionario funcionario: funcionariosFuncao) {
					System.out.println("Nome: \t\t\t\t"+funcionario.getNome());
					System.out.println("Data de nascimento: \t\t"+funcionario.getDataNascimento().format(dataFormatada));
					System.out.println("Salário: \t\t\t"+salarioFormatado.format(funcionario.getSalario()));
					System.out.println("------------------------------------------\n");
				}
			}
			System.out.println("\n\n-----FIM DA LISTA DE FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO-----\n\n");
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao imprimir lista de funcionários por função");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}
	
	/**
	 * função para exibir os funcionários que fazem aniversário em determinado mês
	 * @param funcionarios lista de funcionários
	 * @param mes mês de aniversário que se deseja buscar
	 */
	public static void imprimeFuncionarios(Set<Funcionario> funcionarios, Month mes) {
		try {
			DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			DecimalFormat salarioFormatado = new DecimalFormat("#,##0.##");
			Locale local = new Locale("pt", "BR");
			System.out.println("-----IMPRIMINDO LISTA DE FUNCIONÁRIOS POR MÊS DE ANIVERSÁRIO-----\n\n");
			System.out.println("Mês: "+mes.getDisplayName(TextStyle.FULL, local)+"\n\n");
			for (Funcionario funcionario: funcionarios) {
				if (funcionario.getDataNascimento().getMonth().equals(mes)) {
					System.out.println("Nome: \t\t\t\t"+funcionario.getNome());
					System.out.println("Data de nascimento: \t\t"+funcionario.getDataNascimento().format(dataFormatada));
					System.out.println("Salário: \t\t\t"+salarioFormatado.format(funcionario.getSalario()));
					System.out.println("Função: \t\t\t"+funcionario.getFuncao());
					System.out.println("------------------------------------------\n");
				}
			}
			System.out.println("\n\n-----FIM DA LISTA DE FUNCIONÁRIOS POR MÊS DE ANIVERSÁRIO-----\n\n");
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao imprimir funcionários que fazem aniversário em determinado mês");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}
	
	/**
	 * função que imprime as informações do funcionário de maior idade
	 * @param funcionarios lista de funcionários
	 */
	public static void imprimeFuncionarioMaiorIdade(Set<Funcionario> funcionarios) {
		Funcionario funcionarioMaiorIdade = null;
		try {
			for (Funcionario funcionario: funcionarios) {
				if (funcionarioMaiorIdade == null || funcionarioMaiorIdade.getDataNascimento().isAfter(funcionario.getDataNascimento())) {
					funcionarioMaiorIdade = funcionario;
				}
			}
			LocalDate hoje = LocalDate.now();
			Period idade = Period.between(funcionarioMaiorIdade.getDataNascimento(), hoje);
			System.out.println("-----IMPRIMINDO OS DADOS DO FUNCIONÁRIO DE MAIOR IDADE-----\n\n");
			System.out.println("Nome: \t\t"+funcionarioMaiorIdade.getNome());
			System.out.println("Idade: \t\t"+idade.getYears()+" anos");
			System.out.println("\n\n-----FIM DA IMPRESSÃO DOS DADOS DO FUNCIONÁRIO DE MAIOR IDADE-----\n\n");
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao imprimir funcionário de maior idade");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}
	
	/**
	 * função que imprime a lista de funcionários em ordem alfabética
	 * @param funcionarios lista de funcionários
	 */
	public static void imprimeFuncionariosOrdemAlfabetica(Set<Funcionario> funcionarios) {
		try {
			Set<Funcionario> funcionariosOrdemAlfabetica = new TreeSet<Funcionario>();
			funcionariosOrdemAlfabetica.addAll(funcionarios);
			System.out.println("-----IMPRIMINDO OS FUNCIONÁRIOS EM ORDEM ALFABÉTICA-----\n\n");
			imprimeFuncionarios(funcionariosOrdemAlfabetica);
			System.out.println("\n\n-----FIM DA IMPRESSÃO DOS FUNCIONÁRIOS EM ORDEM ALFABÉTICA-----\n\n");
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao imprimir os funcionários em ordem alfabética");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}
	
	/**
	 * função que imprime o total somado dos salários de todos os funcionários
	 * @param funcionarios lista de funcionários
	 */
	public static void imprimeTotalSalariosFuncionarios(Set<Funcionario> funcionarios) {
		try {
			BigDecimal totalSalarios = new BigDecimal(0.00);
			DecimalFormat salarioFormatado = new DecimalFormat("#,##0.##");
			for (Funcionario funcionario: funcionarios) {
				totalSalarios = totalSalarios.add(funcionario.getSalario());
			}
			System.out.println("-----IMPRIMINDO O TOTAL SOMADO DOS SALÁRIOS DE TODOS OS FUNCIONÁRIOS-----\n\n");
			System.out.println("Salário Total: "+salarioFormatado.format(totalSalarios)+"\n\n");
			System.out.println("\n\n-----FIM DA IMPRESSÃO DO TOTAL DOS SALÁRIOS DOS FUNCIONÁRIOS-----\n\n");
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao calcular o total de salários de todos os funcionários");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}
	
	/**
	 * função que imprime quantas vezes um salário mínimo cada funcionário recebe
	 * @param funcionarios lista de funcionários
	 * @param salarioMinimo valor do salário mínimo
	 */
	public static void imprimeSalariosMinimos(Set<Funcionario> funcionarios, BigDecimal salarioMinimo) {
		try {
			DecimalFormat vezesFormatado = new DecimalFormat("0.00");
			System.out.println("-----IMPRIMINDO QUANTAS VEZES UM SALÁRIO MÍNIMO CADA FUNCIONÁRIO GANHA-----\n\n");
			for (Funcionario funcionario: funcionarios) {
				System.out.println("Nome: \t\t\t\t\t\t"+funcionario.getNome());
				System.out.println("Quantas vezes um salário mínimo?: \t\t"+vezesFormatado.format(funcionario.getSalario().divide(salarioMinimo, RoundingMode.HALF_UP)));
				System.out.println("------------------------------------------\n");
			}
			System.out.println("\n\n-----FIM DA LISTA DE FUNCIONÁRIOS VEZES SALÁRIO MÍNIMO-----\n\n");
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao calcular quantas vezes um salário mínimo o funcionário ganha");
			System.out.println("Mensagem de erro: "+e.getMessage());
		}
	}

}
