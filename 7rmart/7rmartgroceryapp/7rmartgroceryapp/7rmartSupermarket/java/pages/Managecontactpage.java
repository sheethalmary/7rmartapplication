package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class Managecontactpage {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	WaitUtility wait=new WaitUtility();
	
	public Managecontactpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement updatecontactbutton;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumberfield;
	@FindBy(xpath="//input[@id='email']")WebElement emailaddressfield;
	@FindBy(xpath="//textarea[@name='address']")WebElement addressfield;
	@FindBy(xpath="//textarea[@name='del_time']")WebElement deliverytimefield;
	@FindBy(xpath="//input[@name='del_limit']")WebElement deliverychargelimitfield;
    @FindBy(xpath="//button[@name='Update']")WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmessage;
	public  Managecontactpage clickContactButton()
  {
												
		page.javascriptclick(updatecontactbutton,driver);
		return this;
	
  }
	public    Managecontactpage updatePhoneNumberInPhoneNumberField(String number)
	{
		phonenumberfield.clear();
		phonenumberfield.sendKeys(number);
		return this;
		
	}
	public  Managecontactpage  updateEmailIdInEmailId(String email)
	{
		emailaddressfield.clear();
		emailaddressfield.sendKeys(email);
		return this;
	
	}
	public   Managecontactpage updateAddressInAddress(String email)
	{
		addressfield.clear();
		addressfield.sendKeys(email);
		return this;
		
	}
	public   Managecontactpage  updateDeliveryTimeInDeliveryTime(String deliverytime)
	{
		deliverytimefield.clear();
		deliverytimefield.sendKeys(deliverytime);
		return this;
		
	}
	public   Managecontactpage updateDeliveryChargeLimitInDeliveryChargelimit(String deliverytimelimit)
	{
		deliverychargelimitfield.clear();
		deliverychargelimitfield.sendKeys(deliverytimelimit);
	return this;
	}
	public  Managecontactpage submitButtonInUpdateContact()
	{
		page.javascriptclick(updatebutton, driver);
		return this;
	
	}
	public boolean isalertpresent()
	{
		return alertmessage.isDisplayed();
	}
	}
	

	
	
											

