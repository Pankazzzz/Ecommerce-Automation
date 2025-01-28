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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PankajShukla.PageObjects.PracticeLandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeBaseTest {

	public WebDriver driver; 
	public PracticeLandingPage lp;
	
	public WebDriver initializeDriver() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\PankajShukla\\Resources\\PracticeGlobalData.properties");
		Properties pr=new Properties();
		pr.load(fis);
		//String browser=pr.getProperty("browser");
		
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : pr.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			ChromeOptions cp=new ChromeOptions();

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\chromedriver.exe");
			
			//WebDriverManager.chromedriver().setup();

			if(browserName.contains("headless")) {
				cp.addArguments("headless");	
			}
			
			driver = new ChromeDriver(cp);	
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public PracticeLandingPage launchApplication() throws IOException
	{
		WebDriver driver=initializeDriver();
		lp=new PracticeLandingPage(driver);
		lp.goTo();
		return lp;
		
	}
	
	public List<HashMap<String, String>> getDataToMap(String filepath) throws IOException
	{
		
		String jsonContent= FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		
		ObjectMapper obj=new ObjectMapper();
		List<HashMap<String,String>> data=obj.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
	}
	
	@AfterMethod(alwaysRun  = true)
	public void tear()
	{
		driver.close();
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+ "\\reports\\"+ testCaseName + ".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+ "\\reports\\"+ testCaseName + ".png";	
	}
	
}
