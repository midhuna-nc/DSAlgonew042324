package parallel;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.pages.BrowserPage;
import com.qa.factory.DriverFactory1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrowserPageSteps {

	private static String title;
	private BrowserPage openpage = new BrowserPage(DriverFactory1.getDriver());
	Logger   log = (Logger) LogManager.getLogger("BrowserPageSteps.java");

	@When("User enters the DSAlgo portal URL")
	public void user_enters_the_ds_algo_portal_url() {
		openpage.OpenTheBrowserURL();
		log.info("Browser page url");
	}

	@Then("The user should landed on the DS_Algo Get Started page with message {string}")
	public void the_user_should_landed_on_the_ds_algo_get_started_page_with_message(String string) {
		openpage.BrowserURL();
		String actualBrowserPageMsg = openpage.browserPagemsg();
		System.out.println("Verify message You are at the right place ======="+actualBrowserPageMsg);
		String expBrowserPageMsg = "You are at the right place";
		title = openpage.BrowserpageTitle();
		System.out.println("Page title is" +title);
		log.info("User got the title");
		Assert.assertEquals(expBrowserPageMsg, actualBrowserPageMsg);
	}

	@Given("The user should open the DS Algo Portal URL in any supported browser")
	public void the_user_should_open_the_ds_algo_portal_url_in_any_supported_browser() {
		openpage.BrowserURL();
		String actualBrowserPageMsg = openpage.browserPagemsg();
		System.out.println("Verify message You are at the right place ======="+actualBrowserPageMsg);
		String expBrowserPageMsg = "You are at the right place";
		title = openpage.BrowserpageTitle();
		System.out.println("Page title is" +title);
		log.info("User got the title");
		Assert.assertEquals(expBrowserPageMsg, actualBrowserPageMsg);
	}

	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String getstartbtn) {
		openpage.GetStartBtnListBrowserPage(0);
	}

	@Then("The user should land in Data Structure Introduction Page with {string} and {string} links")
	public void the_user_should_land_in_data_structure_introduction_page_with_and_links(String string, String string2) {
		openpage.browserpagemsg();		
		title = openpage.homepageTitle();
		System.out.println("Home page Title is "+title);
	}
}
