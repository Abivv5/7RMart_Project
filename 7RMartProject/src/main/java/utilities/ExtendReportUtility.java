package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");// to create
																										// folder file

		reporter.config().setReportName("7RMart SuperMarket"); //

		extentReports.attachReporter(reporter);

		extentReports.setSystemInfo("Organization", "Obsqura");

		extentReports.setSystemInfo("Name", " Abi ");

		return extentReports;

	}

}
