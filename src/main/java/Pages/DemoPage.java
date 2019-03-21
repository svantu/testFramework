package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {
	
	
	@FindBy(xpath=".//*[@id='page-content']//a[text()='QA Testing Site']")
	WebElement QATestingSiteButton;
	public DemoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnQATestingButton() {
		QATestingSiteButton.click();
	}
	

}
