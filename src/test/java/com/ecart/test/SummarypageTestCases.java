package com.ecart.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

public class SummarypageTestCases extends TestBase{
	
	SearchPage search;
	ProductDescriptionPage proddescr;
	SummaryPage summary;

	public SummarypageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialise();
		System.out.println("driver initilaised");
		search = new SearchPage();
		proddescr = new ProductDescriptionPage();
		summary = new SummaryPage();
			} 
	
	@Test(priority=1)
	public void validatetabdisplayed() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");
	search.searchItemsInSearchBox(prop.getProperty("item"));
	String results = search.validateSearchResultsInSearchPage();
	System.out.println(results);
	ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
	search.selectOneFromSearchResults(prop.getProperty("item"));
	proddescr.selectonecolorfromavailablecolor();
	Thread.sleep(3000);
	proddescr.clickOnItem("qtyplus");
	ExtentTestManager.getTest().log(Status.INFO, "Adding item to cart");
	proddescr.clickOnItem("addcart");
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(Status.INFO, "checkout item by clicking on proceedtocheckout");
	proddescr.clickOnItem("proceedcheckout");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "validatee summary page displayed");
		Assert.assertTrue(summary.isSummaryPageDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "validating tabs in summary page");
		Assert.assertTrue(summary.tabsdisplayed("summary"));
		Assert.assertTrue(summary.tabsdisplayed("login"));
		Assert.assertTrue(summary.tabsdisplayed("address"));
		Assert.assertTrue(summary.tabsdisplayed("shipping"));
		Assert.assertTrue(summary.tabsdisplayed("payment"));

	}
	
	@Test(priority=2)
	/*validate quantity of items update and price totals update in summary page after remove add items in shoppingcart*/
	public void validateQuanityOfItemsAndPricetotalsUpdateAfterRemoveAddItemsInShoppingCart() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");
		search.searchItemsInSearchBox(prop.getProperty("item"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
		search.selectOneFromSearchResults(prop.getProperty("item"));
		proddescr.selectonecolorfromavailablecolor();
		Thread.sleep(3000);
		proddescr.clickOnItem("qtyplus");
		ExtentTestManager.getTest().log(Status.INFO, "Adding item to cart");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "checkout item by clicking on proceedtocheckout");
		proddescr.clickOnItem("proceedcheckout");
		search.searchItemsInSearchBox(prop.getProperty("item2"));
		String results1 = search.validateSearchResultsInSearchPage();
		System.out.println(results1);
		search.selectOneFromSearchResults(prop.getProperty("item2"));
		ExtentTestManager.getTest().log(Status.INFO, "selecting one dress item from results");
		proddescr.selectonecolorfromavailablecolor();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Adding item to cart");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "checkout item by clicking on proceedtocheckout");
		proddescr.clickOnItem("proceedcheckout");
		search.searchItemsInSearchBox(prop.getProperty("item3"));
		String results3 = search.validateSearchResultsInSearchPage();
		System.out.println(results3);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from blouse results");
		search.selectOneFromSearchResults(prop.getProperty("item3"));
		proddescr.selectonecolorfromavailablecolor();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Adding item to cart");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "checkout item by clicking on proceedtocheckout");
		proddescr.clickOnItem("proceedcheckout");
		Assert.assertTrue(summary.isSummaryPageDisplayed());
		String itemsincart = summary.validateItemsCountInSummaryPage();
		ExtentTestManager.getTest().log(Status.INFO, "validating item count in summary page");
		Assert.assertEquals(itemsincart, "4 Products");
		ExtentTestManager.getTest().log(Status.INFO, "Deleting one blouse item qty in summary page");
		summary.clickonicon("deleteblouseicon");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Adding one t-shirt item qty in summary page");
		summary.clickonicon("addtshirticon");
		Assert.assertEquals(itemsincart, "4 Products");
		ExtentTestManager.getTest().log(Status.INFO, "validating item costs based on qty and item totals");
		Boolean flag = summary.validateitemtotalsbasedonqtyupdated();
		Assert.assertTrue(flag);
		ExtentTestManager.getTest().log(Status.INFO, "validating total cart cosed based on itemtotals and shipping cost");
		Boolean flag1 = summary.validatetotalcartcostafterqtyupdated();
		Assert.assertTrue(flag1, "total product cost calculated correctly");
	
	}
	
	@Test(priority=3)
	public void validatePriceTotalsUpdateAfterAddItemaInShoppingCart() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");
		search.searchItemsInSearchBox(prop.getProperty("item2"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
		search.selectOneFromSearchResults(prop.getProperty("item2"));
		proddescr.selectonecolorfromavailablecolor();
		Thread.sleep(3000);
		proddescr.clickOnItem("qtyplus");
		ExtentTestManager.getTest().log(Status.INFO, "Adding item to cart");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "checkout item by clicking on proceedtocheckout");
		proddescr.clickOnItem("proceedcheckout");
		Assert.assertTrue(summary.isSummaryPageDisplayed());
		String itemsincart = summary.validateItemsCountInSummaryPage();
		ExtentTestManager.getTest().log(Status.INFO, "validating item count in summary page");
//		Assert.assertEquals(itemsincart, "2 Products");
		ExtentTestManager.getTest().log(Status.INFO, "Add summer dress item qty in summary page");
		summary.clickonicon("addtshirticon");
		Thread.sleep(3000);
//		Assert.assertEquals(itemsincart, "3 Products");
		ExtentTestManager.getTest().log(Status.INFO, "validating item costs based on qty and item totals");
		System.out.println("abcfjg");
		Boolean flag = summary.validateItemtotalsUpdatedBasedonqtytshirt();
		Assert.assertTrue(flag);
		ExtentTestManager.getTest().log(Status.INFO, "validating total cart cosed based on itemtotals and shipping cost");
		Boolean flag1 = summary.validatetotalcartcostafterqtyupdated();
		Assert.assertTrue(flag1, "total product cost calculated correctly");
		
	}
	
	@Test(priority = 4)
	/*validating product description,adding multi color option item and qty update in cart*/
	public void validateSummaryPageForSingleItemInCart() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");
		search.searchItemsInSearchBox(prop.getProperty("item"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
		search.selectOneFromSearchResults(prop.getProperty("item"));
		proddescr.selectonecolorfromavailablecolor();
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
		proddescr.clickOnItem("proceedcheckout");
		ExtentTestManager.getTest().log(Status.INFO, "validating summary page displayed after checkout");
		Boolean flag = summary.isSummaryPageDisplayed();
		String itemsincart = summary.validateItemsCountInSummaryPage();
		ExtentTestManager.getTest().log(Status.INFO, "validating item count in summary page");
		Assert.assertEquals(itemsincart, "1 Product");
		Assert.assertTrue(true);
		ExtentTestManager.getTest().log(Status.INFO, "Test Executed successfully.");

				
	}
	
	@Test(priority = 5)
	
	/*validating qty update and multi color option by adding 2 more items to cart*/
	public void validateQuanityOfItemsUpdateForMoreItemsInSummaryPage() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");
		search.searchItemsInSearchBox(prop.getProperty("item"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
		search.selectOneFromSearchResults(prop.getProperty("item"));
		proddescr.selectonecolorfromavailablecolor();
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
		proddescr.clickOnItem("proceedcheckout");
//		proddescr.clickOnItem("qtyplus");
		ExtentTestManager.getTest().log(Status.INFO, "Adding one more item t-shirt");
		search.searchItemsInSearchBox(prop.getProperty("item2"));
		search.selectOneFromSearchResults(prop.getProperty("item2"));
		ExtentTestManager.getTest().log(Status.INFO, "selecting one color from multicolor");
		proddescr.selectonecolorfromavailablecolor();
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
//		proddescr.clickOnItem("qtyplus"); /*Getting elementinterceptableexception*/
		proddescr.clickOnItem("proceedcheckout");
		ExtentTestManager.getTest().log(Status.INFO, "validate summary page displayed after checkout");
		Assert.assertTrue(summary.isSummaryPageDisplayed());
		String itemsincart = summary.validateItemsCountInSummaryPage();
		ExtentTestManager.getTest().log(Status.INFO, "validate item count is updated to 2");
		Assert.assertEquals(itemsincart, "2 Products");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Test Executed successfully");

		}
	
	
	
//	@Test
//	public void buttonsdisplayed() {
//		ExtentTestManager.getTest().log(Status.INFO, "validate buttons displayed in summary page");
////		Assert.assertTrue(summary.validatebuttondisplayed("continueshopping"));
//		Assert.assertTrue(summary.validatebuttondisplayed("proceedtocheckout"));
//		
//	}
@AfterMethod
	public void teardown() {
	driver.quit();
	
}
}
