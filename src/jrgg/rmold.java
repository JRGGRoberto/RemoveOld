package jrgg;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class rmold extends ControlFile {
	
	/**
	 *Recebe o caminho\nomearquivo 
	 *e executa o comando do SO para exclusão
	 * @param caminhoArq
	 */
	public static void apagar(String caminhoArq) {
		String so = System.getProperty("os.name").substring(0, 3).toLowerCase();
		String comando;
		if (so.equals("mac") || so.equals("lin")) {
			comando = "rm " + caminhoArq;
		} else if (so.equals("win")){
			comando = "cmd /C del /Q " + caminhoArq;
		} else {
			System.out.println("Sistema não reconhecido");
			return;
		}
		Runtime r = Runtime.getRuntime();
			try {
			r.exec(comando);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void lista(Backup bk){
		Filesbk bkgroup = new Filesbk(bk.getNome(), bk.getQndSalva());
		
		File folder = new File(bk.getDiretorio());
		File[] listOfFiles = folder.listFiles();
		
		
		/**
		 * Ordena de acordo com a ultima modificação
		 */
		Arrays.sort(listOfFiles, new Comparator<File>(){
		    public int compare(File f1, File f2){
		        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
		    } 
		});
		
		/**
		 * Verifica o inicio do formato
		 * se começar com * compara de uma forma
		 * se não compara apenas o inicio informado no formato
		 */
		int len =0;
		boolean inicioVariavel = false;
		if(bk.formato.substring(0, 1).equals("*")){
			inicioVariavel = true;
			for(len=0; len < bk.formato.length(); len++){
				if(!bk.formato.substring(len, len+1).equals("*")){
					break;
				}
			}
		}
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if(listOfFiles[i].getName().length() > bk.getFormato().length()){
					if(listOfFiles[i].getName().substring(len, bk.getFormato().length()).equals(bk.getFormato()) ){
							bkgroup.addfilename(bk.getDiretorio() + listOfFiles[i].getName());
					}
				}
			}
		}
		
		int del = 0;
		if(!bkgroup.filenome.isEmpty()){
			System.out.println("Backup: " + bkgroup.getNome());
			System.out.println("Manter os " + bkgroup.getQnt() +" ultimos");
			
			if(bkgroup.getQnt()< bkgroup.filenome.size()){
				del = bkgroup.filenome.size() - bkgroup.getQnt();
			}
			
			for(int x = 0; x < bkgroup.filenome.size(); x ++){
				if(del > 0){
					bkgroup.filenome.get(x).apaga();
					del--;
				}
				System.out.print("[" + (x + 1) +"] |"+  bkgroup.filenome.get(x).getFilenam() + "|");
				if(bkgroup.filenome.get(x).isDeleta()){
					String arqdel = bkgroup.filenome.get(x).getFilenam().trim();
					apagar(arqdel);
					System.out.print(" [removido]");
				}
				System.out.println();

			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		iniciar();
		if(!backups.isEmpty()){
			for(Backup b: backups){
				lista(b);
			}
		}else {
			System.out.println("Configure o sistema.");
			System.out.println("Formato do arquivo:");
			System.out.println("nome;dir/subdir;formato;N");
		}
		
	}
}