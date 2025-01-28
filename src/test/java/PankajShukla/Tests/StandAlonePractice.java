package PankajShukla.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PankajShukla.PageObjects.OrderPage;
import PankajShukla.PageObjects.PracticeCartPage;
import PankajShukla.PageObjects.PracticeCheckoutPage;
import PankajShukla.PageObjects.PracticeConfirmationPage;
import PankajShukla.PageObjects.PracticeLandingPage;
import PankajShukla.PageObjects.PracticeOrderPage;
import PankajShukla.PageObjects.PracticeProductCatalogue;
import PankajShukla.PageObjects.ProductCatalogue;
import PankajShukla.TestComponents.PracticeBaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlonePractice extends PracticeBaseTest{

	String productName = "Banarsi Saree";
	@Test(groups = {"Purchase"}, dataProvider = "getData")
	public void submitOrder(HashMap<String, String> hp) throws IOException {
		// TODO Auto-generated method stub	
	
		PracticeProductCatalogue ps=lp.loginToApplication(hp.get("email"), hp.get("password"));
		 List<WebElement> productList=ps.findProducts();
		 ps.addToCart(hp.get("product"));
		 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		PracticeCartPage ct=ps.goToCart();
		boolean match= ct.verifyProductDisplay(hp.get("product"));
		AssertJUnit.assertTrue(match);
	    PracticeCheckoutPage cpg=ct.goToCheckoutPage();
	    cpg.selectCountry("india");
	    PracticeConfirmationPage pcp=cpg.goToConfirmationPage();
	
	String confirmMessage = pcp.getHeader();
	System.out.println(confirmMessage);
	AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods = {"submitOrder"},groups="Purchase")
	public void verifyOrder()
	{
		PracticeProductCatalogue ps=lp.loginToApplication("automationtesting11@gmail.com", "Testing@1");
		PracticeOrderPage pop =lp.goToOrders();
		boolean flag=pop.VerifyOrders("Banarsi Saree");
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	

	
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object[][] {{"automationtesting11@gmail.com","Testing@1","ZARA COAT 3"},{"geraltofrivia8@gmail.com","Testing@1","ADIDAS ORIGINAL"}};  
//	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		HashMap<String, String> hp=new HashMap<String,String>();
//		hp.put("email", "automationtesting11@gmail.com");
//		hp.put("pass", "Testing@1");
//		hp.put("productName", "ZARA COAT 3");
//		
//		HashMap<String, String> hp1=new HashMap<String,String>();
//		hp1.put("email", "geraltofrivia8@gmail.com");
//		hp1.put("pass", "Testing@1");
//		hp1.put("productName", "ADIDAS ORIGINAL");
//		
//		return new Object[][] {{hp},{hp1}};
//		
//	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data=getDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\PankajShukla\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	

}
