package practicePackage;

import org.testng.annotations.Test;

public class DemoTest {

	@Test(groups = {"smoke", "regression"})
	public void testscript5_Test()
	{
		System.out.println("-- testscript-5 --");
		
		System.out.println("-- testscript-5 --");
	}
	
	@Test(groups = "smoke")
	public void testscript6_Test()
	{
		System.out.println("-- testscript-6 --");
		
	}
}
