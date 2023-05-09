package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewPopularMakeTable {
	private WebDriver driver;
	private By ppl_make_card_link = By.cssSelector("a[href='/make/c4u1mqnarscc72is00ng']");
	private By table_displayed = By.xpath("//table[@class='cars table table-hover']");

	
	public ViewPopularMakeTable(WebDriver driver) {
			this.driver = driver;
		}
	
	public void clickPopularMake() {
		driver.findElement(ppl_make_card_link).click();
	}

	public void checkTableDisplayed() {
		Boolean check_table_displayed = driver.findElement(table_displayed).isDisplayed();
		Assert.assertTrue("Test failed", check_table_displayed);
	}
}