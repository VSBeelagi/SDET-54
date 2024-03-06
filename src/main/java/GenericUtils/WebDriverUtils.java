package GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.mysql.cj.jdbc.Driver;

public class WebDriverUtils {

	public void waitForPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public WebDriverWait webdriverWaitObj(WebDriver driver, int sec) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
	
	public void waitUntilEleToBeVisible(WebDriver driver, int sec, WebElement element)
	{
		webdriverWaitObj(driver, sec).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilEleToBeClickable(WebDriver driver, int sec, WebElement element)
	{
		webdriverWaitObj(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilAlertToBEPresent(WebDriver driver, int sec)
	{
		webdriverWaitObj(driver, sec).until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * Object creation to handle dropdown
	 * @param element
	 * @return
	 */
	public Select dropdownObj(WebElement element)
	{
		Select sel = new Select(element);
		return sel;
	}
	
	public void handleDropdown(WebElement element, int index)
	{
		dropdownObj(element).selectByIndex(index);
	}
	
	public void handleDropdown(WebElement element, String value )
	{
		dropdownObj(element).selectByValue(value);
	}
	
	public void handleDropdown(String text, WebElement element)
	{
		dropdownObj(element).selectByVisibleText(text);
	}
	
	public Actions actionObj(WebDriver driver)
	{
		Actions act = new Actions(driver);
		return act;
	}
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
		
		actionObj(driver).dragAndDrop(src, dst).perform();
	}
	
	public void mouseHoverOnEle(WebDriver driver, WebElement element)
	{
		actionObj(driver).click(element).perform();
	}
	
	public void doubleClick(WebDriver driver)
	{
		actionObj(driver).doubleClick().perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		actionObj(driver).doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver)
	{
		actionObj(driver).contextClick().perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		actionObj(driver).contextClick(element).perform();
	}
	
	/**
	 * This method will Press Enter Key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		actionObj(driver).sendKeys(Keys.ENTER).perform();
	}
	
	public void switchToWindow(WebDriver driver, String expWind)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			String currentTitle = driver.switchTo().window(win).getTitle();
			
			if(currentTitle.contains(expWind))
			{
				break;
			}
				
		}
	}
	
	public Robot robotObj() throws AWTException
	{
		Robot rb= new Robot();
		return rb;
	}
		/**
		 * This method will Press Enter Key
		 * @param driver
		 */
		public void enterKey(WebDriver driver) throws Throwable
		{
			robotObj().keyPress(KeyEvent.VK_ENTER);
		}
		
		/** 
		 * This method is used to release the key
		 * @param driver
		 * @throws Throwable
		 */
		public void enterRelease(WebDriver driver) throws Throwable
		{
			robotObj().keyRelease(KeyEvent.VK_ENTER);
		}
		
		/**
		 * This method will switch the frame based on index
		 * @param driver
		 * @param index
		 */
		public void switchToFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		
		
		/**
		 * This method will switch the frame based on nameOrID
		 * @param driver
		 * @param nameOrID
		 */
		public void switchToFrame(WebDriver driver, String nameOrID)
		{
			driver.switchTo().frame(nameOrID);
		}
		
		/**
		 * This method will switch the frame based on address
		 * @param driver
		 * @param address
		 */
		public void switchToFrame(WebDriver driver, WebElement address)
		{
			driver.switchTo().frame(address);
		}
		
		
		/**
		 * This method is used to accept alert popup
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		
		/**
		 * This method is used to cancel alert popup
		 * @param driver
		 */
		public void cancelAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
	
		/**
		 * This method will take screenshot and store it in folder called as screenshot
		 * @param driver
		 * @param screenShotName
		 * @return
		 * @throws Throwable
		 */
		public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
			{
				JavaUtils jLib = new JavaUtils();
				
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				String path = "./screenshot/"+screenShotName+" "+jLib.getSystemDateInFormat()+".png";
				File dst = new File(path);
				String scrpath = dst.getAbsolutePath();
				FileUtils.copyFile(src, dst);
				return scrpath;
				
			}
		
		/**
		 * This method will perform random scroll
		 * @param driver
		 */
		public void scrollBarAction(WebDriver driver)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,800)","");
		}
		
		
		/**
		 * This method will scroll until specified element is found
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			jse.executeScript("window.scrollBy(0,"+y+")", element);
		}
	
}
