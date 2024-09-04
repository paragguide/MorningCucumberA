package testcases;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Forget2 extends Hook
{
	@Given("i launch {string} with url {string} add report {string} on testname {string}")
	public void i_launch_with_url_add_report_on_testname(String browser, String url, String reportname, String testname) 
	{
	    beforeTest(browser,url,reportname,testname);
	}
	@When("clicked on signin link")
	public void clicked_on_signin_link() 
	{
	    
	}
	@When("clicked on forget pwd link")
	public void clicked_on_forget_pwd_link() 
	{
	    
	}
	@When("enter valid username")
	public void enter_valid_username() {
	    
	}
	@Then("send email to registered email")
	public void send_email_to_registered_email() 
	{
	    
	}

}
