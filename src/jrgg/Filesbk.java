package jrgg;

import java.util.ArrayList;

public class Filesbk {
	private String nome;
	private int qnt;
	protected ArrayList<Filenames> filenome = new ArrayList<Filenames>();
	
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void addfilename(String nomef){
		filenome.add(new Filenames(nomef));
	}
	
	public Filesbk(String nome, int qnt) {
		super();
		this.nome = nome;
		this.qnt = qnt;
	}
	
	

}
