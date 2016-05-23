package fr.metz.iut.louis.pedrazzani.TwitterMongo.modele;

import java.util.Date;

public class Tweet {

	private String auteur;
	private String message;
	private Date dateDeCreation;

	public Tweet(String auteur, String message) {
		this(auteur, message, new Date());
	}

	public Tweet(String auteur, String message, Date dateDeCreation) {
		this.auteur = auteur;
		this.message = message;
		this.dateDeCreation = dateDeCreation;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getMessage() {
		return message;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	@Override
	public String toString() {
		return "Tweet [auteur=" + auteur + ", message=" + message + ", dateDeCreation=" + dateDeCreation + "]";
	}

}
