package PankajShukla.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PankajShukla.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{

		
		WebDriver driver;
		
		public LandingPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		//WebElement userEmail=driver.findElement(By.id("userEmail"));
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement userPassword;

		@FindBy(id="login")
		WebElement login;

		@FindBy(css="[class*='flyInOut']")
		WebElement error;
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		public ProductCatalogue LoginApplication(String email,String password)
		{
			userEmail.sendKeys(email);
			userPassword.sendKeys(password);
			login.click();
			ProductCatalogue productsCatalogue=new ProductCatalogue(driver);
			return productsCatalogue;
		}

		public String getErrorMessage()
		{
			waitForElementToAppear(error);
			return error.getText();
		}
}
