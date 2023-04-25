package driverFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import commonFunctions.AddEmpPage;
import config.AppUtil1;
public class TestScript extends AppUtil1{
@Test
public void startTest()
{
	AddEmpPage emp =PageFactory.initElements(driver, AddEmpPage.class);
boolean res =emp.verify_Emp("Selenium","Manual","Automation");
System.out.println(res);
}
}
