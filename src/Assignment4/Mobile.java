package Assignment4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mobile 
{
	public WebDriver driver;
	
	  //for click on Mobile menu and List
	  @Test (priority=1)
	  public void clickOnMobile() 
	  {
		  System.out.println("Sagar kotwal");
		  System.out.println("In th 1st Test");
		  driver.findElement(By.cssSelector("div[class='page-header-container'] div[id='header-nav'] a")).click();
		  driver.findElement(By.cssSelector("div[class='main'] div[class='col-main'] div[class='toolbar'] a")).click();
		  
	  }
	  
	
	  //for click on compare Two Mobile
	  @Test (priority=2)
	  public void clickOnCompare()
	  {
		  System.out.println("In the 2nd Test");
		  driver.findElement(By.cssSelector("#products-list > li:nth-child(1) > div > div > div:nth-child(3) > ul > li:nth-child(2) > a")).click();
		  driver.findElement(By.cssSelector("div[class='main'] div[class='col-main'] li[class='item even'] a[class='link-compare']")).click();
	  }
	  
	  //for click on Compare Button
	  @Test (priority=3)
	  public void clickOnButton() throws InterruptedException
	  {
		  System.out.println("In th 3rd Test");
		  driver.findElement(By.cssSelector("div[class='main']  div[class='col-right sidebar'] button")).click();
		  Thread.sleep(5000);
	  }
	  
	  //for Switch into window and verify the product is reflected in the windows
	  @Test (priority=4)
	  public void verifyWindows() throws InterruptedException
	  {
		  System.out.println("In the 4th Test");
		  Set<String> windows = driver.getWindowHandles();
		  Iterator<String> itr= windows.iterator();
		  while(itr.hasNext())
		  {
			  
		   String we=itr.next();
		   System.out.println("THe windows = "+we);
		   driver.switchTo().window(we);
		  }	     
		   Boolean flag1 = driver.findElement(By.cssSelector("table[class='data-table compare-table'] a img")).isDisplayed();
		   Boolean flag2 =  driver.findElement(By.cssSelector("table[class='data-table compare-table'] a img[alt='IPhone']")).isDisplayed();
		  
		  if(flag1.equals(flag2))
		  {
			  System.out.println("The product is Reflected");
		  }
		  
		  
	  }
	  
	  @BeforeMethod
	  public void getAllCookies() 
	  {
		  Set<Cookie> cookies = driver.manage().getCookies();
		  for(Cookie cookie : cookies)
		  {
			  System.out.println("The Cookie Name is = "+cookie.getName());
		  }
	  }

	  @AfterMethod
	  public void screenshot() throws IOException 
	  {
		  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFileToDirectory(src, new File("F:\\Users\\asus\\eclipse-workspace\\MobileUsingTestNGassign\\src\\Assignment4\\screenshot\\"));
	  }

	  @BeforeClass
	  public void maximizeBrowser() 
	  {
		  driver.manage().window().maximize();
		  System.out.println("The Browser is Maximize");
	  }

	  @AfterClass
	  public void dbConnectionClose()
	  {
		 System.out.println("The Data Base Connetion Close");
	  }

	  @BeforeTest
	  public void enterApplictionURL() 
	  {
		  driver.get("http://live.guru99.com/");
		  System.out.println("The URL is UP");
	  }

	  @AfterTest
	  public void deleteAllCookies() 
	  {
		  driver.manage().deleteAllCookies();
		  System.out.println("All Cookies are delete");
	  }

	  @BeforeSuite
	  public void openBrowser() 
	  {
		  System.setProperty("webdriver.chrome.driver", "F:\\SeleniumgridFile\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }

	  @AfterSuite
	  public void afterSuite() throws InterruptedException 
	  {
		  Thread.sleep(5000);
		  driver.quit();
		  System.out.println("The Browser is close");
	  }


}
