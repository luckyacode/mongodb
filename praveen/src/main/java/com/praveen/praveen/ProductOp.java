package com.praveen.praveen;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.praveen.model.Product;

@Service
public class ProductOp {
	
	public static List<Product> getList(){
		List<Product> al = new ArrayList<>();
	      Product honey = new Product();
	      honey.setId("1");
	      honey.setName("Honey");
	      al.add( honey);
	       
	      Product almond = new Product();
	      almond.setId("2");
	      almond.setName("Almond");
	      al.add(almond);
		return al;
	}

}
