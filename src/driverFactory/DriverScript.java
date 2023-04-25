	package driverFactory;
	import java.io.File;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.testng.Reporter;
	import org.testng.annotations.Test;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	import commonFunctions.FunctionalLibrary;
	import config.AppUtil;
	import utilities.ExcelFileUtil;
	public class DriverScript extends AppUtil {
		String inputpath="E:\\11oclock_Selenium\\DDT_FrameWork\\FileInput\\LoginData.xlsx";
		String outputpath="E:\\11oclock_Selenium\\DDT_FrameWork\\FileOutput\\DataDrivenResults.xlsx";
		ExtentReports report;
		ExtentTest test;
		@Test
		public void starTest() throws Throwable
		{
			ExcelFileUtil xl = new ExcelFileUtil(inputpath);
			int rc = xl.rowCount("Login");
			report = new ExtentReports("./ExtenReports/Login.html");
			Reporter.log("No of Rows::"+rc,true);
			for (int i = 1; i <=rc; i++) 
			{
				test = report.startTest("Validate Login");
				test.assignAuthor("Reddy");
				String Username = xl.getCelldata("Login", i, 0);
				String Password = xl.getCelldata("Login", i, 1);
				boolean res = FunctionalLibrary.verify_Login(Username, Password);
				if (res) 
				{
	
					xl.SetCelldata("Login", i, 2, "Login Sucess", outputpath);
					xl.SetCelldata("Login", i, 3, "Pass", outputpath);
					test.log(LogStatus.PASS, "Login Sucess");
				}
				else 
				{
					File Screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(Screen, new File("./Screenshot/iteration/"+i+"Loginpage.png") );
					xl.SetCelldata("Login", i, 2, "Login Fail", outputpath);
					xl.SetCelldata("Login", i, 3, "Fail", outputpath);
					test.log(LogStatus.FAIL, "Login Fail");
				}
				report.endTest(test);
				report.flush();
			}
		}
	}
	
