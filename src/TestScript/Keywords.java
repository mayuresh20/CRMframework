package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Keywords {

	static FirefoxDriver driver;
	static Properties prop;
	static FileInputStream input;
	public void openbrowser() throws IOException  {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		prop = new Properties();
		input =	new FileInputStream("G:\\Satish Sir\\salesforce\\src\\ObjectRepository\\objectrepository.properties");
		prop.load(input);
	}
	
	public void input(String testData, String objectName) {
		driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(testData);
		
	}
	
	public void navigate(String testData) {
		driver.get(testData);
		
	}
	
	public void click(String objectName)  {
		driver.findElement(By.xpath(prop.getProperty(objectName))).click();
		
	}

	public void selectlist(String testData, String objectName) {
		Select select = new Select(driver.findElement(By.xpath(prop.getProperty(objectName))));
		select.selectByValue(testData);
	}

	public String verifypagetitle(String expectedTestData) {
		String actualValue  = driver.getTitle();
		return actualValue;
	}

	public String verifyeditboxtext(String expectedTestData, String objectName) {
		String actualValue = driver.findElement(By.xpath(prop.getProperty(objectName))).getAttribute("value");
		return actualValue;
	}

	public String verifypagetext(String expectedTestData, String objectName) {
		String actualValue = driver.findElement(By.xpath(prop.getProperty(objectName))).getText();
		return actualValue;
	}

		

}
