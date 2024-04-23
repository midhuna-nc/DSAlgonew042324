package parallel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPagesteps {
	private static String title;
	private LoginPage loginpage = new LoginPage (DriverFactory1.getDriver());
	Logger   log = (Logger) LogManager.getLogger("LoginPagesteps.java");
	
	
	@Given("user is on Login Page")
	public void user_is_on_login_page() {
		DriverFactory1.getDriver().get("https://dsportalapp.herokuapp.com/login");
		log.info("Navigated to the Login Page");
		}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginpage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
		log.info("User got the Url title");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
	    loginpage.enteruserName(userName);
	    log.debug("Username "+userName+ " is entered");
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
	   loginpage.enterpwd(pwd);
	   log.debug("Password is entered");
	}

	@When("user clicks on the Login button")
	public void user_clicks_on_the_login_button() {
	    loginpage.clickonLogin();
	    log.debug("Clicking on Login");
	}

	//Scenario outline 
	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String uName, String pPwd) {
		loginpage.UserNPwdL(uName, pPwd);
	}

	@When("User Click on Login button")
	public void user_click_on_login_button() {
		loginpage.clickonLogin();
	    log.debug("Clicking on Login");
	}

	@Then("User should navigate to HomePage with message {string}")
	public void user_should_navigate_to_home_page_with_message(String expSuccessMsg) {		
		String actualsuccessMsg = loginpage.LoginBtnSuccesMsg();
		System.out.println("Validation of message" +actualsuccessMsg);
		Assert.assertTrue(actualsuccessMsg.contains(expSuccessMsg));
		
	}

	@Then("User should see alert message {string}")
	public void user_should_see_alert_message(String string) {
		 String alerttxt = loginpage.LoginBtnAlert();
		 System.out.println("Alert Message "+alerttxt);
	   	}

	@Then("User should see Error message {string}")
	public void user_should_see_error_message(String expErrorMsg) {
	
		String actualErrorMsg = loginpage.LoginBtnError();
		System.out.println("Validation of message" +actualErrorMsg);
		Assert.assertTrue(actualErrorMsg.contains(expErrorMsg));
	}
}
