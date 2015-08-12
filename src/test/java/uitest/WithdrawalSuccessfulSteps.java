package uitest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WithdrawalSuccessfulSteps {
	
	private WebDriver driver;
	private String applicationUrl = "http://localhost:8090/SmartBank/";
	
	@Given("^I am logged in$")
	public void i_am_logged_in() throws Throwable {
		driver = new FirefoxDriver();
	    driver.get(applicationUrl);
	    driver.findElement(By.id("btnBegin")).click();
	    driver.findElement(By.id("debitCardNumber")).sendKeys("3333333333333333");
	    driver.findElement(By.id("atmPin")).sendKeys("3333");
	    driver.findElement(By.xpath("//input[@value=\"ACCESS ACCOUNT\"]")).click();
	}

	@When("^I am on Withdrawal Options Page$")
	public void i_am_on_Withdrawal_Options_Page() throws Throwable {
	    Assert.assertEquals("ATM Options - SmartBank ATM", driver.getTitle());
	    //throw new PendingException();
	}

	@Then("^Withdrawal Button should be displayed$")
	public void withdrawal_Button_should_be_displayed() throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value=\"WITHDRAWAL\"]")).isDisplayed()); 
	    //throw new PendingException();
	}

	@When("^I click on Withdrawal Button$")
	public void i_click_on_Withdrawal_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Cash Withdrawal Page should be displayed$")
	public void cash_Withdrawal_Page_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^I am on Cash Withdrawal Page$")
	public void i_am_on_Cash_Withdrawal_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^I enter (\\d+) in Amount to Withdraw text box$")
	public void i_enter_in_Amount_to_Withdraw_text_box(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I click on Withdraw Button$")
	public void i_click_on_Withdraw_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^ATM Options Page is displayed$")
	public void atm_Options_Page_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
