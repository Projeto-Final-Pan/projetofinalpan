package api.spring.bluebank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private int agencia;
	
	@NotNull
	private String conta;
	
	private double saldo;
	
	//private Cliente titular;
	
	private static int total; //esse atributo serve para sabermos quantas contas foram abertas
	
	//enum tipo de conta


	public int getAgencia() {
		return agencia;
	}


	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	public String getConta() {
		return conta;
	}


	public void setConta(String conta) {
		this.conta = conta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", conta=" + conta + ", saldo=" + saldo + "]";
	}
	
	
}
