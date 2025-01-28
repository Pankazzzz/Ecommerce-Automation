package PankajShukla.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PankajShukla.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
	//Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	//Assert.assertTrue(match);
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderedItems;

	
	public Boolean verifyOrderedItem(String orderedIteamName)
	{
		Boolean match = 	orderedItems.stream().anyMatch(orderedItems-> orderedItems.getText().equalsIgnoreCase(orderedIteamName));
		return match;	
	}
	
	
	
}
