package com.ecart.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecart.base.TestBase;

public class ProductDescriptionPage extends TestBase{
	
	@FindBy(xpath="//label[contains(text(),'Color')]")
	WebElement colorpicklist;
	
	@FindBy(xpath="//a[@id='color_11']")
	WebElement selectblack;
	
	@FindBy(xpath="//a[@id='color_13']")
	WebElement selectorange;
	
	@FindBy(xpath="//a[@id='color_14']")
	WebElement selectblue;
	
	@FindBy(xpath="//a[@id='color_24']")
	WebElement selectpink;
	
	@FindBy(xpath="//a[@id='color_16']")
	WebElement selectyellow;
	
	@FindBy(xpath="//img[@id='bigpic']")
	WebElement img;
	
	@FindBy(xpath="//button[@name='Submit']")
	WebElement addtocart;
	
	@FindBy(css="body.product.product-5.product-printed-summer-dress.category-11.category-summer-dresses.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(4) div.center_column.col-xs-12.col-sm-12 div.primary_block.row:nth-child(1) div.pb-center-column.col-xs-12.col-sm-4 div:nth-child(4) div.rte.align_justify > p:nth-child(1)")
	WebElement description;
	
	@FindBy(xpath="//label[contains(text(),'Quantity')]")
	WebElement quantityupdatelabel;
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]")
	WebElement productaddsuccessmessage;
	
	@FindBy(xpath="//body[@id='product']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='layer_cart']/div[@class='clearfix']/div[@class='layer_cart_cart col-xs-12 col-md-6']/h2/span[1]")
	WebElement itemsincartbeforecheckout;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtocheckout;
	
	@FindBy(xpath="//a[@class='btn btn-default button-plus product_quantity_up']//span")
	WebElement plusqtyicon;
	
	@FindBy(css="body.order.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 div.table_block.table-responsive:nth-child(5) table.table.table-bordered.stock-management-on tr.cart_item.first_item.address_0.odd:nth-child(1) td.cart_delete.text-center div:nth-child(1) a.cart_quantity_delete > i.icon-trash")
	WebElement removeitem;
	
	public ProductDescriptionPage() {
		PageFactory.initElements(driver, this);

	}
	
	public String validateProductDescriptionPageLoaded() {
		return driver.getTitle();
		
		
	}	
		public void selectblackcoloritem() {
			System.out.println(selectblack.getText());
			selectblack.click();
			System.out.println(img.getCssValue("color"));
		}
		
		public Boolean validateDescription() {
			description.getText();
			return description.isDisplayed();
			
		}
		
		public Boolean validatequantityupdateoption() {
			return quantityupdatelabel.isDisplayed();
		}
		public void colorlistDisplayed() throws InterruptedException {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(3000);
			colorpicklist.isDisplayed();	
			}
		
		
		
		public void selectcolorfromlist(String color) throws InterruptedException {
			Thread.sleep(3000);
			try {
				
				if(color.equalsIgnoreCase("black")) {
				if(selectblack.isDisplayed()) {
				selectblack.click();
					}
				}else if(color.equalsIgnoreCase("orange")) 
					{
				if(selectorange.isDisplayed()) {
					selectorange.click();
				}
					}	
			else if(color.equalsIgnoreCase("blue")) 
				{
				if(selectblue.isDisplayed()) {
					selectblue.click();
				}
			}
			else if(color.equalsIgnoreCase("pink")) {
				if(selectpink.isDisplayed()) {
					selectpink.click();
				}
			}
			
			else if(color.equalsIgnoreCase("yellow")) {
				if(selectyellow.isDisplayed()) {
					selectyellow.click();
				}
						}
			
			
			}
			catch(NoSuchElementException e) 
				{
					System.out.println("Element was not found in DOM "+ e.getStackTrace());
				}
			}
			
		
		public void clickOnItem(String item) throws Exception{
			try {
			if(item.equalsIgnoreCase("addcart")) {
			addtocart.click();
			}
			else if(item.equalsIgnoreCase("proceedcheckout")) {
				proceedtocheckout.click();
			}
			else if(item.equalsIgnoreCase("qtyplus")) {
//			Actions action = new Actions(driver);
//			action.moveToElement(plusqtyicon).click().build().perform();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", plusqtyicon);
				plusqtyicon.click();
			}
			else if(item.equalsIgnoreCase("deleteitem")) {
				removeitem.click();
			}
			
		 }catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		} 
			
		}
		
		public Boolean validateSummaryPageDisplayed() {
			if(driver.getTitle().equalsIgnoreCase("Order - My Store")) {
				return true;
				}
			return false;
			
		}
		
//		public Boolean visibleof(String icon) {
//			if(plusqtyicon.isEnabled()) {
//				return true;
//			}
//			else return false;
//			
//		}
		
		public void validateSelectedColorItemDisplayed(String color) throws InterruptedException {
			Thread.sleep(3000);
			if(color.equalsIgnoreCase("black")) {
			selectblack.isSelected();
			}else if(color.equalsIgnoreCase("blue")) {
			selectblue.isSelected();
		}
		}
		
		public String validateNoOfItemsAddedtoCartBeforeCheckOut() {
			productaddsuccessmessage.getText().equalsIgnoreCase("Product successfully added to your shopping cart");
			return itemsincartbeforecheckout.getText();
		}
		
//		public String validateNoOfItemsAfterCheckout() {
//			System.out.println(itemsincart.getText());
//			return itemsincart.getText();
//		}
	}


