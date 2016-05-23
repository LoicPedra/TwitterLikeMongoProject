package fr.metz.iut.louis.pedrazzani.TwitterMongo;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.metz.iut.louis.pedrazzani.TwitterMongo.modele.Tweet;
import fr.metz.iut.louis.pedrazzani.TwitterMongo.modele.Twitter;

public class MainTwitterMongo {

	public static void main(String[] args) {

		System.out.println("=== TwitterMongo ===");

		Logger mongoLogger = Logger.getLogger("org.mongodb");
		mongoLogger.setLevel(Level.SEVERE);

		/*
		 * TweetsDAO tweetsDAO = new TweetsDAO();
		 * 
		 * LinkedList<Tweet> tweets = tweetsDAO.getTweets();
		 * 
		 * if(tweets.size() < 1) System.out.println(
		 * "Vous n'avez pas de tweet dans votre timeline"); else { for (Tweet
		 * tweet : tweetsDAO.getTweets()) { System.out.println(tweet); } }
		 * 
		 * System.out.println("---------------------------");
		 * 
		 * tweetsDAO.insertTweet(new Tweet("Loic", "Premier tweet !"));
		 * 
		 * System.out.println("---------------------------");
		 * 
		 * tweets = tweetsDAO.getTweets();
		 * 
		 * if(tweets.size() < 1) System.out.println(
		 * "Vous n'avez pas de tweet dans votre timeline"); else { for (Tweet
		 * tweet : tweetsDAO.getTweets()) { System.out.println(tweet); } }
		 */

		Twitter twitter = new Twitter();

		LinkedList<Tweet> allTweets = twitter.getTweets();

		if (allTweets.size() < 1)
			System.out.println("Vous n'avez pas de tweet dans votre timeline");
		else {
			for (Tweet tweet : allTweets) {
				System.out.println(tweet);
			}
		}

		System.out.println("---------------------------");

		twitter.insertTweet(new Tweet("Loic", "Premier tweet !"));

		System.out.println("---------------------------");

		allTweets = twitter.getTweets();

		if (allTweets.size() < 1)
			System.out.println("Vous n'avez pas de tweet dans votre timeline");
		else {
			for (Tweet tweet : allTweets) {
				System.out.println(tweet);
			}
		}

	}

}
