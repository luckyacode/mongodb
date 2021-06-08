package WebData.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Jannotation {
	
	public static void p(String s){
		System.out.println(s);
	}
	//beforeclass afterclass should be static
	@BeforeClass
	public static void beforeClass(){
			p("Before Class");
	}
	@AfterClass
	public static void afterClass(){
		p("After Class");
	}
	@Before
	public void before(){
		p("Before .");
	}
	@After
	public void after(){
		p("After .");
	}
	@Test
	public void test(){
		p("In Test");
	}
	
	@Ignore
	public void ignore(){
		p("Ignore ");
	}

}
