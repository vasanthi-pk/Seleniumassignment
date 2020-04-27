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
		search.searchItemsInSearchBox(prop.getProperty("item"));
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
		proddescr.selectcolorfromlist("black");
		proddescr.validateSelectedColorItemDisplayed("black");
			
	}
	
	@Test(priority = 1)
	
	/*validating product description and multi color updates for blouse*/
	public void validateProductDescriptionPageforPrinteddress() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");
		search.searchItemsInSearchBox(prop.getProperty("item3"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
		search.selectOneFromMatchSearchResults("Blouse");
		String title = proddescr.validateProductDescriptionPageLoaded();
		ExtentTestManager.getTest().log(Status.INFO, "validating product description page displayed for selected item");
		Assert.assertEquals(title, "Blouse - My Store");
		proddescr.colorlistDisplayed();
		ExtentTestManager.getTest().log(Status.INFO, "validating product description");
		Boolean flag3 = proddescr.validateDescription();
		Assert.assertTrue(flag3);
		ExtentTestManager.getTest().log(Status.INFO, "Test Executed successfully");
		proddescr.selectcolorfromlist("black");
		proddescr.validateSelectedColorItemDisplayed("black");
		}
	
	@Test(priority = 2)
	/*validating product description and multi color updates for printed chiffon dress*/
	public void validateProductiondescriptionpageforPrintedChiffondress() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");
		search.searchItemsInSearchBox(prop.getProperty("item"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
		search.selectOneFromMatchSearchResults("printechiffonddress");
		String title = proddescr.validateProductDescriptionPageLoaded();
		System.out.println(title);
		ExtentTestManager.getTest().log(Status.INFO, "validating product description page displayed for selected item");
		Assert.assertEquals(title, "Printed Chiffon Dress - My Store");
		proddescr.colorlistDisplayed();
		ExtentTestManager.getTest().log(Status.INFO, "validating product description");
		Boolean flag3 = proddescr.validateDescription();
		Assert.assertTrue(flag3);
		ExtentTestManager.getTest().log(Status.INFO, "Test Executed successfully");
		}
	
	@Test(priority = 2)
	/*validating qty items update after remove and add items in shopping cart*/
	public void validateProductiondescriptionpagefortshirtitem() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "searching for items in search box");
		search.searchItemsInSearchBox(prop.getProperty("item2"));
		String results = search.validateSearchResultsInSearchPage();
		System.out.println(results);
		ExtentTestManager.getTest().log(Status.INFO, "selecting one item from results");
		search.selectOneFromMatchSearchResults("t-shirt");
		String title = proddescr.validateProductDescriptionPageLoaded();
		ExtentTestManager.getTest().log(Status.INFO, "validating product description page displayed for selected item");
		Assert.assertEquals(title, "Faded Short Sleeve T-shirts - My Store");
		proddescr.colorlistDisplayed();
		ExtentTestManager.getTest().log(Status.INFO, "validating product description");
		Boolean flag3 = proddescr.validateDescription();
		Assert.assertTrue(flag3);
		ExtentTestManager.getTest().log(Status.INFO, "Test Executed successfully");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

