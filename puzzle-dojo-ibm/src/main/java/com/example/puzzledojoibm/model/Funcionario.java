package com.example.puzzledojoibm.model;

import java.time.LocalTime;

public class Funcionario {
	
	private String nome;
	private LocalTime dataEntrada;
	private LocalTime dataSaida;
	private LocalTime dataSaidaAlmoco;
	private LocalTime dataEntradaAlmoco;
	
	
	public Funcionario(String nome, LocalTime dataEntrada, LocalTime dataSaida, LocalTime dataSaidaAlmoco,
			LocalTime dataEntradaAlmco) {
		super();
		this.nome = nome;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.dataSaidaAlmoco = dataSaidaAlmoco;
		this.dataEntradaAlmoco = dataEntradaAlmco;
	}
	
	// boleano retornando funcionario presente horario
	
	public Funcionario() {
		super();
	}

	public LocalTime getDataSaidaAlmoco() {
		return dataSaidaAlmoco;
	}
	public void setDataSaidaAlmoco(LocalTime dataSaidaAlmoco) {
		this.dataSaidaAlmoco = dataSaidaAlmoco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalTime getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalTime getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalTime dataSaida) {
		this.dataSaida = dataSaida;
	}
	public LocalTime getDataEntradaAlmco() {
		return dataEntradaAlmoco;
	}
	public void setDataEntradaAlmco(LocalTime dataEntradaAlmco) {
		this.dataEntradaAlmoco = dataEntradaAlmco;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida
				+ ", dataSaidaAlmoco=" + dataSaidaAlmoco + ", dataEntradaAlmco=" + dataEntradaAlmoco + "]";
	}
	
}
