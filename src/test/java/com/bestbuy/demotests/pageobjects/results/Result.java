package com.bestbuy.demotests.pageobjects.results;

import com.bestbuy.demo.element.*;

public interface Result  {
			
	public Link image();

	public String title();
	
	public void click();
	
	public String availability();
		
}
