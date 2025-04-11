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


public class RadioButton extends Init{
	
	@Test
	public void HandleradioButton1() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//h5[normalize-space()='Elements']")));
		driver.findElement(By.xpath("//h5[normalize-space()='Elements']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Radio Button']")).click();
		Thread.sleep(2000);
		boolean GoToRadioButtonPage = driver.findElement(By.xpath("//h1[normalize-space()='Radio Button']")).isDisplayed();
		if(GoToRadioButtonPage == true)
		{
			System.out.println("Đã đi đến vùng Radio Button");
		}
		else
		{
			System.out.println("Chưa đi đến vùng Radio Button");
		}
		Thread.sleep(2000);
		
		boolean CheckSelectYes = driver.findElement(By.xpath("//label[normalize-space()='Yes']")).isSelected();
		if(CheckSelectYes == true)
		{
			System.out.println("Đã sai ở Yes");
		}
		else if(CheckSelectYes == false)
		{
			driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
			String GetText = driver.findElement(By.xpath("//span[@class='text-success']")).getText();
//			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[@class='text-success']")));
			if(GetText.equals("Yes"))
			{
				System.out.println("Ok Yes");
				driver.findElement(By.xpath("//label[normalize-space()='Impressive']")).click();
				if (CheckSelectYes == true )
				{
					System.out.println("Đã sai ở Impressive");
				}
				else if (CheckSelectYes == false && GetText.equals("Impressive"))
				{
					System.out.println("Ok Impressive");
					System.out.println("Test thành công");
				}
			}
		}
		boolean CheckEnable = driver.findElement(By.xpath("//label[normalize-space()='No']")).isEnabled();
		if(CheckEnable == false)
		{
			System.out.println("Ok Enable");
		}
		else if (CheckEnable == true)
		{
			System.out.println("Không ok enable");
		}
		
	}
	
		
		
		
		
//		Assert.assertFalse(CheckSelect);
//		System.out.println("Yes chưa được chọn");
//		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
//		String GetText = driver.findElement(By.xpath("//span[@class='text-success']")).getText();
//		boolean CompareGetText = GetText.equals("Yes");
//		boolean CheckSelectUpdate = driver.findElement(By.xpath("//label[normalize-space()='Yes']")).isSelected();
//		Assert.assertTrue(CheckSelectUpdate);
//		Assert.assertTrue(CheckSelectUpdate && CompareGetText);
//		System.out.println("Ok");
		
		
}
