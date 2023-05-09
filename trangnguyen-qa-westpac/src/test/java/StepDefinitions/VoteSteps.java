package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.VotePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VoteSteps {
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driver = setupEnv();
	private VotePage votePage = new VotePage(driver);
	
	private WebDriver setupEnv() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@Given("^user4 opens the browser and goes to (.*)$")
	public void user4_opens_the_browser_and_goes_to_url(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user4 clicks Popular Model")
	public void user4_clicks_popular_model() {
		votePage.clickPopularModel();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Then("^user4 should not be able to vote or leave the comment about the model, and encounters (.*)$")
	public void user4_should_not_be_able_to_vote_or_leave_the_comment_about_the_model_and_encounters(String expectedMessage) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String actual_msg = votePage.getMsg();
			Assert.assertEquals(expectedMessage, actual_msg);
		} catch (Exception ex) {
			Assert.fail("An unexpected error occurred: " + ex.getMessage());
        } finally {
            // close the browser
        	driver.close();
            driver.quit();
        }
	}
}
	