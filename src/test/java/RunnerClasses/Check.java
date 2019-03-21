package RunnerClasses;

import org.openqa.selenium.WebDriver;

import BrowserManager.DriverManager;
import BrowserManager.DriverManagerFactory;
import BrowserManager.DriverType;

public class Check {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\Drivers\\geckodriver.exe");
		DriverManager firefox=DriverManagerFactory.getManager(DriverType.CHROME);
		WebDriver driver=firefox.getDriver();
		driver.get("https://google.com");
	}

}
