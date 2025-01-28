package PankajShukla.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PankajShukla.AbstractComponents.PracticeAbstract;

public class PracticeLandingPage extends PracticeAbstract{

		WebDriver driver;
	
		public PracticeLandingPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
				
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement userPassword;
		
		@FindBy(id="login")
		WebElement login;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement error;
		
		
		By element=By.cssSelector(".mb-3");
		
		
		public PracticeProductCatalogue loginToApplication(String userEmailD,String userPasswordD)
		{
			userEmail.sendKeys(userEmailD);
			userPassword.sendKeys(userPasswordD);
			login.click();
		 PracticeProductCatalogue ps=new PracticeProductCatalogue(driver);
		 return ps;
		}
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		public String getErrorMessage()
		{
			elementVisibilityAppear(error);
			return error.getText();
		}
		

}
