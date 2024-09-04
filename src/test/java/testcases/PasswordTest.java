package testcases;

import static core.Hook.*;

import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.ScreenShot2;

public class PasswordTest 
{
	boolean x = false;
	public static boolean login = false;
	
	@Given("userid is valid")
	public void userid_is_valid() 
	{
	    if(UseridTest.username == true)
	    {
	    	x = true;
	    	test = report.createTest("PasswordTest");
	    }
	}
	@When("i enter correct password {string}")
	public void i_enter_correct_password(String pswd) 
	{
	    if(x == true)
	    {
	    	pwd.sendKeys(pswd);
	    	test.log(Status.INFO, MarkupHelper.createLabel("Enter valid passwordd ..", ExtentColor.BLUE));
	  	  
	    	submit.click();
	    }
	}
	@Then("i should login")
	public void i_should_login() throws Exception 
	{
		try {
			  err2.getText();
			  test.log(Status.FAIL, MarkupHelper.createLabel("error coming when password is valid..", ExtentColor.RED));
				
			  Assert.fail("error coming when password is valid..");
			    
			    }
			    catch(Exception e)
			    {
			  test.log(Status.PASS, MarkupHelper.createLabel("password is valid..Loged in", ExtentColor.GREEN));
			  ScreenShot2.takeScreenshot("LoginSucsess");	
			  
			  login = true;
			    }
		//afterTest() ;
	}



}
