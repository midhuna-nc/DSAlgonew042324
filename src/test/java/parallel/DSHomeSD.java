package parallel;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory1;
import com.pages.DSHomePage;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	
	public class DSHomeSD {
		WebDriver driver; 
		private DSHomePage DSPage= new DSHomePage(DriverFactory1.getDriver()); 
		Logger   log = (Logger) LogManager.getLogger("DSHomePage.java");
		@Given("User is on the Data Structures Home Page")
		public void user_is_on_the_data_structures_home_page() {
		    DSPage.introPage1();
		    System.out.println("User is on DS Home page");
		}
		
		@When("User clicks the data structure dropdown arrow")
		public void user_clicks_the_data_structure_dropdown_arrow() {
			System.out.println("datastructure");
			DSPage.clickDropDown();
		}

		@Then("User should see the list of six options in the DS dropdown arrow")
		public void user_should_see_the_list_of_six_options_in_the_ds_dropdown_arrow() {
			System.out.println("datastructure");
			DSPage.dropDownOptions();
		}

		@When("User selects any DS item from dropdown without sign in")
		public void user_selects_any_ds_item_from_dropdown_without_sign_in() {
			System.out.println("datastructure");
			DSPage.clickDropdownitem(3);
			log.info("User clicks on any dropwon item list");
		}

		@Then("User should see the error message {string}")
		public void user_should_see_the_error_message(String message) {
			System.out.println("datastructure"); 
			DSPage.errorMessage();
			System.out.println("Message you get on clicking any item in Dropdown is :"+message);
		}

		@When("User clicks on GET Started button of  any DataStructures items without sign in")
		public void user_clicks_on_get_started_button_of_any_data_structures_items_without_sign_in() {
			System.out.println("User clicks any of the GetStarted buttons");
			DSPage.GetStartBtnList(2);
			log.info("User clicks on any of the get started buttons");
		}


		@When("User clicks the Register link on DS Algo Intoduction Home page")
		public void user_clicks_the_register_link_on_ds_algo_intoduction_home_page() {
		DSPage.clickRegisterLink();
		}

		@Then("User should be redirected to Register page and see the Login link at the bottom of the page")
		public void user_should_be_redirected_to_register_page_and_see_the_login_link_at_the_bottom_of_the_page() {
			DSPage.registerPage();
		}

		@When("User clicks the SignIn link on DS Algo Intoduction Home page")
		public void user_clicks_the_sign_in_link_on_ds_algo_intoduction_home_page() {
		   DSPage.clickSignInPage(); 	
		}
		@Then("User should be redirected to SignIn page and User should see the Register link at the bottom of the page")
		public void user_should_be_redirected_to_sign_in_page_and_user_should_see_the_register_link_at_the_bottom_of_the_page() {
			System.out.println("datastructure"); 
			DSPage.loginLinkPage();
		}




		
			
	}


