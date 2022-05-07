package connex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appli.ContratMaintenance;
import appli.Date;
/**
 *
 * @author vincent.scicluna
 */
public class RequeteContrat {
        String Requete;
        String numContrat;

    public RequeteContrat(String Requete, String numContrat) {
        this.Requete = Requete;
        this.numContrat = numContrat;
    }
    
    public RequeteContrat() {
        
    }

    public String getRequete() {
        return Requete;
    }

    public String getNumContrat() {
        return numContrat;
    }
        
    public int RequeteJour(String numClient){
            String req = this.getRequete();
            int jourRestant = 0;
            
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
            String reqT = req + "WHERE contratdemaintenance.NumeroClient = " + numClient;
            truc = connexion.createStatement();
            System.out.println(reqT);
            jeuEnreg = truc.executeQuery(reqT);
            
            while(jeuEnreg.next()){
                jourRestant = jeuEnreg.getInt(1);
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
        return jourRestant;
    }
}
