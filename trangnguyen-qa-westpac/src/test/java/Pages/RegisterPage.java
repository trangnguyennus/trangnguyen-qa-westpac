package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	private WebDriver driver;
	private By linktxt_register_login = By.linkText("Register");
	private By reg_username = By.xpath("//input[@id='username']");
	private By reg_firstName = By.xpath("//input[@id='firstName']");
	private By reg_lastName = By.xpath("//input[@id='lastName']");
	private By reg_password = By.xpath("//input[@id='password']");
	private By reg_confirmPassword = By.xpath("//input[@id='confirmPassword']");
	private By btn_register_page = By.xpath("//button[text()='Register']");
	private By err_msg_validation = By.xpath("//div[@class='result alert alert-danger']");
	
	public RegisterPage(WebDriver driver) {
			this.driver = driver;
		}
	
	public void clickRegisterLink() {
		driver.findElement(linktxt_register_login).click();
	}
	
	public void enterExistingUserName(String existingUsername) {
		driver.findElement(reg_username).sendKeys(existingUsername);
	}
	
	public void enterFirstName(String firstName) {
		driver.findElement(reg_firstName).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(reg_lastName).sendKeys(lastName);
	}
	
	public void enterValidPassword(String password) {
		driver.findElement(reg_password).sendKeys(password);
	}
	
	public void enterValidConfirmPassword(String confirmPassword) {
		driver.findElement(reg_confirmPassword).sendKeys(confirmPassword);
	}
	
	
	public void clickRegisterBtn() {
		driver.findElement(btn_register_page).click();
	}
	
	public String getErrMsgValidation() {
		return driver.findElement(err_msg_validation).getText();
	}

}