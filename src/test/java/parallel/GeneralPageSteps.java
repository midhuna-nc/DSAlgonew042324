package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map; 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.apache.poi.openxml4j.exceptions.*;
import com.pages.ArrayPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory1;

import dsutilities.ExcelReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GeneralPageSteps {
	private static String title;
	private LoginPage Loginpage = new LoginPage (DriverFactory1.getDriver());
	private ArrayPage Arraypage;
	private static String arrayCodeFile = "src\\test\\resources\\config\\Excel_Login_Pythoncode.xlsx";
	Logger   log = (Logger) LogManager.getLogger("GeneralPageSteps.java");

	@Given("User has already Logged in")
	public void user_has_already_logged_in(DataTable  dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory1.getDriver().get("https://dsportalapp.herokuapp.com/login");
		
		Arraypage = Loginpage.doLogin(username, password);
	}
	
	@Given("User is on the {string} Home Page of URL {string}")
	public void user_is_on_the_ds_algo_home_page(String expectedTitleName, String URL) {
		DriverFactory1.getDriver().get(URL);
		title = Arraypage.getPageTitle();
		Assert.assertTrue(title.contains(expectedTitleName));
		log.info("Home Page title are " + title + " and " + expectedTitleName );
	}

	@When("User clicks on Data Structures dropdown arrow")
	public void user_clicks_on_data_structures_dropdown_arrow() {
		Arraypage.DropDownClick();
		log.info("User clicked on Data Structures dropdown");
	}

	@Then("User should able to see six option in DataStructure Dropdown")
	public void user_should_able_to_see_six_option_in_data_structure_dropdown() {
		log.info("User should be able to see six options");	
	}

	@When("User clicks on the Arrays List")
	public void user_clicks_on_the_arrays_list() {
	    Arraypage.DropDownList(0);
		log.info("User has Selected Arrays option");
	}

	@Then("User should be on {string} page")
	public void user_should_be_on_array_page(String expectedTitleName) {
		title = Arraypage.getPageTitle();
		Assert.assertTrue(title.contains(expectedTitleName));
		log.info("User was able to see " + title + " page");
	}

	@When("User clicks on Get Started button index {int}")
	public void user_clicks_on_get_started_button_index(int idx ) {
	     Arraypage.GetStartBtnList(idx);
	}
	@Then("User gets the Array Topics covered")
	public void user_gets_the_array_topics_covered(DataTable dataTable) throws Exception {
		List<List<String>> topics = dataTable.asLists(String.class);
		for (List<String> topic :  topics) {
		      Arraypage.isValidTopic(topic.get(0));
			}	
	}
	@When("User clicks on Arrays in Python link")
	public void user_clicks_on_arrays_in_python_link() {
	    Arraypage.ArrayinPython();
	}

	@When("User clicks Try Here button of {string}")
	public void user_clicks_try_here_button_of(String Topic) {
	    Arraypage.try_here();
	}

	@When("The user clicks the Run button without entering the code in the Editor")
	public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor() {
	    Arraypage.runbtn();
	}

	@Then("Validate if any change in the page {string} title")
	public void validate_if_any_change_in_the_page_title(String expectedTitleName) {
		title = Arraypage.getPageTitle();
		Assert.assertTrue(title.contains(expectedTitleName));
		log.info("There was no change in the Assesment page");
	}

	@Then("The user should able to see an error message in alert window")
	public void the_user_should_able_to_see_an_error_message_in_alert_window() {
	   String expoutput = Arraypage.alertwin(); 
	   System.out.println("Alert window is : " + expoutput);
	   Arraypage.alertwin1();
	}

	@When("The user write code in Editor from sheetname {string} and rownumber {int}")
	public void the_user_write_code_in_editor_from_given_sheetname_and_rownumber(String SheetName, Integer RNum) 
		throws InvalidFormatException, IOException, InterruptedException{
			ExcelReader reader = new ExcelReader();
			List<Map<String,String>> testData = reader.getData(arrayCodeFile, SheetName);
			Thread.sleep(2000);
			String testcode = testData.get(RNum).get("pythonCode");	
			System.out.println(testcode);
			Arraypage.texteditorData(testcode);
		}
	
	@When("The user write code in PracQn Editor from sheetname {string} and rownumber {int}")
	public void the_user_write_code_inPracQn_editor_from_sheetname_and_rownumber(String SheetName, Integer RNum) 
		throws InvalidFormatException, IOException, InterruptedException{
			ExcelReader reader = new ExcelReader();
			List<Map<String,String>> testData = reader.getData(arrayCodeFile, SheetName);
			String testcode = testData.get(RNum).get("pythonCode");	
			Arraypage.copyCode(testcode);
			Arraypage.runbtn();
		}
	
	@When("Click the run button")
	public void click_the_run_button() {
	  Arraypage.runbtn();
	}

	@Then("The user should able to see output in the console {string}")
	public void the_user_should_able_to_see_output_in_the_console1(String expresult) {
	    String actualmsg = Arraypage.tryeditormsg();
	    Assert.assertEquals(actualmsg, expresult);
	}

	@Given("The user is on the {string} Home Page")
	public void the_user_is_on_the_home_page(String expectedTitleName) {
		title = Arraypage.getPageTitle();
		Assert.assertTrue(title.contains(expectedTitleName));
		log.info("User was able to see " + title + " page");
		DriverFactory1.getDriver().navigate().refresh();
	}
	@Given("The user is on the {string} page")
	public void the_user_is_on_the_page(String expectedTitleName) {
		DriverFactory1.getDriver().get("https://dsportalapp.herokuapp.com/array/practice");
		title = Arraypage.getPageTitle();
		System.out.println(title+ "=" + expectedTitleName);
		Assert.assertTrue(title.contains(expectedTitleName));
		log.info("Home Page title are " + title + " and " + expectedTitleName );
	}

	@When("User click on {string}")
	public void user_click_on(String Arr_Topic) throws Exception {
	    Arraypage.ClickTopic(Arr_Topic);
	}

	@Then("User should navigate to page that contains title {string}")
	public void user_should_navigate_to_page_that_contains_title(String title) {
		the_user_is_on_the_home_page(title);
	}

	@When("User click on {string} page")
	public void user_click_on_link(String PracQn) throws Exception {
	    Arraypage.ClickTopic1(PracQn);
	}
	
	@When("User clear the text-editor")
	public void user_clear_texteditor() throws InterruptedException{
		Arraypage.clear_texteditor();		
	}

	@Then("The user is on the {string} Page1")
	public void the_user_is_on_the_page1(String string) {
	    Arraypage.getPageTitle();
	}
	@When("User click back button and navigate to URL {string}")
	public void user_click_back_button_and_navigate_to_url(String URL) {
		DriverFactory1.getDriver().navigate().back();
		DriverFactory1.getDriver().get(URL);
	}

	@When("User click on Signout button")
	public void user_click_on_signout_button() {
		Arraypage.signoutBtn();
	}
}
