package PankajShukla.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject()
	{
			String path= System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter=new ExtentSparkReporter(path);
			reporter.config().setDocumentTitle("Extent Testing");
			reporter.config().setReportName("Web automation test report");
			
			ExtentReports extent=new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Pankaj");
			return extent;
		
	}
}
