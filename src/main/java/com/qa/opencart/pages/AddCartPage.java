package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class AddCartPage {
	
	String Name="iMac";
	By loc = By.id("product");
	
	public void click() {
		System.out.println("click ---" + loc);
	}

}
