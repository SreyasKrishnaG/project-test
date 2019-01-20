package com.bestbuy.demotests.pageobjects.results;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.*;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.utils.enumerations.*;

import static com.bestbuy.demotests.BaseTest.BaseTestClass.*;


/* implements the list of results */
@Name("SEARCH_RESULTS")
@FindBy(id="ctl00_CC_ProductSearchResultListing_SearchProductListing")
public class SearchResults extends HtmlElement {
	
	@Name("RESULTS")
	@FindBy(xpath = "//li[contains(@class,'listing-item')]")
	private List<SearchResult> results;
	
	private final String filteredListError = "filtered results list is empty";
			
	public SearchResult get(int index) {
		return results.get(index);				 
	}
	
	public int count() {
		return results.size();				 
	}
	
	public List<SearchResult> filterBy(Availability status) {													
		List <SearchResult> list = results.stream()
				                          .filter(condition(status))
				                          .collect(Collectors.<SearchResult>toList());
		
		if (list.size() == 0) 
			throw new HtmlElementsException(filteredListError);		
		
		return list;			
	}
	
	private Predicate<SearchResult> condition(Availability status) {		
		return p -> p.availability().equalsIgnoreCase(status.toString());
	}
}
