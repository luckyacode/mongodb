package WebData.extra;

import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import WebData.db.Db;
import WebData.db.Logs;

public class Extra {
	public static Logger log = Logs.getLog();
	public static MongoDatabase md = Db.connect();
	public static void main(String args[]){
		log.info("Start");
		
		MongoCollection<Document> cl = md.getCollection("tmp1");
		
		cl.findOneAndUpdate(eq("_id",54),
				new Document("$set",new Document("name","praveen")));
		
		
		
		System.out.println("OK");
		
		
		
		
	}

}
