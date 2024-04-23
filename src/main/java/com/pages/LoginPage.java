package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	// 1.By Locators
	By username = By.xpath("//input[@id='id_username']");
	By password = By.xpath("//input[@id='id_password']");
	By loginButton = By.xpath("//input[@type='submit']");
	By sucessmsg = By.xpath("//div[contains(text(),'You are logged in')]");
	By ErrorMsg = By.xpath("//div[contains(text(),'Invalid Username and Password')]");

	// 2.Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features of the page in form of methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enteruserName(String userName) {
		System.out.println("User : " + userName);
		driver.findElement(username).sendKeys(userName);
	}

	public void enterpwd(String pwd) {
		System.out.println("Password : " + pwd);
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickonLogin() {
		driver.findElement(loginButton).click();
	}

	public void UserNPwdL(String UN, String Pwd) {
		driver.findElement(username).sendKeys(UN);
		driver.findElement(password).sendKeys(Pwd);
	}

	// Login "You are logged in" success message
	public String LoginBtnSuccesMsg() {
		WebElement validmsg = driver.findElement(sucessmsg);
		String msgSuccess = validmsg.getText();
		System.out.println(validmsg.getText());
		return msgSuccess;
	}

	// Alert Message validation "Please fill out this field"
	public String LoginBtnAlert() {
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		System.out.println("Actual message appeared on screen: " + messageStr);
		return messageStr;
	}

	// Error message "Invalid Username and Password"
	public String LoginBtnError() {
		String errormsg = driver.findElement(ErrorMsg).getText();
		System.out.println("Expected message " + errormsg);
		return errormsg;
	}

	// Array Page login
	public ArrayPage doLogin(String un, String pwd) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		System.out.println("Logged in with username :" + un + " & password: " + pwd);
		return new ArrayPage(driver);
	}
}