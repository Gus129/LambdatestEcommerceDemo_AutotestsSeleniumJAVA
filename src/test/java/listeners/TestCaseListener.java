package listeners;

import base.BaseTest;
import org.testng.*;


public class TestCaseListener extends BaseTest implements ITestListener {

    // This belongs to ITestListener and will execute before the whole Test starts

    @Override
    public void onStart(ITestContext result) {

        Reporter.log("About to begin executing Class " + result.getName(), true);
        System.out.println("");
    }

    // This belongs to ITestListener and will execute, once the whole Test is finished

    @Override
    public void onFinish(ITestContext result) {
        Reporter.log("About to end executing Class " + result.getName(), true);
        System.out.println("");
    }
    // This belongs to ITestListener and will execute before each test method

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("---------------------------------");
        Reporter.log("Testcase " + result.getName() + " started successfully", true);

    }

    // This belongs to ITestListener and will execute only in the event of a successful test method
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Testcase " + result.getName() + " passed successfully", true);
        System.out.println("---------------------------------");
        System.out.println("");
    }

    // This belongs to ITestListener and will execute only in the event of a fail test

    public void onTestFailure(ITestResult result) {

        Reporter.log("Testcase " + result.getName() + " failed", true);
        failureScreenshot(result.getName());
        System.out.println("---------------------------------");
        System.out.println("");


    }

    // This belongs to ITestListener and will execute only in the event of the skipped test method

    public void onTestSkipped(ITestResult result) {
        Reporter.log("Testcase " + result.getName() + " got skipped", true);
        System.out.println("---------------------------------");
        System.out.println("");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }


}
