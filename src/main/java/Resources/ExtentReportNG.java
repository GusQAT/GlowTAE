package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    public static ExtentReports getReportObject()
    {
        String path = System.getProperty("user.dir")+"\\Reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path); // Class in charge of creating report
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Gus");
        return extent;
    }
}
