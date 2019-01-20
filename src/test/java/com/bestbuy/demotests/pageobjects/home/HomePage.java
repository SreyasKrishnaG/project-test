package com.bestbuy.demotests.pageobjects.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.TextInput;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.page.*;
import com.bestbuy.demotests.pageobjects.results.ResultsPage;

public class HomePage extends Page {
	
	private final String siteUrl = "https://www.bestbuy.com/";
	private final String expectedUrl = "www.bestbuy.com";
	private final String expectedTitle = "Best Buy";
	
	private final String homePageError = "home page is not displayed";
	
	private SearchHeader searchHeader;
	
	@Name("CLOSE")
	@FindBy(className="close")
	private WebElement closeModal;	

	public HomePage(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	public HomePage open() {		
		getDriver().get(siteUrl);		 
		
		if (!urlContains(expectedUrl) || !titleContains(expectedTitle)) 
			throw new HtmlElementsException(homePageError);
		
		

		return this;
	}		
	
	public ResultsPage search(String keyword) {
		
		if(closeModal != null)
			closeModal.click();
		
		searchHeader.search(keyword);
		
		ResultsPage resultsPage = new ResultsPage(getDriver());
		if (resultsPage.totalCount() == 0)
			throw new RuntimeException("there are no results for the search");
		
		return resultsPage;
	}
		
}
