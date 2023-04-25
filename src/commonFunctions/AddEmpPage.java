package commonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
public class AddEmpPage {
	WebDriver driver;
	public AddEmpPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	@FindBy(xpath="//b[normalize-space()='PIM']")
	WebElement ClickPim;
	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement ClickAddbtn;
	@FindBy(xpath="//input[@id='firstName']")
	WebElement EnterFname;
	@FindBy(xpath="//input[@id='middleName']")
	WebElement EnterMname;
	@FindBy(xpath="//input[@id='lastName']")
	WebElement EnterLname;
	@FindBy(xpath ="//input[@id='employeeId']")
	WebElement BeforeEid;
	@FindBy(id = "btnSave")
	WebElement ClickSaveBtn;
	@FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
	WebElement AfterEid;
	public boolean verify_Emp(String fname,String mname,String lname)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(ClickPim).click().perform();
		ac.moveToElement(this.ClickAddbtn).click().perform();
		this.EnterFname.sendKeys(fname);
		this.EnterMname.sendKeys(mname);
		this.EnterLname.sendKeys(lname);
		String ExpecetedEid = this.BeforeEid.getAttribute("value");
		ac.moveToElement(this.ClickSaveBtn).click().perform();
		String ActualEid = this.AfterEid.getAttribute("value");
		if (ExpecetedEid.equals(ActualEid)) 
		{
			Reporter.log("Add Employee Sucess::"+ExpecetedEid+"   "+ActualEid,true);
			return true;
		}
		else
		{
			Reporter.log("Add Employee fail::"+ExpecetedEid+"   "+ActualEid,true);
			return false;
		}
	}

}
