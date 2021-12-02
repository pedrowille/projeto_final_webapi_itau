package br.com.contaBancaria.models;

import javax.persistence.*;

@Entity
@Table(name= "conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
    @Column(name="numero")
    private int numero;
    @Column
    private int agencia;
    @Column
    private int tipo;
    @Column
    private double saldo;
	
    //@ManyToOne
   ///@JoinColumn(name = "cliente_id", nullable = false) /// uma conta pode te um cliente
   // private Cliente cliente;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	//public Cliente getCliente() {
		//return cliente;
	//}

	///public void setCliente(Cliente cliente) {
		//this.cliente = cliente;
	//}
    
		

}
