package jrgg;
import java.util.Scanner;

public class Config {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int op; 
		ControlFile.iniciar();
		do{
			
			System.out.println("- Menu Principal - ");
			System.out.println();
			System.out.println("1 -> Criar ControlFile");
			System.out.println("2 -> Apagar ControlFile");
			System.out.println("3 -> Alterar ControlFile");
			System.out.println("4 -> Listar ControlFile");
			System.out.println("5 -> Sair");
			System.out.print("[:");
			
			op = key.nextInt();
			
			switch(op){
				case 1: 
						System.out.println("- Criar ControlFile");
						System.out.println();
						System.out.print("Nome: ");
						String nome = key.next();
						System.out.print("Diretorio: ");
						String diretorio = key.next();
						System.out.print("Formato: ");
						String formato = key.next();
						System.out.print("Qnt a ser guardada: ");
						int qndSalva = key.nextInt();
						ControlFile.criarBackup(nome, diretorio, formato, qndSalva);
						System.out.println();
						break;
				
				case 2: 
						System.out.println("- Apagar ControlFile");
						ControlFile.listar();
						System.out.println("Informe o n. a apagar: ");
						byte i = key.nextByte();
						if(i>=0 && i< ControlFile.backups.size()){
							ControlFile.deleteBackup(i);
						} else {
							System.out.println("Fora do range");
						}
						System.out.println();
						break;
						
				case 3:
						System.out.println("- Alterar ControlFile");
						ControlFile.listar();
						if(!ControlFile.backups.isEmpty()){
							System.out.print("Informe o n. a alterar: ");
							i = key.nextByte();
							if((i>=0) && (i< ControlFile.backups.size() )){
								System.out.print("1-nome, 2-direc, 3-format, 4-qnt: ");
								String newval ;
								byte j = key.nextByte();
								key.nextLine();
								
								if((j>0) && (j<5)){
									System.out.print("novo valor: ");
									newval = key.nextLine();
									switch (j){
									case 1:  ControlFile.backups.get(i).setNome(newval);
										break; 
									case 2:  ControlFile.backups.get(i).setDiretorio(newval);
										break;
									case 3:  ControlFile.backups.get(i).setFormato(newval);
										break;
									case 4: byte a = Byte.parseByte(newval);
											ControlFile.backups.get(i).setQndSalva(a);
										break;	
									}
								} else{
									System.out.println("Opcao invalida");
								}
							} else {
								System.out.println("Fora do range");
							}
							System.out.println();
						}
					break;
					
				case 4: 
						System.out.println("- Listar ControlFile");
						ControlFile.listar();
						System.out.println();
					break;
					
				default: System.out.println("a\n");
					break;
			}
		}while(op != 5 );
		System.out.println("Fim.");
		ControlFile.guardarDados();
		key.close();
	}
}

		/**
		 * 
/backup/aes
backup_AES01CDom0_aaaa_mm_dd_hh_MM_ss.tgz
backup_AES02CDom0_aaaa_mm_dd_hh_MM_ss.tgz

/backup/cm
backup_AACMACDom0_aaaa_mm_dd_hh_MM_ss.tgz
backup_AACMACDom0_aaaa_mm_dd_hh_MM_ss.tgz
backup_AACMESSCDom0_aaaa_mm_dd_hh_MM_ss.tgz
full_AACMA_040001_aaaammdd.tar.gz
full_AACMB_040001_aaaammdd.tar.gz
full_AACMESS_105209_aaaammdd.tar.gz

/backup/cms
CMS-aammdd-01-LSAC-00-F-01-05-CMS010000000000
CMS-aammdd-01-LSAC-00-F-01-05-CMS020000000000

/sbce
07-02-2015_13-18-57_6.3.2-08-5478.zip  repo.xml
07-02-2015_15-53-34_6.3.2-08-5478.zip


/smgr
backup_SMGR01CDom0_2015_07_02_12_31_03.tgz
backup_SMGR02CDom0_2015_07_02_12_41_47.tgz
smgr01_2015_Jul_02_03_33_26_653.zip

		 */

