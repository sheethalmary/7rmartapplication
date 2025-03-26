package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	public PageUtility page;
	public WaitUtility wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")WebElement subcategorybutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")WebElement categorypagefolderarrow;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adminuserbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']") WebElement managecontactbutton;
public SubCategoryPage clickOnSubcategory(){
subcategorybutton.click();
return new SubCategoryPage(driver);

}
public Adminuserpage clickAdminUserButton() {
	
	 JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",adminuserbutton);
		return new Adminuserpage(driver);
	
}
public Managecontactpage clickManageContactField() {
	managecontactbutton.click();
	return new Managecontactpage(driver);
	
}
public Categorypage clickCategoryField()
{
	categorypagefolderarrow.click();
	
   return new Categorypage(driver);
}

	
}


