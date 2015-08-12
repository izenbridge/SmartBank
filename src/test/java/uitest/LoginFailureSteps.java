package uitest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginFailureSteps {
	private WebDriver driver;
	private String applicationUrl = "http://localhost:8090/SmartBank/";

	
	
	
	@Given("^home page is available with card no and PIN input boxes$")
	public void home_page_is_available_with_card_no_and_PIN_input_boxes() throws Throwable {
		driver = new FirefoxDriver();
		driver.get(applicationUrl);
		
	}

	@When("^user clicks login button$")
	public void user_clicks_login_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id='btnBegin']")).click();
				driver.findElement(By.xpath("//*[@value='ACCESS ACCOUNT']")).click();
	}

	@Then("^show error msg stating please input card details$")
	public void show_error_msg_stating_please_input_card_details() throws Throwable {
		WebElement ele = driver.findElement(By.xpath("//*[@class='error']"));
		Assert.assertTrue(ele.isDisplayed());
		Assert.assertEquals("Invalid Debit Card number! Please enter a valid 16-digit Debit Card number", ele.getText());
	}

	/*@Given("^home page is available with card no And PIN input boxes$")
	public void home_page_is_available_with_card_no_And_PIN_input_boxes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^user provides card number (\\d+)$")
	public void user_provides_card_number(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^PIN no (\\d+)$")
	public void pin_no(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^show error msg stating INVALID user$")
	public void show_error_msg_stating_INVALID_user() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^show error msg stating please provide PIN no$")
	public void show_error_msg_stating_please_provide_PIN_no() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^user provides PIN no (\\d+)$")
	public void user_provides_PIN_no(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^show error msg stating please provide card no$")
	public void show_error_msg_stating_please_provide_card_no() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
*/
}
