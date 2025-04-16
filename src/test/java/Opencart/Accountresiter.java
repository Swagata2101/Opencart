package Opencart;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Accountresiter extends BasePage{
	WebDriver driver;
	public Accountresiter(WebDriver driver){
		super(driver);}
	//Locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cnfmpass;
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement subscribe;
	@FindBy(xpath="//input[@name='agree']")
	WebElement policy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement cont;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement getconfirmation;
	//Actions
	public void setfirst(String user) {
		firstname.sendKeys(user);
	}
	public void setlast(String user) {
		lastname.sendKeys(user);
	}
	public void setemail(String user) {
		email.sendKeys(user);
	}
	public void settelephone(String user) {
		telephone.sendKeys(user);
	}
	public void setpass(String user) {
		password.sendKeys(user);
	}
	public void cnfpass(String user) {
		cnfmpass.sendKeys(user);
	}
	public void click(String user) {
		subscribe.click();
	}
	public void radiobtn(String user) {
		policy.click();
	}
	public void cntinue(String User) {
		cont.click();
	}
	
	public String getcnfm() {
		try {
			return (getconfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
	
}
