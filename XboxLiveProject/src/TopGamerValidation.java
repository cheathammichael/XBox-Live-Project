import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TopGamerValidation {
	public String baseUrl = "https://www.xboxgamertag.com/";
	String driverPath = "geckodriver.exe";
	public WebDriver driver;
	public String expected = null;
	public String actual = null;
	CustomAssertion m_custom = new CustomAssertion();
	public String userNameFor6 = "";
	
	@BeforeTest
	public void launchBrowser() throws FileNotFoundException {
		System.out.println("launching firefox browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		driver.findElement(By.linkText("Leaderboards")).click();
		//PrintWriter out = new PrintWriter("test.txt");
		//out.println("This is test text to identify the default location of file output/input");
		//out.close();
		System.out.println("Before filename");
		//File userName = new File("C:\\Users\\michael.cheatham\\eclipse-workspace\\XboxLiveProject\\search-conf.txt");
		File userName = new File("search-conf.txt");
		
		System.out.println("Before scanner");
		Scanner scan = new Scanner(userName);
		System.out.println("Before file read");
	    userNameFor6 = scan.next();
		
		System.out.println("After file read");
		scan.close();
	}
	
	@Test(priority = 0)
	public void numberOne() {
	
		m_custom.addMessage(driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/a")).getText());
		m_custom.addCompare(driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/a")).getText());
	    m_custom.addMessage(driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/p")).getText());
	    m_custom.addCompare(driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/p")).getText());
	    assert(m_custom.assertCompare());
	    m_custom.messagesClear();
	}
	
	@Test(priority = 1)
	public void numberTwo() {
		
		m_custom.addMessage(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/a")).getText());
		m_custom.addCompare(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/a")).getText());
	    m_custom.addMessage(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/p")).getText());
	    m_custom.addCompare(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/p")).getText());
	    assert(m_custom.assertCompare());
	    m_custom.messagesClear();
	}
	
	@Test(priority = 2)
	public void numberThree() {
		
		m_custom.addMessage(driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[3]/a")).getText());
		m_custom.addCompare(driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[3]/a")).getText());
	    m_custom.addMessage(driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[4]/p")).getText());
	    m_custom.addCompare(driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[4]/p")).getText());
	    assert(m_custom.assertCompare());
	    m_custom.messagesClear();
	}
	
	@Test(priority = 3)
	public void numberFour() {
	
		m_custom.addMessage(driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[3]/a")).getText());
		m_custom.addCompare(driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[3]/a")).getText());
	    m_custom.addMessage(driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[4]/p")).getText());
	    m_custom.addCompare(driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[4]/p")).getText());
	    assert(m_custom.assertCompare());
	    m_custom.messagesClear();
	    
	}
	
	@Test(priority = 4)
	public void numberFive() {
	
		m_custom.addMessage(driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div[3]/a")).getText());
		m_custom.addCompare(driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div[3]/a")).getText());
	    m_custom.addMessage(driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div[4]/p")).getText());
	    m_custom.addCompare(driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div[4]/p")).getText());
	    assert(m_custom.assertCompare());
	    m_custom.messagesClear();
	    
	}
	
	@Test(priority = 5)
	public void validateGames() {
		driver.get(baseUrl);
		WebElement wb = null;
		wb = driver.findElement(By.xpath("/html/body/div[1]/form/input[1]"));
		wb.click();
		wb.sendKeys(userNameFor6);
		wb = driver.findElement(By.xpath("/html/body/div[1]/form/input[2]"));
		wb.click();
		for (int i = 1; i < 5; i++)
		{ 
		//Modify all tests for use of css selector.
						
			m_custom.addMessage(driver.findElement(By.cssSelector("div.col-lg-4:nth-child(" + i + ") > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h3:nth-child(1) > a:nth-child(1)")).getText());

			m_custom.addCompare(driver.findElement(By.cssSelector("div.col-lg-4:nth-child(" + i + ") > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h3:nth-child(1) > a:nth-child(1)")).getText());
		}
		assert(m_custom.assertCompare());

		m_custom.messagesClear();
	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
	}
}
/*
no1 = ));
no2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/h3/a"));
no3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/h3/a"));
no4 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[4]/div/div/div[1]/h3/a"));
t1 = no1.getText();
t2 = no2.getText();
t3 = no3.getText();
t4 = no4.getText();
assert(t1.compareTo("League of Legends")==0);
assert(t2.compareTo("Fortnite")==0);
assert(t3.compareTo("DARK SOULS™ II")==0);
assert(t4.compareTo("Skyrim")==0);
*/