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

public class TextBox extends Init{
	
	@Test
	public void HandleTextBox() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h5[normalize-space()='Elements']")));
		Thread.sleep(1500);
		driver.findElement(By.xpath("//h5[normalize-space()='Elements']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[normalize-space()='Text Box']")).click();
		Thread.sleep(1500);
//		if(	driver.findElement(By.xpath("//span[normalize-space()='Text Box']")).getText().equals("Text Box"))
//		{
//			System.out.println("Đã di chuyển đúng nơi có Text Box");
//		}
//		else
//		{
//			System.out.print("Di chuyển sai vị trí");
//		}
		if(	driver.findElement(By.xpath("//span[normalize-space()='Text Box']")).isDisplayed())
		{
	
				System.out.println("Đã di chuyển đúng nơi có Text Box");
		}
		else
		{
				System.out.print("Di chuyển sai vị trí");
		}
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Hung");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("hung123@gmail.com");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("280");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("515");
		Thread.sleep(1500);
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[@id='submit']")));
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//p[@id='name']")).getText().contains("Hung") && driver.findElement(By.xpath("//p[@id='email']")).getText().contains("hung123@gmail.com") && driver.findElement(By.xpath("//p[@id='currentAddress']")).getText().contains("280") && driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText().contains("515"))
		{
			System.out.println("Ok Login");
		}
		else
			System.out.println("Not Ok Login");
		
	}
}
