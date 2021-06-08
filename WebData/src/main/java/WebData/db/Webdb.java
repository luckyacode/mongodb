package WebData.db;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan
public class Webdb {
	public Logger log = Logs.getLog();
	@Autowired DbAccess db;
	public static void main(String args[]){
		SpringApplication.run(Webdb.class, args);
	}
	
	@RequestMapping(value="/data")
	public String get(){
		return db.get();
	}
	@RequestMapping(value="/data/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") String id){
		return db.delete(id);
	}
	@RequestMapping(value="/data/{id}" , method=RequestMethod.PUT)
	public String update(@PathVariable("id") String id,@RequestBody String k){
		return db.update(id,k);
	}
	@RequestMapping(value="/data", method=RequestMethod.POST)
	public String insert(@RequestBody String k){
		return db.insert(k);
	}

}
