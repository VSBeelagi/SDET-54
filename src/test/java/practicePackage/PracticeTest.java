package practicePackage;

import org.testng.annotations.Test;

public class PracticeTest {
	@Test(groups = "smoke")
	public void testscript1_Test()
	{
		System.out.println("-- testscript-1 --");
		
	}
	
	@Test
	public void testscript2_Test()
	{
		System.out.println("-- testscript-2 --");
		
	}
}
