package dsutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReaderr {

	private Properties prop;
	private static String browserType;

	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static String getBrowser(String Browser) {
		if (browserType != null)
			return Browser;
		else
			throw new RuntimeException("Incorrect browser");
	}

	public static void setBrowserType(String Browser) {
		browserType = Browser;
	}

	public static String getBrowserType() throws Throwable
	{
		if (browserType != null)
			return browserType;
		else
			throw new RuntimeException("browser not specified in the testng.xml");
	}
}
