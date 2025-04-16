package Opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
		
	}
//locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement btn;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement btn1;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginbtn;
	//Actions
	public void myaccount() {
		btn.click();
	}
	public void resiter() {
		btn1.click();
	}
	public void login() {
		loginbtn.click();
	}
	}
