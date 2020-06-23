package com.example.puzzledojoibm;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.puzzledojoibm.model.Funcionario;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ProcessamentoDeSuspeitos {
	
	private static String arquivo ="PONTO_14-05-2020.csv";
	// leitura do log da IBM
	
	private static final Integer COLUNA_NOME_FUNCIONARIO = 0;
	private static final Integer COLUNA_HORA_ENTRADA = 1;
	private static final Integer COLUNA_SAIDA_HORA_ALMOCO = 2;
	private static final Integer COLUNA_RETORNO_ALMOCO = 3;
	private static final Integer COLUNA_HORA_SAIDA = 4;
	
	//Logica de leitura do arquivo txt
	
	public static void main(String[] args) throws IOException {
		
	
	
		Reader reader = Files.newBufferedReader(Paths.get("C:" + File.separator  +arquivo));
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
 
		List<String[]> batidas = csvReader.readAll();
		List<Funcionario> pontoFuncionarios = new ArrayList<Funcionario>(batidas.size());
		//1 organizar a saida
		for (String[] linha : batidas) {
			Funcionario func =	new Funcionario( linha[COLUNA_NOME_FUNCIONARIO] ,
					convertStringToDate( linha[COLUNA_HORA_ENTRADA] ),
					convertStringToDate( linha[COLUNA_SAIDA_HORA_ALMOCO] ),
					convertStringToDate( linha[COLUNA_RETORNO_ALMOCO] ),
					convertStringToDate( linha[COLUNA_HORA_SAIDA]) );
					pontoFuncionarios.add( func ); 
			System.out.println(func);
	    }
	}
	//2 boleano retornando funcionario presente horario
	//3 confere com o horario do ultimo log do servidor roubado
	//4 BONUS refactory da aplicação
	//5 BONUS JUnit da aplicação
	
	
	// Logica de leitura do arquivo
	// descobrir quem roubou 
	

	private static LocalTime convertStringToDate(String dataStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime dateTime = LocalTime.parse(dataStr, formatter);
		return dateTime;

	}
}
