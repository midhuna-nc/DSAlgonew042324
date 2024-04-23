package parallel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.pages.RegisterPage;
import com.qa.factory.DriverFactory1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSD {
	WebDriver driver;
	Logger log = (Logger) LogManager.getLogger("RegisterSD.java");
	private RegisterPage rPage = new RegisterPage(DriverFactory1.getDriver());

	@Given("User is already in the Register page")
	public void user_is_already_in_the_register_page() {
		rPage.registerPageUrl();
		log.info("register page is opened");
	}

	@When("The user enters {string} and {string} and {string} input fields with no values")
	public void the_user_enters_and_and_input_fields_with_no_values(String UN, String PWD, String CPWD) {

		try {
			rPage.userName(UN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rPage.passWord(PWD);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			rPage.confirmPassword(CPWD);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("User enters the input fields");
	}

	@When("User clicks the register button")
	public void user_clicks_the_register_button() {
		try {
			rPage.clickReg();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("The validation message {string} appears below the input field.")
	public void the_validation_message_appears_below_the_input_field(String validmessage) {
		rPage.validationMsg();
		System.out.println("validation message :" + validmessage);
		log.info("Validation message :" + validmessage);
	}

	@When("The user enters {string} and {string} and {string} input fields with missing values")
	public void the_user_enters_and_and_input_fields_with_missing_values(String UN, String PWD, String CPWD) {
		try {
			rPage.userName(UN);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			rPage.passWord(PWD);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			rPage.confirmPassword(CPWD);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("The user enters {string} and {string} and {string} input fields with invalid values")
	public void the_user_enters_and_and_input_fields_with_invalid_values(String UN, String PWD, String CPWD) {
		try {
			rPage.userName(UN);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			rPage.passWord(PWD);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			rPage.confirmPassword(CPWD);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("The user enters {string} and {string} and {string} input fields with different values in password and confirm password textfields")
	public void the_user_enters_and_and_input_fields_with_different_values_in_password_and_confirm_password_textfields(
			String UN, String PWD, String CPWD) {
		try {
			rPage.userName(UN);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			rPage.passWord(PWD);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			rPage.confirmPassword(CPWD);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("The user should able to see warning message {string}")
	public void the_user_should_able_to_see_warning_message(String pwdmsg) {
		rPage.pwdErrMsg();
		System.out.println("Password mismatch Error Message :  " + pwdmsg);
		log.info("password_mismatch:The two password fields didn’t match.");
	}
}
