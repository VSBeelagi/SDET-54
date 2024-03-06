package practicePackage;

import org.testng.annotations.Test;

public class SampleTest {

	@Test(groups = {"smoke","regression"})
	public void testscript3_Test()
	{
		System.out.println("-- testscript-3 --");
	}
	
	@Test(groups = "regression")
	public void testscript4_Test()
	{
		System.out.println("-- testscript-4 --");
	}
}
