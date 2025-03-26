package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutility;
import utilities.Waitutility;

public class Homepage {

	public WebDriver driver;
	public Pageutility page;
	public Waitutility wait;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	WebElement subcategorypagefolderarrow;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminuserbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")WebElement managecontactbutton;
	
	public Subcategorypage clickSubCategoryField() {
		subcategorypagefolderarrow.click();
		return new Subcategorypage(driver);
	}

	
	public Adminuserpage clickAdminUserButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", adminuserbutton);
		return new Adminuserpage(driver);
	}

	public Managecontactpage clickManageContactField() {
		managecontactbutton.click();
		return new Managecontactpage(driver);
	}

	
}