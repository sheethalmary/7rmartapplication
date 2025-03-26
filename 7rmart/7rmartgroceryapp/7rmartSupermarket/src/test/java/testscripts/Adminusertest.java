package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.Adminuserpage;
import pages.Categorypage;
import pages.HomePage;
import pages.LoginPage;

  public class Adminusertest extends Base{
	  LoginPage login;
		HomePage home;
		Adminuserpage adminuser;
	  @Test
	  public void verifyUserIsabletocreateNewAdminUser() throws IOException {
		 login=new LoginPage(driver);
		home=login.loginUsingExceldata();
		String username="manu";
		 String password="123456";
		adminuser = home.clickAdminUserButton().clickNewButton().enterUserNameInUserNameField(username).enterPasswordInPasswordField(password).selectUserTypeInUserTypeField().clicksubmitButton();
		  boolean alertmessage=adminuser.successfullAlertMessage();
		  Assert.assertTrue(alertmessage,Constants.ap_verifyaddadminuser);
		  
		  }
	  @Test
	  public void verifyUserIsabletosearchAdminUser() throws IOException
	  {
		  login=new LoginPage(driver);
		   home=login.loginUsingExceldata();
		   String usernamesearch="ETHELWIN";
		    adminuser=home.clickAdminUserButton().clicksearchButton().enterUserNameInUserNameFieldSearch(usernamesearch).selectUserTypeInUserTypeFieldInSearch().clicksubmitsearchButton();
		  boolean tablesearch=adminuser.elementSearchinTable();
		  Assert.assertTrue(tablesearch,Constants.ap_verifysearchadminuser);
	  }
	  @Test
	  public void verifyUserIsabletoupdateTheAdminUser() throws IOException
	  {
		  login=new LoginPage(driver);
		  home=login.loginUsingExceldata();
		  String username="RINSON";
		  adminuser=home.clickAdminUserButton().clickupdateButton().enterUserNameInUserNameFieldUpdate(username).clicksubmitButtonUpdate();
		  boolean isalertisdisplayed= adminuser.successfullAlertMessageupdate();
		  Assert.assertTrue(isalertisdisplayed,Constants.ap_verifyupdateadminuser);
	  }
	  @Test
	  public void verifyUserIsabletoclickDeleteButtonToDeleteTheAdminUser() throws IOException
	  {
		  login=new LoginPage(driver);
		  home=login.loginUsingExceldata();
		  adminuser = home.clickAdminUserButton().clickDeleteButton();
		  boolean isalertdisplayed=adminuser.successfullAlertMessageInDelete();
		  Assert.assertTrue(isalertdisplayed,Constants.ap_verifydeleteadminuser);
	  }
	  
	  
	
  }

