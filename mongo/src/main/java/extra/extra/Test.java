package extra.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.bson.Document;
import org.json.JSONArray;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.util.JSON;

import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Aggregates.*;
import extra.db.Db;
import extra.db.Logs;
import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;

public class Test {
	public static Logger log = Logs.getLog();
	public static MongoDatabase db = Db.connect();

	public static void main(String[] args) {
		
	MongoCollection<Document> cl = db.getCollection("students");
		
	MongoCursor<Document> mc ;
	MongoCollection<Document> mcl = db.getCollection("std2");
//	mcl.insertMany();


	cl.aggregate(Arrays.asList(project(Projections.exclude("scores")),sort(Sorts.descending("scores")),
			out("std2"))).toCollection();
	cl.aggregate(Arrays.asList(match(eq("id",4)),out("std3"))).toCollection();
	mc = db.getCollection("std2").find().sort(Sorts.descending("scores")).iterator();

	
	
	while(mc.hasNext())
	p(mc.next().toString());
	
//	double sums = 0;
//		while(mc.hasNext()){
//			sums=0;
//			Document d = mc.next();
//			p(d.get("_id")+" -> "+d.get("name"));
//			ArrayList<Document> sm =  (ArrayList<Document>)d.get("scores");
//			for(Document ds:sm)
//				sums = sums+Double.parseDouble(""+ds.get("score"));
//			
//			Document ndoc = new Document("name",d.get("name"));			
//			ndoc.append("scores",sums);
//			cl.replaceOne(eq("_id", d.get("_id")),ndoc);
//		}
		
	}
	public static void p(String a){
		log.info(a);
		System.out.println(a);
	}
	
}
