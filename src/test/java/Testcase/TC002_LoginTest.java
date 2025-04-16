package Testcase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Opencart.HomePage;
import Opencart.MyAccountPage;
import Opencart.loginaccount;

public class TC002_LoginTest extends BaseClass{
	
	
	@Test(groups ={"Sanity","Master"})
	public void LOGIN() {
		 logger.info("********* Starting testcase2 ********");
		 try {
		 
		HomePage hp=new HomePage(driver);
		hp.myaccount();
		hp.login();

		loginaccount LA=new loginaccount(driver);
		LA.verify_email("john213@gmail.com");
		LA.password("John@21");
		LA.Click();
		MyAccountPage mp=new MyAccountPage(driver);
		boolean targetpage=mp.IsMyaccountExist();
		Assert.assertEquals(targetpage, true);
	}
		 catch(Exception e){
			 Assert.fail();
		 } }
}
		
		


	 
