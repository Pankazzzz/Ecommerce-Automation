package PankajShukla.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PankajShukla.PageObjects.CartPage;
import PankajShukla.PageObjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement addCart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement clickOnOrder;
	
	
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
	}

	public void waitForElementsToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForElementToAppear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	
	public void waitForElementsToDisappear(WebElement element)
	{

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	
	}
	
	public CartPage goToCart()
	{
		addCart.click();

		CartPage cart= new CartPage(driver);
		return cart;
	}
	
	public OrderPage goToOrderPage()
	{
		clickOnOrder.click();
		OrderPage orderPage= new OrderPage(driver);
		return orderPage;
	}

}
