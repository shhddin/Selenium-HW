package hw16;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumMethods {
	WebDriver driver;
	WebElement searchElement;
	WebElement element;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.ebay.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(enabled = true, priority = 1)
	public void manageAndNavigate() throws InterruptedException {
		searchElement = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
		searchElement.sendKeys("toilet paper", Keys.ENTER);
		Thread.sleep(5000);
		driver.navigate().to("http://www.yahoo.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		searchElement = driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]"));
		searchElement.sendKeys("Which computer is good for testing");
		Thread.sleep(3000);
		searchElement.clear();
		driver.navigate().back();
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.manage().window().fullscreen();

	}

	@Test(enabled = true, priority = 2)
	public void dimension()  {
		Dimension dimension = new Dimension(800, 500);
		driver.manage().window().setSize(dimension);
		}

	@Test(enabled = true, priority = 3)
	public void cookiePopup() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.nationwide.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		searchElement = driver.findElement(By.xpath("//button[@id='truste-consent-button']"));
		searchElement.click();
		Thread.sleep(2000);
	}

	@Test(enabled = false, priority = 4)
	public void dropdown() throws InterruptedException {
		Select select = new Select(driver.findElement(By.xpath("//select[@id='customSelectQuote']")));
		select.selectByIndex(1);
		Thread.sleep(5000);
		select.selectByValue("Homeowners");
		Thread.sleep(5000);
		select.selectByVisibleText("Auto");
		Thread.sleep(5000);

	}

	@Test(enabled = true, priority = 5)
	public void actions() throws InterruptedException {
		Actions action = new Actions(driver);
		searchElement = driver.findElement(By.xpath("//button[@id='truste-consent-button']"));
		action.moveToElement(searchElement).click().build().perform();
		Thread.sleep(5000);
		searchElement = driver.findElement(By.className("nw-header__search"));
		action.moveToElement(searchElement).click().build().perform();
		Thread.sleep(5000);
	}

	@Test(enabled = true, priority = 6)
	public void alert1() throws InterruptedException {
		driver.get("https://enthrallit.com/selenium");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		element = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
		element.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept();
		Thread.sleep(5000);
	}

	@Test(enabled = true, priority = 7)
	public void alert2() throws InterruptedException {
		element = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]"));
		element.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.dismiss();
		Thread.sleep(5000);
	}

	@Test(enabled = true, priority = 8)
	public void alert3() throws InterruptedException {
		element = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]"));
		element.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.sendKeys("Shahed Uddin");
		alert.accept();
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();

	}
}
