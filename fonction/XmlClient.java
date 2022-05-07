package fonction;

import appli.Materiel;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author vincent.scicluna
 */
public class XmlClient {
    private String nomFichier;
    private String numClient;

    public XmlClient(String nomFichier, String numClient) {
        this.nomFichier = nomFichier;
        this.numClient = numClient;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getNumClient() {
        return numClient;
    }

    public void setNumClient(String numClient) {
        this.numClient = numClient;
    }
    
    public void ecrire(String numClient, ArrayList<Materiel>matos){
            try {
                  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                  DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

                  // élément de racine
                  Document doc = docBuilder.newDocument();
                  Element racine = doc.createElement("listeMateriel");
                  doc.appendChild(racine);

                  // l'élément client
                  Element client = doc.createElement("client");
                  racine.appendChild(client);

                  // attributs de l'élément contact
                  Attr attr = doc.createAttribute("id");
                  attr.setValue(numClient);
                  client.setAttributeNode(attr);
                                    
                  for(Materiel unMateriel : matos){
                            
                            Element materiel = doc.createElement("materiel");
                            client.appendChild(materiel);
                            
                            // NumeroDeSerie
                            Attr attr2 = doc.createAttribute("NumeroDeSerie");
                            attr2.setValue(unMateriel.getNumeroDeSerie());
                            materiel.setAttributeNode(attr2);

                            // ReferenceInterne
                            Element ReferenceInterne = doc.createElement("ReferenceInterne");
                            ReferenceInterne.appendChild(doc.createTextNode(unMateriel.getReferenceInterne()));
                            materiel.appendChild(ReferenceInterne);

                            // LibelleTypeMateriel
                            Element LibelleTypeMateriel = doc.createElement("LibelleTypeMateriel");
                            LibelleTypeMateriel.appendChild(doc.createTextNode(unMateriel.getLibelleTypeMateriel()));
                            materiel.appendChild(LibelleTypeMateriel);
                            
                            // DateDeVente
                            Element DateDeVente = doc.createElement("DateDeVente");
                            DateDeVente.appendChild(doc.createTextNode(unMateriel.getDateDeVente()));
                            materiel.appendChild(DateDeVente);
                            
                            // Dateinstallation
                            Element Dateinstallation = doc.createElement("Dateinstallation");
                            Dateinstallation.appendChild(doc.createTextNode(unMateriel.getDateinstallation()));
                            materiel.appendChild(Dateinstallation);
                            
                            // Emplacement 
                            Element Emplacement = doc.createElement("Emplacement");
                            Emplacement.appendChild(doc.createTextNode(unMateriel.getEmplacement()));
                            materiel.appendChild(Emplacement);
                  }

                  // enregistrement au format xml
                  TransformerFactory transformerFactory = TransformerFactory.newInstance();
                  Transformer transformer = transformerFactory.newTransformer();
                  DOMSource source = new DOMSource(doc);
                  StreamResult resultat = new StreamResult(new File("FichierClient"+numClient+".xml"));

                  transformer.transform(source, resultat);

                  System.out.println("Fichier sauvegardé avec succès!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}

