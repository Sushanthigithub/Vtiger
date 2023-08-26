package listenersTestng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " Test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ "Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ "Fail");
		System.out.println("Failed because: "+result.getThrowable());
		TakesScreenshot ts=(TakesScreenshot)(BaseClass2.sdriver);
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/" + result.getMethod().getMethodName()+ ".png");
		
		try {
			FileUtils.copyFile(src, dest);
		}  catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() +"Skipped");
		System.out.println(result.getThrowable()+ "Occured");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite execution started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution Terminated");
	}
    
}
