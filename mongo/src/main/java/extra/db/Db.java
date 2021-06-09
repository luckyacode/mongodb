package extra.db;

import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class Db {
	public static MongoDatabase db = null;
	public static Logger log = Logs.getLog();

	public static void main(String ar[]) {
		db = connect();
		log.info("Connected through Main Class Db");
	}

	public static MongoDatabase connect() {
		if (db == null) {
			MongoClient mo = new MongoClient("localhost", 27017);
			MongoCredential cr = MongoCredential.createCredential("root", "mydb", "root".toCharArray());
			db = mo.getDatabase("mydb");
		}
		if (db != null)
			log.info("Connected Successfully\n");
		else
			log.info("Failed To connect");
		return db;
	}
}
