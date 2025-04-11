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

public class CheckBox extends Init{
	
	@Test
	public void HandleCheckBox() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h5[normalize-space()='Elements']")));
		driver.findElement(By.xpath("//h5[normalize-space()='Elements']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[normalize-space()='Check Box']")).click();
		Thread.sleep(1500);
		if(	driver.findElement(By.xpath("//h1[normalize-space()='Check Box']")).isDisplayed())
		{		
				System.out.println("Đã di chuyển đúng nơi có Check Box");
		}
		else
		{
				System.out.print("Di chuyển sai vị trí");
		}
		driver.findElement(By.xpath("//button[@title='Toggle']//*[name()='svg']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']//li[1]//span[1]//button[1]//*[name()='svg']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//label[@for='tree-node-notes']//span[@class='rct-checkbox']//*[name()='svg']")).click();
		Thread.sleep(1500);
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[normalize-space()='You have selected :']")));
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//span[@class='text-success']")).getText().contains("notes"))
		{
			System.out.println("Ok test 1");
		}
		else
		{
			System.out.println("Không ok test 1");
		}
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//label[@for='tree-node-commands']//span[@class='rct-checkbox']//*[name()='svg']")));
		Thread.sleep(1500);
		driver.findElement(By.xpath("//label[@for='tree-node-commands']//span[@class='rct-checkbox']//*[name()='svg']")).click();
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//span[@class='text-success']")).getText().contains("desktop"))
		{
			System.out.println("Ok test 2");
		}
		else
		{
			System.out.println("Không ok test 2");
		}
		driver.findElement(By.xpath("//span[@class='rct-checkbox']//*[name()='svg']")).click();
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//span[@class='text-success']")).getText().contains("home"))
		{
			System.out.println("Ok test 3");
		}
		else
		{
			System.out.println("Không ok test 3");
		}
	}
}
