package WebData.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUnit {
	
	protected int a,b;
	
	 @Test
	 
	 public void setUp()
	 {
		 a =3;
		 b = 4;
	 }
		
	   public void testAdd() {
		   int c = a +b;
		   assertTrue(c==7);
//	      String str = "Junit is working fine";
//	      assertEquals("Junit is working fine",str);
	   }
}
