package WebData.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;

@Service
public class DbAccess {
	public static MongoDatabase md = Db.connect();
	public static Logger log = Logs.getLog();
 
	public String toString(List<String> l) {
		String k = "";
		for (String t : l)
			k = k + t + "\n";
		return k;
	}

	public String insert(String k) {
		String[] ar = k.split(" ");
		MongoCollection<Document> cl = md.getCollection("tmp1");
		Document d = new Document("_id", 
				Integer.parseInt(ar[0]))
				.append("name", ar[1]).append("scores",
				Double.parseDouble(ar[2]));
		cl.insertOne(d);
		log.info("Insert Success : " + ar[0]);
		return "New Insert Success\n" + get();
	}

	public String delete(String id) {
		MongoCollection<Document> cl = md.getCollection("tmp1");
		cl.deleteOne(eq("_id", Double.parseDouble(id)));
		log.info("Deleted Success : " + id);
		return get();
	}

	public String update(String id, String k) {
		String[] ar = k.split(" ");
		MongoCollection<Document> cl = md.getCollection("tmp1");
		cl.updateOne(eq("_id", Double.parseDouble(id)),
				new Document("$set", new Document("name", ar[0]).append("scores", Double.parseDouble(ar[1]))));
		log.info("Updated Success : " + id);
		return get();
	}

	public String get() {
		List<String> al = new ArrayList<String>();
		MongoCursor<Document> cl2 = md.getCollection("tmp1").find().limit(5).iterator();
		while (cl2.hasNext()) {
			al.add(cl2.next().toString());
		}
		return toString(al);
	}

	public static void main(String args[]) {

		// MongoCollection<Document> cl = md.getCollection("students");
		//
		// MongoCursor<Document> cu =
		// md.getCollection("students").find().iterator();
		//
		// double count = 0;
		//
		// while (cu.hasNext()) {
		// count = 0;
		// Document mdoc = cu.next();
		// List<Document> ld = (List<Document>) mdoc.get("scores");
		// for (Document d : ld) {
		// count = count + Double.parseDouble("" + d.get("score"));
		// }
		// cl.updateOne(eq("_id", mdoc.get("_id")), new Document("$set", new
		// Document("scores", count)));
		//
		// }
		//
		// cl.aggregate(Arrays.asList(sort(Sorts.descending("scores")),
		// out("tmp1"))).toCollection();

//		MongoCollection<Document> cl = md.getCollection("tmp1");
		// cl.deleteOne(eq("_id",Double.parseDouble("64.0")));
		MongoCursor<Document> cl2 = md.getCollection("tmp1").find().sort(Sorts.descending("_id")).iterator();

		while (cl2.hasNext())
			log.info(cl2.next().toString());
	}
}
