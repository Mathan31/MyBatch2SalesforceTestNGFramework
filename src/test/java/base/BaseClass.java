package base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import factoryDesign.BrowserFactoryManager;
import utils.PropertyFileUtil;
import wrapper.HTMLReport;

public class BaseClass extends HTMLReport{
	
	public WebDriver driver; // null --> 5457781 --> null
	public String propFileName = "Environment";
	public  String iBrowserType = PropertyFileUtil.readDataFromPropertyFile(propFileName, "Browser"); // 1-chrome,2-edge,3-firefox,4-safari
	String sURL = PropertyFileUtil.readDataFromPropertyFile(propFileName,"URL");
	public String excelFileName = "";
	public String testName,testDescription,testModule;
	
	@BeforeSuite
	public void reportInit() {
		startReport();
	}
	
	@AfterSuite
	public void bindReport() {
		endReport();
	}
	
	@BeforeClass 
	public  void invokeBrowser() {
		driver = BrowserFactoryManager.getDriver(iBrowserType).getDriverManager();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(sURL);
		driver.manage().window().maximize();
		startTestCase(testName, testDescription);
		startTestCase(testModule);
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

	@Override
	public String takeScreenshot() {
		String sPath = System.getProperty("user.dir")+"/snap/img"+System.currentTimeMillis()+".png";
		TakesScreenshot oShot = (TakesScreenshot)driver;
		File osrc = oShot.getScreenshotAs(OutputType.FILE);
		File dis = new File(sPath);
		try {
			FileUtils.copyFile(osrc, dis); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sPath;
	}

}
