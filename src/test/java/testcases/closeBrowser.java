package testcases;

import core.Hook;
import io.cucumber.java.en.When;

public class closeBrowser 
{
	@When("close browser")
	public void close_browser() 
	{
	    Hook.afterTest();
	}

}
