package TestComponents;

import Resources.ExtentReportNG;
import Test.OpenCareerTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends OpenCareerTest implements ITestListener
{
    WebDriver driver;
    ExtentTest test;
    ExtentReports extent = ExtentReportNG.getReportObject();

    @Override
    public void onTestStart(ITestResult result) {
       test =  extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());

        try {
//            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
//                    .get(result.getInstance());

        driver = OpenCareerTest.initializeDriver();
        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

        String filePath = null;
        try {
            filePath = getScreenShot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onFinish(ITestContext result) {
        extent.flush(); // Indicates end of process and it is important to generate the report
    }
}
