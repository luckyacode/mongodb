package WebData.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEmp {
	Emplogic logic = new Emplogic();
	Emp e = new Emp();
	
	
	//@Ignore if write in @Test so method not execute
	//@Test(timeout=1000) auto time out
	@Test(timeout=10)
	public void getYearly(){
		e.setName("name1");
		e.setAge(34);
		e.setSalary(3000);
		int fs = logic.getYsalary(e);
		assertTrue(fs==(3000*12));
	}

}
