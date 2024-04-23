package parallel;


import org.junit.runner.RunWith;
import org.testng.annotations.*;
import dsutilities.configReaderr;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
      features = {"src/test/resources/parallel"},
      glue= {"parallel"},
      plugin={"pretty",
    		  "html:target/report.html",
    		  "json:target/report.json",
    		  "junit:target/report.xml",
    		  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
    		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    		  "timeline:test-output-thread/"
    		 }
)
public class TestNGRunnerNG1 extends AbstractTestNGCucumberTests
{
  @BeforeTest
  @Parameters({"browser"})
	public void defineBrowser(String browser) throws Throwable
  {
	  configReaderr.setBrowserType(browser);
  }
  @Override	
  @DataProvider(parallel = true)
  public Object[][] scenarios()
  {
	 return super.scenarios();
  }
}
