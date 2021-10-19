package br.com.residencia.contas;

import br.com.residencia.IO.LeituraEscrita;

public class ContaCorrente extends Conta {

	private Integer totalSaques = 0, totalDepositos = 0, totalTransferencias = 0;
	private Double totalTributado1 = 0.1, totalTributado2 = 0.2, totalTributos = 0.0;
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(String tipoConta, String cpf, String agencia, String numero, Double saldo) {
		super(tipoConta, cpf, agencia, numero, saldo);
	
	}

	

	@Override
	public String toString() {
		return "Conta Corrente [Numero da Ag�ncia = " + this.getAgencia() + "N�mero da conta = " + 
		this.getNumero() + "Saldo em conta =" + this.getSaldo() + ", CPF = " + this.getCpf() + "]";
	}



	double saldo;
	@Override
	public boolean sacar(double valor) {
		if(getSaldo() < valor || valor < 0) {
			return false;
		}
		else {
			if((getSaldo() - valor - totalTributado1) >= 0) {
				saldo = getSaldo() - valor;
				setSaldo(saldo - totalTributado1);
				totalSaques++;
				totalTributos++;
				totalTributos = totalTributos * totalTributado1;
			}else {
				System.out.println("N�o foi poss�vel realizar a opera��o!");
			}
			totalTributado1 = totalTributado1 * totalSaques;
			return true;
		}
	}

	@Override
	public boolean depositar(double valor) {
		if(valor < 0) {
			return false;
		}else {
			if((getSaldo() + totalTributado1) >= 0) {
				saldo = getSaldo() + valor;
				setSaldo(saldo - 0.10);
				totalDepositos++;
				totalTributos++;
				totalTributos = totalTributos * totalTributado1;
			}else {
				System.out.println("N�o foi poss�vel realizar a opera��o!");
			}
			this.totalTributado1 = this.totalTributado1 * this.totalDepositos;
			return true;
		}
	}
	@Override
	public boolean transferir(double valor, Conta destinatario) {
		if(this.sacar(valor) == false) {
			return false;
		}
		else {
			destinatario.depositar(valor + 0.20);
			totalTransferencias++;
			totalTributos++;
			totalTributos = totalTributos * totalTributado2;
		}
		totalTributado2 = totalTributado2 * totalTransferencias;
		return true;
	}

	public Double getTotalTributado1() {
		return totalTributado1;
	}

	public Double getTotalTributado2() {
		return totalTributado2;
	}

	public Integer getTotalSaques() {
		return totalSaques;
	}

	public Integer getTotalDepositos() {
		return totalDepositos;
	}

	public Integer getTotalTransferencias() {
		return totalTransferencias;
	}

	public Double getTotalTributos() {
		return totalTributos;
	}
	

}