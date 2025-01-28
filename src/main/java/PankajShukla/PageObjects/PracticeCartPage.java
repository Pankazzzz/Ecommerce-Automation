package PankajShukla.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PankajShukla.AbstractComponents.PracticeAbstract;

public class PracticeCartPage extends PracticeAbstract{
	
	WebDriver driver;
	public PracticeCartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(css=".cartSection h3")
	List <WebElement> products;

	@FindBy(css=".totalRow button")
	WebElement checkoutPage;
	
	
	public boolean verifyProductDisplay(String productName)
	{
		boolean match=products.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public PracticeCheckoutPage goToCheckoutPage()
	{
		checkoutPage.click();
		PracticeCheckoutPage cpg=new PracticeCheckoutPage(driver);
		return cpg;
	}
}
