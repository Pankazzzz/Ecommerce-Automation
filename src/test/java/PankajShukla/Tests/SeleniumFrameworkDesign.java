package PankajShukla.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PankajShukla.PageObjects.CartPage;
import PankajShukla.PageObjects.CheckoutPage;
import PankajShukla.PageObjects.ConfirmationPage;
import PankajShukla.PageObjects.LandingPage;
import PankajShukla.PageObjects.OrderPage;
import PankajShukla.PageObjects.ProductCatalogue;
import PankajShukla.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFrameworkDesign extends BaseTest{

	String productName = "Banarsi Saree";
	
	@Test(dataProvider = "getData",groups="Purchase")
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub

		
		ProductCatalogue productsCatalogue=landingPage.LoginApplication(input.get("email"),input.get("password"));
		List<WebElement> products=productsCatalogue.getProducts();
		productsCatalogue.addToCart(input.get("product"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		CartPage cart=productsCatalogue.goToCart();
		Boolean match=cart.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		cart.goToCheckout();
		CheckoutPage check=new CheckoutPage(driver);
		check.selectCountry("India");
		check.submitOrder();
		
		ConfirmationPage confirm=new ConfirmationPage(driver);
		String message=confirm.getconfirmMessage();
		
		AssertJUnit.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(message);
	
		driver.findElement(By.cssSelector("[class*='fa-sign-out']")).click();
		
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest()
	{
		ProductCatalogue productsCatalogue=landingPage.LoginApplication("automationtesting11@gmail.com","Testing@1");
		OrderPage orderPage=productsCatalogue.goToOrderPage();
		orderPage.verifyOrderedItem(productName);
	}
	
	
	
	@DataProvider
	public Object getData() throws IOException
	{
		List<HashMap<String, String>> data=getDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\PankajShukla\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}



//HashMap<String, String> map=new HashMap<String,String>();
//map.put("email", "anshika@gmail.com");
//map.put("password", "Iamking@000");
//map.put("product", "ZARA COAT 3");
//
//HashMap<String, String> map1=new HashMap<String,String>();
//map1.put("email", "rahulshetty@gmail.com");
//map1.put("password", "Iamking@000");
//map1.put("product", "ADIDAS ORIGINAL");
		