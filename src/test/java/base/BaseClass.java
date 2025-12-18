package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import utils.PropertyFileUtil;

public class BaseClass {
	
	public static WebDriver driver;
	public String propFileName = "Environment";
	public  String iBrowserType = PropertyFileUtil.readDataFromPropertyFile(propFileName, "Browser"); // 1-chrome,2-edge,3-firefox,4-safari
	String sURL = PropertyFileUtil.readDataFromPropertyFile(propFileName,"URL");
	public String excelFileName = "";
	
	@BeforeClass 
	public  void invokeBrowser() {
		switch (iBrowserType.toLowerCase()) {
		case "chrome":
			System.out.println("User option is : " + iBrowserType + ",so invoking chrome browser");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.out.println("User option is : " + iBrowserType + ",so invoking edge browser");
			driver = new EdgeDriver();
			break;
		case "firefox":
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
	
	@AfterClass(alwaysRun = true)
	public  void closeBrowser() {
		driver.quit();
	}


	@DataProvider(name="TestCaseData")
	public Object[][] excelData() throws Exception {
		Object[][] values = utils.DataProviderObject.getValue(excelFileName);
		return values;
	}

}
