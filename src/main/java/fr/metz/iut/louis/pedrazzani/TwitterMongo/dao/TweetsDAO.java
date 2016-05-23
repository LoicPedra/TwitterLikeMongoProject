package fr.metz.iut.louis.pedrazzani.TwitterMongo.dao;

import java.util.ArrayList;
import java.util.LinkedList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;

import fr.metz.iut.louis.pedrazzani.TwitterMongo.modele.Tweet;

public class TweetsDAO {

	private static TweetsDAO instance;

	public static TweetsDAO getInstance() {
		if (instance == null)
			instance = new TweetsDAO();

		return instance;

	}

	public LinkedList<Tweet> getTweets() {

		LinkedList<Tweet> tweets = new LinkedList<Tweet>();

		MongoCollection<Document> collection = TwitterDAO.getInstance().getCollection();

		FindIterable<Document> it = collection.find().projection(Projections.exclude("_id"));

		ArrayList<Document> docs = new ArrayList<Document>();

		it.into(docs);

		for (Document doc : docs) {
			// System.out.println(doc);

			if (doc.containsKey("auteur") && doc.containsKey("message") && doc.containsKey("dateDeCreation"))
				tweets.add(new Tweet(doc.getString("auteur"), doc.getString("message"), doc.getDate("dateDeCreation")));
		}

		return tweets;
	}

	public void insertTweet(Tweet tweet) {
		MongoCollection<Document> collection = TwitterDAO.getInstance().getCollection();

		Document doc = new Document();
		doc.append("auteur", tweet.getAuteur());
		doc.append("message", tweet.getMessage());
		doc.append("dateDeCreation", tweet.getDateDeCreation());

		collection.insertOne(doc);
	}

}
