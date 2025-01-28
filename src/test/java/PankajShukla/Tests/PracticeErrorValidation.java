package PankajShukla.Tests;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.awt.Window;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PankajShukla.PageObjects.PracticeCartPage;
import PankajShukla.PageObjects.PracticeCheckoutPage;
import PankajShukla.PageObjects.PracticeConfirmationPage;
import PankajShukla.PageObjects.PracticeLandingPage;
import PankajShukla.PageObjects.PracticeProductCatalogue;
import PankajShukla.TestComponents.PracticeBaseTest;
import PankajShukla.TestComponents.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeErrorValidation extends PracticeBaseTest{

	@Test(groups = {"ErrorValidation"}, retryAnalyzer = Retry.class)
	public void submitOrderError() throws IOException {
		// TODO Auto-generated method stub

		String productName = "Banarsi Saree";
		PracticeProductCatalogue ps=lp.loginToApplication("geraltofrivia8@gmail.com", "FTesting@1");
		lp.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());

	}

}
