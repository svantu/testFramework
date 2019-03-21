package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtilities.Utilities;

public class MoodleQALandingPage {
	WebDriver driver;
	public MoodleQALandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath = ".//*[@id='page-wrapper']//button[@data-action='toggle-drawer']")
	WebElement toggleDrawer;
	@FindBy(xpath = ".//*[@id='nav-drawer']//span[text()='Private files']")
	WebElement PrivateFileTab;
	@FindBy(xpath="//a[@title='Add...']/i")
	WebElement FileUpload;
	@FindBy(name="repo_upload_file")
	WebElement BrowseToFileUpload;
	@FindBy(xpath="//button[text()='Upload this file']")
	WebElement UploadFileButton;
	
	@FindBy(xpath="//div[@class='fp-filename']")
	WebElement verifyFileUpload;

	public void clickOnToggleDrawer() {
		boolean ToggleDrawerExpanded = Boolean.parseBoolean(toggleDrawer.getAttribute("aria-expanded"));
		if (!ToggleDrawerExpanded) {
			toggleDrawer.click();
		}
	}

	public void clickOnPrivateFileTab() {
		PrivateFileTab.click();
	}
	
	public void clickOnUploadFile() {
		Utilities.asynchronousWaitUSingJavaScriptExecutor(driver);
		Utilities.clickAnElementUsingJavaScriptExecutor(driver, FileUpload);
		Utilities.asynchronousWaitUSingJavaScriptExecutor(driver);
		BrowseToFileUpload.sendKeys("C:\\Users\\Test\\Documents\\demo.log");
		UploadFileButton.click();
	}
	public void verifyFileGotUploaded() {
		Utilities.asynchronousWaitUSingJavaScriptExecutor(driver);
		Assert.assertTrue(verifyFileUpload.isDisplayed());
	}
}
