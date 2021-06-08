package WebData.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class Jtest2 {
	int num=5;
	String str = "Hello World";
	String sn = null;
	
	@Test
	public void testAdd(){
		assertEquals("Hello World",str);
		assertTrue(5==num);
		assertNull(sn);
	}

}
