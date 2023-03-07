package main.java.com.ubo.tp.twitub.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.com.ubo.tp.twitub.datamodel.User;

public class UserPage extends JPanel{
	JFrame frame;
	User user;
	
	public UserPage(JFrame frame, User user) {
		this.frame = frame;
		this.user = user;
		
		String name = this.user.getName();
        String username = this.user.getUserTag();
        
        // Créer les étiquettes pour afficher les messages
        JLabel welcomeLabel = new JLabel("Bienvenue");
        JLabel nameLabel = new JLabel("Nom : " + name);
        JLabel usernameLabel = new JLabel("Pseudo : " + username);
        
     // Configurer la police de caractères des étiquettes
        Font font = new Font("Arial", Font.PLAIN, 16);
        welcomeLabel.setFont(font);
        nameLabel.setFont(font);
        usernameLabel.setFont(font);
        
        // Créer des panneaux pour contenir chaque étiquette
        JPanel welcomePanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel usernamePanel = new JPanel();
        
        // Ajouter chaque étiquette à son panneau correspondant
        welcomePanel.add(welcomeLabel);
        namePanel.add(nameLabel);
        usernamePanel.add(usernameLabel);
        
        // Configurer les panneaux pour qu'ils soient alignés verticalement
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.Y_AXIS));
        
        // Configurer les marges des panneaux pour réduire l'espace entre les éléments
        int topMargin = 10;
        int bottomMargin = 10;
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));
        namePanel.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));
        usernamePanel.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));
        
        // Ajouter les panneaux à la fenêtre
        this.add(welcomePanel, BorderLayout.NORTH);
        this.add(namePanel, BorderLayout.CENTER);
        this.add(usernamePanel, BorderLayout.SOUTH);
        this.frame.add(this);
        // Configurer la fenêtre
        this.frame.setTitle("Profil");
        this.frame.setPreferredSize(new Dimension(300, 150));
        this.frame.pack();
        this.frame.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
	}
}
