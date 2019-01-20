package com.bestbuy.demotests.pageobjects.basket;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.FindByJS;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.*;
import com.bestbuy.demotests.pageobjects.cart.Cart;
import com.bestbuy.demotests.pageobjects.checkout.SecureCheckout;

public class BasketPage extends Page {	
	
	private Cart cart;
	  
	@Name("PRODUCTS_IN_BASKET")
	@FindBy(className="prod-title-links")
	private List<HtmlElement> productList;	
	
	@Name("CHECKOUT_BUTTON")
	@FindByJS("document.getElementById('ctl00_CP_btnSubmitOrder')")
	private WebElement checkoutButton;
	
	  @Name("PROCEED_TO_CART")
	  @FindByJS("document.getElementById('proceed-to-cart')")
	  private WebElement proceedToCartButton;
	
	private final String basketPageError = "basket page is not displayed";
	private final String checkoutButtonError = "cannot click checkout button after 5 attempts";
	
	//private final String expectedUrl = "https://www-ssl.bestbuy.ca/Order/Basket.aspx";
	private final String expectedUrl = "https://www.bestbuy.ca/order/basket.aspx";
	
	public BasketPage(WebDriver driver) {
		 super(driver); 
				 
		 HtmlElementLoader.populatePageObject(this, driver);
		 
		  
		 if (urlContains(expectedUrl) == false) 			 
			 throw new HtmlElementsException(basketPageError);		 
	}
	  		
	public Cart cart() {
		return cart;
	}

	public int productCount() {		
		return productList.size();
	}
	
	public SecureCheckout checkOut() {	
		int i = 0;
		do {
			try {
				checkoutButton.click();
			}
			catch (Exception ex) {
				reload();
			}			
			i++;			 
		} while (new SecureCheckout(getDriver()).isAt() == false && i < 5);
		
		if (i == 5) 
			throw new HtmlElementsException(checkoutButtonError);		
		
		return new SecureCheckout(getDriver());
	}

}
