package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class SalesPage extends MenuPage {

	private By leadsLink = By.xpath("//a/span[text()='Leads']");
	private By newBtn = By.xpath("//div[text()='New']");
	private By lastnameTxt = By.xpath("//input[@name='lastName']");
	private By companyTxt = By.xpath("//input[@name='Company']");
	// private By leadStatusBtn=By.xpath("//button[@data-value='Open - Not
	// Contacted']");
	private By leadStatusBtn = By.xpath("//label[contains(text(),'Lead Status')]/ancestor::div[@part='combobox']/div[1]//button");
	private By statusTxt = By.xpath("(//span[@title='Working - Contacted'])[2]");
	private By savebtn = By.xpath("//button[@name='SaveEdit']");
	private By noOfEmployee = By.xpath("//input[@name='NumberOfEmployees']");


	

	public SalesPage clickOnNewButton() {
		driver.findElement(newBtn).click();
		return this;
	}

	public SalesPage enterLastName(String lastName) {
		driver.findElement(lastnameTxt).sendKeys(lastName);
		return this;
	}
	
	public SalesPage clickOnLeadsLink() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(leadsLink)).click().perform();
		return this;
	}
	

	public SalesPage clickAndSelectLeadStatus() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(noOfEmployee)).perform();
		try {
			Thread.sleep(3000);
			driver.findElement(leadStatusBtn).click();
			Thread.sleep(2000);
			driver.findElement(statusTxt).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this;
	}

	public SalesPage enterCompanyName(String companyName) {
		driver.findElement(companyTxt).sendKeys(companyName);
		return this;
	}

	public SalesPage clickOnSaveButton() {
		driver.findElement(savebtn).click();
		return this;
	}

}
