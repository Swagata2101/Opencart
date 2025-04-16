package Testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.Logger;      // ✅ CORRECT
import org.apache.logging.log4j.LogManager;  // ✅ CORRECT

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Opencart.HomePage;
import Opencart.MyAccountPage;
import Opencart.loginaccount;

import Utilities.Dataprovider;

public class TC003_LoginDDT extends BaseClass {
	

	
	   private static final Logger logger = LogManager.getLogger(TC003_LoginDDT.class);

	@Test(dataProvider="Dataprovider",dataProviderClass=Dataprovider.class,groups={"Datadriven","Master"})//getting data from different class
	public void Verify_loginDDT(String email,String pwd,String exp){
		 logger.info("***** Starting Verify_loginDDT Test *****");
		    logger.info("Test data: Email = " + email + ", Password = " + pwd + ", Expected = " + exp);

		try {
		HomePage hp=new HomePage(driver);
		hp.myaccount();
		hp.login();
		 logger.info("Clicked on Login");
		
		loginaccount la=new loginaccount(driver);
		la.verify_email(email);
		la.password(pwd);
		la.Click();
		 logger.info("Entered credentials and clicked login");
		MyAccountPage MP=new MyAccountPage(driver);
		boolean targetpage=MP.IsMyaccountExist();
		MP.clicklogout();
		   if (targetpage) {
	            logger.info("Login Success: MyAccount page found.");
	        } else {
	            logger.warn("Login Failure: MyAccount page NOT found.");
	        }

		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true) {
				MP.clicklogout();
				logger.info("Logged out after successful login.");
				Assert.assertTrue(true);
			}
			else {
				logger.error("Expected login to succeed, but it failed.");
				Assert.assertTrue(false);
			}
			
		}
		if (exp.equalsIgnoreCase("Invalid")) {
            if (!targetpage) {
                logger.info("Login failed as expected for invalid credentials.");
                Assert.assertTrue(true);
            } else {
                MP.clicklogout();
                logger.error("Expected login to fail, but it succeeded.");
                Assert.assertTrue(false);
            }
        }
	}
	catch(Exception e) {
		logger.error("Exception occurred: " + e.getMessage());
		Assert.fail();
	}
		   logger.info("***** Ending Verify_loginDDT Test *****");
	}

}
