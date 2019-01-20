package com.bestbuy.demotests.pageobjects.cart;

import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;

@Name("NAVIGATION_CART")
@FindBy(className="navigation-cart-button")
public class Cart extends HtmlElement{
	
	@Name("CART_COUNT")
	@FindBy(className="navigation-cart-quantity")
	private HtmlElement cartCount;

	public int count() {
		try {
			return Integer.parseInt(cartCount.getText());
		}
		catch (Exception ex) {
			return 0;
		}		
	}
	
}
