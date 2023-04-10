package base;

import org.testng.*;

public class Listener implements ITestListener {

    // This belongs to ITestListener and will execute before the whole Test starts

    @Override
    public void onStart(ITestContext arg0) {

        Reporter.log("About to begin executing Class " + arg0.getName(), true);
        System.out.println("");
    }

    // This belongs to ITestListener and will execute, once the whole Test is finished

    @Override
    public void onFinish(ITestContext arg0) {
        Reporter.log("About to end executing Class " + arg0.getName(), true);
        System.out.println("");
    }
    // This belongs to ITestListener and will execute before each test method

    @Override
    public void onTestStart(ITestResult arg0) {
        System.out.println("---------------------------------");
        Reporter.log("Testcase " + arg0.getName() + " started successfully", true);

    }

    // This belongs to ITestListener and will execute only in the event of a successful test method
    public void onTestSuccess(ITestResult arg0) {
        Reporter.log("Testcase " + arg0.getName() + " passed successfully", true);
        System.out.println("---------------------------------");
        System.out.println("");
    }

    // This belongs to ITestListener and will execute only in the event of a fail test

    public void onTestFailure(ITestResult arg0) {
        Reporter.log("Testcase " + arg0.getName() + " failed", true);
        System.out.println("---------------------------------");
        System.out.println("");

    }

    // This belongs to ITestListener and will execute only in the event of the skipped test method

    public void onTestSkipped(ITestResult arg0) {
        Reporter.log("Testcase " + arg0.getName() + " got skipped", true);
        System.out.println("---------------------------------");
        System.out.println("");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }


}
