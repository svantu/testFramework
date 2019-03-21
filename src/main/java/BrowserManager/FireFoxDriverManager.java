package BrowserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManager implements DriverManager{
	private WebDriver driver;
	public WebDriver getDriver() {
		System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		return driver;
	}



}
