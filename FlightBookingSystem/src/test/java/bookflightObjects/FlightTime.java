package bookflightObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightTime {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//div[@data-test-id='sortBar']")
	WebElement sortFlights;
	
	@FindBy(xpath = "//option[@value='DEPARTURE_INCREASING']")
	WebElement ascendingOrder;
	
	@FindBy(xpath = "//li[@data-test-id='offer-listing'][1]")
	WebElement earlyFlight;
	
	@FindBy(xpath = "//button[@stid='select-button']")
	WebElement selectFlight;
	
	public FlightTime(WebDriver driver) {	
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public void sortFlights() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id='sortBar']")));
		sortFlights.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='DEPARTURE_INCREASING']")));
		ascendingOrder.click();
	}
	
	public void selectFlight() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@data-test-id='listings']")));
		earlyFlight.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@stid='select-button']")));
		selectFlight.click();
	}
}
