package connex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appli.Date;

public class RequeteDate {
		private String requete;

		public RequeteDate(String requete) {
			super();
			this.requete = requete;
		}

		public String getRequete() {
			return requete;
		}

		public void setRequete(String requete) {
			this.requete = requete;
		}
		
		public Date DateInstallation(String numClient, String numDeSerie){
            String req = this.getRequete();
            
            Date laDate = new Date (0,0,0);
            
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
            
            String reqT = req + "Where NumeroClient =  " + numClient + " AND NumeroDeSerie = " + numDeSerie;
            truc = connexion.createStatement();
            System.out.println(reqT);
            jeuEnreg = truc.executeQuery(reqT);
            
            while(jeuEnreg.next()){
                laDate.setAnnee(jeuEnreg.getInt(1));
                laDate.setMois(jeuEnreg.getInt(2));
                laDate.setJour(jeuEnreg.getInt(3));
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
        return laDate;
    }
    
		public Date DateSignature(String numClient, String numContrat){
            String req = this.getRequete();
            
            Date laDate = new Date (0,0,0);
            
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
            
            String reqT = req + " Where NumeroClient =  " + numClient + " AND NumeroDeContrat  = " + numContrat;
            truc = connexion.createStatement();
            System.out.println(reqT);
            jeuEnreg = truc.executeQuery(reqT);
            
            while(jeuEnreg.next()){
                laDate.setAnnee(jeuEnreg.getInt(1));
                laDate.setMois(jeuEnreg.getInt(2));
                laDate.setJour(jeuEnreg.getInt(3));
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
        return laDate;
    }
		
		public Date DateEcheance(String numClient, String numContrat){
            String req = this.getRequete();
            
            Date laDate = new Date (0,0,0);
            
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
            
            String reqT = req + "Where NumeroClient =  " + numClient + "AND NumeroDeContrat  = " + numContrat;
            truc = connexion.createStatement();
            System.out.println(reqT);
            jeuEnreg = truc.executeQuery(reqT);
            
            while(jeuEnreg.next()){
                laDate.setAnnee(jeuEnreg.getInt(1));
                laDate.setMois(jeuEnreg.getInt(2));
                laDate.setJour(jeuEnreg.getInt(3));
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
        return laDate;
    }
}
