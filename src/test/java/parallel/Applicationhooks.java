package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory1;

import dsutilities.configReaderr;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Applicationhooks {

	private DriverFactory1 driverFactory;
	private WebDriver driver;
	private configReaderr configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new configReaderr();
		prop = configReader.init_prop();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory1();
		driver = driverFactory.init_driver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
		//take screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte [] sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}
