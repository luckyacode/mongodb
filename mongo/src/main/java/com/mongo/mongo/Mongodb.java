package com.mongo.mongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.bson.Document;
import org.springframework.data.mongodb.core.aggregation.ComparisonOperators.Eq;
import org.springframework.data.mongodb.core.aggregation.ScriptOperators.Accumulator;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.DeleteOptions;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.util.JSON;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.minidev.json.JSONObject;

import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Aggregates.*;


class emp{
	String id,fname;
	int salary;
	public emp(String id,String fname,int salary){
		this.id=id;
		this.fname=fname;
		this.salary=salary;
	}
	public String getId(){
		return id;
	}
	public String getName(){
		return fname;
	}
	public int getSalary(){
		return salary;
	}
	
}

public class Mongodb {
	public static MongoDatabase db = null;

	public static MongoDatabase connect() {
		MongoClient mo = new MongoClient("localhost", 27017);
		MongoCredential cr = MongoCredential.createCredential("root", "mydb", "root".toCharArray());
		MongoDatabase db = mo.getDatabase("mydb");
		p("connected to mydb success");
		return db;
	}

	public static void main(String args[]) {

		p("Starting....");
		db = connect();

		
		MongoCollection<Document> cl = db.getCollection("emp");

Document	cus= cl.aggregate(Arrays.asList(match(and(eq("status","inactive"),
				gte("salary",3000))),count())).first();
			
//		int count=0;
//		if(cus!=null)
//		 count = (int)cus.get("count");
//
//		while(count!=0){
//			cl.replaceOne(and(gte("salary",3000),eq("status","inactive")),
//					new Document("salary",5000)
//					.append("status", "active")
//					.append("name", "name"+count)					
//					);
//			count--;
//		}
//		
//		p("Done");
		
//		cl.updateMany(ne("id",""),
//		new Document("$set",new Document("status","inactive")));

//		MongoCursor<Document> cu = db.getCollection("counts2").find().iterator();
		
//		while(cu.hasNext()){
//			p(cu.next()+"");
//		}

//exlude not add(), include(list) add only
//cl.aggregate(Arrays.asList(project(Projections.exclude("scores")),sort(Sorts.descending("scores")),
//		out("std2"))).toCollection();



//		

		//only delete single key value 
//		cl.updateMany(gt("salary",2000), new Document("$unset",
//				new Document("salary",1)));

		
		
		//replace all remain id and set new key value
//		cl.replaceOne(eq("salary",3000), 
//				new Document("salary2",3000)
//				.append("name","tripathi")
//				);
//		
		
//		updateone with multiple key value pair
//		cl.updateOne(gt("salary", 2000),
//				new Document("$set",
//						new Document("fname","pt")
//						.append("tt", "OK")
//						.append("not", "present")
//						));
		
		//on replace only single key value pair remain
//		cl.replaceOne(and(eq("salary",12000),eq("fname","s")), 
//				new Document("salary",13000));
//		cl.deleteMany(eq("salary",6000));		
//		cl.updateMany(lt("salary",6000), new Document("$set",new Document("salary",12000)));		
//		cl.updateMany(new Document("salary",1000),new Document("$set",new Document("salary",6000)));
		//if already in update so key value override if not new key value made
//		cl.updateOne(new Document("salary", 2000),new Document("$set",new Document("salary",9000)));
//		cl.deleteOne(Filters.gte("salary", 5000));
		
		
//		MongoCollection<Document> cl = db.getCollection("emp");
//		cl.aggregate(Arrays.asList(group("$fname", Accumulators.sum("salary", "$salary")),
//				match(Filters.ne("salary", 5000)), out("mynew"))).toCollection();
//		
//		MongoCursor<Document> cur = db.getCollection("mynew").find().iterator();
//
//		while (cur.hasNext()) {
//			p(cur.next() + "");
//		}
//
		//
		// cl.aggregate(Arrays.asList(group("$fname",Accumulators.sum("salary",
		// "$salary")),
		// match(Filters.gt("salary", 5000)),out("mynew"))).toCollection();
		// The index stores the value of a specific field or set of fields,
		// ordered by the value of the field.
		// second highest salary
		// MongoCursor<Document> cur =
		// db.getCollection("emp").find().sort(Sorts.descending("salary")).skip(1).limit(1).iterator();
		// MongoCursor<Document> cur = db.getCollection("emp").find().sort(new
		// Document("salary",-1)).skip(1).limit(1).iterator();
		// second highest salary

		// cl.aggregate(Arrays.asList(group("$fname",
		// Accumulators.sum("salary", "$salary")),
		// sort(Sorts.descending("salary")),
		// out("salary"))).toCollection();

		// cl.aggregate(Arrays.asList(
		// match(Filters.gt("id", 8)),
		// sort(Sorts.descending("id")),
		// out("largest_seven"))).toCollection();

		// Document d = cl.aggregate(Arrays.asList(
		// match(Filters.eq("id", "4")),
		// count())).first();
		// count())).first();

		// Document d = cl.find().first();
		// p(d.toJson());

		// MongoCursor<Integer> cur = cl.distinct("id",
		// Integer.class).iterator();
		// while(cur.hasNext())
		// {
		// p(cur.next()+"");
		// }

		// cl.deleteOne(eq("id",55));

		// cl.updateOne(new Document("id",2),new Document("$set",new
		// Document("id",55)));

		// import static com.mongodb.client.model.Projections.excludeId;
		// import static com.mongodb.client.model.Filters.*;

		// find().skip(5).limit(2).projection(excludeId()).iterator();

		// MongoCursor<Document> cur = db.getCollection("users").
		// find(and(eq("id",10),gte("id",2))).sort(new
		// Document("id",1)).projection(excludeId()).iterator();

		// BasicDBObject flt = new BasicDBObject("id",new
		// BasicDBObject("$gt",10));
		// flt.append("id", new BasicDBObject("$lte",18));
		// MongoCursor<Document> cur = cl.find(flt).iterator();
		// while(cur.hasNext())
		// {
		// p(cur.next().toJson());
		// }

		// List<Document> doclist = new ArrayList<Document>();
		// for(int i=1;i<=10;i++)
		// {
		// doclist.add(new Document("id",i*2));
		// }

		// cl.insertMany(doclist);

		// Document stats = db.runCommand(new Document("dbstats",1));
		// for(Map.Entry<String, Object> m:stats.entrySet())
		// p(m.getKey()+" : "+m.getValue());

		// cl.insertOne(d);
		// List<Document> doclist = new ArrayList<Document>();
		// for(int i=1;i<=10;i++)
		// {
		// doclist.add(new Document("EMP"+i*10,"PASS"+i*2));
		// }
		//
		// cl.insertMany(doclist);
		// MongoCollection<Document> col = db.getCollection("students");
		// MongoCursor<Document> cur = col.find().iterator();
		// Document d = cur.next();
		// for(Entry<String, Object> m : d.entrySet())
		// {
		// p(m.getKey()+" : "+m.getValue());
		// }

		// for(String nm : db.listCollectionNames())
		// p(nm);

		// col.drop();
		// col.deleteOne(Filters.eq("id","1"));

		// col.updateOne(Filters.eq("name","praveen"), Updates.set("id", "34"));
		// FindIterable<Document> itr = col.find();
		// Iterator<Document> it = itr.iterator();
		// while(it.hasNext())
		// {
		// p(it.next().toJson());
		// }
		//
		//
		// Document doc = new Document("name","praveen77")
		// .append("id", "1").append("mob", "123");
		// col.insertOne(doc);
		// p("insert done");

	}

	static void p(String a) {
		System.out.println(a);
	}
}
