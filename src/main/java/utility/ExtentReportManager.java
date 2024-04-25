package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class ExtentReportManager extends TestBase {
	static ExtentReports report;
	public static ExtentReports getReport() {
		
		if(report==null) {
			
			String ReportName=new SimpleDateFormat("dd-MM-YYY hh-mm-ss").format(new Date());
			ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("A:\\java\\WebAuto\\ExtentReports"+ReportName+".html");
			report=new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("Os","Windows");
			report.setSystemInfo("Environment","SIT");
			report.setSystemInfo("Build Number","12.11");
			report.setSystemInfo("Browser","Chrome");
			htmlReporter.config().setDocumentTitle("UI testing document");
			htmlReporter.config().setReportName("UI test report");
		}
		
		return report;
		
	}
  
}
