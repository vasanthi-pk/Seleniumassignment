package com.ecart.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProject\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("abc");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://www.automationpractice.com");
		System.out.println(driver.getTitle());
		WebElement search = driver.findElement(By.xpath("//input[@name='search_query']"));
		search.clear();
		String item = "DRESS";
		search.sendKeys(item);
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		WebElement searchtext = driver.findElement(By.xpath("//h1[@class='page-heading  product-listing']"));
		if(searchtext.getText().contains(item)) {
			System.out.println("matched");
			
		}
		System.out.println(driver.getTitle());
//		List<WebElement> searchresults = driver.findElements(By.xpath("//ul[@class='product_list grid row']//li//div//a"));
//		for(WebElement searchitem:searchresults) 
//		{	if(searchitem.getText().contains(item)) {
//			System.out.println(searchitem.getText());
//		}
//		}
		List<WebElement> searchresults = driver.findElements(By.xpath("//li[contains(@class,'ajax_block_product col')]//a[contains(@class,'product-name')][contains(text(),'Dress')]"));
		WebElement item1 = driver.findElement(By.xpath("//div[contains(@class,'right-block')]//a[contains(@class,'product-name')][contains(text(),'Faded Short Sleeve T-shirts')]"));
		
		WebElement item2 = driver.findElement(By.xpath("//div[contains(@class,'right-block')]//a[contains(@class,'product-name')][contains(text(),'Blouse')]"));
		searchresults.add(item2);
		searchresults.add(item1);
		//		List<WebElement>itemadd = driver.findElements(By.xpath("//div[contains(@class,'right-block')]//a[contains(@class,'product-name')][contains(text(),'T-shirts')]"));
//		System.out.println(itemadd.get(0).getText());
//		List<WebElement> searchresults = driver.findElements(By.xpath("//ul[@class='product_list grid row']//child::li"));
		System.out.println(searchresults.size());
		for(WebElement searchresult:searchresults) {
			String itemname = searchresult.getText();
			Boolean flag= itemname.contains("Dress");
			System.out.println(flag);
//			String[] items = itemname.split(("\\r?\\n"));
//			System.out.println(items[0]);
//			
		System.out.println(itemname);
		}
		driver.findElement(By.xpath("//ul[@class='product_list grid row']//li//div//a[@title='Printed Summer Dress']")).click();
		List<WebElement> colorslist = driver.findElements(By.xpath("//ul[@id='color_to_pick_list']//li//a"));
		System.out.println("colorslist"+colorslist);
//			colorslist.get(0).click();
		for(WebElement color:colorslist) {
			if(color.getAttribute("title").equalsIgnoreCase("Green")){
				color.click();
				System.out.println("Green color select");
				break;
			}
			else if(color.getAttribute("title").equalsIgnoreCase("Orange")){
				color.click();
				System.out.println("Orange color select");
				break;
			}
			else if(color.getAttribute("title").equalsIgnoreCase("Blue")){
				color.click();
				System.out.println("Blue color select");
				break;
			}
			System.out.println(color.getAttribute("title"));
		
	}
		driver.findElement(By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']//i[@class='icon-plus']")).click();
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.xpath("//a[@class='cart_quantity_up btn btn-default button-plus']//i[@class='icon-plus']")).click();
		System.out.println("selected");
		
		//a[@class='btn btn-default button-plus product_quantity_up']//i[@class='icon-plus']
}
}
