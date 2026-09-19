package com.test.utils;

public enum Browser {

	CHROME("chrome"),
	EDGE("edge"),
	FIREFOX("firefox");
	
	final String browserName;
	
	Browser(String browserName){
		this.browserName=browserName;
	}
	
	public String getBrowserName() {
		return browserName;
	}
	
}
