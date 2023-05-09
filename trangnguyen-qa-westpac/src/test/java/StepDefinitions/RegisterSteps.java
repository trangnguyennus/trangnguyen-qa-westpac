package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driver = setupEnv();
	private RegisterPage registerPage = new RegisterPage(driver);
	
	private WebDriver setupEnv() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}
	
	@Given("^user3 opens the browser and goes to (.*)$")
	public void user3_opens_the_browser_and_goes_to_url(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("user3 clicks register link")
	public void user3_clicks_register_link() {
		registerPage.clickRegisterLink();
	}

	@When("^user3 enters existingUsername (.*)$")
	public void user3_enters_existingUsername(String existingUsername) {
		registerPage.enterExistingUserName(existingUsername);
	}

	@And("^user3 enters firstName (.*)$")
	public void user3_enters_valid_firstName(String firstName) {
		registerPage.enterFirstName(firstName);
	}
	
	@And("^user3 enters lastName (.*)$")
	public void user3_enters_valid_lastName(String lastName) {
		registerPage.enterLastName(lastName);
	}
	
	@And("^user3 enters valid password (.*)$")
	public void user3_enters_valid_password(String password) {
		registerPage.enterValidPassword(password);
	}
	
	@And("^user3 enters valid confirmPassword (.*)$")
	public void user3_enters_valid_confirmPassword(String confirmPassword) {
		registerPage.enterValidConfirmPassword(confirmPassword);
	}
	
	@And("user3 clicks register button")
	public void user3_clicks_register_button () {
		registerPage.clickRegisterBtn();
	}	
	
	@Then("^user3 encounters the errmsg (.*)$")
	public void user3_encounters_the_errmsg(String expectedErrMsgValidation) {
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				String actual_err_msg_validation = registerPage.getErrMsgValidation();
				Assert.assertEquals(expectedErrMsgValidation, actual_err_msg_validation);
			} catch (Exception ex) {
				Assert.fail("An unexpected error occurred: " + ex.getMessage());
	        } finally {
	            // close the browser
	        	driver.close();
	            driver.quit();
	        }
		}

}