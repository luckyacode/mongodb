package com.praveen.praveen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.praveen.model.Product;



@RestController
public class ProductServiceController {
	private ProductOp pro = new ProductOp();
	
   @RequestMapping(value = "/products")
   public List<Product> getProduct() {
	   List<Product> prol = pro.getList();
      return prol;
   } 
   @RequestMapping(value="/products",method=RequestMethod.POST)
   public List<Product> createProduct(@RequestBody Product Product){
	   List<Product> prol = pro.getList();
	   prol.add(Product);
	   return prol;	   
   }
   
   @RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)
   public List<Product> delete(@PathVariable("id") String id)
   {
	   List<Product> prolist = pro.getList();
	  prolist = findId(prolist,id);
	   return prolist;
   }
   
   @RequestMapping(value="/products/{id}",method=RequestMethod.PUT)
   public List<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product Product){
	   List<Product> li = pro.getList();
	   li.remove(id);
	   li.add(Product);
	   return li;
   }
   public List<Product> findId(List<Product> prolist,String id){

	   for(int i=0;i<prolist.size();i++){
		   Product p = prolist.get(i);
		   if((p.getId()).trim().equalsIgnoreCase(id.trim()))
			   prolist.remove(p);
			   return prolist;
	   }
	   return prolist;
   }

}


//@RestController
//public class ProductServiceController {
//	private static Map<String,Product> hm = new HashMap<>();
//	static{
//		Product a = new Product();
//		a.setId("1");a.setName("mango");hm.put(a.getId(), a);
//		Product b = new Product();
//		b.setId("2");b.setName("banana");hm.put(b.getId(), b);
//	}
//	@RequestMapping(value="/")
//	public ResponseEntity<Object> getProduct(){
//		return new ResponseEntity<>(hm.values(),HttpStatus.OK);
//	}
//		
//	@RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)
//	public ResponseEntity<Object> delete(@PathVariable("id") String id ){
//		hm.remove(id);
//		return new ResponseEntity<>("Product Deleted Success",HttpStatus.OK);
//	}	
//	
//	@RequestMapping(value="/products/{id}",method=RequestMethod.PUT)
//	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id,@RequestBody Product product)
//	{
//		hm.remove(id);
//		product.setId(id);
//		hm.put(product.getId(), product);
//		return new ResponseEntity<>("Product Updated Success",HttpStatus.ACCEPTED);
//	}
//	@RequestMapping(value="/products",method=RequestMethod.POST)
//	public ResponseEntity<Object> createProduct(@RequestBody Product product){
//		hm.put(product.getId(), product);
//		return new ResponseEntity<>("New Product Created",HttpStatus.OK);
//	}
//	
//}
