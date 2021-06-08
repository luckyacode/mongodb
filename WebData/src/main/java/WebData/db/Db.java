package WebData.db;

import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Db {
	public static Logger log = Logs.getLog();
	private static MongoDatabase md = null;
	
	public static MongoDatabase connect(){
		if(md!=null)
			return md;
		MongoClient mo = new MongoClient("localhost",27017);
		md = mo.getDatabase("mydb");
		log.info("Connected to myddb lossg ok");
		return md;
	}
	
	public static void main(String args[]){
		
		MongoClient mo = new MongoClient("localhost",27017);
		MongoDatabase md = mo.getDatabase("mydb");
		System.out.println("connect success");
	}
}
