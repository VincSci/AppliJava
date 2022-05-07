package graphik;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import appli.Client;
import appli.ContratMaintenance;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import connex.*;
import fonction.PdfRelance;
import fonction.XmlClient;
import javax.swing.JTextPane;

public class Fenetre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Fenetre() throws SQLException {
		setTitle("Appli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(204, 102, 204));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(53, 27, 587, 443);
		contentPane.add(tabbedPane);
		
		JPanel pPagePrincpale = new JPanel();
		pPagePrincpale.setBackground(new Color(204, 102, 204));
		JLabel lblAccueil = new JLabel("Accueil : ");
		lblAccueil.setForeground(new Color(0, 0, 51));
		lblAccueil.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAccueil.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccueil.setBounds(158, 36, 266, 118);
		pPagePrincpale.add(lblAccueil);
		tabbedPane.addTab("Page Principale", null, pPagePrincpale, null);
		pPagePrincpale.setLayout(null);
		
		JTextPane txtAcceuil = new JTextPane();
		txtAcceuil.setText("1) G\u00E9n\u00E9rer Xml : Cette option vous permet de g\u00E9n\u00E9rer un document Xml pour un client choisit pr\u00E9amablement. \r\n\r\n2) Materiel Hors-Contrat : Cette option vous permet d'enregistrer le materiel hors-contratd'un client choisit pr\u00E9amablement. \r\n\r\n3) Courrier de Relance : Cette option vous permet de g\u00E9n\u00E9rer un document Pdf qui peut servir de courrier de relance pour un client choisit pr\u00E9amablement. ");
		txtAcceuil.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtAcceuil.setEditable(false);
		txtAcceuil.setBounds(65, 131, 467, 141);
		txtAcceuil.setBackground(new Color(204, 102, 204));
		pPagePrincpale.add(txtAcceuil);
		
		JPanel pPage1 = new JPanel();
		pPage1.setBackground(new Color(204, 102, 204));
		tabbedPane.addTab("G\u00E9n\u00E9rer Xml", null, pPage1, null);
		pPage1.setLayout(null);
		
		JLabel lblPage1 = new JLabel("G\u00E9n\u00E9rer un Fichier Xml : ");
		lblPage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPage1.setForeground(new Color(0, 0, 51));
		lblPage1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPage1.setBounds(141, 36, 330, 118);
		pPage1.add(lblPage1);
		
		JComboBox comboBoxClient = new JComboBox();
		comboBoxClient.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxClient.setModel(new DefaultComboBoxModel(new String[] {"Choisisser un Client :  ", "1 ", "2", "3", "4", "5"}));
		comboBoxClient.setToolTipText("");
		comboBoxClient.setEditable(false);
		comboBoxClient.setBounds(88, 139, 243, 44);
		pPage1.add(comboBoxClient);
		
		JButton btnGenXml = new JButton("G\u00E9n\u00E9rer le Fichier");
		btnGenXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxClient.getSelectedItem().toString() != "Choisisser un Client :  ") {
                    String numClient = comboBoxClient.getSelectedItem().toString();
                    	XmlClient FichierXml = new XmlClient("fichierRelance", numClient);
                        
                        Client leClient = new Client(numClient);
                        leClient.setLesMateriels(leClient.getMaterielsSousContrat());
                        
                        FichierXml.ecrire(numClient, leClient.getLesMateriels());
				}
				else {
					JOptionPane FenMessage = new JOptionPane();
					FenMessage.showMessageDialog(null, "Veuillez choissir un Client", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGenXml.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnGenXml.setBounds(162, 231, 169, 44);
		pPage1.add(btnGenXml);
		
		
		
		JPanel pPage2 = new JPanel();
		pPage2.setBackground(new Color(204, 102, 204));
		tabbedPane.addTab("Materiel Hors-Contrat", null, pPage2, null);
		pPage2.setLayout(null);
		
		JLabel lblPage2 = new JLabel("Enregistrer le materiel Hors-Contrat");
		lblPage2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPage2.setForeground(new Color(0, 0, 51));
		lblPage2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPage2.setBounds(15, 36, 550, 118);
		pPage2.add(lblPage2);
        
        JComboBox comboBoxContrat = new JComboBox();
		comboBoxContrat.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxContrat.setModel(new DefaultComboBoxModel(new String[] {"Choisisser un Client :  ", "1", "2", "3", "4", "5"}));
		comboBoxContrat.setToolTipText("");
		comboBoxContrat.setEditable(false);
		comboBoxContrat.setBounds(88, 139, 243, 44);
		pPage2.add(comboBoxContrat);
		        
		JButton btnContrat = new JButton("Enregistrer Materiel Hors-Contrat");
		btnContrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxContrat.getSelectedItem().toString() != "Choisisser un Client :  ") {
		                              JOptionPane FenMessage = new JOptionPane();
					int returnVal = FenMessage.showConfirmDialog(btnContrat,
						        "Voulez vous vraiment enregistrez tous le materiel hors-contrat sous un contrat?",
							"Confirmation d'enregistrement",
								JOptionPane.YES_NO_CANCEL_OPTION);
					if (returnVal == FenMessage.OK_OPTION) {
                        JOptionPane MessageResult = new JOptionPane();
                        MessageResult.showMessageDialog(null, "Le Materiels du Client est désormais couvert", "Enregistrement termine", JOptionPane.INFORMATION_MESSAGE);
					}
				}
		                        else {
					JOptionPane FenMessage = new JOptionPane();
					FenMessage.showMessageDialog(null, "Veuillez choissir un Client", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		        });
		btnContrat.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnContrat.setBounds(162, 231, 200, 44);
		pPage2.add(btnContrat);
		
		JPanel pPage3 = new JPanel();
		pPage3.setBackground(new Color(204, 102, 204));
		tabbedPane.addTab("Courrier de Relance", null, pPage3, null);
		pPage3.setLayout(null);
		
		JLabel lblPage3 = new JLabel("Courrier de Relance :");
		lblPage3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPage3.setForeground(new Color(0, 0, 51));
		lblPage3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPage3.setBounds(100, 36, 450, 118);
		pPage3.add(lblPage3);
        
        JComboBox comboBoxRelance = new JComboBox();
		comboBoxRelance.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxRelance.setModel(new DefaultComboBoxModel(new String[] {"Choisisser un Client :  ", "1", "2", "3", "4", "5"}));
		comboBoxRelance.setToolTipText("");
		comboBoxRelance.setEditable(false);
		comboBoxRelance.setBounds(88, 139, 243, 44);
		pPage3.add(comboBoxRelance);
		
		JButton btnGenPdf = new JButton("G\u00E9n\u00E9rer le Courrier");
		btnGenPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxRelance.getSelectedItem().toString() != "Choisisser un Client :  ") {
		                            String numClient = comboBoxRelance.getSelectedItem().toString();
		                            RequeteAgence reqTel = new RequeteAgence("SELECT Agence.TelephoneAgence FROM agence, client ", numClient);
		                            String numeroTel = reqTel.RequeteTel();
		                            
		                            RequeteAgence reqCli = new RequeteAgence("SELECT NomClient FROM client ", numClient);
		                            String nomClient = reqCli.RequeteNomClient();
		                            
		                            PdfRelance pdf = new PdfRelance("RelanceClient", nomClient);
		                            pdf.ecrire(nomClient, numeroTel);
				}
				else {
					JOptionPane FenMessage = new JOptionPane();
					FenMessage.showMessageDialog(null, "Veuillez choissir un Client", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGenPdf.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnGenPdf.setBounds(162, 231, 169, 44);
		pPage3.add(btnGenPdf);
}
}

