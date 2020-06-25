package com.example.puzzledojoibm.model;

import java.time.LocalTime;

public class Funcionario {
	
	private String nome;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	private LocalTime horaSaidaAlmoco;
	private LocalTime horaEntradaAlmoco;
	
	
	public Funcionario(
			String nome,
			LocalTime horaEntrada,
			LocalTime horaSaidaAlmoco,
			LocalTime horaEntradaAlmco,
			LocalTime horaSaida) {
		super();
		this.nome = nome;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.horaSaidaAlmoco = horaSaidaAlmoco;
		this.horaEntradaAlmoco = horaEntradaAlmco;
	}
	
	// boleano retornando funcionario presente horario
	
	public Funcionario() {
		super();
	}

	public LocalTime getDataSaidaAlmoco() {
		return horaSaidaAlmoco;
	}
	public void setDataSaidaAlmoco(LocalTime dataSaidaAlmoco) {
		this.horaSaidaAlmoco = dataSaidaAlmoco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalTime getDataEntrada() {
		return horaEntrada;
	}
	public void setDataEntrada(LocalTime dataEntrada) {
		this.horaEntrada = dataEntrada;
	}
	public LocalTime getDataSaida() {
		return horaSaida;
	}
	public void setDataSaida(LocalTime dataSaida) {
		this.horaSaida = dataSaida;
	}
	public LocalTime getDataEntradaAlmco() {
		return horaEntradaAlmoco;
	}
	public void setDataEntradaAlmco(LocalTime dataEntradaAlmco) {
		this.horaEntradaAlmoco = dataEntradaAlmco;
	}

	@Override
	public String toString() {
		return "Funcionario ["
				+ "nome=" + nome + ", "
				+ "horaEntrada=" + horaEntrada + ", "
				+ "horaSaidaAlmoco=" + horaSaidaAlmoco + ", "
				+ "horaEntradaAlmoco=" + horaEntradaAlmoco + ", "
				+ "horaSaida=" + horaSaida + ", "
				+ "]";
	}

	 
	
}
