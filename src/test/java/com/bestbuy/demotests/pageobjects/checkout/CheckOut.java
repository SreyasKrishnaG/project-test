package com.bestbuy.demotests.pageobjects.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bestbuy.demo.annotations.FindByJS;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.page.*;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demo.exceptions.HtmlElementsException;

public class CheckOut extends Page {

	private ShipTo shipTo;
	private PaymentMethod paymentMethod;	
	private PaymentDetails paymentDetails;
	private Errors errors;
	
	//private final String expectedUrl = "https://www-ssl.bestbuy.ca/Order/Checkout.aspx";
	private final String expectedUrl = "https://www.bestbuy.ca/Order/Checkout.aspx";
	
	
	private final String checkoutPageError = "user info checkout is not displayed";
	
	@Name("CONTINUE")
	@FindByJS("document.getElementById('ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_btnContinueFromShipping')")
	private WebElement continueButton;
	
	@Name("SUBMIT")
	@FindByJS("document.getElementById('ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_BtnContinueFromPayment')")
	private WebElement submitButton;
	
	@Name("CHECK_SAME_AS_SHIPPING")
	@FindByJS("document.getElementById('ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_UCEditCreditCard_ChkSameAsShipping')")
	private WebElement sameAsShippingButton;
	
	public CheckOut(WebDriver driver) {
		 super(driver); 
		 		 
		 HtmlElementLoader.populatePageObject(this, driver);
		 
		 if (urlContains(expectedUrl) == false) 
			 throw new HtmlElementsException(checkoutPageError);		 
	}	
		
	public ShipTo shipTo() {
		return shipTo;	
	}
		
	public PaymentMethod paymentMethod() {				
		return paymentMethod;
	}
		
	public PaymentDetails paymentDetails() {				
		return paymentDetails;
	}
		
	public Errors errors() {				
		return errors;
	}

	public void continueToPayment() {		
		continueButton.click();
		((BrowserDriver)getDriver()).waitUntilVisible(paymentMethod);		
	}
		
	public void checkSameAsShipping() {				
		sameAsShippingButton.click();
	}
		
	public void submitPayment() {		
		submitButton.click();
	}	
	
}
