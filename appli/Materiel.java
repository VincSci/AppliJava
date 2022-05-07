package appli;

public class Materiel {
    private String NumeroDeSerie;
    private String ReferenceInterne;
    private String LibelleTypeMateriel;
    private String DateDeVente;
    private String Dateinstallation;
    private Date dateInstalle;
    private String Emplacement;

    public Materiel(String NumeroDeSerie, String ReferenceInterne, String LibelleTypeMateriel, String DateDeVente, String Dateinstallation, String Emplacement) {
        this.NumeroDeSerie = NumeroDeSerie;
        this.ReferenceInterne = ReferenceInterne;
        this.LibelleTypeMateriel = LibelleTypeMateriel;
        this.DateDeVente = DateDeVente;
        this.Dateinstallation = Dateinstallation;
        this.Emplacement = Emplacement;
    }

    public String getNumeroDeSerie() {
        return NumeroDeSerie;
    }

    public void setNumeroDeSerie(String NumeroDeSerie) {
        this.NumeroDeSerie = NumeroDeSerie;
    }

    public String getReferenceInterne() {
        return ReferenceInterne;
    }

    public void setReferenceInterne(String ReferenceInterne) {
        this.ReferenceInterne = ReferenceInterne;
    }

    public String getLibelleTypeMateriel() {
        return LibelleTypeMateriel;
    }

    public void setLibelleTypeMateriel(String LibelleTypeMateriel) {
        this.LibelleTypeMateriel = LibelleTypeMateriel;
    }

    public String getDateDeVente() {
        return DateDeVente;
    }

    public void setDateDeVente(String DateDeVente) {
        this.DateDeVente = DateDeVente;
    }

    public String getDateinstallation() {
        return Dateinstallation;
    }

    public void setDateinstallation(String Dateinstallation) {
        this.Dateinstallation = Dateinstallation;
    }

    public String getEmplacement() {
        return Emplacement;
    }

    public void setEmplacement(String Emplacement) {
        this.Emplacement = Emplacement;
    }

    public Date getDateInstalle() {
        return dateInstalle;
    }
    
}

