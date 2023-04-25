package driverFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;
import commonFunctions.AddEmpPage;
import config.AppUtil1;
import utilities.ExcelFileUtil;
public class TestScript1withExcel extends AppUtil1{
	String inputpath ="E:\\11oclock_Selenium\\DDT_FrameWork\\FileInput\\Employee.xlsx";
	String outputpath ="E:\\11oclock_Selenium\\DDT_FrameWork\\FileOutput\\EmpResults.xlsx";
	@Test
	public void startTest()throws Throwable
	{
		AddEmpPage emp =PageFactory.initElements(driver, AddEmpPage.class);
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc =xl.rowCount("EmpData");
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String FirstName =xl.getCelldata("EmpData", i, 0);
			String MiddleName =xl.getCelldata("EmpData", i, 1);
			String Lastname =xl.getCelldata("EmpData", i, 2);
			boolean res =emp.verify_Emp(FirstName, MiddleName, Lastname);
			if(res)
			{
				xl.SetCelldata("EmpData", i, 3, "Pass", outputpath);
			}
			else
			{
				xl.SetCelldata("EmpData", i, 3, "Fail", outputpath);
			}
		}
	}
}

