package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Locators
	private final By checkoutButton = By.id("checkout");
	private final By firstName = By.id("first-name");
	private final By lastName = By.id("last-name");
	private final By postalCode = By.id("postal-code");
	private final By continueButton = By.id("continue");
	private final By finishButton = By.id("finish");
	private final By checkoutCompletionMessage = By.cssSelector(".complete-text");
	
	private String expectedMessage = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
	
	
	public CheckoutPage checkout(String fname, String lname, String pcode) {
		
		driver.findElement(checkoutButton).click();
		
		// Checkout: Information
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(postalCode).sendKeys(pcode);
		driver.findElement(continueButton).click();
		
		// Checkout: Overview
		driver.findElement(finishButton).click();
		
		WebElement message = driver.findElement(checkoutCompletionMessage);
		
		assertEquals(message.getText(),expectedMessage,"Confirmation message mismatch");
		
		
		return this;
	}
}
