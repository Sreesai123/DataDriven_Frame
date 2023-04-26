package calender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://flights.qedgetech.com/");
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.name("dob")).sendKeys("14-07-2020");
		driver.quit();
	}
}
