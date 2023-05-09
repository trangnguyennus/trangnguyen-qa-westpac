package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	private WebDriver driver;
	private By txt_username = By.xpath("//input[@placeholder='Login']");
	private By txt_password = By.xpath("//input[@name='password']");
	private By btn_login = By.xpath("//button[text()='Login']");
	private By linktxt_logout = By.linkText("Logout");
	
	
	public LogoutPage(WebDriver driver) {
			this.driver = driver;
		}
	
	public void enterUserName(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLoginBtn() {
		driver.findElement(btn_login).click();
	}
	
	public void clickLogoutNavLink() {
		driver.findElement(linktxt_logout).click();
	}
	
	public void checkLoginBtnDisplayed() {
		driver.findElement(btn_login).isDisplayed();
	}
}