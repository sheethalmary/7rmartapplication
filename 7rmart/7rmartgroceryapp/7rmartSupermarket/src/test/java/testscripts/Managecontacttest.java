package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.Managecontactpage;


	public class Managecontacttest extends Base{
		 LoginPage login;
		 HomePage home;
		 Managecontactpage managecontact;
		  @Test
		  public void verifyUserIsAbletoUpdateTheContactDetailsInManage() throws IOException {
			  login=new LoginPage(driver);
			  home=login.loginUsingExceldata();
			  String number="9061855788";
			  String email="obsquara@gmail.com";
			  String address="infopark road ,kochi";
			  String deliverytime="31";
			  String deliverychargelimit="500";
			 
managecontact=home.clickManageContactField().clickContactButton().updatePhoneNumberInPhoneNumberField(number).updateEmailIdInEmailId(email).updateAddressInAddress(address).updateDeliveryTimeInDeliveryTime(deliverytime).updateDeliveryChargeLimitInDeliveryChargelimit(deliverychargelimit).submitButtonInUpdateContact();
			  boolean alert= managecontact.isalertpresent();
			  Assert.assertTrue(alert, Constants.mc_managecontact);
		  }
		}
  

