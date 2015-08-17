package uitest;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogingSuccessPageSteps {
	
	private WebDriver driver;
	private String applicationUrl = "http://localhost:8080/SmartBank/login";

	@Given("^I am in the login page$")
	public void i_am_in_the_login_page() throws Throwable {
		driver = new FirefoxDriver();
		driver.get(applicationUrl);
	}

	@When("^I try to login with ATM PIN and card number$")
	public void i_try_to_login_with_ATM_PIN_and_card_number() throws Throwable {
		driver.findElement(By.xpath("//*[@id='cardNo']")).sendKeys("3333333333333333");;
		driver.findElement(By.xpath("//*[@id='pinNo']")).sendKeys("3333");;
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();;
	}

	@Then("^login success page must be displayed$")
	public void login_success_page_must_be_displayed() throws Throwable {
		
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Options"));
		
		WebElement btn = driver.findElement(By.xpath("//*[@id='btnWithdrawal']"));
		Assert.assertNotNull(btn);
	}

}
