package fr.metz.iut.louis.pedrazzani.TwitterMongo.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import fr.metz.iut.louis.pedrazzani.TwitterMongo.controlleur.ConnexionControlleur;

public class ConnexionVue extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField champPseudo;

	private JButton bouttonValider;
	private JButton bouttonAnuller;

	public ConnexionVue(String title, ConnexionControlleur controlleur) {
		super(title);

		UIManager.put("Synthetica.window.decoration", Boolean.FALSE);

		try {
			UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Dimension dimensionApplication = new Dimension(400, 325);
		this.setSize(dimensionApplication);
		this.setPreferredSize(dimensionApplication);
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		JPanel b1 = new JPanel();
		b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		this.champPseudo = new JTextField("", 20);
		this.champPseudo.setMaximumSize(new Dimension(150, 40));
		this.champPseudo.getDocument().addDocumentListener(controlleur);
		this.champPseudo.setActionCommand("pseudo");
		b1.add(this.champPseudo);

		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new BorderLayout());

		JPanel panelActionPositive = new JPanel();
		panelActionPositive.setLayout(new GridLayout(1, 2));

		this.bouttonValider = new JButton("Valider");
		this.bouttonValider.setActionCommand("valider");
		this.bouttonValider.setEnabled(false);
		this.bouttonValider.addActionListener(controlleur);
		panelActionPositive.add(this.bouttonValider);

		this.bouttonAnuller = new JButton("Annuler");
		this.bouttonAnuller.addActionListener(controlleur);
		this.bouttonAnuller.setActionCommand("annuler");

		panelBoutons.add(panelActionPositive, BorderLayout.EAST);
		panelBoutons.add(this.bouttonAnuller, BorderLayout.WEST);

		JPanel b4 = new JPanel();
		b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
		b4.add(b1);

		this.setLayout(new BorderLayout());

		this.getContentPane().add(
				new JLabel("<html>Saisissez votre pseudo :<br /><br /><br /></html>", SwingConstants.CENTER),
				BorderLayout.NORTH);
		this.getContentPane().add(b4, BorderLayout.CENTER);
		this.getContentPane().add(panelBoutons, BorderLayout.SOUTH);

	}

	public String getPseudo() {
		return this.champPseudo.getText();
	}

	public void setValidateEnable(boolean enable) {
		this.bouttonValider.setEnabled(enable);
	}

	public void cacher() {
		this.setVisible(false);
	}

}
