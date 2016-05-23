package fr.metz.iut.louis.pedrazzani.TwitterMongo.dao;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TwitterDAO {

	private static TwitterDAO instance;

	private MongoClient client;
	private MongoDatabase database;
	private MongoCollection<Document> collection;

	public static TwitterDAO getInstance() {
		if (instance == null)
			instance = new TwitterDAO();

		return instance;
	}

	private TwitterDAO() {
		this.client = new MongoClient();
		this.database = this.client.getDatabase("TwitterDb");
		this.collection = this.database.getCollection("TwitterDb");
	}

	public MongoCollection<Document> getCollection() {
		return collection;
	}

}
