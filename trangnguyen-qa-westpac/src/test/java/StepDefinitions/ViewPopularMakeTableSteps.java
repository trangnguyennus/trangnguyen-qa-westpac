package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.ViewPopularMakeTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewPopularMakeTableSteps {
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driver = setupEnv();
	private ViewPopularMakeTable viewPopularMakeTable = new ViewPopularMakeTable(driver);
	
	private WebDriver setupEnv() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@Given("^user5 opens the browser and goes to (.*)$")
	public void user5_opens_the_browser_and_goes_to_url(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("user5 clicks on popular make card")
	public void user5_clicks_on_popular_make_card() {
		viewPopularMakeTable.clickPopularMake();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Then("^user5 is able to see a table of all models of the popular make")
	public void user5_is_able_to_see_a_table_of_all_models_of_the_popular_make() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			viewPopularMakeTable.checkTableDisplayed();
		} catch (Exception ex) {
			Assert.fail("An unexpected error occurred: " + ex.getMessage());
        } finally {
            // close the browser
        	driver.close();
            driver.quit();
        }
	}
}
	