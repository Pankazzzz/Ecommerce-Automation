package PankajShukla.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PankajShukla.AbstractComponents.PracticeAbstract;

public class PracticeCheckoutPage extends PracticeAbstract{
	WebDriver driver;
	public PracticeCheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	By result= By.cssSelector(".ta-results");
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement submit;
	
	@FindBy(css=".action__submit")
	WebElement confirmationPage;
	
	
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();

		elementVisibilityAppear(result);
		submit.click();
	}
	
	
	public PracticeConfirmationPage goToConfirmationPage()
	{
		confirmationPage.click();	
		PracticeConfirmationPage pcp=new PracticeConfirmationPage(driver);
		return pcp;
	}
	
	
}
