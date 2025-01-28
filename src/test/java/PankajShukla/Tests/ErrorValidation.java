package PankajShukla.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PankajShukla.PageObjects.CartPage;
import PankajShukla.PageObjects.CheckoutPage;
import PankajShukla.PageObjects.ConfirmationPage;
import PankajShukla.PageObjects.LandingPage;
import PankajShukla.PageObjects.ProductCatalogue;
import PankajShukla.TestComponents.BaseTest;
import PankajShukla.TestComponents.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest{

	@Test(groups= {"errorHandling"}, retryAnalyzer = Retry.class)
	public void loginPageErrorValidation()
	{
		// TODO Auto-generated method stub

		String productName = "Banarsi Saree";
		landingPage.LoginApplication("ansh@gmail.com","Iamkin00");
		 Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

	@Test
	public void ProductCatalogueErrorValidation()
	{
		// TODO Auto-generated method stub
		String productName = "Banarsi Saree";
		
		ProductCatalogue productsCatalogue=landingPage.LoginApplication("rahulshetty@gmail.com","Iamking@000");
		List<WebElement> products=productsCatalogue.getProducts();
		productsCatalogue.addToCart(productName);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		CartPage cart=productsCatalogue.goToCart();
		Boolean match=cart.verifyProductDisplay("Banarsi aree");
		Assert.assertFalse(match);
		
	}

}
