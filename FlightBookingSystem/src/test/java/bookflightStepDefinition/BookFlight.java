package bookflightStepDefinition;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import bookflightObjects.BookingDetails;
import bookflightObjects.Cookies;
import bookflightObjects.FlightTime;
import io.cucumber.java.en.*;

public class BookFlight {
	
	Logger logger = LogManager.getLogger(BookFlight.class);
	
	
	WebDriver driver = null;
	WebDriverWait wait;
	
	Cookies cookies;
	BookingDetails details;
	FlightTime flights;
	
	@BeforeTest
	@Given("browser is open")
	public void launchBrowser() {
		logger.info("Opening browser.");
		driver = new ChromeDriver();
		logger.info("Configuring Chrome drivers.");
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
	}

	@Test (priority = 1)
	@And("user navigate to the homepage")
	public void gotoHomePage() {
		
		driver.manage().window().maximize();
		logger.info("Navigating to home page.");
		driver.get("https://euro.expedia.net/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@Test (priority = 2)
	@When("user enters required details")
	public void enterFlightDetails() {

		details = new BookingDetails(driver);
		cookies = new Cookies(driver);
		logger.info("Accepting cookies.");
		cookies.acceptAll();
		logger.info("Clicking the flight tab.");
		details.clickFlights();
		logger.info("Clicking one way route.");
		details.clickOneWay();
		logger.info("Selecting cabin.");
		details.selectCabin();
		logger.info("Selecting departure airport.");
		details.selectOrigin();
		logger.info("Selecting arrival airport.");
		details.selectDestination();
		logger.info("Selecting date of departure.");
		details.selectDate();
	}

	@Test (priority = 3)
	@And("clicks on search flight button")
	public void searchFlights() {
		logger.info("Clicking the search button.");
		details.clickSearch();
	}

	@Test (priority = 4)
	@Then("user select best time for the flight")
	public void flightTime() throws InterruptedException {
		flights = new FlightTime(driver);
		logger.info("Sorting flights in ascending order based on time of departure.");
		flights.sortFlights();
		logger.info("Selecting the first flight on the list.");
		flights.selectFlight();
		
		//Switch to the next tab
        for(String handle1: driver.getWindowHandles()) {
        	logger.info("Switching tabs.");
            driver.switchTo().window(handle1);
        }
        logger.info("Show more details about the flight.");
        driver.findElement(By.xpath("//span[text()=\"Show details\"]")).click();
	}
	
	@AfterTest
	@Then("close browser and quit operations")
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("End session.");
		driver.close();
		driver.quit();
	}
}
