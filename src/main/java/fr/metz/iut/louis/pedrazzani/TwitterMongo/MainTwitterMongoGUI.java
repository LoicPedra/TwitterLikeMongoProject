package fr.metz.iut.louis.pedrazzani.TwitterMongo;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.metz.iut.louis.pedrazzani.TwitterMongo.controlleur.ConnexionControlleur;
import fr.metz.iut.louis.pedrazzani.TwitterMongo.vue.ConnexionVue;

public class MainTwitterMongoGUI {

	public static void main(String[] args) {

		Logger mongoLogger = Logger.getLogger("org.mongodb");
		mongoLogger.setLevel(Level.SEVERE);

		ConnexionControlleur controlleur = new ConnexionControlleur();

		ConnexionVue vue = new ConnexionVue("Connexion à TwitterMongo", controlleur);

		controlleur.setVue(vue);

		vue.setVisible(true);

	}

}
