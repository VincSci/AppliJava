package connex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vincent.scicluna
 */
public class RequeteAgence {
    String Requete;
    String numClient;

    public RequeteAgence(String Requete, String numClient) {
        this.Requete = Requete;
        this.numClient = numClient;
    }

    public String getRequete() {
        return Requete;
    }

    public String getNumClient() {
        return numClient;
    }
    
    public String RequeteTel(){
            String req = this.getRequete();
            String para = this.numClient;
            
            String tel = "";
            
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
            
            String reqT = req + "WHERE agence.NumeroAgence = client.NumeroClient AND NumeroClient =  " + para;
            truc = connexion.createStatement();
            System.out.println(reqT);
            jeuEnreg = truc.executeQuery(reqT);
            
            while(jeuEnreg.next()){
                tel = jeuEnreg.getString(1);
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
        return tel;
    }
    
        public String RequeteNomClient(){
            String req = this.getRequete();
            String para = this.numClient;
            
            String tel = "";
            
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
            
            String reqT = req + "WHERE NumeroClient =  " + para;
            truc = connexion.createStatement();
            System.out.println(reqT);
            jeuEnreg = truc.executeQuery(reqT);
            
            while(jeuEnreg.next()){
                tel = jeuEnreg.getString(1);
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
        return tel;
    }
}
