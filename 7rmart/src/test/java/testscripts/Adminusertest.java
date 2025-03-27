package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Constants;
import pages.Adminuserpage;
import pages.Homepage;
import pages.Loginpage;
import utilities.Pageutility;

public class Adminusertest extends Base {
	Loginpage login;
	Homepage home;
	Pageutility page = new Pageutility();
	Adminuserpage adminuser;

	@Test
	public void verifyUserIsAbleTocreateNewAdminUser() throws IOException {
		login = new Loginpage(driver);
		home = login.loginUsingExceldata();
		adminuser = home.clickAdminUserButton().clickNewButton().enterUserNameInUserNameField("Ethelwin")
				.enterPasswordInPasswordField("123456").selectUserTypeInUserTypeField().clicksubmitButton();
		boolean alertmessage = adminuser.successfullAlertMessage();
		Assert.assertTrue(alertmessage, Constants.ADM_ADMINUSERS);

	}

	@Test(groups = "smoke")
	public void verifyUserIsAbleTosearchAdminUser() throws IOException {
		login= new Loginpage(driver);
		home=login.loginUsingExceldata();
		adminuser= home.clickAdminUserButton().clicksearchButton().enterUserNameInUserNameFieldSearch("admin1233").selectUserTypeInUserTypeFieldInSearch().clicksubmitsearchButton();
		boolean tablesearch = adminuser.elementSearchinTable();
		Assert.assertTrue(tablesearch, Constants.ADM_ADMINUSERSSEARCH);
	}

	@Test
	public void verifyUserIsAbleToUpdateTheAdminUser() throws IOException {
		login= new Loginpage(driver);
		home=login.loginUsingExceldata();
       adminuser=home.clickAdminUserButton().clickupdateButton().enterUserNameInUserNameFieldUpdate("Ethelwin").clicksubmitButtonUpdate();
		boolean isalertisdisplayed = adminuser.successfullAlertMessageupdate();
		Assert.assertTrue(isalertisdisplayed, Constants.ADM_ADMINUSERSUPDATE);
	}

	@Test
	public void verifyUserIsAbleToDeleteTheAdminUser() throws IOException {
		login = new Loginpage(driver);
		home=login.loginUsingExceldata();
		adminuser=home.clickAdminUserButton().clickDeleteButton();
		boolean isalertdisplayed = adminuser.successfullAlertMessageInDelete();
		Assert.assertTrue(isalertdisplayed, Constants.ADM_ADMINUSERSDELETE);
	}

}