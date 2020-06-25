package com.example.puzzledojoibm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.puzzledojoibm.model.Funcionario;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ProcessamentoDeSuspeitos {
	
	private static String arquivo ="PONTO_14-05-2020.csv";
	private static String logIbm ="IBM123456_Server_log.txt";
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
					convertStringToTime( linha[COLUNA_HORA_ENTRADA] ),
					convertStringToTime( linha[COLUNA_SAIDA_HORA_ALMOCO] ),
					convertStringToTime( linha[COLUNA_RETORNO_ALMOCO] ),
					convertStringToTime( linha[COLUNA_HORA_SAIDA]) );
					pontoFuncionarios.add( func ); 
			System.out.println(func);
	    }
		
		
		// Leitura de log
	    LocalTime ultHorario = null;
		BufferedReader buffRead = new BufferedReader(new FileReader("C:" + File.separator  +logIbm));
        String linha = "";
        while (true) {
            if (linha != null) {
            	if (linha.length() > 20)
            	{
            		ultHorario = convertStringToTime(linha.substring(11, 16));
            	}
            	//System.out.println(linha);
 
            } else
                break;
            linha = buffRead.readLine();
        }
        System.out.println(ultHorario);
        buffRead.close();

        List<Funcionario> presentes = presentes(pontoFuncionarios, ultHorario);
        presentes.forEach(System.out::println);
        
	}

	private static List<Funcionario> presentes(List<Funcionario> todos, LocalTime ultimoLog){
		return todos.stream()
				.filter(f -> f.getDataEntrada().isBefore(ultimoLog) && ultimoLog.isBefore(f.getDataSaida()))
				.collect(Collectors.toList());
		
	}
	//2 boleano retornando funcionario presente horario
	//3 confere com o horario do ultimo log do servidor roubado
	//4 BONUS refactory da aplicação
	//5 BONUS JUnit da aplicação
	
	
	// Logica de leitura do arquivo
	// descobrir quem roubou 
	

	private static LocalTime convertStringToTime(String dataStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime dateTime = LocalTime.parse(dataStr, formatter);
		return dateTime;

	}
}
