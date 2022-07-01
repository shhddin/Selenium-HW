package hw14ClickMethod;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickMethod {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.xfinity.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1)
	public void clickOnElement() throws InterruptedException {
		driver.findElement(By.cssSelector("a.xc-header--signin-link")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 2)
	public void inputId() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='user']")).sendKeys("abcd");
		Thread.sleep(10000);
		driver.findElement(By.id("sign_in")).click();
		Thread.sleep(5000);
	}

	@Test(enabled = true, priority = 3)
	public void enrollButton() {
		driver.manage().deleteAllCookies();
		driver.get("https://enthrallit.com/accounts/login/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[@class='btn navapply-btn']")).click();

	}

	@AfterTest
	public void tearUp() {
		driver.quit();

	}

}
