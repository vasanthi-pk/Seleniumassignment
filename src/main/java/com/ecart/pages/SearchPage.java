package com.ecart.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ecart.base.TestBase;


public class SearchPage extends TestBase {

	//Page Factory
	@FindBy(xpath="//input[@name='search_query']")
	WebElement search;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchbutton;
	
	@FindBy(xpath="//a[contains(@class,'sf-with-ul')][contains(text(),'Women')]")
	WebElement womentab;
	
	@FindBy(xpath="//a[@title='Dresses']")
	WebElement dressestab;
	
	@FindBy(xpath="//a[@title='T-shirts']")
	WebElement tshirtstab;
	
	@FindBy(xpath="//div[@id='categories_block_left']/h2[contains(text(),'Women')]")
	WebElement womencategorylist;
	
	@FindBy(xpath="//span[@class='grower CLOSE']/a[contains(text(),'Tops')]")
	WebElement topslist;
	
	@FindBy(xpath="//span[@class='grower CLOSE']/a[contains(text(),'Dresses'")
	WebElement dresseslist;
	
	@FindBy(xpath="//div[@id='categories_block_left']//div/ul/li/span[1]")
	WebElement topsexpandbutton;
	
	@FindBy(xpath="//h1[@class='page-heading  product-listing']")
	WebElement searchresults;
	
	@FindBy(xpath="//h1[contains(@class,'product-listing')]")
	WebElement matchingsearchresults;
	
	@FindBy(xpath="//ul[@class='product_list grid row']//li//div//a[@title='Printed Summer Dress']")
	WebElement summerdress;
	
	@FindBy(xpath="//a[@class='product_img_link']//img[@class='replace-2x img-responsive']")
	WebElement sleeveshirt;
	
	@FindBy(xpath="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-in-line first-item-of-tablet-line last-item-of-mobile-line hovered']//a[@class='product-name'][contains(text(),'Printed Dress')]")
	WebElement printeddress;
	
	@FindBy(xpath="//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Chiffon Dress')]")
	WebElement printechiffonddress;
	
	@FindBy(xpath="//div[@class='right-block']//a[@class='product-name'][contains(text(),'Blouse')]")
	WebElement blouse;
	
	@FindBy(xpath="//div[@class='shopping_cart']//a[@title='View my shopping cart']")
	WebElement shoppingcart;
	
	@FindBy(xpath="//p[@class='alert alert-warning']")
	WebElement searchresultswithnokeyword;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateSearchPageTitle() {
		
		return driver.getTitle();
	
		}
	public Boolean validateSearchInputTextEnabled() {
		Actions action = new Actions(driver);
		action.moveToElement(search).click().build().perform();
		return search.isEnabled();
		
	}
	
	public Boolean validateSearchIconDisplayed() {
		return searchbutton.isDisplayed();
	}
	
	public void searchItemsInSearchBox(String item) {
		try{
			search.clear();
			search.sendKeys(item);
			searchbutton.click();
			}
			 catch (NoSuchElementException e) {
					System.out.println("Element was not found in DOM "+ e.getStackTrace());
			} catch (Exception e) {
					System.out.println("Unable to click on element "+ e.getStackTrace());
				} 
			
		}
	
	
	public void searchWithoutKeywordInSearchBox() {
		search.clear();
		searchbutton.click();
	}
	
	public Boolean validateMatchingSearchResults() {
		Boolean flag2 = matchingsearchresults.isDisplayed();
		return flag2;
		
		}
	
	public String validateInvalidItemSearchResults() {
		return matchingsearchresults.getText();
		
		
		}
	
	public String validateSearchResultsInSearchPage() {
		String results = searchresults.getText();
		return results;
	}
	
	public void selectOneFromMatchSearchResults(String item) {
		
		try {
		if(item.equalsIgnoreCase("Printed Summer Dress")) {
		summerdress.click();
		
		} else if(item.equalsIgnoreCase("t-shirt")) {
			sleeveshirt.click();
		}
		else if(item.equalsIgnoreCase("printechiffonddress")) {
			printechiffonddress.click();
		}
		else if(item.equalsIgnoreCase("Printed Dress")){
			printeddress.click();
		}
		else if(item.equalsIgnoreCase("Blouse")) {
			blouse.click();
		}
		}
		catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
	} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		} 
			
		}
		
	
	
	public Boolean validateWomenTabDisplayed() {
		return womentab.isDisplayed();
		}
	
	public Boolean validateDressesTabDisplayed() {
		return dressestab.isDisplayed();
			}
	public Boolean validateTshirtsTabDisplayed() {
		return tshirtstab.isDisplayed();
	}
	
	public void selectWomenTab() {
		try {
		womentab.click();
		}
		catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		}
	}
	
	public void selectDressesTab() {
		dressestab.submit();
	}
	
	public String validateshoppingcartEmpty() {
		return shoppingcart.getText();
		
	}
	
	public String validateresultswithnoKeyword() {
		return searchresultswithnokeyword.getText();
	}
	
	public Boolean validateWomenCategoryListDisplayed() {
		return womencategorylist.isDisplayed();
	}
	
	public Boolean validateTopsexpandcategoryDisplayed() {
		return topslist.isDisplayed();
	}
	
	public void validateTopsCategoryList() {
		try {
		topsexpandbutton.click();
		
			}
		catch (NoSuchElementException e) 
		{
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		}

		
}
	public Boolean validateInvalidResults() {
		Boolean flag;	
		List<WebElement> searchresults = driver.findElements(By.xpath("//li[contains(@class,'ajax_block_product col')]//a[contains(@class,'product-name')][contains(text(),'Dress')]"));
		WebElement item1 = driver.findElement(By.xpath("//div[contains(@class,'right-block')]//a[contains(@class,'product-name')][contains(text(),'Faded Short Sleeve T-shirts')]"));
		
		WebElement item2 = driver.findElement(By.xpath("//div[contains(@class,'right-block')]//a[contains(@class,'product-name')][contains(text(),'Blouse')]"));
		searchresults.add(item2);
		searchresults.add(item1);
		
//		
		for(WebElement actualresult:searchresults) {
			if(!actualresult.getText().contains("Dress")) {
			System.out.println("results are not matched");
			return flag=false;
		}
	}
		return flag=true;
		
	}
	
	
public void selectOneFromSearchResults(String item) {
	try {
		if(item.equalsIgnoreCase("dress"))
		 {
			if(summerdress.isDisplayed()) {
			summerdress.click();
		
			} else if(printeddress.isDisplayed()) {
			printeddress.click();
			}
			else if(printechiffonddress.isDisplayed()) {
			printechiffonddress.click();
			}
		 }
		if(item.equalsIgnoreCase("T-Shirts")) {
			if(sleeveshirt.isDisplayed()) {
				sleeveshirt.click();
			}
		}
		
		if(item.equalsIgnoreCase("blouse")) {
			if(blouse.isDisplayed()) {
				blouse.click();
			}
		}
	}
		catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
	} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		} 
			
		}
	
}
	


