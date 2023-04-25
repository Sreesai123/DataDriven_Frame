package commonFunctions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Reporter;
import config.AppUtil;
public class FunctionalLibrary extends AppUtil {
	public static boolean verify_Login(String user,String Passwd)
	{
		driver.get(conpro.getProperty("Url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(conpro.getProperty("ObjUser"))).sendKeys(user);
		driver.findElement(By.xpath(conpro.getProperty("ObjPass"))).sendKeys(Passwd);
		driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();
		String Expected = "dashboard";
		String Actual = driver.getCurrentUrl();
		if (Actual.contains(Expected)) 
		{
			Reporter.log("Login Sucess::"+Expected+"   "+Actual,true);
			return true;
		}
		else 
		{
			String Error_Message = driver.findElement(By.xpath(conpro.getProperty("Objerror"))).getText();
			Reporter.log(Error_Message+"  "+Expected+"   "+Actual,true);
			return false;
		}
	}
}


