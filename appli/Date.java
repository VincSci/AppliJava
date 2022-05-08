package appli;

public class Date {
    int jour;
    int mois;
    int annee;

public Date(int jour, int mois, int annee) {
    this.jour = jour;
    this.mois = mois;
    this.annee = annee;
}

public int getJour() {
    return jour;
}

public int getMois() {
    return mois;
}

public int getAnnee() {
    return annee;
}

public void setJour(int jour) {
	this.jour = jour;
}

public void setMois(int mois) {
	this.mois = mois;
}

public void setAnnee(int annee) {
	this.annee = annee;
}

public String DateComplete(){
    String dateComplete = String.valueOf(this.annee) + "-" + String.valueOf(this.mois) + "-" + String.valueOf(this.jour);
    
    return dateComplete;
}
}

