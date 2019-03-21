package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import BrowserManager.DriverManager;
import BrowserManager.DriverManagerFactory;
import BrowserManager.DriverType;
import CommonUtilities.Utilities;
import Pages.DemoPage;
import Pages.MoodleQALandingPage;
import Pages.MoodleQALoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefintionTest {
	WebDriver driver;
	@Given("^Login into moodle site with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void loginIntoMoodle(String Username,String Password) throws IOException {
		System.setProperty("webdriver.gecko.driver", ".src\\test\\resources\\Drivers\\geckodriver.exe");
		DriverManager dManager=DriverManagerFactory.getManager(DriverType.FIREFOX);
		driver=dManager.getDriver();
		driver.get(Utilities.getAValueFromPropertyFile("SystemProperties", "URL"));
		driver.manage().window().maximize();
		DemoPage demoPage=new DemoPage(driver);
		demoPage.clickOnQATestingButton();
		MoodleQALoginPage moodleLoginPage=new MoodleQALoginPage(driver);
		moodleLoginPage.loginIntoMoodleQaTestApplication(Username, Password);
	}
	@When("User click on PrivateFiles tab")
	public void user_click_on_PrivateFiles_tab() {
		MoodleQALandingPage moodleQALandingPage=new MoodleQALandingPage(driver);
		moodleQALandingPage.clickOnToggleDrawer();
		moodleQALandingPage.clickOnPrivateFileTab();
		moodleQALandingPage.clickOnUploadFile();
	}
	@Then("Verify file upload")
	public void verify_file_upload() {
		MoodleQALandingPage moodleQALandingPage=new MoodleQALandingPage(driver);
		moodleQALandingPage.verifyFileGotUploaded();
	}
}
