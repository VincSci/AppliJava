package appli;

import java.util.ArrayList;

import connex.RequeteContrat;

public class ContratMaintenance {
    
    private String numContrat;
    private Date dateSignature;
    private Date dateEcheance;
    private String numClient;
    private String refTypeContrat;
    private ArrayList<Materiel> lesMaterielsAssures = new ArrayList<Materiel>();
    
    public int getJoursRestants (String NumClient){
        int nbJour = 0;
            String requete = "SELECT DATEDIFF(DateEcheance, CURRENT_DATE) FROM contratdemaintenance";
            
            RequeteContrat reqContrat = new RequeteContrat(requete);
            
            nbJour = reqContrat.RequeteJour(NumClient);
        return nbJour;
    }
    // Renvoie le nombre de jours avant que le contrat arrive à échéance
    
    public boolean estValide (Date dateActuel){
        boolean Valide = true;
        
        if(dateSignature.getJour() > dateActuel.getJour() && dateEcheance.getJour() < dateActuel.getJour()){
            if(dateSignature.getMois() > dateActuel.getMois() && dateEcheance.getMois() < dateActuel.getMois()){
                if(dateSignature.getAnnee() > dateActuel.getAnnee() && dateEcheance.getAnnee() < dateActuel.getAnnee()){
                            Valide = false;
                }
            }
        }
        return Valide;
    }
    // indique si le contrat est valide (la date du jour est entre la date de signature et la date d’échéance)
    
    public void ajouteMateriel (Materiel unMateriel){
        if(dateSignature.getJour() <= unMateriel.getDateinstallation().getJour() && dateEcheance.getJour() >= unMateriel.getDateinstallation().getJour()){
            if(dateSignature.getMois() <= unMateriel.getDateinstallation().getMois() && dateEcheance.getMois() >= unMateriel.getDateinstallation().getMois()){
                if(dateSignature.getAnnee() <= unMateriel.getDateinstallation().getAnnee() && dateEcheance.getAnnee() >= unMateriel.getDateinstallation().getAnnee()){
                            lesMaterielsAssures.add(unMateriel);
                }
            }
        }
    }
    // ajoute unMatériel à la collection lesMaterielsAssures si la date de signature du contrat est 
    // antérieure à la date d’installation du matériel

    public ContratMaintenance(String numContrat, String numClient, String refTypeContrat) {
		super();
		this.numContrat = numContrat;
		this.numClient = numClient;
		this.refTypeContrat = refTypeContrat;
	}
    
    public String getNumContrat() {
        return numContrat;
    }

	public Date getDateSignature() {
        return dateSignature;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public String getNumClient() {
        return numClient;
    }

    public String getRefTypeContrat() {
        return refTypeContrat;
    }

	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
	}

	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}

	public void setRefTypeContrat(String refTypeContrat) {
		this.refTypeContrat = refTypeContrat;
	}

	public void setLesMaterielsAssures(ArrayList<Materiel> lesMaterielsAssures) {
		this.lesMaterielsAssures = lesMaterielsAssures;
	}
}
