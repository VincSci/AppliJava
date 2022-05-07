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

public Date(String date) {
    this.jour = date.charAt(9) + date.charAt(10);
    this.mois = date.charAt(6) + date.charAt(7);
    this.annee = date.charAt(1) + date.charAt(2) + date.charAt(3) + date.charAt(4);
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

public String DateComplete(){
    String dateComplete = String.valueOf(this.annee) + "-" + String.valueOf(this.mois) + "-" + String.valueOf(this.jour);
    
    return dateComplete;
}
}

