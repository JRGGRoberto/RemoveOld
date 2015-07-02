package jrgg;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class rmold {
	public static void main(String[] args) {
		File folder = new File("/");
		File[] listOfFiles = folder.listFiles();
		
		Arrays.sort(listOfFiles, new Comparator<File>(){
		    public int compare(File f1, File f2){
		        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
		    } 
		});
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if(listOfFiles[i].getName().length() > 11){
					if(listOfFiles[i].getName().substring(0, 12).equals("install.res.") ){
						System.out.println("File: " + i +" - " + listOfFiles[i].getName());
					}
				}
				
				
			//	System.out.println("File: [" +n+ "] "+ listOfFiles[i].getName());
			} /*else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}*/
		}

	}
}