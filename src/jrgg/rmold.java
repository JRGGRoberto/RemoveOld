package jrgg;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class rmold extends ControlFile {
	
	
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

		
		Arrays.sort(listOfFiles, new Comparator<File>(){
		    public int compare(File f1, File f2){
		        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
		    } 
		});
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if(listOfFiles[i].getName().length() > bk.getFormato().length()){
					if(listOfFiles[i].getName().substring(0, bk.getFormato().length()).equals(bk.getFormato()) ){
						bkgroup.addfilename(bk.getDiretorio() + listOfFiles[i].getName());
					}
				}
			}
		}
		
		int j;
		int del = 0;
		if(!bkgroup.filenome.isEmpty()){
			j = 0;
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
					File file = new File(bkgroup.filenome.get(x).getFilenam());  
					
					if(file.delete()){
						System.out.print(" - Removido");	
					} else {
						System.out.print(" - Error");
						file.deleteOnExit();
					}
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
		}
		
	}
}