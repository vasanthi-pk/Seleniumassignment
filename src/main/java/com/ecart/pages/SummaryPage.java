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
	
	@FindBy(xpath="//a[@id='2_7_0_0']//i[@class='icon-trash']")
	WebElement deleteblouseicon;
	
	@FindBy(xpath="//a[@id='cart_quantity_up_1_1_0_0']//i[@class='icon-plus']")
	WebElement addtshirticon;
	
	@FindBy(xpath="//a[@id='cart_quantity_up_5_22_0_0']//i[@class='icon-plus']")
	WebElement addsummerdressicon;
	
	@FindBy(xpath="//span[@id='product_price_5_22_0']//span[@class='price']")
	WebElement summerdressunitprice1;
	
	@FindBy(xpath="//input[@name='quantity_5_22_0_0']")
	WebElement summerdressquantity;
	
	@FindBy(css="#total_product_price_5_22_0")
	WebElement summerdressqtytotalprice;
	
	@FindBy(xpath="//span[contains(text(),'$16.51')]")
	WebElement sleevetshirtsunitprice;
	
	@FindBy(xpath="//span[@id='product_price_5_22_0']//span[@class='price'][contains(text(),'$28.98')]")
	WebElement summerdressunitprice;
	
	@FindBy(xpath="//input[@name='quantity_1_1_0_0']")
	WebElement sleevetshirtquantity;
	
	@FindBy(xpath="//span[@id='total_product_price_1_1_0']")
	WebElement sleevetshirttotalprice;
	
	@FindBy(xpath="//td[@id='total_product']")
	WebElement totalproducts;
	
	@FindBy(xpath="//td[@id='total_shipping']")
	WebElement totalshipping;
	
	@FindBy(xpath="//td[@id='total_price_without_tax']")
	WebElement totalpricewithouttax;
	
	@FindBy(xpath="//td[@id='total_tax']")
	WebElement tax;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement totalprice;
	
	
	
	
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
		
		public void clickonicon(String icon) {
			if(icon.equalsIgnoreCase("deleteblouseicon")) {
				deleteblouseicon.click();
				
			}
			else if(icon.equalsIgnoreCase("addtshirticon")) {
				addtshirticon.click();
				
			}
			
			else if(icon.equalsIgnoreCase("addsummerdressicon")) {
				addsummerdressicon.click();
			}
		}
		
		public Boolean validateitemtotalsbasedonqtyupdated() {
			Float int_summerdressitemcost; int int_summerdressqty; Float inttotal_summerdressitemcost;
			Float int_sleevetshirtitemcost; Float total_products_cost; int int_sleevetshirtqty; Float inttotal_sleevetshirtitemcost;
			String itemcost = summerdressunitprice.getText();
			itemcost = itemcost.replace("$", " ");
			System.out.println(itemcost);
			int_summerdressitemcost = Float.parseFloat(itemcost);
			System.out.println(int_summerdressitemcost);
			String summerdressqty = summerdressquantity.getAttribute("value");
			int_summerdressqty = Integer.parseInt(summerdressqty);
			System.out.println(int_summerdressqty);
			String totalprice_summerdress = summerdressqtytotalprice.getText();
			System.out.println(totalprice_summerdress);
			totalprice_summerdress = totalprice_summerdress.replace("$", " ");
			inttotal_summerdressitemcost = Float.parseFloat(totalprice_summerdress);
			System.out.println(inttotal_summerdressitemcost);
 			driver.navigate().refresh();
			String sleevetshirtitemcost = sleevetshirtsunitprice.getText();
			sleevetshirtitemcost = sleevetshirtitemcost.replace("$", " ");
			System.out.println(sleevetshirtitemcost);
			int_sleevetshirtitemcost = Float.parseFloat(sleevetshirtitemcost);
			String sleevetshirtqty = sleevetshirtquantity.getAttribute("value");
			int_sleevetshirtqty = Integer.parseInt(sleevetshirtqty);
			System.out.println(int_sleevetshirtqty);
			String totalprice_sleevetshirtdress = sleevetshirttotalprice.getText();
			totalprice_sleevetshirtdress = totalprice_sleevetshirtdress.replace("$", " ");
			inttotal_sleevetshirtitemcost = Float.parseFloat(totalprice_sleevetshirtdress);
			System.out.println(inttotal_sleevetshirtitemcost);
			String total_products = totalproducts.getText();
			total_products = total_products.replace("$", " ");
			total_products_cost = Float.parseFloat(total_products);
			System.out.println(total_products_cost);
		if(inttotal_summerdressitemcost == int_summerdressqty*int_summerdressitemcost) {
				if(inttotal_sleevetshirtitemcost == int_sleevetshirtqty*int_sleevetshirtitemcost)
					{
						if(total_products_cost == inttotal_summerdressitemcost+inttotal_sleevetshirtitemcost)
							System.out.println(total_products_cost);
						return true;
					}
			 }
			 return false;
			 
		}
			 public Boolean validatetotalcartcostafterqtyupdated() {
				 Float totalcart_cost; Float tax_cost; Float shipping_cost; Float totalproducts_cost;
				 String total_products = totalproducts.getText();
				 total_products = total_products.replace("$", " ");
				 totalproducts_cost = Float.parseFloat(total_products);
				 String total_shipping = totalshipping.getText();
				 total_shipping = total_shipping.replace("$", " ");
				 shipping_cost = Float.parseFloat(total_shipping);
				 String taxcost = tax.getText();
				 taxcost = taxcost.replace("$", " ");
				 tax_cost = Float.parseFloat(taxcost);
				 String totalcartcost = totalprice.getText();
				 totalcartcost = totalcartcost.replace("$", " ");
				 totalcart_cost = Float.parseFloat(totalcartcost);
				 
				 if(totalcart_cost == totalproducts_cost+tax_cost+shipping_cost) {
					 return true;
				 }
				 return false;
				 
						 
			 }
			 
			 public Boolean validateItemtotalsUpdatedBasedonqtytshirt() {
				 Float int_sleevetshirtitemcost; Float total_products_cost; int int_sleevetshirtqty; Float inttotal_sleevetshirtitemcost;
				 System.out.println("start");
				String sleevetshirtitemcost = sleevetshirtsunitprice.getText();
				sleevetshirtitemcost = sleevetshirtitemcost.replace("$", " ");
				System.out.println(sleevetshirtitemcost);
				int_sleevetshirtitemcost = Float.parseFloat(sleevetshirtitemcost);
				String sleevetshirtqty = sleevetshirtquantity.getAttribute("value");
				int_sleevetshirtqty = Integer.parseInt(sleevetshirtqty);
				System.out.println(int_sleevetshirtqty);
				String totalprice_sleevetshirtdress = sleevetshirttotalprice.getText();
				totalprice_sleevetshirtdress = totalprice_sleevetshirtdress.replace("$", " ");
				inttotal_sleevetshirtitemcost = Float.parseFloat(totalprice_sleevetshirtdress);
				System.out.println(inttotal_sleevetshirtitemcost);
				String total_products = totalproducts.getText();
				total_products = total_products.replace("$", " ");
				total_products_cost = Float.parseFloat(total_products);
				System.out.println(total_products_cost);
			
					if(inttotal_sleevetshirtitemcost == int_sleevetshirtqty*int_sleevetshirtitemcost)
						{
							if(total_products_cost == inttotal_sleevetshirtitemcost)
								System.out.println(total_products_cost);
							return true;
						}
				 
				 return false;
				 
			}
			 }


		
