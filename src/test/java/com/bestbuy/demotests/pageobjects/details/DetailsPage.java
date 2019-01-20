package com.bestbuy.demotests.pageobjects.details;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bestbuy.demo.annotations.FindByJS;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.pageobjects.modal.*;
import com.bestbuy.demotests.pageobjects.basket.*;
import com.bestbuy.demotests.page.*;

public class DetailsPage extends Page {
	       
  @Name("ADD_TO_CART")
  @FindByJS("document.getElementById('btn-cart')")
  private WebElement addToCartButton;
  
  @Name("PROCEED_TO_CART")
  @FindByJS("document.getElementById('proceed-to-cart')")
  private WebElement proceedToCartButton;
  
  
  private final String detailsPageError = "details page is not displayed";
  
  private final String expectedUrl = "www.bestbuy.ca/en-ca/product";
    
  public DetailsPage(WebDriver driver) {
	 super(driver); 	 	 
	 HtmlElementLoader.populatePageObject(this, driver);
	 
	 if (urlContains(expectedUrl) == false) 		
	 	 throw new HtmlElementsException(detailsPageError);
	 
	 Modal modal = new Modal(driver);
	 modal.close();
  }
  
  public BasketPage addToCart() {	  
	  addToCartButton.click();

		 //((BrowserDriver)getDriver()).waitUntilVisible(proceedToCartButton);
		 
		  proceedToCartButton.click();
	  
	  BasketPage basketPage = new BasketPage(getDriver());
	  
	  if (basketPage.cart().count() != 1 || basketPage.productCount() != 1)
		  throw new RuntimeException("product is not added to cart");
	  
	  return basketPage;
  }
  
}
