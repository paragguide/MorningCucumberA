package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Page 
{
  public static WebDriver driver = null;
  
  public static ExtentReports report = null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	
  public void beforeTest(String browser,String url,String reportname,String testname) 
  {
	 
	// ...... Report init .....
		
			String path = System.getProperty("user.dir")+"//src//test//java//reports//"+reportname+".html";
			report = new ExtentReports();
			spark = new ExtentSparkReporter(path);
			
			report.attachReporter(spark);
			
			spark.config().setDocumentTitle(reportname);
			spark.config().setReportName(reportname);
			spark.config().setTheme(Theme.STANDARD);
			 test = report.createTest(testname);
			
	  
	  // driver init.....
			 
	  if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.get(url);
		
		test.log(Status.INFO, MarkupHelper.createLabel("browser "+browser+" url "+url +" opens ", ExtentColor.BLUE));
		 
		PageFactory.initElements(driver, this);  // for external xpath
		
		// implicit wait.. one time wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize(); // full screen

	 
  }

  
  public static void afterTest() 
  {
	  driver.quit();
	  report.flush() ; // close report compulsory..
  }

}
