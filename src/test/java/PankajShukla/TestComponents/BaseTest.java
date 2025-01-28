package PankajShukla.TestComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PankajShukla.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties property =new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\PankajShukla\\Resources\\GlobalData.properties");
		property.load(fis);
		
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : property.getProperty("browser");
		
		
		if(browserName.contains("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
			
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void teardDown()
	{
		driver.quit();
	}
	
	public List<HashMap<String, String>> getDataToMap(String filepath) throws IOException
	{
		
		String jsonContent= FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		
		ObjectMapper obj=new ObjectMapper();
		List<HashMap<String,String>> data=obj.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png");
		
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png";
	
	}

}
