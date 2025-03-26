package testscripts;

  import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
  import org.testng.annotations.DataProvider;
  import org.testng.annotations.Test;

  import automationcore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
  public class LoginTest extends Base{
	@Test
	 public void verifyUserLoginWithValidCredential() throws IOException {
		
		LoginPage lp=new LoginPage(driver);
		
		lp.loginUsingExceldata();
		
		boolean ishomepageloaded=lp.ishomepageloaded();
		   Assert.assertTrue(ishomepageloaded,Constants.lp_verifyloginwithvalidcredential);
	}
	 @Test
	 public void  verifyWithValidUserNameAndInvalidPassword() {
		  String username="admin";
		  String password="1234";
		  LoginPage lpip=new LoginPage(driver);
		  lpip.enterUsernameonUsernamefield(username);
		  lpip.enterpassword(password);
		  lpip.Clickonlogin();
		  boolean isalertmessagedisplayed=lpip.isalertdisplayed();
		   Assert.assertTrue(isalertmessagedisplayed,Constants.lp_verifyloginwithinvalidcredential);
		  
	  }
	  @Test
	  public void  verifyWithInValidUserNameAndValidPassword() {
		  String username="adminl23";
		  String password="admin";
		  LoginPage lpvu=new LoginPage(driver);
		  lpvu.enterUsernameonUsernamefield(username);
		  lpvu.enterpassword(password);
		  lpvu.Clickonlogin();
		  boolean isalertmessagedisplayed=lpvu.isalertdisplayed();
		   Assert.assertTrue(isalertmessagedisplayed,Constants.lp_verifyWithInValidUserNameAndValidPassword);
	  }
	  @Test(dataProvider="dataprovider1")
	  public void  verifyWithInValidUserNameAndInValidPassword( String username, String password) {
		
		  LoginPage lpi=new LoginPage(driver);
		  lpi.enterUsernameonUsernamefield(username);
		  lpi.enterpassword(password);
		  lpi.Clickonlogin();
		  boolean isalertmessagedisplayed=lpi.isalertdisplayed();
		   Assert.assertTrue(isalertmessagedisplayed,Constants.lp_verifyWithInValidUserNameAndValidPassword);
	  }
	  @DataProvider(name="dataprovider1")
	  public Object[][]dataprovider()
	  {
	  
	  return new Object[][]{{"anu","123"},{"hello","12334"},{"fhgf","dcgdgf"},{"33555","ettt"}};
	}
	  
	}

  