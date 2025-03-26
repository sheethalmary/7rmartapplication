package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.Categorypage;
import pages.HomePage;
import pages.LoginPage;


  public class Categorytest extends Base{
	  LoginPage login;
		HomePage home;
		Categorypage category;
		
	  @Test
	  public void verifyUserIsabletocreateNewCategory() throws IOException {
		  login=new LoginPage(driver);
			 home=login.loginUsingExceldata();
			 String categoryname="Mobile";
			 category=home.clickCategoryField().clickCreateNewCategory().enterCategoryInCategoryField(categoryname).selectTheSelectGroup().clickChooseFile().clickSaveButton();
		   boolean alertmessage=category.alertmessage();
		  Assert.assertTrue(alertmessage,Constants.c_categoryadd);
	  }
	  @Test
	  public void verifyUserIsabletOSearchCategoryUsingSearchoption() throws IOException
	  {
		  login=new LoginPage(driver);
		  home=login.loginUsingExceldata();
		  String categoryname="veggies";
		  category= home.clickCategoryField().clickSearchButtonInSearch().enterCategoryInCategoryFieldsearch(categoryname).clickSubmitButtonInSearch();
		  
		  boolean search=category.elementSearchinginCategory();
		  Assert.assertTrue(search,Constants.c_categorysearch);
	  }
	  @Test
	  public void verifyUserIsabletOupdateTheCategoryField() throws IOException
	  {
		  login=new LoginPage(driver);
		  home=login.loginUsingExceldata();
		  String categorynameupdate="Mobile";
		 category=home.clickCategoryField().clickupdateTheCategory().enterCategoryInCategoryField(categorynameupdate).clicksubmitButtoninUpdate();
		 
		  boolean alertmessage=category.alertMessageInUpdate();
		  Assert.assertTrue(alertmessage,Constants.c_categoryupdate);
	  }
	  @Test
	  public void verifyUserIsabletOdeleteTheCategoryField() throws IOException
	  {
		  login=new LoginPage(driver);
		  home=login.loginUsingExceldata();
		 
		  category= home.clickCategoryField().deleteTheCategoryField();
		  boolean alertmessage=category.alertMessageInDelete();
		  Assert.assertTrue(alertmessage,Constants.c_categorydelete);
	  }
	 
	}

