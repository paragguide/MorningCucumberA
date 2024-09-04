package testcases;

import static core.Hook.productslinks;
import static core.Hook.productsnames;
import static core.Hook.searchtxtbox;
import static core.Page.driver;
import static core.Page.report;
import static core.Page.test;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.ScreenShot2;

public class Searchproduct 
{
	boolean x = false;
	@Given("i am logged in")
	public void i_am_logged_in() 
	{
	   if(PasswordTest.login == true)
	   {
		   x = true;
		   test = report.createTest("SearchTest");
	   }
	}
	@When("^i search for (.*) in price (.*)")
	public void i_search_for_in_price(String product,int price) throws Exception 
	{
	   if(x == true)
	   {
		   searchtxtbox.clear();
			  searchtxtbox.sendKeys(product);
			  
			  Actions a = new Actions(driver);
			  a.sendKeys(Keys.ENTER).perform();
		  
	   }
	}
	@Then("get results")
	public void get_results() throws Exception 
	{
		int p1 = productsnames.size();
		 int p2 = productslinks.size();
		  
		  if(p1 > 0 && p2 > 0)
		  {
	  test.log(Status.PASS, MarkupHelper.createLabel("Product result found..", ExtentColor.GREEN));
		ScreenShot2.takeScreenshot("ProductResult");	 
		
		
		  }
		  else
		  {
		Assert.fail("No products found");	
		test.log(Status.FAIL, MarkupHelper.createLabel("NO products found..", ExtentColor.RED));
		  
		  }
	}




}
