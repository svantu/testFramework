package CommonUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Utilities {

	WebDriver driver;

	public static WebElement waitForAnElementUsingExplicit(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		return driver.findElement(locator);
	}

	public static WebElement waitForElementUsingFluentWait(WebDriver driver, By locator) {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).pollingEvery(2, TimeUnit.SECONDS);
		WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver webDriver) {
				// TODO Auto-generated method stub
				return webDriver.findElement(locator);
			}
		});
		return element;
	}

	public static void waitForStaleNessOfElementToGoOff(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
	}

	public static boolean alertIsPresent(WebDriver driver) {
		boolean isAlertPresent = false;
		try {
			driver.switchTo().alert();
			isAlertPresent = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isAlertPresent;
	}

	public static String takeScreenShot(WebDriver driver, String DestinationPath) throws FileNotFoundException, IOException {
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		DestinationPath = DestinationPath + ".png";
		File DestFileObj=new File(DestinationPath);
		FileUtils.copyFile(srcFile, DestFileObj);
		return DestinationPath;
	}

	public static WebElement customWait(WebDriver driver, By locator) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			try {
				WebElement	element = driver.findElement(locator);
				if (element.isDisplayed()) {
					break;
				}
			} catch (Exception e) {
				Thread.sleep(500);
			}
		}
		return driver.findElement(locator);
	}
	public static void selectAValueFromDropDownUsingVisibleText(WebDriver driver,String VisibleText,By locator) {
		Select select=new Select(driver.findElement(locator));
		select.selectByVisibleText(VisibleText);
	}
	public static void selectAVAlueFromDropDownUsingIndex(WebDriver driver,int index,By locator) {
		Select select=new Select(driver.findElement(locator));
		select.selectByIndex(index);
	}
	public static void selectAValueFRomDroDownUsingValue(WebDriver driver,String Value,By locator) {
		Select select=new Select(driver.findElement(locator));
		select.selectByValue(Value);
	}
	public static void mouseOver(WebDriver driver,WebElement element){
		Actions actObj=new Actions(driver);
		actObj.moveToElement(element).build().perform();
	}
	public static void dragAndDown(WebDriver driver,WebElement source,WebElement target) {
		Actions actObj=new Actions(driver);
		actObj.dragAndDrop(source, target).build().perform();
	}
	public static void switchToIFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public static void switchToWindow(WebDriver driver) {
		String parentWindow=driver.getWindowHandle();
		for(String window:driver.getWindowHandles()) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
			}
		}
	}
	public static void switchBetweenMultipleWindows(WebDriver driver,String PageTitle) {
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			driver.switchTo().window(window);
			if(driver.getTitle().equalsIgnoreCase(PageTitle)) {
				break;
			}
		}
	}
	public static void clickOnWebElement(WebDriver driver,By locator) {
		driver.findElement(locator).click();
	}
	public static void sendTextIntoTextField(WebDriver driver,By locator,String text) {
		driver.findElement(locator).sendKeys(text);
	}
	public static void clickAnElementUsingJavaScriptExecutor(WebDriver driver,WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	public static void asynchronousWaitUSingJavaScriptExecutor(WebDriver driver) {
		((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
	}
	
	public static void scrollToAnElementUsingJavaScriptExecutor(WebDriver driver,WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	public static void highlightAnElement(WebDriver driver,WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.background=\"pink\"", element);
	}
	public static String getAValueFromPropertyFile(String PropertyFileName,String Property) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(PropertyFileName+".properties");
		prop.load(fis);
		return prop.getProperty(Property);
	}
	
}

