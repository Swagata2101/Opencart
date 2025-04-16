package Opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Testcase.BaseClass;

public class loginaccount extends BasePage{
	public loginaccount(WebDriver driver) {
		super(driver);}
	 @FindBy(xpath="//input[@id='input-email']")
	 WebElement txtemail;
	 @FindBy(xpath="//input[@id='input-password']")
	 WebElement pass;
	@FindBy(xpath="//input[@value='Login']")
	 WebElement loginbtn;

//Actions
public void verify_email(String email) {
	txtemail.sendKeys(email);
}
public void password(String pwd) {
	pass.sendKeys(pwd);
}
public void Click() {
	loginbtn.click();
}

}

