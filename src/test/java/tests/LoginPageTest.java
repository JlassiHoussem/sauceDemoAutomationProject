package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInjectionIntern;

public class LoginPageTest extends BaseTest{
	
	@Test(priority= 1 ,dataProvider = "userData", dataProviderClass = DataInjectionIntern.class)
	public void loginTest(String username, String password) {
		LoginPage login = new LoginPage(driver);
		
		login.loginPage(username, password);
	}
}