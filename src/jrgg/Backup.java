package jrgg;

import java.io.PrintWriter;

public class Backup {
	protected String nome;
	protected String diretorio;
	protected String formato;
	protected int qndSalva;

	public Backup(String nome, String diretorio, String formato, int qndSalva) {
		super();
		this.nome = nome;
		this.diretorio = diretorio;
		this.formato = formato;
		this.qndSalva = qndSalva;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public int getQndSalva() {
		return qndSalva;
	}

	public void setQndSalva(int qndSalva) {
		this.qndSalva = qndSalva;
	}

	public void escreverFicheiro(PrintWriter pw) {
		pw.write(nome + ";" + diretorio + ";" + formato + ";" + qndSalva + "\n");
	}
}
