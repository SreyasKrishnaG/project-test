package com.bestbuy.demotests.pageobjects.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Link;
import com.bestbuy.demo.element.Radio;
import com.bestbuy.demo.element.TextInput;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.page.*;
import com.bestbuy.demo.utils.enumerations.*;

public class SecureCheckout extends Page {	
	
	@Name("NEW_CUSTOMERS_RADIOBTN")
	@FindBy(id="ctl00_CP_UcCheckoutSignInUC_radioButtonNew")
	private Radio guestsRadioBtn;
	
	@Name("MEMBERS_RADIOBTN")
	@FindBy(id="ctl00_CP_UcCheckoutSignInUC_radioButtonSignIn")
	private Radio membersRadioBtn;
		
	@Name("EMAIL")
	@FindBy(id="ctl00_CP_UcCheckoutSignInUC_UserNameContainer_txtUserName")
	private TextInput emailTxt;

	@Name("PASSWORD")
	@FindBy(id="ctl00_CP_UcCheckoutSignInUC_PasswordContainer_txtPassword")
	private TextInput passwordTxt;	
	
	@Name("CONTINUE_CHECKOUT")
	@FindBy(id="ctl00_CP_UcCheckoutSignInUC_btnSubmitOrder")
	private Link continueBtn;
	
	//private final String expectedUrl = "https://www-ssl.bestbuy.ca/Order/SelectCheckoutMethod.aspx";
	private final String expectedUrl = "https://www.bestbuy.ca/Order/SelectCheckoutMethod.aspx";
	
	
	private final String invalidMemberError = "invalid member type";
	private final String notEnabledError = "email and password are not enabled";
	
	public SecureCheckout(WebDriver driver) {
		 super(driver); 	 		 
		 HtmlElementLoader.populatePageObject(this, driver);		 
	}
	
	public boolean isAt() {
		return urlContains(expectedUrl);		
	} 
		
	public SecureCheckout select(MemberType type) {
		Radio radioButton;
						
		switch (type) {
			case GUEST:
						radioButton = guestsRadioBtn;
						break;
			case MEMBER:
						radioButton = membersRadioBtn;
						break;
			default:					    
					    throw new HtmlElementsException(invalidMemberError);
		}
		
		radioButton.click();		
		
		if (type == MemberType.MEMBER)
			if (!emailTxt.isEnabled() && !passwordTxt.isEnabled()) 				
				throw new HtmlElementsException(notEnabledError);			
		
		return this;
	}
		
	public SecureCheckout typeEmailPassword(String email, String password) {
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		return this;
	}
		
	public CheckOut continueCheckout() {		
		continueBtn.click();		
		return new CheckOut(getDriver());
	}		

}
