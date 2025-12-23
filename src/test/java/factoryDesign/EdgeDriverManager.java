package factoryDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager implements FactoryInterface{

	@Override
	public WebDriver getDriverManager() {
		// TODO Auto-generated method stub
		return new EdgeDriver();
	}

}
