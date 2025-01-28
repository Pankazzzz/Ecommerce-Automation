package PankajShukla.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PankajShukla.AbstractComponents.PracticeAbstract;

public class PracticeProductCatalogue extends PracticeAbstract{
	
	WebDriver driver;
	
	By productList = By.cssSelector(".mb-3");
	
	public PracticeProductCatalogue(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> productLists;
	
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastConatiner = By.cssSelector("#toast-container");
	
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
			
	public List<WebElement> findProducts()
	{
		elementVisibilityAppear(productList);
		return productLists;
	}
	
	public WebElement filterProduct(String productName)
	{
		return findProducts().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);


	}

	public void addToCart(String productName)
	{

		filterProduct(productName).findElement(addToCart).click();
		elementVisibilityAppear(toastConatiner);
		elementVisibilityDisappear(spinner);
	}
	
	
	
	
	

}
