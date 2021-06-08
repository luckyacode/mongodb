package WebData.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class Jtest1 {
	
	String msg = "Hello World";
	MessageUtil mu = new MessageUtil(msg);
	
	@Test
	public void testPrintMessage(){
		//if change
		msg = "llo Worl";
		assertEquals(msg,mu.printMessage());
	}
	

}
