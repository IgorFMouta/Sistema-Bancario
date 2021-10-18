package br.com.residencia.pessoas;

public class Gerente extends Funcionario {


	protected int numFuncionarios;

	protected String senha;
	protected Integer numFuncionarios1;

	public Gerente(String cargo, String nome, String sobrenome, String cpf, String senha, Integer agencia, Integer numeroConta, Double saldo, Double salario, Integer numFuncionarios) {
		super(cargo,nome,sobrenome,cpf,senha,agencia,numeroConta,saldo,salario);

		this.numFuncionarios = numFuncionarios;
	}

	public Gerente() {

	}

	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	public String getSenha() {
		return senha;
	}


	public boolean autenticar(String senha) {
		if (this.senha == senha) {
//			System.out.prIntegerln("Acesso Permitido!");
			return true;
		} else {
//			System.out.prIntegerln("Acesso Negado!");
			return false;
		}
	}

}