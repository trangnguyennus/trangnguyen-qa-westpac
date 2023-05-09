package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driver = setupEnv();
	private LoginPage loginPage = new LoginPage(driver);
	
	private WebDriver setupEnv() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}
	
	@Given("^user1 opens the browser and goes to (.*)$")
	public void user1_opens_the_browser_and_goes_to_url(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("^user1 enters (.*) and (.*)$")
	public void user1_enters_username_and_password(String username, String password) {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
	}
	
	@And("user1 clicks login button")
	public void user1_clicks_login_button() {
		loginPage.clickLoginBtn();
	}

	@Then("user1 is able to login successfully")
	public void user1_is_able_to_login_successfully() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			loginPage.checkLogoutLinkTextDisplayed();
		} catch (Exception ex) {
			Assert.fail("An unexpected error occurred: " + ex.getMessage());
        } finally {
            // close the browser
            driver.quit();
        }
	}
}