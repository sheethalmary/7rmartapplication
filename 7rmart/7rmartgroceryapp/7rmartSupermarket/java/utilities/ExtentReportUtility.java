package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility{

	public static final ExtentReports extentReports = new ExtentReports();   //EXTENSIVE HTML REPORT,SINGLE GLOBAL ACESSIBKE INSTANCE OF EXTEND REPORT
	public synchronized static ExtentReports createExtentReports() {    
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //CLASS- CREATION AND CONFOGURATION of htmlreport
		
		reporter.config().setReportName("GROCERY APPLICATION");  //SET TITLE		
extentReports.attachReporter(reporter);  
		extentReports.setSystemInfo("Organization", "Obsqura");  //these are system level information
		extentReports.setSystemInfo("Name", "Sheethal");
		return extentReports;   
	}
}//SYNCHRONIZE-THREAD SAFETY...MULTIPLE RUN
//IT SPECIFY FILE PATH TO SAVE REPORT
//to call this listeners