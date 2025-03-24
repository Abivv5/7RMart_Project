package listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationCore.Base;
import utilities.ExtendReportUtility;

public class Listeners extends Base implements ITestListener { //ItestListener is a inbuilt interface
	ExtentTest test;

	ExtentReports extent = ExtendReportUtility.createExtentReports();

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) { //fetch the method name attach into the report

		ITestListener.super.onTestStart(result);

		test = extent.createTest(result.getMethod().getMethodName());

		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) { //onTestSuccess is a predefined method from ItestListener interface
		//when invoke once the testcase pass.

		ITestListener.super.onTestSuccess(result);

		extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) { // Called when a test method fails.

		ITestListener.super.onTestFailure(result);

		extentTest.get().log(Status.FAIL, "Test Failed");

		extentTest.get().fail(result.getThrowable());

		WebDriver driver = null;

		String testMethodName = result.getMethod().getMethodName();

		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")

					.get(result.getInstance());

		} catch (IllegalArgumentException e) {

			e.printStackTrace();

		} catch (IllegalAccessException e) {

			e.printStackTrace();

		} catch (NoSuchFieldException e) {

			e.printStackTrace();

		} catch (SecurityException e) {

			e.printStackTrace();

		}

		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")

					.get(result.getInstance());

		} catch (Exception e) {

		}

	}

	public void onTestSkipped(ITestResult result) { //when TC skipped.

		ITestListener.super.onTestSkipped(result);

		extentTest.get().log(Status.SKIP, "Test Skipped");

		String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);

	}

	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);

	}

	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);

	}

	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);

		extent.flush();

	}

}
