package connex;

import appli.Materiel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author vincent.scicluna
 */
public class RequeteClient {
    String Requete;
    String numClient;

    public RequeteClient(String Requete, String numClient) {
        this.Requete = Requete;
        this.numClient = numClient;
    }

    public String getRequete() {
        return Requete;
    }

    public String getNumClient() {
        return numClient;
    }
    
    public void RequeteMateriel(ArrayList<Materiel> lesMateriels){
            String req = this.getRequete();
            String para = this.numClient;
            
            parametre param = new parametre();
            
            Connection connexion = null;
        try
        {
            Class.forName (param.getDriverSGBD());
            connexion = DriverManager.getConnection ("jdbc:mysql://localhost/tpcashcash", param.getNomUtilisateur(), param.getMotDePasse());
            System.out.println("Connexion réussi");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Classe introuvable " + ex.getMessage ());
        }
        catch (SQLException ex)
        {
            System.out.println("Connexion impossible : " + ex.getMessage ());
        }
        Statement truc = null;
        ResultSet jeuEnreg = null;
        
        try {
            
            String reqT = req + "WHERE materiel.ReferenceInterne = typemateriel.ReferenceInterne AND materiel.NumeroClient =  " + para;
            truc = connexion.createStatement();
            System.out.println(reqT);
            jeuEnreg = truc.executeQuery(reqT);
            
            while(jeuEnreg.next()){
                Materiel materiel = new Materiel(jeuEnreg.getString(1), jeuEnreg.getString(2), jeuEnreg.getString(3), jeuEnreg.getString(4), jeuEnreg.getString(5), jeuEnreg.getString(6));
                lesMateriels.add(materiel);
            }
        }
        catch (Exception ex){
            System.out.println("Erreur : " + ex.getMessage());
        }
        
        finally
        {
            try
            {
                if (connexion != null)
                connexion.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace ();
            }
        }
    }
    
    public String RequeteContrat(){
            String req = this.getRequete();
            String para = this.numClient;
            
            parametre param = new parametre();
            
            Connection connexion = null;
        try
        {
            
            Class.forName (param.getDriverSGBD());
            connexion = DriverManager.getConnection ("jdbc:mysql://localhost/tpcashcash", param.getNomUtilisateur(), param.getMotDePasse());
            System.out.println("Connexion réussi");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Classe introuvable " + ex.getMessage ());
        }
        catch (SQLException ex)
        {
            System.out.println("Connexion impossible : " + ex.getMessage ());
        }
        Statement truc = null;
        ResultSet jeuEnreg = null;
        String nbJour = "0";
        
        try {
            
            String reqT = req + "Where NumeroClient =  " + para;
            truc = connexion.createStatement();
            System.out.println(reqT);
            jeuEnreg = truc.executeQuery(reqT);
            
            while(jeuEnreg.next()){
                nbJour = jeuEnreg.getString(1);
            }
        }
        catch (Exception ex){
            System.out.println("Erreur : " + ex.getMessage());
        }
        
        finally
        {
            try
            {
                if (connexion != null)
                connexion.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace ();
            }
        }
        return nbJour;
    }
    
}

