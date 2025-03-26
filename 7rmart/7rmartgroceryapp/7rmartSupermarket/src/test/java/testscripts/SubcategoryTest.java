package testscripts;
import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;

public class SubcategoryTest extends Base{
	LoginPage login;
	HomePage home;
	SubCategoryPage subcategory;
 @Test
 public void verifyUserIsabletoAddNewSubcategoryTest() throws IOException {
	 login=new LoginPage(driver);
	 home=login.loginUsingExceldata();
	 String subcategoryname="babydoll";
	 subcategory=home.clickOnSubcategory().clickOnNewbutton().selectCategoryField().enterSubCategoryField(subcategoryname)
	 .chooseimage().ClickOnSaveButton();
	 boolean isalertmessagedisplayed=subcategory.isalertmessagedisplayed();
	  Assert.assertTrue(isalertmessagedisplayed,Constants.sp_verifyAddNewSubcategoryTest);
 }
 @Test
 
 public void verifyUserIsabletoSearchSubcategoryTest() throws IOException {
	 LoginPage login=new LoginPage(driver);
	 login.loginUsingExceldata();
	 HomePage home=new HomePage(driver);
	 home.clickOnSubcategory();
	 SubCategoryPage subcategorypagesearch=new SubCategoryPage(driver);
	 subcategorypagesearch.clickOnSearchicon();
	 subcategorypagesearch.selectCategoryField();
	  String subcategorynameinsearch="babydoll";
	  subcategorypagesearch.enterSubCategoryField(subcategorynameinsearch);
	 subcategorypagesearch.ClickOnSearchButton();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 boolean ischeckelementinthetable=subcategorypagesearch.elementsearch();
	  Assert.assertTrue(ischeckelementinthetable,Constants.sp_verifySearchSubcategoryTest);
 }

	  @Test
	  public void verifyUserIsabletoDeleteCategory() throws IOException {
			 LoginPage login=new LoginPage(driver);
			 login.loginUsingExceldata();
			 HomePage home=new HomePage(driver);
			 home.clickOnSubcategory();
			 SubCategoryPage delete=new SubCategoryPage(driver);
			 delete.clickOnDeletebutton(); 
			
			 boolean isdeletealertdisplayed=delete.isdeletealertdisplayed();
			  Assert.assertTrue(isdeletealertdisplayed,Constants.sp_verifydeletesubcategory);
			  
		 }
	  @Test
	  public void verifyUserIsabletoupdateTheSubCategoryDetails() throws IOException
	  {
		  LoginPage login=new LoginPage(driver);
			 login.loginUsingExceldata();
			 HomePage home=new HomePage(driver);
			 home.clickOnSubcategory();
			 SubCategoryPage update=new SubCategoryPage(driver);
			 update.clickOnUpdateButtonInSubcategorytable();
			 update.selectCategorynameInUpdate();
			 String Subcategorynameinupdate="babydoll";
			 update.enterSubcategoryInUpdate(Subcategorynameinupdate);
			 update.changeImageInFileUpload();
			 update.clickUpdatebutton();
			 boolean updatealertmessage=update.updateAlertMessage();
			 Assert.assertTrue(updatealertmessage,Constants.sp_verifyupdatesubcategory);
	  }
	  public void verifyUserIsabletoclickOnDeletebutton() throws IOException
	  {
		  LoginPage lp=new LoginPage(driver);
		  lp.loginUsingExceldata();
		  HomePage home=new HomePage(driver);
		  home.clickOnSubcategory();
		  SubCategoryPage Subcategorydelete=new SubCategoryPage(driver);
		  Subcategorydelete.clickOnDeletebutton();
		  boolean deletealertmessagedisplayed=Subcategorydelete.isdeletealertdisplayed();
		  Assert.assertTrue(deletealertmessagedisplayed, Constants.sp_verifydeletesubcategory);
	  }
}
	
	
	 