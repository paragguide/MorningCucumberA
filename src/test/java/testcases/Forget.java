package testcases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static core.Hook.*;

public class Forget 
{
boolean x = false;
	@Given("login is fail")
	public void login_is_fail() 
	{
	    if(PasswordTest.login == false)
	    {
	    	x = true;
	    	 test = report.createTest("Steps");
	    }
	}
	@When("i click forget link")
	public void i_click_forget_link() 
	{
	    if(x == true)
	    {
	    	forgetpwdlink.click();
			  
	    }
	}
	@When("enter recover userid")
	public void enter_recover_userid() 
	{
		forgetuid.clear();
		  forgetuid.sendKeys("paragguide@yahoo.co.in");
	}
	@Then("email should go")
	public void email_should_go() 
	{
		forgetctnbtn.click();
		  test.log(Status.INFO, MarkupHelper.createLabel("recovered pwd ..", ExtentColor.BLUE));
		  
	}

}
