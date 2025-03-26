package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class Categorypage {
	
		public WebDriver driver;
		 PageUtility page=new  PageUtility() ;
	     WaitUtility wait =new  WaitUtility();
	     FileUploadUtility fileupload = new FileUploadUtility();
		public Categorypage(WebDriver driver)
		{
			 this.driver = driver;    
			PageFactory.initElements(driver,this);
			
		}
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")WebElement createnewcategorybutton;
		@FindBy(xpath="//input[@id='category']")WebElement categoryfield ;
		@FindBy(xpath="//li[@id='134-selectable']") WebElement selectgroupdiscountdraganddrop1 ;
		@FindBy(xpath="//li[@id='134-selection']") WebElement selectgroupdiscountdraganddrop2;
		@FindBy(xpath="//input[@id='main_img']") WebElement choosefile;
		@FindBy(xpath="//button[@class='btn btn-danger']") WebElement savebutton;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmessage;
		@FindBy(xpath="//i[@class='fa fa-search']") WebElement searchbutton;
		@FindBy(xpath="//input[@class='form-control']") WebElement categoryfieldinsearch;
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[1]") List <WebElement>elementsearch;
		@FindBy(xpath="//button[@type='submit']") WebElement searchsubmitbutton;
		@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']") WebElement updatebutton;
		@FindBy(xpath="//input[@id='category']") WebElement categoryfieldinupdate;
		@FindBy(xpath="//button[@type='submit']") WebElement submitbuttonupdate;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successfullalertinupdate;
		@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']") WebElement deletebuttonincategory;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successfullalertindelete;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement resetbutton;
		
		public Categorypage clickCreateNewCategory()
		{
			page.javascriptclick(createnewcategorybutton, driver);
			return this;
			
		}
		public Categorypage enterCategoryInCategoryField(String newcategory)
		{
			categoryfield.sendKeys(newcategory+page.generateCurrentDateAndTime());
			return this;
		}
		public Categorypage selectTheSelectGroup()
		{
			
			page.javascriptclick(selectgroupdiscountdraganddrop1, driver);
			return this;
			
			
		}
		public Categorypage clickChooseFile()
		{
			String filepath = Constants.choosefile;
			fileupload.fileuploadusingsendkeys(choosefile, filepath);
			return this;
			
			
		}
		public  Categorypage clickSaveButton()
		{
		
			page.javascriptclick(savebutton,driver);
			return this;
			
		}
		
		
		public boolean alertmessage()
		{
			
			return alertmessage.isDisplayed();
		}
		public Categorypage clickSearchButtonInSearch()
		{  
			page.javascriptclick(searchbutton,driver);
			return this;
			
			
		}
		
		public Categorypage enterCategoryInCategoryFieldsearch(String category)
		{
			categoryfieldinsearch.sendKeys(category+page.generateCurrentDateAndTime());
			return this;
		}
		public Categorypage clickSubmitButtonInSearch()
		{  
	         page.javascriptclick(searchsubmitbutton,driver);
	         return this;
		}
		public boolean elementSearchinTable()
		{
			 return ((WebElement) elementsearch).isDisplayed();
		}
		public boolean elementSearchinginCategory() {
		    String categorysearch ="Mobile";
		    boolean flag = false;
		      if (elementsearch != null && !(elementsearch). isEmpty()) {
		    	  for (WebElement searching : elementsearch) 
		        {
		            if (searching.getText().trim().equalsIgnoreCase(categorysearch)) {
		                flag = true;
		                break;
		            }
		        }
		    }
		    
		    return flag;
		}
		public Categorypage clickupdateTheCategory()
		{
			 page.javascriptclick(updatebutton, driver);
			return this;
			 
		}
		public Categorypage enterCategoryFieldinUpdate(String categoryfieldupdate)
		{
			
			categoryfieldinupdate.sendKeys(categoryfieldupdate);
			return this;
			
		}
		public Categorypage clicksubmitButtoninUpdate()
		{
			page.javascriptclick(submitbuttonupdate, driver);
			return this;	
			}
		public boolean alertMessageInUpdate()
		{
			
			return successfullalertinupdate.isDisplayed();
		}
		public Categorypage deleteTheCategoryField()
		{
			
			page.javascriptclick(deletebuttonincategory, driver);
			driver.switchTo().alert().accept();
			return this;
			
		}
		
		public boolean alertMessageInDelete()
		{
			return successfullalertindelete.isDisplayed();
		}
		
		}


