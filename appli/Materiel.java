package appli;

public class Materiel {
    private String NumeroDeSerie;
    private String DateDeVente;
    private Date Dateinstallation;
    private String Emplacement;
    private TypeMateriel leType;
    
    public Materiel(String numeroDeSerie, String dateDeVente, String emplacement, TypeMateriel leType) {
		super();
		NumeroDeSerie = numeroDeSerie;
		DateDeVente = dateDeVente;
		Emplacement = emplacement;
		this.leType = leType;
	}

	public String getNumeroDeSerie() {
        return NumeroDeSerie;
    }

    public void setNumeroDeSerie(String NumeroDeSerie) {
        this.NumeroDeSerie = NumeroDeSerie;
    }

    public TypeMateriel getLeType() {
		return leType;
	}

	public void setLeType(TypeMateriel leType) {
		this.leType = leType;
	}

	public String getDateDeVente() {
        return DateDeVente;
    }

    public void setDateDeVente(String DateDeVente) {
        this.DateDeVente = DateDeVente;
    }

    public Date getDateinstallation() {
        return Dateinstallation;
    }

    public void setDateinstallation(Date Dateinstallation) {
        this.Dateinstallation = Dateinstallation;
    }

    public String getEmplacement() {
        return Emplacement;
    }

    public void setEmplacement(String Emplacement) {
        this.Emplacement = Emplacement;
    }
}

