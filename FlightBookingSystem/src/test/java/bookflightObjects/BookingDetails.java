package bookflightObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingDetails {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(linkText = "Flights")
	WebElement tab_flights;
	
	@FindBy(linkText = "One-way")
	WebElement tab_oneway;
	
	@FindBy(xpath = "//button[@id='cabin_class']")
	WebElement cabin_class;
	
	@FindBy(xpath = "//button[@class='uitk-list-item'][1]")
	WebElement cabin;
	
	@FindBy(xpath = "//div[@id='origin_select-menu']")
	WebElement origin_select;
	
	@FindBy(xpath = "//div[@id='destination_select-menu']")
	WebElement destination_select;
	
	@FindBy(xpath = "//div[@class='uitk-date-picker-menu uitk-menu uitk-menu-mounted']")
	WebElement dt_date;
	
	@FindBy(xpath = "//button[@id='search_button']")
	WebElement btn_search;
	
	public BookingDetails(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlights() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Flights")));
		tab_flights.click();
	}
	
	public void clickOneWay() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("One-way")));
		tab_oneway.click();
	}
	
	public void selectCabin() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='cabin_class']")));
		cabin_class.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='uitk-list-item'][1]")));
		cabin.click();
	}
	
	public void selectOrigin() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='origin_select-menu']")));
		origin_select.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='origin_select']")));
		driver.findElement(By.xpath("//input[@id='origin_select']")).sendKeys("O.R. Thambo");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Johannesburg (JNB - O.R. Tambo Intl.) South Africa']")));
		driver.findElement(By.xpath("//button[@aria-label='Johannesburg (JNB - O.R. Tambo Intl.) South Africa']")).click();
		
	}
	
	public void selectDestination() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='destination_select-menu']")));
		destination_select.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='destination_select']")));
		driver.findElement(By.xpath("//input[@id='destination_select']")).sendKeys("CPT");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Cape Town (CPT - Cape Town Intl.) South Africa']")));
		driver.findElement(By.xpath("//button[@aria-label='Cape Town (CPT - Cape Town Intl.) South Africa']")).click();
		
	}
	
	public void selectDate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uitk-date-picker-menu uitk-menu uitk-menu-mounted']")));
		dt_date.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='31 Aug 2023']")));
		driver.findElement(By.xpath("//button[@aria-label='31 Aug 2023']")).click();
		driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click();
	}
	
	public void clickSearch() {
		btn_search.click();
	}
}
