package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By logoutLink = By.linkText("Logout");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	private By accSecHeaders = By.cssSelector("div#content h2");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.DEFAULT_TIME_OUT, AppConstants.ACC_PAGE_TITLE);
		System.out.println("Acc page title : " + title);
		return title;
	}

	public boolean getAccPageUrl() {
		String url = eleUtil.waitForUrlContains(AppConstants.DEFAULT_TIME_OUT, AppConstants.ACC_PAGE_URL_PARAM);
		System.out.println("Acc page url : " + url);
		if (url.contains(AppConstants.ACC_PAGE_URL_PARAM)) {
			return true;
		}
		return false;
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.doEleIsDisplayed(logoutLink);
	}

	public boolean isSearchExist() {
		return eleUtil.doEleIsDisplayed(search);
	}
	
	public SearchResultsPage performSearch(String productKey) {
		System.out.println("Product Key is : " + productKey);
		if(isSearchExist()) {
			eleUtil.doSendKeys(search, productKey);
			eleUtil.doClick(searchIcon);
			return new SearchResultsPage(driver);
		}
		else {
			System.out.println("search field is not present on the page.....");
			return null;
		}
	}
	
	

	public ArrayList<String> getAccSecHeadersList() {
		List<WebElement> secList = eleUtil.waitForElementsToBeVisible(accSecHeaders, AppConstants.DEFAULT_LARGE_TIME_OUT);
		System.out.println("total seactions headers: " + secList.size());
		ArrayList<String> actSecTextList = new ArrayList<String>();
		for (WebElement e : secList) {
			String text = e.getText();
			actSecTextList.add(text);
		}
		return actSecTextList;
	}

}
