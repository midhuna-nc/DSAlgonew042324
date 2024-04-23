package com.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserPage {
	private WebDriver driver;

	// By locators
	By message = By.xpath("//p[contains(text(),'You are at the right place')]");
	By message1 = By.xpath("//a[text()='NumpyNinja']");
	By getStartedBtn = By.xpath("//button[text()='Get Started']");
	By dsDropD1 = By.xpath("//a[text()='Data Structures']");
	By dsMList = By.xpath("//div[@class='dropdown-menu show']/a");
	By reglink = By.xpath("//a[contains(text(),' Register ')]");
	By signinlink = By.xpath("//a[contains(text(),'Sign in')]");

	public BrowserPage(WebDriver driver) {
		this.driver = driver;
	}

	public void OpenTheBrowserURL() {
		System.out.println("User enters the DSAlgo portal URL");
	}

	public void BrowserURL() {
		driver.get("https://dsportalapp.herokuapp.com");
	}

	public String BrowserpageTitle() {
		return driver.getTitle();
	}

	public String browserPagemsg() {
		String msg = driver.findElement(message).getText();
		return msg;
	}

	public void GetStartBtnListBrowserPage(int index) {
		List<WebElement> getbtnList = driver.findElements(getStartedBtn);
		getbtnList.get(index).click();
	}

	public void browserpagemsg() {
		WebElement linkRegister = driver.findElement(reglink);
		System.out.println("Verify the Registe Link : " + linkRegister.getText());
		WebElement linkSignIn = driver.findElement(signinlink);
		System.out.println("Verify the Registe Link : " + linkSignIn.getText());
	}

	public String homepageTitle() {
		String homePTitle = driver.getTitle();
		return homePTitle;
	}
}