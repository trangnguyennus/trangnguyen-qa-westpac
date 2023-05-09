package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VotePage {
	private WebDriver driver;
	private By img_link = By.cssSelector("a[href='/model/c4u1mqnarscc72is00ng|c4u1mqnarscc72is00sg']");
	private By txt_msg = By.xpath("//p[@class='card-text']");
	
	public VotePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickPopularModel() {
		driver.findElement(img_link).click();
	}
	
	public String getMsg() {
		return driver.findElement(txt_msg).getText();
	}
}