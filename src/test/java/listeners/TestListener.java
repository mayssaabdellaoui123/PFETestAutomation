package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.BaseFile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

public class TestListener extends BaseFile implements ITestListener {
    static int screenshotCounter = 0;

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        String location = "images/";
        String methodName = result.getName();
        if(result.getThrowable() != null){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            System.out.println(sw.toString());
            //k nhebou na3mlou screeshot :
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            File snapshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
            //bech na3mlou dossier jdid : path eli chyethal fih l screenshot w esm te3 image :
            try {
                FileUtils.copyFile(snapshot, new File(location + methodName + screenshotCounter +"_" + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
