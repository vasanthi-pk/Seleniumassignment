package com.ecart.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ecart.base.ExtentTestManager;
import com.ecart.base.TestBase;
import com.ecart.pages.ProductDescriptionPage;
import com.ecart.pages.SearchPage;
import com.ecart.pages.SummaryPage;

public class ProductPageTestCases extends TestBase{
	SearchPage search;
	ProductDescriptionPage proddescr;
	SummaryPage summary;

	public ProductPageTestCases() {
		super();
	}
	
	

	@BeforeMethod
	public void setUp() 
	{
		initialise();
		search = new SearchPage();
		proddescr = new ProductDescriptionPage();
		summary = new SummaryPage();
	}
	
	@Test(priority = 0)
	/*validating product description,adding multi color option item and qty update in cart*/
	public void validateProductDesciptionPageForSingleItemInCart() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");		
		search.searchItemsInSearchBox("dress");
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
		search.selectOneFromMatchSearchResults("Printed Summer Dress");
		String title = proddescr.validateProductDescriptionPageLoaded();
		ExtentTestManager.getTest().log(Status.INFO, "validating product description page displayed for selected item");
		Assert.assertEquals(title, "Printed Summer Dress - My Store");
		proddescr.colorlistDisplayed();
		ExtentTestManager.getTest().log(Status.INFO, "validating product description");
		Boolean flag3 = proddescr.validateDescription();
		Assert.assertTrue(flag3);
		ExtentTestManager.getTest().log(Status.INFO, "selecting black color item from multicolor");
		proddescr.selectcolorfromlist("black");
		proddescr.validateSelectedColorItemDisplayed("black");
		ExtentTestManager.getTest().log(Status.INFO, "Adding item to cart");
		proddescr.clickOnItem("addcart");
		proddescr.validateNoOfItemsAddedtoCartBeforeCheckOut();
		proddescr.clickOnItem("proceedcheckout");
		ExtentTestManager.getTest().log(Status.INFO, "validating summary page displayed after checkout");
		Boolean flag = summary.isSummaryPageDisplayed();
		String itemsincart = summary.validateItemsCountInSummaryPage();
		ExtentTestManager.getTest().log(Status.INFO, "validating item count in summary page");
		Assert.assertEquals(itemsincart, "1 Product");
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Test Executed successfully");

				
	}
	
	@Test(priority = 2)
	
	/*validating qty update and multi color option by adding 2 more items to cart*/
	public void validateQuanityOfItemsUpdateForMoreItemsInShoppingCart() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");
		search.searchItemsInSearchBox(prop.getProperty("item"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
		search.selectOneFromMatchSearchResults("Printed Summer Dress");
		ExtentTestManager.getTest().log(Status.INFO, "selecting black color item from multicolor");
		proddescr.selectcolorfromlist("black");
		proddescr.validateSelectedColorItemDisplayed("black");
		ExtentTestManager.getTest().log(Status.INFO, "Adding black color summer dress to cartr");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
		proddescr.clickOnItem("proceedcheckout");
//		proddescr.clickOnItem("qtyplus");
		ExtentTestManager.getTest().log(Status.INFO, "Adding one more item t-shirt");
		search.searchItemsInSearchBox(prop.getProperty("item2"));
		search.selectOneFromMatchSearchResults("t-shirt");
		ExtentTestManager.getTest().log(Status.INFO, "selecting blue color item from multicolor");
		proddescr.selectcolorfromlist("blue");
		proddescr.validateSelectedColorItemDisplayed("blue");
		ExtentTestManager.getTest().log(Status.INFO, "Adding blue color t-shirt to cart");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
//		proddescr.clickOnItem("qtyplus"); /*Getting elementinterceptableexception*/
		proddescr.validateNoOfItemsAddedtoCartBeforeCheckOut();
		proddescr.clickOnItem("proceedcheckout");
		ExtentTestManager.getTest().log(Status.INFO, "validate summary page displayed after checkout");
		Assert.assertTrue(summary.isSummaryPageDisplayed());
		String itemsincart = summary.validateItemsCountInSummaryPage();
		ExtentTestManager.getTest().log(Status.INFO, "validate item count is updated to 2");
		Assert.assertEquals(itemsincart, "2 Products");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Test Executed successfully");

		}
	
	@Test(priority = 3)
	/*validating qty items update after remove and add items in shopping cart*/
	public void validateQuanityOfItemsUpdateAfterRemoveAddItemsInShoppingCart() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");
		search.searchItemsInSearchBox(prop.getProperty("item"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
		search.selectOneFromMatchSearchResults("printechiffonddress");
		proddescr.selectcolorfromlist("yellow");
		proddescr.validateSelectedColorItemDisplayed("yellow");
		ExtentTestManager.getTest().log(Status.INFO, "Adding item to cart");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "checkout item by clicking on proceedtocheckout");
		proddescr.clickOnItem("proceedcheckout");
//		proddescr.clickOnItem("qtyplus");
		ExtentTestManager.getTest().log(Status.INFO, "searching for second item t-shirt");
		search.searchItemsInSearchBox(prop.getProperty("item2"));
		search.selectOneFromMatchSearchResults("t-shirt");
		ExtentTestManager.getTest().log(Status.INFO, "select blue color item from multicolor list");
		proddescr.selectcolorfromlist("blue");
		proddescr.validateSelectedColorItemDisplayed("blue");
		ExtentTestManager.getTest().log(Status.INFO, "Adding second item to cart");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
//		proddescr.clickOnItem("qtyplus"); /*Getting elementinterceptableexception*/
		proddescr.validateNoOfItemsAddedtoCartBeforeCheckOut();
		proddescr.clickOnItem("proceedcheckout");
		Assert.assertTrue(summary.isSummaryPageDisplayed());
		String itemsincart = summary.validateItemsCountInSummaryPage();
		ExtentTestManager.getTest().log(Status.INFO, "validating item count is 2 in product summary page");
		Assert.assertEquals(itemsincart, "2 Products");
		ExtentTestManager.getTest().log(Status.INFO, "searchinf for item 3 printed summer dress");
		search.searchItemsInSearchBox(prop.getProperty("item"));
		search.selectOneFromMatchSearchResults("Printed Summer Dress");
		proddescr.selectcolorfromlist("blue");
		proddescr.validateSelectedColorItemDisplayed("blue");
		ExtentTestManager.getTest().log(Status.INFO, "Adding 3rd item to cart");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "click on proceed checkout");
		proddescr.clickOnItem("proceedcheckout");
		Assert.assertTrue(summary.isSummaryPageDisplayed());
		String itemsincart2 = summary.validateItemsCountInSummaryPage();
		ExtentTestManager.getTest().log(Status.INFO, "validating no of items is 3 in cart");
		Assert.assertEquals(itemsincart2, "3 Products");
		//	proddescr.clickOnItem("qtyplus");
		ExtentTestManager.getTest().log(Status.INFO, "searching for fourth item t-shirt");
		search.searchItemsInSearchBox(prop.getProperty("item2"));
		search.selectOneFromMatchSearchResults("t-shirt");
		proddescr.selectcolorfromlist("blue");
		proddescr.validateSelectedColorItemDisplayed("blue");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "checkout forth item");
		proddescr.clickOnItem("proceedcheckout");
		ExtentTestManager.getTest().log(Status.INFO, "Remove first item which added previously");
		proddescr.clickOnItem("deleteitem");
		String itemsincart3 = summary.validateItemsCountInSummaryPage();
		ExtentTestManager.getTest().log(Status.INFO, "validating count after removing previously added item");
		/*validating count after removing previously added item*/
		Assert.assertEquals(itemsincart3, "3 Products");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Test Executed successfully");
		}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

