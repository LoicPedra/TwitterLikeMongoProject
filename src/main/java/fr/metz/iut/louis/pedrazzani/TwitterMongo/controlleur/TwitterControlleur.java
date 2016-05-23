package fr.metz.iut.louis.pedrazzani.TwitterMongo.controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import fr.metz.iut.louis.pedrazzani.TwitterMongo.modele.Tweet;
import fr.metz.iut.louis.pedrazzani.TwitterMongo.modele.Twitter;
import fr.metz.iut.louis.pedrazzani.TwitterMongo.vue.TwitterVue;

public class TwitterControlleur implements KeyListener, ActionListener {

	private TwitterVue vue;

	protected Twitter twitter;

	private String username;

	protected Timer timer;
	
	public boolean estSurAccueil = true;

	public TwitterControlleur(String username) {
		super();
		this.username = username;
		this.twitter = new Twitter();

		timer = new Timer();
	}

	public void setVue(final TwitterVue vue) {
		this.vue = vue;
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(estSurAccueil)
					vue.refreshTweets(getAllTweets());
					//System.out.println("refreshTweetAccueil");
			}
		}, 0, 5000);
	}
	
	

	public TwitterVue getVue() {
		return vue;
	}

	public String getUsername() {
		return username;
	}

	public String[] getAllTweets() {
		LinkedList<Tweet> tweets = twitter.getTweets();
		
		if (tweets.size() == 0) {
			String[] twString = new String[1];
			twString[0] = "<html><h1>" + "Aucun tweet n'est disponible dans votre fil d'actualité ...</h1></html>";
			return twString;
		}
		
		String[] twStrings = new String[tweets.size()];

		for (int i = 0; i < tweets.size(); i++) {
			Tweet tweet = tweets.get(i);
			twStrings[i] = "<html><h1><small>" + tweet.getAuteur()
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ tweet.getDateDeCreation() + "</small><br />" + tweet.getMessage().replace(
							"@" + this.getUsername(), "<strong>@" + this.getUsername() + "</strong>")
					+ "</h1></html>";
		}

		return this.reverseArray(twStrings);
	}

	public String[] getAllTweetsFromMe() {
		LinkedList<Tweet> tweets = twitter.getTweetsFrom(username);
		
		if (tweets.size() == 0) {
			String[] twString = new String[1];
			twString[0] = "<html><h1>Vous n'avez pas encore tweeter ...</h1></html>";
			return twString;
		}
		
		String[] twStrings = new String[tweets.size()];

		for (int i = 0; i < tweets.size(); i++) {
			Tweet tweet = tweets.get(i);
			twStrings[i] = "<html><h1><small>" + tweet.getAuteur()
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ tweet.getDateDeCreation() + "</small><br />" + tweet.getMessage().replace(
							"@" + this.getUsername(), "<strong>@" + this.getUsername() + "</strong>")
					+ "</h1></html>";
		}

		return this.reverseArray(twStrings);
	}
	
	public String[] getAllTweetsByHastag(String hashtag) {
		LinkedList<Tweet> tweets = twitter.getTweetsContainHashtag(hashtag);
		
		if (tweets.size() == 0) {
			String[] twString = new String[1];
			twString[0] = "<html><h1>" + "Aucun résultat n'est disponible pour cette recherche : " + hashtag + "</h1></html>";
			return twString;
		}
		
		String[] twStrings = new String[tweets.size()];

		for (int i = 0; i < tweets.size(); i++) {
			Tweet tweet = tweets.get(i);
			twStrings[i] = "<html><h1><small>" + tweet.getAuteur()
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ tweet.getDateDeCreation() + "</small><br />" + tweet.getMessage().replace(
							"@" + this.getUsername(), "<strong>@" + this.getUsername() + "</strong>")
					+ "</h1></html>";
		}

		return this.reverseArray(twStrings);
	}

	public String[] getAllTweetsByUser(String user) {
		LinkedList<Tweet> tweets = twitter.getTweetsContainUser(user);

		if (tweets.size() == 0) {
			String[] twString = new String[1];
			twString[0] = "<html><h1>" + "Aucun résultat n'est disponible pour cette recherche : " + user + "</h1></html>";
			return twString;
		}

		String[] twStrings = new String[tweets.size()];

		for (int i = 0; i < tweets.size(); i++) {
			Tweet tweet = tweets.get(i);
			twStrings[i] = "<html><h1><small>" + tweet.getAuteur()
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ tweet.getDateDeCreation() + "</small><br />" + tweet.getMessage().replace(
							"@" + this.getUsername(), "<strong>@" + this.getUsername() + "</strong>")
					+ "</h1></html>";
		}

		return this.reverseArray(twStrings);
	}
	
	public String[] getAllTweetsBySearch(String search) {
		LinkedList<Tweet> tweets = twitter.getTweetsContain(search);

		if (tweets.size() == 0) {
			String[] twString = new String[1];
			twString[0] = "<html><h1>" + "Aucun résultat n'est disponible pour cette recherche : " + search + "</h1></html>";
			return twString;
		}

		String[] twStrings = new String[tweets.size()];

		for (int i = 0; i < tweets.size(); i++) {
			Tweet tweet = tweets.get(i);
			twStrings[i] = "<html><h1><small>" + tweet.getAuteur()
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ tweet.getDateDeCreation() + "</small><br />" + tweet.getMessage().replace(
							"@" + this.getUsername(), "<strong>@" + this.getUsername() + "</strong>")
					+ "</h1></html>";
		}

		return this.reverseArray(twStrings);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			twitter.insertTweet(new Tweet(username, vue.getTweetContenu()));
			vue.refreshTweets(this.getAllTweets());
			vue.cleanTweetContenu();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	protected String[] reverseArray(String[] initial) {
		for (int i = 0; i < initial.length / 2; i++) {
			String temp = initial[i];
			initial[i] = initial[initial.length - i - 1];
			initial[initial.length - i - 1] = temp;
		}

		return initial;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
		case "accueil":
			estSurAccueil = true;
			vue.refreshTweets(this.getAllTweets());
			break;
		case "mesTweets":
			estSurAccueil = false;
			vue.refreshTweets(this.getAllTweetsFromMe());
			break;

		default:
			break;
		}
	}
}
