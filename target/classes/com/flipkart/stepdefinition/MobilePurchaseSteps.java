package com.flipkart.stepdefinition;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchaseSteps {
	static WebDriver d;
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://www.flipkart.com/");
	}

	@Given("user login by entering crendentials")
	public void user_login_by_entering_crendentials() {
		try {
	   		WebElement button = d.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	   		 button.isDisplayed();
	   	     button.click();
	   	}catch (Exception e) {
	   		System.out.println("Popup not displayed");
	   	}
	}

	@When("user search mobile")
	public void user_search_mobile() {
	  	WebElement search = d.findElement(By.xpath("//input[@type='text']"));
	  	search.sendKeys(realme,Keys.ENTER);
	  	WebElement mobileName = d.findElement(By.xpath("//div[contains(text(),'realme Narzo 50A (Oxygen Blue, 64 GB)')]"));
		String name = mobileName.getText();
		System.out.println(name);
	  	mobileName.click();
	}

	@When("user click on the buy now button and enter payment details")
	public void user_click_on_the_buy_now_button_and_enter_payment_details() {
		String par = d.getWindowHandle();
	  	Set<String> child = d.getWindowHandles();
			for(String x : child) {
			if(!par.equals(x)) {
					System.out.println("tab switched");
					d.switchTo().window(x);
				}
			}
	}

	@Then("user click on add to cart")
	public void user_click_on_add_to_cart() {
		Assert.assertTrue(d.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")).isDisplayed());	   
	}


}
