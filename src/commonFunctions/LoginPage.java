package commonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage {
	@FindBy(xpath="//input[@id='txtUsername']") 
	WebElement EnterUser;
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement EnterPasswd;
	@FindBy(xpath="//input[@id='btnLogin']") 
	WebElement ClickLogin;
	public void verify_Login(String username,String password)
	{
		EnterUser.sendKeys(username);
		EnterPasswd.sendKeys(password);
		ClickLogin.click();
	}
}
