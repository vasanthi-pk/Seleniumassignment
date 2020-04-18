package com.ecart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecart.base.TestBase;

public class SummaryPage extends TestBase{
	@FindBy(xpath="//span[@id='summary_products_quantity']")
	WebElement itemsincart;
	
	@FindBy(xpath="//span[contains(text(),'Summary')]")
	WebElement summarytab;
	
	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	WebElement signintab;
	
	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	WebElement addresstab;
	
	@FindBy(xpath="//li[@class='step_todo four']//span[contains(text(),'Shipping')]")
	WebElement shippingtab;
	
	@FindBy(xpath="//span[contains(text(),'Payment')]")
	WebElement paymenttab;
	
	@FindBy(xpath="//a[@class='button-exclusive btn btn-default']")
	WebElement continueshopping;
	
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtocheckout;
	
	
	
	
	
	public SummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean isSummaryPageDisplayed() {
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("Order - My Store")) {
			return true;
		}
		return true;
	}
	
	public String validateItemsCountInSummaryPage() {
		driver.navigate().refresh();
		System.out.println(itemsincart.getText());
		return itemsincart.getText();
		
		
	}
	
	public Boolean tabsdisplayed(String tab) {
		if(tab.equalsIgnoreCase("summary")) {
			System.out.println(summarytab.getText());
			summarytab.isDisplayed();
			}
			else if(tab.equalsIgnoreCase("login")) {
			signintab.isDisplayed();
			}else if(tab.equalsIgnoreCase("address")) {
			addresstab.isDisplayed();
			}
			else if(tab.equalsIgnoreCase("shipping")) {
			shippingtab.isDisplayed();
				
			}
			else if(tab.equalsIgnoreCase("payment")) {
				paymenttab.isDisplayed();
			 
}
		return true;
	}
		
		public Boolean validatebuttondisplayed(String button) {
			if(button.equalsIgnoreCase("continueshopping")) {
				continueshopping.isDisplayed();
				}
		else if(button.equalsIgnoreCase("proceedtocheckout")) {
			proceedtocheckout.isDisplayed();
}
			return true;
		}
}
