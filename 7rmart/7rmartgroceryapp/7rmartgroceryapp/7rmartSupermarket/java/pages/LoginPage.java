package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class LoginPage{
	public WebDriver driver;
	public  LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}

@FindBy(xpath="//input[@name='username']")WebElement userNameField;
@FindBy(xpath="//input[@name='password']")WebElement passwordField;
@FindBy(xpath="//button[@type='submit']")WebElement loginbuttonField;
@FindBy(xpath="//span[text()='7rmart supermarket']")WebElement welcomemessage;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement incorrectmessagedisplayed;
public void enterUsernameonUsernamefield(String username)
{
	userNameField.sendKeys(username);
	
}
public void enterpassword(String password)
{
	passwordField.sendKeys(password);
	
}
public HomePage Clickonlogin()
{
	
	loginbuttonField.click();
	return new HomePage(driver);
}
public boolean ishomepageloaded()
{
	return welcomemessage.isDisplayed();
}
public boolean isalertdisplayed()
{
	return incorrectmessagedisplayed.isDisplayed();

}
public HomePage loginUsingExceldata() throws IOException {
	String username=ExcelUtility.readStringData(1,0,"LoginPage");
	String password=ExcelUtility.readStringData(1,1,"LoginPage");
	userNameField.sendKeys(username);
	passwordField.sendKeys(password);
	loginbuttonField.click();
	return new HomePage(driver);
	
	
	
	
}
}

