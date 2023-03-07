package main.java.com.ubo.tp.twitub.vue;

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

public class Inscription extends JFrame {
    private JTextField Nom;
    private JTextField Tag;

    private JTextField Avatar;

    private JButton button;
    private JTextArea textArea;

    protected EntityManager mEntityManager;

    protected IDatabase mDatabase;

    public Inscription ( IDatabase mDatabase, EntityManager mEntityManager) {
        super("Inscription");
        this.mEntityManager = mEntityManager;
        this.mDatabase = mDatabase;

        button = new JButton("Inscription");
        this.Nom = new JTextField();
        this.Tag = new JTextField();

        this.Nom.setPreferredSize(new Dimension(200, 24));
        this.Tag.setPreferredSize(new Dimension(200, 24));

        textArea = new JTextArea(5, 10);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Nom.getText().equals("")|| Tag.getText().equals("")) {
                    textArea.setText("Veuillez remplir tous les champs");
                } else {
                    textArea.setText("Inscription réussie");
                }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        panel.add(new JLabel("Nom d'utilisateur :"));
        panel.add(this.Nom);
        panel.add(new JLabel("Tag :"));
        panel.add(this.Tag);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
