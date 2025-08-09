package utils;

import org.testng.annotations.DataProvider;

public class DataInjectionIntern {
	// Annotation to define a data provider named "userData"
		@DataProvider(name = "userData")
		// Method that returns a 2D array of objects
		// containing test data
		public Object[][] userData() {
			return new Object[][] {
					// First set of data: username and password
					{ "standard_user", "secret_sauce" },
					};
		}
}
