package fr.metz.iut.louis.pedrazzani.TwitterMongo.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.metz.iut.louis.pedrazzani.TwitterMongo.controlleur.TwitterControlleur;

public class RechercheListener implements KeyListener {

	private TwitterControlleur parent;

	public RechercheListener(String username, TwitterControlleur parent) {
		this.parent = parent;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			parent.estSurAccueil = false;
			if (parent.getVue().getRechercheContenu().startsWith("#"))
				parent.getVue()
						.refreshTweets(parent.getAllTweetsByHastag("#" + parent.getVue().getRechercheContenu().split("#")[1]));
			else if (parent.getVue().getRechercheContenu().startsWith("@"))
				parent.getVue().refreshTweets(parent.getAllTweetsByUser("@" + parent.getVue().getRechercheContenu().split("@")[1]));
			else
				parent.getVue().refreshTweets(parent.getAllTweetsBySearch(parent.getVue().getRechercheContenu().trim()));
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
