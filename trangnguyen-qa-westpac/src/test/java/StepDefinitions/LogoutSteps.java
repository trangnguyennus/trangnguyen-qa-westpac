package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.LogoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driver = setupEnv();
	private LogoutPage logoutPage = new LogoutPage(driver);
	
	private WebDriver setupEnv() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}
	
	@Given("^user2 opens the browser and goes to (.*)$")
	public void user2_opens_the_browser_and_goes_to_url(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("^user2 enters (.*) and (.*)$")
	public void user2_enters_username_and_password(String username, String password) {
		logoutPage.enterUserName(username);
		logoutPage.enterPassword(password);
	}
	
	@And("user2 clicks login button")
	public void user2_clicks_login_button() {
		logoutPage.clickLoginBtn();
	}

	@When("user2 clicks logout navigation link")
	public void user2_clicks_logout_navigation_link() {
		logoutPage.clickLogoutNavLink();
	}
	
	@Then("user2 is able to logout successfully")
	public void user2_is_able_to_logout_successfully() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			logoutPage.checkLoginBtnDisplayed();
		} catch (Exception ex) {
			Assert.fail("An unexpected error occurred: " + ex.getMessage());
        } finally {
            // close the browser
            driver.quit();
        }
	}
}