package main.java.com.ubo.tp.twitub.vue;

import main.java.com.ubo.tp.twitub.controler.CtrlConnexion;
import main.java.com.ubo.tp.twitub.core.EntityManager;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Connexion extends JPanel {
	
	private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private CtrlConnexion cConnex;
    
    private boolean etatConnex;
    private JFrame frame;
    
    public Connexion(JFrame frame, CtrlConnexion cConnex) {
    	super();
     // Crée les champs de texte et le bouton de connexion
    	this.frame = frame;
    	this.loginField = new JTextField(20);
    	this.passwordField = new JPasswordField(20);
    	this.loginButton = new JButton("Connexion");
        this.cConnex = cConnex;
        this.etatConnex = false;
        
        // Crée un panneau pour les champs de texte et le bouton
        JPanel loginPanel = new JPanel();
        connexionPage();
    }
    
    public void connexionPage() {
    	this.setLayout(new GridLayout(3, 1, 5, 5));
    	this.add(new JLabel("Identifiant:"));
    	this.add(loginField);
    	this.add(new JLabel("Mot de passe:"));
    	this.add(passwordField);
        this.add(loginButton);
        
        // Ajoute le panneau au contenu de la fenêtre
        this.frame.getContentPane().add(this);
        // Configure la taille et l'emplacement de la fenêtre
//        setSize(300, 150);
//        this.frame.setLocationRelativeTo(null);
        this.setVisible(true);
        System.out.print("CONNEXION");
        this.loginButton.addActionListener(e -> checkConnexion(loginField.getText(), passwordField.getText()));
    }
    
    public void checkConnexion(String tag, String passwrd){
    	this.cConnex.checkConnexion(tag, passwrd);
    }
}
