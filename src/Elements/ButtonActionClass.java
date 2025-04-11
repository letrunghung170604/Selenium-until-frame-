package Elements;

import java.awt.AWTException;



import java.awt.Desktop.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
 
public class ButtonActionClass extends Init{
	
	@Test
	public void HandleButton() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", 	driver.findElement(By.xpath("//h5[normalize-space()='Elements']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h5[normalize-space()='Elements']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Buttons']")).click();
		Thread.sleep(2000);
		boolean GoToButton = driver.findElement(By.xpath("//h1[normalize-space()='Buttons']")).isDisplayed();
		Assert.assertTrue(GoToButton);
		System.out.println("Đã đi đến Button Page");
		//Xử lý DoubleClick
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//button[@id='doubleClickBtn']"))).build().perform();
		String GetText = driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText();
		js.executeScript("arguments[0].scrollIntoView(true);", 	driver.findElement(By.xpath("//p[@id='doubleClickMessage']")));
		Assert.assertEquals(GetText, "You have done a double click", "Không hoàn thành Double Click");
		System.out.println("Hoàn thành Double Click");
		Thread.sleep(2000);
		//Xử lý Right Click
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[@id='rightClickBtn']")));
		Thread.sleep(2000);
		action.contextClick(driver.findElement(By.xpath("//button[@id='rightClickBtn']"))).build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText(), "You have done a right click", "Không hoàn thành Right Click");
		System.out.println("Hoàn thành Right Click");
		Thread.sleep(2000);
		//Xử lý click
		action.click(driver.findElement(By.xpath("//button[normalize-space()='Click Me']"))).build().perform();
//		driver.findElement(By.xpath("//button[normalize-space()='Click Me']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText(), "You have done a dynamic click", "Không hoàn thành Dynamic Click");
		System.out.println("Hoàn thành Dynamic CLick");
	}

}
