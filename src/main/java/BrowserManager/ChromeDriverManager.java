package BrowserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements DriverManager{
	
	static String currentProjLocation = System.getProperty("user.dir");
	
	private WebDriver driver;
	public WebDriver getDriver() {
		
		System.setProperty("webdriver.chrome.driver", currentProjLocation+"/src/test/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}

	


}
