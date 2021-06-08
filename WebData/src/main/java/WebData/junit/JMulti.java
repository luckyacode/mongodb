package WebData.junit;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class JMulti {
	Integer num ;
	boolean actual ;
	
	public JMulti(Integer num,boolean actual,int c)
	{
		this.num=num;
		this.actual=actual;
	}
	
	@Parameterized.Parameters
	public static Collection evenodd(){
		return Arrays.asList(new Object[][]
				{
					{2,true,1},
					{3,false,1},
					{5,false,1},
					{14,true,1},
					{22,true,1},
					{189,false,1}
				});
	}

	@Test
	public void testNow2(){
		System.out.println("Inside Testnow");
		assertEquals(actual,(num%2==0)? true:false);
	}

}
