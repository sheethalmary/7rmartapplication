package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {

	public WebDriver driver;

	PageUtility page = new PageUtility();
	WaitUtility wait = new WaitUtility();
	FileUploadUtility fileupload = new FileUploadUtility();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryfield;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryField;
	@FindBy(xpath = "//input[@name='main_img']")
	WebElement chooseimage;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessagedisplayed;

	@FindBy(xpath="//i[@class='fas fa-trash-alt']") 
	WebElement deletebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") 
	WebElement deletealertmessagedisplayed;

	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchicon;
	@FindBy(xpath="//select[@id='un']") 
	WebElement categoryfieldinsearch;
	@FindBy(xpath="//input[@name='ut']")WebElement subcategoryfieldinsearch;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td") List<WebElement>table;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement searchbutton;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=3027&page_ad=1']")WebElement updatebuttonblue;
	@FindBy(xpath="//select[@id='cat_id']")WebElement selectCategorynameupdate;
	@FindBy(xpath="//input[@id='subcategory']")WebElement subcategoryinupdate;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement choosefileinupdate;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement updatebuttonsubmit;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successfullalertsubcategoryupdate;

	public SubCategoryPage clickOnNewbutton() {
		page.javascriptclick(newbutton,driver);
		return this;
	}

	public SubCategoryPage selectCategoryField() {

		page.selectDropdownWithVisibleText(categoryfield, "Toys");
		return this;

	}

	public SubCategoryPage enterSubCategoryField(String subcategory) {

		subcategoryField.sendKeys(subcategory+page.generateCurrentDateAndTime());
		return this;

	}

	public SubCategoryPage chooseimage() {
		String filepath = Constants.imageupload;
		fileupload.fileuploadusingsendkeys(chooseimage, filepath);
		return this;
	}

	public SubCategoryPage ClickOnSaveButton() {
		page.javascriptclick(savebutton,driver);
		return this;

	}

	public boolean isalertmessagedisplayed() {

		return alertmessagedisplayed.isDisplayed();
	}

	public SubCategoryPage clickOnSearchicon() {
		page.javascriptclick(searchicon,driver);
		return this;
	}

	public SubCategoryPage selectCategoryFieldInSearch() {

		page.selectDropdownWithValue(categoryfield, "burger");
		return this;
	}

	public SubCategoryPage enterSubCategoryFieldinSearch(String subcategory) {

		subcategoryfieldinsearch.sendKeys(subcategory);
		return this;
	}

	public SubCategoryPage ClickOnSearchButton() {
		page.javascriptclick(searchbutton,driver);
		return this;

	}

	public boolean elementsearch() {
		String subcategory = "baby doll";
		boolean flag = false;
		if (table != null && !table.isEmpty()) {
			for (WebElement searching : table) {
				if (searching.getText().trim().equalsIgnoreCase(subcategory)) {
					flag = true;
					break;
				}
			}
		}

		return flag;
	}

	public SubCategoryPage clickOnDeletebutton() {
		page.javascriptclick(deletebutton, driver);
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isdeletealertdisplayed() {

		return deletealertmessagedisplayed.isDisplayed();
	}

	

	public SubCategoryPage clickOnUpdateButtonInSubcategorytable() {
		page.javascriptclick(updatebuttonblue,driver);
		
		return this;
	}

	public SubCategoryPage selectCategorynameInUpdate() {

		page.selectDropdownWithVisibleText(subcategoryfieldinsearch, "burger");
		return this;
	}

	public SubCategoryPage changeImageInFileUpload() {
		String filepath = Constants.choosefile;
		fileupload.fileuploadusingsendkeys(choosefileinupdate, filepath);
		return this;

	}

	public SubCategoryPage enterSubcategoryInUpdate(String subcategorynameinupdate) {

		subcategoryinupdate.sendKeys(subcategorynameinupdate);
		return this;
	}

	public boolean updateAlertMessage() {
		return successfullalertsubcategoryupdate.isDisplayed();

	}

	public SubCategoryPage clickUpdatebutton() {
		page.javascriptclick(updatebuttonsubmit,driver);
		return this;

	}

}
