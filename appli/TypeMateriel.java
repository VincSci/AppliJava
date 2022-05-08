package appli;

public class TypeMateriel {
	private String referenceInterne;
	private String libelleTypeMateriel;
	
	public TypeMateriel(String referenceInterne, String libelleTypeMateriel) {
		super();
		this.referenceInterne = referenceInterne;
		this.libelleTypeMateriel = libelleTypeMateriel;
	}

	public String getReferenceInterne() {
		return referenceInterne;
	}

	public String getLibelleTypeMateriel() {
		return libelleTypeMateriel;
	}

	public void setReferenceInterne(String referenceInterne) {
		this.referenceInterne = referenceInterne;
	}

	public void setLibelleTypeMateriel(String libelleTypeMateriel) {
		this.libelleTypeMateriel = libelleTypeMateriel;
	}
	
}
