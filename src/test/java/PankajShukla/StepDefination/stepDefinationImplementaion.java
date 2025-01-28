package PankajShukla.StepDefination;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import PankajShukla.PageObjects.CartPage;
import PankajShukla.PageObjects.CheckoutPage;
import PankajShukla.PageObjects.ConfirmationPage;
import PankajShukla.PageObjects.LandingPage;
import PankajShukla.PageObjects.ProductCatalogue;
import PankajShukla.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinationImplementaion extends BaseTest {

	
	public LandingPage landingPage;
	public ProductCatalogue productsCatalogue;
	public  ConfirmationPage confirm;
	
	@Given("I Landed on Ecommerce page")
	public void  I_Landed_on_Ecommerce_page() throws IOException
	{
		landingPage = launchApplication(); 
	}
	
	@Given("^Logged in with username (.+) and (.+)$")
	public void  Given_Logged_in_with(String username,String password)
	{
		 productsCatalogue=landingPage.LoginApplication(username,password);
		
	}
	
	
	
	
	
	
	@When("^I add product (.+) in the cart$")
	public void  I_add_product_in_the_cart(String productName) throws InterruptedException
	{
		List<WebElement> products=productsCatalogue.getProducts();
		productsCatalogue.addToCart(productName);	
	}
	

	
	@When("^Checkout the (.+) and submit order$")
	public void Checkout_the_and_submit_order(String productName)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		CartPage cart=productsCatalogue.goToCart();
		Boolean match=cart.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		cart.goToCheckout();
		CheckoutPage check=new CheckoutPage(driver);
		check.selectCountry("India");
		check.submitOrder();
		
		 confirm=new ConfirmationPage(driver);
			
	}
	
	@Then("{string} is displayed on confirmation page")
	public void is_displayed_on_confirmation_page(String string)
	{
		String message=confirm.getconfirmMessage();
		
		AssertJUnit.assertTrue(message.equalsIgnoreCase(string));
		System.out.println(message);
		driver.close();
	
	
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void message_is_displayed(String string) throws Throwable
	{
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close();
	}
	
   




	
}
