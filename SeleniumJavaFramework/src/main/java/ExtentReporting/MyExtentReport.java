package ExtentReporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyExtentReport {
    public ExtentReports extent;
    public String currentMethodName;
    public ExtentTest test;

    public ExtentReports instantiateReportingAgent(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/MyReport.html");
        spark.config().setDocumentTitle("Automation Test Report");
        extent.attachReporter(spark);

        return extent;
    }

    public ExtentTest instantiateExtentReport(){
        currentMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println("Current Method -> " + currentMethodName);
        System.out.println("Instantiating test to a value..");
        test = extent.createTest(currentMethodName);
        System.out.println(test);
        return test;
    }

    public void addToReport(){
        extent.flush();
    }

}
