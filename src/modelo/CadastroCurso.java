package modelo;

public class CadastroCurso {
	
	private String nomeCurso;
	private String observCurso;
	
	public CadastroCurso() {}
	
	public CadastroCurso(String nomeCurso, String observCurso) {
		super();
		this.nomeCurso = nomeCurso;
		this.observCurso = observCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getObservCurso() {
		return observCurso;
	}

	public void setObservCurso(String observCurso) {
		this.observCurso = observCurso;
	}
	
	
	
	

}
