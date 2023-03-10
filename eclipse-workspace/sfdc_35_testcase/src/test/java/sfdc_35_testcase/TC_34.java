package sfdc_35_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_34 extends ReusableMethods {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		 WebDriverManager.chromedriver().setup();
//		  WebDriverManager.firefoxdriver().setup();
		  driver =new ChromeDriver();
		  driver.get("https://login.salesforce.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Uname=driver.findElement(By.xpath("//input[@id='username']"));
		enterText(Uname, "mithun.r@tekarch.com", "UserName");
		WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
		pwd.clear();
		enterText(pwd, "Test4321", "Password");
	    WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	    clickObj(login, "login");
	    String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		System.out.println("User is on home page");
		}
		else {
			System.out.println("home page is not Lunched");
		}
		WebElement Home = driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]"));
		clickObj(Home, "Home");
		Thread.sleep(2000);

		WebElement NameLink = driver.findElement(By.xpath("//a[contains(text(),'sdgMithun Deekshith')]"));
		clickObj(NameLink, "NameLink");
		 String homepage = driver.getWindowHandle();
		 System.out.println("homepage is displayed");
		 WebElement Edit = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']"));
		 clickObj(Edit, "Edit");
		 Thread.sleep(3000);
		driver.switchTo().frame("contactInfoContentId");
		driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
		Thread.sleep(3000);
		WebElement lastname = driver.findElement(By.className("lastName"));
		lastname.clear();
		lastname.sendKeys("Kotagiri");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")).click();
		driver.close();
		System.out.println("TC34_EditedLastName Executed sucessfully");
	}
}
