package main.java.com.ubo.tp.twitub.ihm;

import main.java.com.ubo.tp.twitub.controler.CtrlConnexion;
import main.java.com.ubo.tp.twitub.core.EntityManager;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.vue.Connexion;
import main.java.com.ubo.tp.twitub.vue.Inscription;
import main.java.com.ubo.tp.twitub.vue.UserPage;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitubMainView implements IObserver{
	
    protected IDatabase mDatabase;
    /* Gestionnaire de bdd et de fichier.*/
    protected EntityManager mEntityManager;
    protected JPanel connexion;
    protected Inscription inscription;
    protected JPanel pageAccueil;
    protected UserPage userPage;
    protected JFrame frame;

/**
 * Constructeur.
 */
public TwitubMainView(IDatabase database, EntityManager mEntityManager) {

	// Crée une grille 1x2 avec des marges horizontales et verticales de 10 pixels
    GridLayout layout = new GridLayout(2, 1, 10, 10);
	
    this.frame = new JFrame("Twitub");
    this.frame.setJMenuBar(menu());
    this.mDatabase = database;
    this.mEntityManager = mEntityManager;
    this.connexion = null;
    this.inscription = null;
    this.pageAccueil = new JPanel(layout);
    this.userPage = null;
    this.frame.setContentPane(this.pageAccueil);

    // Ajoute le bouton "Inscription" dans la première cellule
    JButton buttonInscription = new JButton("Inscription");
    buttonInscription.setPreferredSize(new Dimension(100, 50));
    this.pageAccueil.add(buttonInscription);

    // Ajoute le bouton "Connexion" dans la deuxième cellule
    JButton buttonConnexion = new JButton("Connexion");
    buttonConnexion.setPreferredSize(new Dimension(100, 50));
    this.pageAccueil.add(buttonConnexion);
    buttonConnexion.addActionListener( e -> connexion());
    
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setSize(400, 400);
    this.frame.setVisible(true);
}

    public JMenuBar menu( ) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Fichier");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Quitter");
        menu.add(menuItem);
        //item quit app
        menuItem.addActionListener(e -> System.exit(0));
        //add icone to menu
        ImageIcon icon = new ImageIcon("src/main/resources/images/exitIcon_20.png");
        menuItem.setIcon(icon);

        JMenu aPropos = new JMenu("?");
        menuBar.add(aPropos);
        //open dialogbox about app
        JMenuItem about = new JMenuItem("A propos");
        aPropos.add(about);
        about.addActionListener(e -> about());

        JMenuItem inscription = new JMenuItem("Inscription");
        aPropos.add(inscription);
        inscription.addActionListener(e -> inscription());
        
        return menuBar;
    }

    //button open inscription view
    public void inscription() {
        this.inscription = new Inscription( this.mDatabase, mEntityManager);
    }
    
    //button open connexion view
    public void connexion() {
    	CtrlConnexion ctrlConnex = new CtrlConnexion(this.mDatabase);
    	ctrlConnex.addObserver(this);
    	this.connexion = new Connexion(this.frame, ctrlConnex);
    	this.frame.getContentPane().add(this.connexion);
    	this.pageAccueil.setVisible(false);
    	this.connexion.setVisible(true);
    }
    
  //button userPage
//    public void userPage() {
//    	this.userPage = new UserPage(null);
//    	this.userPage.setVisible(true);
//    }

     //add dialogbox about app
     public void about() {
         JLabel label = new JLabel("<html><div style='text-align: center;'>UBO M2-TIIL<br/>DÃ©partement infromatique<br/></div></html>");

         ImageIcon icon = new ImageIcon("src/main/resources/images/logo_50.jpg");

         JOptionPane optionPane = new JOptionPane();
         optionPane.showMessageDialog(null, label, "A propos", JOptionPane.INFORMATION_MESSAGE, icon);
     }

	@Override
	public void update(IObservable observable){
		CtrlConnexion cc = (CtrlConnexion) observable;
		if(cc.getEtatConnex()) {
			System.out.print(cc.getEtatConnex());
			this.userPage = new UserPage(this.frame, cc.getUser());
			this.userPage.setVisible(true);
			this.connexion.setVisible(false);
		}else {
			this.connexion.setVisible(true);
			this.userPage.setVisible(false);
		}
	}

}