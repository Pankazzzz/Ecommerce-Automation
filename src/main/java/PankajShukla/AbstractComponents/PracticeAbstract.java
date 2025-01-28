package PankajShukla.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PankajShukla.PageObjects.PracticeCartPage;
import PankajShukla.PageObjects.PracticeOrderPage;

public class PracticeAbstract {

	WebDriver driver;
	
	public PracticeAbstract(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	

	
	@FindBy(css="[routerlink*='cart']")
	WebElement goCart;

			@FindBy(css="[routerlink*='myorders']")
			WebElement goToOrder;

			
	public void elementVisibilityAppear(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public void elementVisibilityAppear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void elementVisibilityDisappear(WebElement wb)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(wb));
		
	}
	
	public PracticeCartPage goToCart()
	{
		goCart.click();
		
		PracticeCartPage ct= new PracticeCartPage(driver);
		return ct;
		
	}
	
	public PracticeOrderPage goToOrders()
	{
		goToOrder.click();
		PracticeOrderPage pop=new PracticeOrderPage(driver);
		return pop;
	}
	
	
}
