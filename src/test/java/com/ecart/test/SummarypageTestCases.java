package com.ecart.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
	@Test
	public void validatetabdisplayed() throws Exception {
		search.searchItemsInSearchBox(prop.getProperty("item2"));
		ExtentTestManager.getTest().log(Status.INFO, "searching for  item t-shirt");
		search.selectOneFromMatchSearchResults("t-shirt");
		proddescr.selectcolorfromlist("blue");
		proddescr.validateSelectedColorItemDisplayed("blue");
		ExtentTestManager.getTest().log(Status.INFO, "Adding blue color t-shirt to cart");
		proddescr.clickOnItem("addcart");
		Thread.sleep(3000);
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
	
	@Test
	public void buttonsdisplayed() {
		ExtentTestManager.getTest().log(Status.INFO, "validate buttons displayed in summary page");
		Assert.assertTrue(summary.validatebuttondisplayed("continueshopping"));
		Assert.assertTrue(summary.validatebuttondisplayed("proceedtocheckout"));
		
	}
@AfterMethod
	public void teardown() {
	driver.quit();
	
}
}
