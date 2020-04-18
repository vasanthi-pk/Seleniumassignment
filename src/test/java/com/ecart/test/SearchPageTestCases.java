package com.ecart.test;



import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ecart.base.ExtentTestManager;
import com.ecart.base.TestBase;
import com.ecart.pages.ProductDescriptionPage;
import com.ecart.pages.SearchPage;


public class SearchPageTestCases extends TestBase {
	
	SearchPage search;
	ProductDescriptionPage proddescr;
	public SearchPageTestCases() {
	super();
	}

	@BeforeMethod
	/*initialise browser*/
	public void setUp() {
		initialise();
		System.out.println("driver initilaised");
		search = new SearchPage();
		proddescr = new ProductDescriptionPage();
	}

	@Test(priority = 0)
	/*validate page title*/
	public void validatePageTitleTest() {
		ExtentTestManager.getTest().log(Status.INFO, "validate page title is My Store for Search Page");
		String title = search.validateSearchPageTitle();
		Assert.assertEquals(title, "My Store");
		ExtentTestManager.getTest().log(Status.INFO, "PASSED");
		
		
	}
	
	@Test(priority = 1)
	/*validate search results message for valid search items*/
	public void validateSearchBoxWithValidItemsTest() {
		ExtentTestManager.getTest().log(Status.INFO, "validate search box with valid items search");
		Boolean flag = search.validateSearchInputTextEnabled();
		Assert.assertTrue(flag);
		Boolean flag1 = search.validateSearchIconDisplayed();
		Assert.assertTrue(flag1);
		ExtentTestManager.getTest().log(Status.INFO, "search item dress");
		search.searchItemsInSearchBox(prop.getProperty("item"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		Boolean flag2 = search.validateMatchingSearchResults();
		Assert.assertTrue(flag2);
		ExtentTestManager.getTest().log(Status.INFO, "select printed summer dress from search results");
		search.selectOneFromMatchSearchResults("Printed Summer Dress");
		String title = driver.getTitle();
		ExtentTestManager.getTest().log(Status.INFO, "verifying title of the page after navigating to product description");
		Assert.assertEquals(title, "Printed Summer Dress - My Store");
		ExtentTestManager.getTest().log(Status.INFO, "test executed successfully");
	}
	
	@Test(priority = 2)
	/*validate error message for invalid search items*/
	public void validateResultsMessageForInvalidItemsTest() {
		ExtentTestManager.getTest().log(Status.INFO, "validating search query results for invalid items like abc");
		search.searchItemsInSearchBox(prop.getProperty("invaliditem"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "validating warning message for invalid item search");
		String resultsmsg = search.validateInvalidItemSearchResults();
		ExtentTestManager.getTest().log(Status.INFO, "test executed successfully");

}
	
	@Test(priority = 3)
	/*validate results message for no items in search*/
	public void validateResultsMessageForNoItemsSearch() {
		ExtentTestManager.getTest().log(Status.INFO, "validating search query with no input");
		search.searchWithoutKeywordInSearchBox();
		String resultsmsg = search.validateresultswithnoKeyword();
		System.out.println(resultsmsg);
		ExtentTestManager.getTest().log(Status.INFO, "validating warning message when no input");
		Assert.assertEquals(resultsmsg,"Please enter a search keyword");
		ExtentTestManager.getTest().log(Status.INFO, "test executed successfully");
}
	
	
//	
	@Test(priority = 4)
	/*validate tabs in search page*/
	public void validateTabsInSearchPage() {
		ExtentTestManager.getTest().log(Status.INFO, "validating tabs category in search page");
		search.validateDressesTabDisplayed();
		search.validateWomenTabDisplayed();
		search.validateTshirtsTabDisplayed();
		ExtentTestManager.getTest().log(Status.INFO, "Test Executed successfully");
				
	}
	
	@Test(priority = 5)
	/*validate click on selected item navigate to product description page*/
	public void clickOnItemsNavigateToProductDescriptionPage() {
		ExtentTestManager.getTest().log(Status.INFO, "validating select on item navigating to product description page");
		search.searchItemsInSearchBox(prop.getProperty("item"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		Boolean flag2 = search.validateMatchingSearchResults();
		Assert.assertTrue(flag2);
		ExtentTestManager.getTest().log(Status.INFO, "select one  item printed summer dress from search results");
		search.selectOneFromMatchSearchResults("Printed Summer Dress");
		String title = proddescr.validateProductDescriptionPageLoaded();
		ExtentTestManager.getTest().log(Status.INFO, "validate title of prodcut description page");
		Assert.assertEquals(title, "Printed Summer Dress - My Store");
		ExtentTestManager.getTest().log(Status.INFO, "PASSED");
		
		}
	
	
	
	@Test(priority = 6)
	/*validate shopping cart empty*/
	public void validateShoppingCartEmpty() {
		ExtentTestManager.getTest().log(Status.INFO, "validating shopping cart empty when no items added");
		String cart = search.validateshoppingcartEmpty();
		String[] empty = cart.split("[()]"); 
		String actualcartvalue = empty[1];
		Assert.assertEquals(actualcartvalue, "empty");
		ExtentTestManager.getTest().log(Status.INFO, "Test Executed successfully");
			
		}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
}
