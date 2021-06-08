package WebData.WebData;

import java.util.Collection;

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
public class Webapi {
	@Autowired Po p;
	
	public static void main(String args[]){
			SpringApplication.run(Webapi.class, args);
		}
	
		@RequestMapping(value="/product")
		public String get(){     
			return p.getProduct();
		}
		
		@RequestMapping(value="/product/{id}" , method=RequestMethod.DELETE)
		public String delete(@PathVariable("id") String id){	
			p.delete(id);
			return p.getProduct();
		}
		
		@RequestMapping(value="/product/{id}", method=RequestMethod.PUT)		
		public String update(@PathVariable("id") String id, @RequestBody String a){
			String ar[] = a.split(" ");
			p.update(id, new Product(id,ar[1],ar[2]));
			return p.getProduct();
		}
		 
		@RequestMapping(value="/product", method=RequestMethod.POST)
		public String insert(@RequestBody String a){
			String ar[] = a.split(" ");
			p.insert(new Product(ar[0],ar[1],ar[2]));
			return p.getProduct();
		}
		
}
