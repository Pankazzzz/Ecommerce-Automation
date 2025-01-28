package PankajShukla.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PankajShukla.AbstractComponents.PracticeAbstract;

public class PracticeConfirmationPage extends PracticeAbstract{
	WebDriver driver;
	public PracticeConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(css=".hero-primary")
	WebElement header;
	
	
	
	public String getHeader()
	{
		return header.getText();
	}
}
