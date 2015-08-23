/**
 * 
 */
package uitest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author sahuja
 *
 */
public class LoginHomePageSteps {

	
	private WebDriver driver;
	private String applicationUrl = "http://localhost:8080/SmartBank/";
	
	@Given("^I am on the welcome page$")
	public void i_am_on_the_welcome_page() throws Throwable {
		driver = new FirefoxDriver();
		driver.get(applicationUrl);
	}

	@When("^I click on BEGIN button$")
	public void i_click_on_BEGIN_button() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//*[@id='btnBegin']"));
		element.click();
		
		
	}

	@Then("^Login Home page must be displayed$")
	public void login_Home_page_must_be_displayed() throws Throwable {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("ATM Login"));
	}

	@Then("^there must be text field to enter Debit Card Number$")
	public void there_must_be_text_field_to_enter_Debit_Card_Number() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//*[@id='debitCardNumber']"));
		Assert.assertNotNull(element);
	}

	@Then("^there must be password field to enter the password$")
	public void there_must_be_password_field_to_enter_the_password() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//*[@id='atmPin']"));
		Assert.assertNotNull(element);
	}

	@Then("^there must be a button to Submit the details$")
	public void there_must_be_a_button_to_Submit_the_details() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//*[@value='ACCESS ACCOUNT']"));
		Assert.assertNotNull(element);
	}
	
	@After
	public void teardown(){
		driver.close();
	}
	
}
