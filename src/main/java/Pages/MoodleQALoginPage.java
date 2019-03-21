package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoodleQALoginPage {
	
	public MoodleQALoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="login_username")
	WebElement UsernameTextField;
	
	@FindBy(id="login_password")
	WebElement PasswordTextField;
	
	@FindBy(xpath="//*[@value='Log in']")
	WebElement LoginButton;
	
	public void loginIntoMoodleQaTestApplication(String Username,String Password) {
		UsernameTextField.sendKeys(Username);
		PasswordTextField.sendKeys(Password);
		LoginButton.click();
	}

}
