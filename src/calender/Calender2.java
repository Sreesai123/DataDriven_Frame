package calender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender2 {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://flights.qedgetech.com/");
		driver.findElement(By.name("email")).sendKeys("jsaikumar610@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Sreesai@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='search-date']")).sendKeys("05/30/2023");
		Thread.sleep(3000);
		driver.quit();
		

	}

}
