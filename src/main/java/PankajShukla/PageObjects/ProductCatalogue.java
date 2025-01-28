package PankajShukla.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PankajShukla.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

		
		WebDriver driver;
		
		public ProductCatalogue(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		//WebElement userEmail=driver.findElement(By.id("userEmail"));
		
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
		@FindBy(css=".ng-animating")
		WebElement spinner;
		
		By productsBy=By.cssSelector(".mb-3");
		By addToCart=By.cssSelector(".card-body button:last-of-type");
		By toaster=By.cssSelector("#toast-container");
		
		public List<WebElement> getProducts()
		{
		
			waitForElementsToAppear(productsBy);
			return products;
		}
		
		public WebElement getProductByName(String productName)
		{

			WebElement prod =	getProducts().stream().filter(product->
				product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
			return prod;
		}
		
		public void addToCart(String productName)
		{
			WebElement prod=getProductByName(productName);
			prod.findElement(addToCart).click();
			waitForElementsToAppear(toaster);
			waitForElementsToDisappear(spinner);

		}
		

}
