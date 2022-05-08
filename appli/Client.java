package appli;

import java.util.ArrayList;

import connex.RequeteClient;

public class Client {
    private String numClient; 
    private String Nom; 
    private String raisonSociale;
    private String siren;
    private String codeApe; 
    private String adresse;
    private String telClient;
    private String email;
    private int dureeDeplacement;
    private int distanceKm;
    private int numAgence;
    private ArrayList<Materiel> lesMateriels = new ArrayList<Materiel>();
    private ContratMaintenance leContrat;

    public Client(String numClient) {
        this.numClient = numClient;
    }
    
    public ArrayList<Materiel> getLesMateriels() {
		return lesMateriels;
    }
    // Retourne l'ensemble des matériels du client
    
    public ArrayList<Materiel> getMaterielsSousContrat(){
        ArrayList<Materiel> lesMateriels = new ArrayList<Materiel>();
            String requete = "SELECT materiel.NumeroDeSerie, materiel.ReferenceInterne, typemateriel.LibelleTypeMateriel, materiel.DateDeVente, materiel.Emplacement FROM materiel, typemateriel ";
            RequeteClient ReqMat = new RequeteClient(requete, numClient);
            ReqMat.RequeteMateriel(lesMateriels);
        return lesMateriels;
    }
    // Retourne l'ensemble des matériels pour lesquels le client a souscrit un contrat de maintenance qui
    // est encore valide (la date du jour est entre la date de signature et la date d’échéance)
    
    public boolean estAssure(){
        boolean Assure = false;
            String requete = "SELECT DATEDIFF(DateEcheance, CURRENT_DATE) FROM contratdemaintenance";
            RequeteClient ReqAssure = new RequeteClient(requete, this.numClient);
            String Test = ReqAssure.RequeteContrat();
            if (Test.charAt(0) != '-'){
                Assure = true;
            }
        return Assure;
    } 
    // Retourne vrai si le client est assuré, faux sinon

	public String getNumClient() {
		return numClient;
	}
	
	public String getNom() {
		return Nom;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public String getSiren() {
		return siren;
	}

	public String getCodeApe() {
		return codeApe;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getTelClient() {
		return telClient;
	}

	public String getEmail() {
		return email;
	}

	public int getDureeDeplacement() {
		return dureeDeplacement;
	}

	public int getDistanceKm() {
		return distanceKm;
	}
	
	public int getNumAgence() {
		return numAgence;
	}

	public ContratMaintenance getLeContrat() {
		return leContrat;
	}

	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}
	
	public void setNom(String Nom) {
		this.Nom = Nom;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public void setSiren(String siren) {
		this.siren = siren;
	}

	public void setCodeApe(String codeApe) {
		this.codeApe = codeApe;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDureeDeplacement(int dureeDeplacement) {
		this.dureeDeplacement = dureeDeplacement;
	}

	public void setDistanceKm(int distanceKm) {
		this.distanceKm = distanceKm;
	}
	
	public void setNumAgence(int numAgence) {
		this.numAgence = numAgence;
	}

	public void setLesMateriels(ArrayList<Materiel> lesMateriels) {
		this.lesMateriels = lesMateriels;
	}

	public void setLeContrat(ContratMaintenance leContrat) {
		this.leContrat = leContrat;
	}

        public Client(String numClient, String Nom, String raisonSociale, String siren, String codeApe, String adresse, String telClient, String email, int dureeDeplacement, int distanceKm, int numAgence) {
            this.Nom = Nom;
            this.raisonSociale = raisonSociale;
            this.siren = siren;
            this.codeApe = codeApe;
            this.adresse = adresse;
            this.telClient = telClient;
            this.email = email;
            this.dureeDeplacement = dureeDeplacement;
            this.distanceKm = distanceKm;
            this.numAgence = numAgence;
        }    
    
}
