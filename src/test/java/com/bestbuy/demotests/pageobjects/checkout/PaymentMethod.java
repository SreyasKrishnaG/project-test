package com.bestbuy.demotests.pageobjects.checkout;

import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.element.Link;

@Name("SELECT_PAYMENT_METHOD")
@FindBy(id = "ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_pnlSelectPaymentMethod")
public class PaymentMethod extends HtmlElement {
	
	@Name("SELECT_CREDIT_CARD")
	@FindBy(id="ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_lnkCreditCard")
	private Link selectCreditCard;	
		
	public void selectCreditCard() {				
		selectCreditCard.click();		
	}	
	
}
