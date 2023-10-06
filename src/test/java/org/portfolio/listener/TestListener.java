package org.portfolio.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.portfolio.util.Constants;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        //it will give us an actual driver obj which was created in BaseTest -> BeforeTest
        TakesScreenshot driver = (TakesScreenshot) result.getTestContext().getAttribute(Constants.DRIVER);

        //we can output as file or bytes, but BASE64 will be useful when we will use Jenkins
        String screenshot = driver.getScreenshotAs(OutputType.BASE64);

        //this is a string format we need to be able to implement image in html surefire report
        String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s' />";

        String htmlImage = String.format(htmlImageFormat, screenshot);

        //this will embed image in html report
        Reporter.log(htmlImage);
    }
}
