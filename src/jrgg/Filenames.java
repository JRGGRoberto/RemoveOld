package jrgg;

public class Filenames {
	private String filenam;
	private boolean deleta;
	
	public Filenames(String filenam) {
		super();
		this.filenam = filenam;
		this.deleta = false;
	}

	public String getFilenam() {
		return filenam;
	}

	public void setFilenam(String filenam) {
		this.filenam = filenam;
	}

	public boolean isDeleta() {
		return deleta;
	}

	public void apaga() {
		this.deleta = true;
	}
	
	

}
