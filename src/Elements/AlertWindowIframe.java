package Elements;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertWindowIframe extends Init {

    @Test(priority = 0)
    public void HandleAlert() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h5[normalize-space()='Elements']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h5[normalize-space()='Elements']")).click();
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[normalize-space()='Alerts, Frame & Windows']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[normalize-space()='Alerts, Frame & Windows']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Alerts']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Alerts']")).getText(), "Alerts", "Chưa đi đến vùng alert");
        System.out.println("Đã đi đến vùng alert");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        System.out.println("OK Click Normal");
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[@id='timerAlertButton']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
        Thread.sleep(6000);
        driver.switchTo().alert().accept();
        System.out.println("OK Click Time");
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[@id='confirmButton']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText(), "You selected Cancel", "Sai ở Confirm Box");
        System.out.println("OK Confirm Box");
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        driver.switchTo().alert().sendKeys("oknha");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='promptResult']")).getText(), "You entered oknha", "Sai ở Prompt Box");
        System.out.println("OK Prompt Box");
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void HandleWindow() throws Exception {
        driver.findElement(By.xpath("//span[normalize-space()='Browser Windows']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Browser Windows']")).getText(), "Browser Windows", "Chưa đi đến vùng Window");
        System.out.println("Đã đi đến vùng window");
        String ParentWindow = driver.getWindowHandle();
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.xpath("//button[@id='tabButton']")).click();
            Thread.sleep(2000);
            driver.switchTo().window(ParentWindow);
            Thread.sleep(2000);
        }
        

        Set<String> ChildWindows = driver.getWindowHandles();
        for (String ss : ChildWindows) {
            if (!ss.equals(ParentWindow)) {
                driver.switchTo().window(ss);
                System.out.println("Đã đi đến Tab: " + driver.getCurrentUrl() + " và đóng tab " + driver.getCurrentUrl());
                Thread.sleep(2000);
                driver.close();
            }
        }
        System.out.println("Ok Window");
        driver.switchTo().window(ParentWindow);
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void HandleIframe() throws Exception {
        driver.findElement(By.xpath("//span[normalize-space()='Frames']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Frames']")).getText(), "Frames", "Chưa đi đến vùng Frame");
        System.out.println("Đã đi đến vùng Frame");

        List<WebElement> iframes = driver.findElements(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println("Tổng số iframe: " + iframes.size());

        WebElement targetIframe = findFrameElementByLocator(By.xpath("//h1[@id='sampleHeading']"));
        if (targetIframe != null) {
            int index = iframes.indexOf(targetIframe);
            System.out.println("Phần tử sampleHeading nằm trong iframe số: " + index);

            driver.switchTo().frame(targetIframe);
            System.out.println("Nội dung heading trong iframe: " + driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        } else {
            System.out.println("Không tìm thấy phần tử sampleHeading trong các iframe.");
        }

        driver.switchTo().defaultContent();
    }


    // Trả về chính WebElement iframe chứa phần tử cần tìm
    public WebElement findFrameElementByLocator(By locator) {
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        for (WebElement iframe : iframes) {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(iframe);
            if (driver.findElements(locator).size() > 0) {
                driver.switchTo().defaultContent(); // reset lại
                return iframe;
            }
        }
        driver.switchTo().defaultContent(); // reset nếu không tìm thấy
        return null;
    }

}
