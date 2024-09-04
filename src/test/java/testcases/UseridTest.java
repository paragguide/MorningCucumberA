package testcases;



import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UseridTest extends Hook
{
	public static boolean username = false;

	@Given("i open browser {string} and get url {string} and init report {string} for test {string}")
	public void i_open_browser_and_get_url_and_init_report_for_test(String browser, String url, String reportname, String testname)
	{
		beforeTest(browser,url,reportname,testname);
		test = report.createTest("UseridTest");
	}
	@Given("i click signin")
	public void i_click_signin() 
	{
	   signin.click();
	}
	@When("I enter valid userid {string}")
	public void i_enter_valid_userid(String usrid) 
	{
	    uid.sendKeys(usrid);
	    test.log(Status.INFO, MarkupHelper.createLabel("Enter valid userid ..", ExtentColor.BLUE));
		  
	}
	@When("click continue button")
	public void click_continue_button() 
	{
	    ctnbtn.click();
	}
	@Then("validate the outcomes")
	public void validate_the_outcomes() 
	{
		 if(err1.isDisplayed())
		  {
			  System.out.println("yes...");
			  test.log(Status.FAIL, MarkupHelper.createLabel("error coming when userid is valid..", ExtentColor.RED));
				
			  Assert.fail("error coming when userid is valid..");
			    
		  }
		  else
		  {
			  System.out.println("no...");
			  test.log(Status.PASS, MarkupHelper.createLabel("userid is valid..", ExtentColor.GREEN));
			  username = true;
		  }
		  
	}
}
