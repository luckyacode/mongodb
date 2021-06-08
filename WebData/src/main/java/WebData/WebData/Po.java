package WebData.WebData;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Po {
	public HashMap<String,Product> hm =  new HashMap<String,Product>();;		
		
	public HashMap<String,Product> insert(Product p){
		hm.put(p.getId(), p);
		return hm;
	}
	
	public HashMap<String,Product> delete(String id){
		hm.remove(id);
		return hm;
	}
		
	public HashMap<String,Product> update(String id,Product p){
		hm.remove(id);
		hm.put(id, p);
		return hm;
	}
	
	public String getProduct(){
		if(hm.size()==0){
		hm.put("1", (new Product("1","a","89")));
		hm.put("2", (new Product("2","b","74")));
		hm.put("3", (new Product("3","c","18")));
		hm.put("4", (new Product("4","d","55")));
		hm.put("5", (new Product("5","e","32")));		
		}
		String t = "";
		for(Map.Entry<String,Product> h:hm.entrySet())
		{
			t = t +
				"{"+	
					(h.getValue()).toString()
				+"}\n";
		}
		
		return t;
	}
	
	
}
