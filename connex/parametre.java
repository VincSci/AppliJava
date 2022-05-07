package connex;

public class parametre {
	private String nomUtilisateur;
    private String motDePasse;
    private String serveurBD;
    private String driverSGBD;

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getServeurBD() {
        return serveurBD;
    }

    public String getDriverSGBD() {
        return driverSGBD;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setServeurBD(String serveurBD) {
        this.serveurBD = serveurBD;
    }

    public void setDriverSGBD(String driverSGBD) {
        this.driverSGBD = driverSGBD;
    }

    public parametre() {
        this.nomUtilisateur = "root";
        this.motDePasse = "";
        this.serveurBD = "MySQL";
        this.driverSGBD = "org.gjt.mm.mysql.Driver";
    }
}
