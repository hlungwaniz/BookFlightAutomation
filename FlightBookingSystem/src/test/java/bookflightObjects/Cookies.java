package bookflightObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cookies {
	
	WebDriver driver;
	
	@FindBy(xpath= "//button[text()=\"Accept All\"]")
	WebElement btn_accept_all;
	
	public Cookies(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void acceptAll() {
		btn_accept_all.click();
	}
}
