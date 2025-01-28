package PankajShukla.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PankajShukla.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
	//Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	//Assert.assertTrue(match);
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productTitles;


	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public Boolean verifyProductDisplay(String productName)
	{
		Boolean match = 	productTitles.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;	
	}
	
	public void goToCheckout()
	{
		checkout.click();
	}
	
	
}
