package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

 import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
protected static WebDriver driver;
	
	@Parameters({"browserType", "url"})
	@BeforeTest
	public void setUp(@Optional("chrome")String browserType, String url) {
		ChromeOptions options = new ChromeOptions();
options.addArguments("--headless=new"); // important pour Chrome 109+
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
options.addArguments("--window-size=1920,1080"); // remplace maximize()

driver = new ChromeDriver(options);

		switch(browserType.toUpperCase()) {
		
		case "CHROME":
			driver = new ChromeDriver();
			break;
			
		case "EDGE":
			driver = new EdgeDriver();
			break;
		}
		
		
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
