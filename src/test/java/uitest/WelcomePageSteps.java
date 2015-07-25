package uitest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WelcomePageSteps {

	private WebDriver driver;
	private String applicationUrl = "http://localhost:8090/SmartBank/";

	@Given("^this is my first attempt to access the application$")
	public void this_is_my_first_attempt_to_access_the_application() throws Throwable {
		driver = new FirefoxDriver();
	}

	@When("^I request application base url$")
	public void i_request_application_base_url() throws Throwable {
		driver.get(applicationUrl);
	}

	@Then("^welcome page must be displayed$")
	public void welcome_page_must_be_displayed() throws Throwable {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Welcome"));
	}

	@Then("^there must be bank logo on the page$")
	public void there_must_be_bank_logo_on_the_page() throws Throwable {
		WebElement image = driver.findElement(By.xpath("//*[@id='logo']"));
		Assert.assertTrue(image.isDisplayed());
	}

	@Then("^there must be basic instructions to use the application$")
	public void there_must_be_basic_instructions_to_use_the_application() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//*[@id='instructions']"));
		Assert.assertNotNull(element);
	}

	@Then("^there must be a button to BEGIN the transaction$")
	public void there_must_be_a_button_to_BEGIN_the_transaction() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//*[@id='btnBegin']"));
		Assert.assertNotNull(element);
	}
	
}
