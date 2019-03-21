package BrowserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager implements DriverManager{
	
	static String currentProjLocation = System.getProperty("user.dir");
	
	private WebDriver driver;
	public WebDriver getDriver() {
		
		System.setProperty("webdriver.ie.driver", currentProjLocation+"/src/test/resources/Drivers/IEDriverServer.exe");
		driver= new InternetExplorerDriver();
		return driver;
	}

	


}
