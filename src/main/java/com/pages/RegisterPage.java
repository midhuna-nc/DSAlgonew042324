package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
private WebDriver driver;
	
	//ByLocators
	By usernameTxtBox=By.xpath("//input[@id='id_username']");
	By pwdTxtBox=By.xpath("//input[@id='id_password1']");
	By pwdTxtBox2=By.xpath("//input[@id='id_password2']");
	By registerBox=By.xpath("//input[@value='Register']");
	By pwdErrMsg=By.xpath("//div[contains(text(),' password_mismatch:The two password fields didn’t match')]");
	By registeredName=By.xpath("//div[contains(text(),'New Account Created.')]");
    //Constructor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	public void registerPageUrl() {
		driver.get("https://dsportalapp.herokuapp.com/register");
	}
   public void userName(String UN) throws InterruptedException
   {
	   driver.findElement(usernameTxtBox).sendKeys(UN);
   }
   public void passWord(String PWD) throws InterruptedException
   {
	   driver.findElement(pwdTxtBox).sendKeys(PWD);
   }
   public void confirmPassword(String CPWD) throws InterruptedException {
	   driver.findElement(pwdTxtBox2).sendKeys(CPWD);
   }
   public String validationMsg()
   {
	   WebElement activeElement = driver.switchTo().activeElement();
	   String messageStr = activeElement.getAttribute("validationMessage");
	   return messageStr;
   }
   public String pwdErrMsg()
   {
	  String message= driver.findElement(pwdErrMsg).getText();
	  return message;
   }
   
   public void clickReg() throws InterruptedException
   { 
	   driver.findElement(registerBox).click();
   }
   public String regName()
   {
	   String regMsg=driver.findElement(registeredName).getText();
	   return regMsg;
   }
}
   
   
