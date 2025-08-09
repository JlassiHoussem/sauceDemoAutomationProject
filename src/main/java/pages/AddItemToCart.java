package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemToCart {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AddItemToCart(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Locators for add item to cart
	private final By additemButton = By.id("add-to-cart-sauce-labs-backpack");
	private final By cartIcon = By.cssSelector(".shopping_cart_link");
	private final By itemName = By.cssSelector(".inventory_item_name");
	
	private String expectedItemName = "Sauce Labs Backpack";
	
	public AddItemToCart addItem() {
		
		// click on 'Add to cart' button
		driver.findElement(additemButton).click();
		
		// click on the cart icon
		driver.findElement(cartIcon).click();
		
		return this;
		
	}
	
	public AddItemToCart verifyItemInCart() {
		
		WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));
		
		// verify the item title
		
		assertEquals(itemElement.getText(),expectedItemName, "Confirmation message mistach");
		
		return this;
	}
}
