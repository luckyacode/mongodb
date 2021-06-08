package WebData.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
 
	public static void main(String[] args) {
//		System.out.println("OK");
//	      Result result = JUnitCore.runClasses(TestUnit.class);
//	      Result result = JUnitCore.runClasses(Jtest1.class);
//	      Result result = JUnitCore.runClasses(Jtest2.class);
//	      Result result = JUnitCore.runClasses(TestEmp.class);
//	      Result result = JUnitCore.runClasses(Jannotation.class);
//	      Result result = JUnitCore.runClasses(JSuit.class);
	     Result result = JUnitCore.runClasses(JMulti.class);
		  			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }
}
