package jrgg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ControlFile {
	private static final String FICHEIROCONTROLFILE = "dados/config.csv";
	protected static ArrayList<Backup> backups;
	
	public static void iniciar(){
		backups = new ArrayList<Backup>();
		carregarDados();
	}
	
	
	private static void carregarDados(){
		File arq = new File(FICHEIROCONTROLFILE);
		if(!arq.exists()){
			System.out.println("Nao foi possivel carregar ficheiro.");
			return;
		}
		try{
			importarControlFile(arq);
		} catch(Exception e){
			System.out.println("Erro na importacao dos ficheiros");
		}
	}
	
	
	private static void importarControlFile(File arq) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(arq));
		String texto = br.readLine();
		
		while (texto != null){
			String[] dadosficheiro = texto.split(";");
			String nome = dadosficheiro[0];
			String dir  = dadosficheiro[1];
			String form = dadosficheiro[2];
			int qnt = Integer.parseInt(dadosficheiro[3]);
			criarBackup(nome, dir, form, qnt);
			texto = br.readLine();
		}
		br.close();
	}
	
	
	public static void criarBackup(String nome, String diretorio, String formato, int qndSalva){
		backups.add(new Backup(nome, diretorio, formato, qndSalva));
	}
	
	
	public static void listar(){
		byte x = 0;
		if(!backups.isEmpty()){
			for(Backup b: backups){
				System.out.println("["+ x++ +"] nome: "+ b.nome + "  |diretorio: " + b.diretorio + "  |formato: " + b.formato + "  |qnt_salva: " + b.qndSalva);
			}
		} else {
			System.out.println("Sem registos");
		}
	}
	
	protected static void guardarDados(){
		try{
			PrintWriter pw = new PrintWriter(FICHEIROCONTROLFILE);
			
			for(Backup b: backups){
				b.escreverFicheiro(pw);
			}
			pw.flush();
			pw.close();
		} catch(FileNotFoundException e){
			System.out.println("A pasta para gravacao inexistente");
		}
	}
}
