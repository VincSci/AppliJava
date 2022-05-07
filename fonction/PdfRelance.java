package fonction;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfRelance {
    private String nomFichier;
    private String nomClient;

public PdfRelance(String nomFichier, String nomClient) {
    this.nomFichier = nomFichier;
    this.nomClient = nomClient;
}
    
public void ecrire(String nomClient, String TelAgence){
    try (PDDocument doc = new PDDocument()) {

        PDPage myPage = new PDPage();
        doc.addPage(myPage);

        try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {

            cont.beginText();

            cont.setFont(PDType1Font.TIMES_ROMAN, 12);
            cont.setLeading(14.5f);

            cont.newLineAtOffset(25, 700);
            
            String line1 = "Bonjour Madame, Monsieur,";
            cont.showText(line1);
            cont.newLine();
            
            String sautline = " ";
            cont.showText(sautline);
            cont.newLine();

            String line2 = "Nous vous envoyons ce courrier afin de vous informez que votre contrat de maintenance arrive à sa fin.";
            cont.showText(line2);
            cont.newLine();

            String line3 = "Afin de garder votre materiel couvert, nous vous conseillons d'en signer un nouveau.";
            cont.showText(line3);
            cont.newLine();

            String line4 = "Pour toute informations, vous pouvez nous joindre à ce numéro : ";
            cont.showText(line4);
            cont.newLine();
            
            cont.showText(sautline);
            cont.newLine();
            
            String line5 = TelAgence;
            cont.showText(line5);
            cont.newLine();
            
            cont.endText();
        }

        doc.save("RelanceClient"+nomClient+".pdf");
        
        System.out.println("Fichier sauvegardé avec succès!");
    }
    catch (Exception ex){
        System.out.println("ErreurPDF : " + ex.getMessage());
    }
}
}