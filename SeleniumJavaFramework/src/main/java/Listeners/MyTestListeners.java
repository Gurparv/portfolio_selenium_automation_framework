package Listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("👂 Listener on Test Start...");
        System.out.println("Do something.. goes here");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("👂 Listener on Test Start...");
        System.out.println("Test case passed");
        System.out.println("Do something.. goes here");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("👂 Listener on Test Failure...");
        System.out.println("Test case failed.");
        System.out.println("Do something.. goes here");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("👂 Listener on Test Skipped...");
        System.out.println("Test case Skipped");
        System.out.println("Do something.. goes here");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
