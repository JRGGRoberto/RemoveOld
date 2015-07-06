package jrgg;

public class clearold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//System.out.println("Clear Old - remove arquivos obsoletos");
		for (String s: args) {
            System.out.println(s);
		}
		
		String teste =  "x***1234";
		System.out.println(teste);
		int x;
		for(x=0; x < teste.length(); x++){
			if(!teste.substring(x, x+1).equals("*")){
				//System.out.println(teste.substring(x, x+1));
				break;
			}
		}
		System.out.println("Inicio: "+ x);
		System.out.println(teste.substring(x, teste.length()));
		System.out.println(teste.substring(0, 1));
		
		//(listOfFiles[i].getName().length() > bk.getFormato().length()){
		//if(listOfFiles[i].getName().substring(0, bk.getFormato().length()).equals(bk.getFormato(
		
		
		
	}
}
