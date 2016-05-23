package fr.metz.iut.louis.pedrazzani.TwitterMongo.controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import fr.metz.iut.louis.pedrazzani.TwitterMongo.vue.ConnexionVue;
import fr.metz.iut.louis.pedrazzani.TwitterMongo.vue.TwitterVue;

public class ConnexionControlleur implements DocumentListener, ActionListener {

	private ConnexionVue vue;

	public void setVue(ConnexionVue vue) {
		this.vue = vue;
	}

	@Override
	public void changedUpdate(DocumentEvent de) {
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		this.updateBoutonValider();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		this.updateBoutonValider();
	}

	private void updateBoutonValider() {
		if (vue.getPseudo().trim().equals("") || vue.getPseudo().trim().contains(" "))
			vue.setValidateEnable(false);
		else
			vue.setValidateEnable(true);
	}

	private void switchToMainApplication() {
		TwitterControlleur twitterControlleur = new TwitterControlleur(this.vue.getPseudo());
		TwitterVue twitterVue = new TwitterVue("TwitterMongo", twitterControlleur);
		twitterControlleur.setVue(twitterVue);

		twitterVue.setVisible(true);

		this.vue.cacher();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("annuler"))
			System.exit(0);
		else if (ae.getActionCommand().equals("valider"))
			this.switchToMainApplication();
	}
}
