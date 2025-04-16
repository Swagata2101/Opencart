package Testcase;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import Opencart.Accountresiter;
import Opencart.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups ={"Regression","Master"})
	void page() {
		logger.info("***** Starting test case *********");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("Clicked to MY Account");
		hp.myaccount();
		logger.info("Clicked on resiter.........");
		hp.resiter();
		logger.info("Providing Information........");
		Accountresiter repage= new Accountresiter(driver);
		repage.setfirst(randomstring());
		repage.setlast(randomstring());
		repage.settelephone(randomanumeric());
		repage.setemail(randomstring()+"@gmail.com");
		String password=randomAlphaNumeric();
		repage.setpass(password);
		repage.cnfpass(password);
		repage.click(null);
		repage.radiobtn(null);
		repage.cntinue(null);
		
	    String cnfmsg= repage.getcnfm();
	Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
	}
	catch(Exception e) 
		{
		logger.error("Test Failed");
		logger.debug("Debug log");
		Assert.fail();
		}
		
		logger.info("***** Finished test case");
	
	
}}

