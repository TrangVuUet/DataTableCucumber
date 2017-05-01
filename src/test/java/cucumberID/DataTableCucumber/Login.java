package cucumberID.DataTableCucumber;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	WebDriver driver;

	@Given("^I am on the new user registration page$")
	public void i_am_on_the_new_user_registration_page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "E:/Geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^I enter invalid data on the page$")
	public void i_enter_invalid_data_on_the_page(DataTable table) throws Throwable {
		// Initialize data table
		List<List<String>> data = table.raw();
		System.out.println(data.get(1).get(1));

		// Enter data
		driver.findElement(By.name("firstname")).sendKeys(data.get(1).get(1));
		driver.findElement(By.name("lastname")).sendKeys(data.get(2).get(1));
		driver.findElement(By.name("reg_email__")).sendKeys(data.get(3).get(1));
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(data.get(4).get(1));
		driver.findElement(By.name("reg_passwd__")).sendKeys(data.get(5).get(1));

		Select dropdownB = new Select(driver.findElement(By.name("birthday_day")));
		dropdownB.selectByValue("15");

		Select dropdownM = new Select(driver.findElement(By.name("birthday_month")));
		dropdownM.selectByValue("6");

		Select dropdownY = new Select(driver.findElement(By.name("birthday_year")));
		dropdownY.selectByValue("1990");

		driver.findElement(By.className("_58mt")).click();
		// Click submit button driver.findElement(By.name("websubmit")).click();
	}

	@Then("^the user registration should be unsuccessful$")
	public void the_user_registration_should_be_unsuccessful() throws Throwable {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Failed");
		}
		driver.close();
	}
}