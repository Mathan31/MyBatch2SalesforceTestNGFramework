package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	public  int iBrowserType = 1; // 1-chrome,2-edge,3-firefox,4-safari
	String sURL = "https://login.salesforce.com/";
	
	@BeforeClass
	public  void invokeBrowser() {
		switch (iBrowserType) {
		case 1:
			System.out.println("User option is : " + iBrowserType + ",so invoking chrome browser");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User option is : " + iBrowserType + ",so invoking edge browser");
			driver = new EdgeDriver();
			break;
		case 3:
			System.out.println("User option is : " + iBrowserType + ",so invoking firefox browser");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("User option is wrong : " + iBrowserType + ",so invoking the default chrome browser");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(sURL);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public  void closeBrowser() {
		driver.quit();
	}


}
