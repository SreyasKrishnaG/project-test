package com.bestbuy.demo.exceptions;

import static com.bestbuy.demotests.BaseTest.BaseTestClass.*;

public class HtmlElementsException extends RuntimeException {
   
	private static final long serialVersionUID = 1L;

	public HtmlElementsException() {
        super();
    }

    public HtmlElementsException(String message) {
        super(message);
        log.fatal(message);
    }

    public HtmlElementsException(String message, Throwable cause) {
        super(message, cause);
        log.fatal(message, cause);
    }

    public HtmlElementsException(Throwable cause) {
        super(cause);
        log.fatal(cause);
    }
}
