package fr.metz.iut.louis.pedrazzani.TwitterMongo.modele;

import java.util.LinkedList;

import fr.metz.iut.louis.pedrazzani.TwitterMongo.dao.TweetsDAO;

public class Twitter {

	public LinkedList<Tweet> getTweets() {
		return TweetsDAO.getInstance().getTweets();
	}

	public LinkedList<Tweet> getTweetsFrom(String auteur) {
		LinkedList<Tweet> tweets = new LinkedList<Tweet>();
		for (Tweet tweet : TweetsDAO.getInstance().getTweets()) {
			if (tweet.getAuteur().equals(auteur) || tweet.getMessage().contains("@"+auteur))
				tweets.add(tweet);
		}

		return tweets;
	}

	public LinkedList<Tweet> getTweetsContainHashtag(String hashtag) {
		LinkedList<Tweet> tweets = new LinkedList<Tweet>();
		for (Tweet tweet : TweetsDAO.getInstance().getTweets()) {
			if (tweet.getMessage().contains(hashtag))
				tweets.add(tweet);
		}

		return tweets;
	}

	public LinkedList<Tweet> getTweetsContainUser(String user) {
		LinkedList<Tweet> tweets = new LinkedList<Tweet>();
		for (Tweet tweet : TweetsDAO.getInstance().getTweets()) {
			if (tweet.getMessage().contains(user))
				tweets.add(tweet);
		}

		return tweets;
	}
	
	public LinkedList<Tweet> getTweetsContain(String query) {
		LinkedList<Tweet> tweets = new LinkedList<Tweet>();
		for (Tweet tweet : TweetsDAO.getInstance().getTweets()) {
			if (tweet.getMessage().toLowerCase().contains(query.toLowerCase().trim()))
				tweets.add(tweet);
		}
		return tweets;
	}

	public void insertTweet(Tweet tweet) {
		if (tweet.getMessage().length() > 140)
			TweetsDAO.getInstance().insertTweet(
					new Tweet(tweet.getAuteur(), tweet.getMessage().substring(0, 140), tweet.getDateDeCreation()));
		else
			TweetsDAO.getInstance().insertTweet(tweet);
	}

}
