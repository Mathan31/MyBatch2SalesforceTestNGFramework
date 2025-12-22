package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import wrapper.SeleniumWrapper;

public class LoginPage extends MenuPage{
	
	private By usernameTxt = By.id("username");
	private By passwordTxt = By.id("password");
	private By loginBtn = By.id("Login");
	private By remembermeChBox = By.xpath("//label[text()='Remember me']");
	private By forgotLink = By.id("forgot_password_link");
	private By loginFailureMsg = By.cssSelector("#error");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public LoginPage(WebDriver driver,ExtentTest node) {
		super(driver,node);
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean verifyLoginElements() {
		
		if(oWrap.verifyDisplayedwithReturn(driver.findElement(usernameTxt), "UserName") &&
				oWrap.verifyDisplayedwithReturn(driver.findElement(passwordTxt), "Password") &&
				oWrap.verifyDisplayedwithReturn(driver.findElement(loginBtn), "Login Button")) {
			return true;
		} else {
			return false;
		}
	}

	public LoginPage enterUserName(String userName) {
		oWrap.type(driver.findElement(usernameTxt), userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		oWrap.type(driver.findElement(passwordTxt), password);
		return this;
	}
   
	public HomePage clickOnLogin() {
		oWrap.click(driver.findElement(loginBtn), "LoginButton");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage(driver,node);
	}

	public LoginPage clickOnLoginWithInvalidCredential() {
		oWrap.click(driver.findElement(loginBtn), "LoginButton");
		return this;
	}

	public boolean validateErrorMsg() {
		if(oWrap.verifyDisplayedwithReturn(driver.findElement(loginFailureMsg), "Credential Failure")){
			return true;
		} else {
			return false;
		}
	}

}
