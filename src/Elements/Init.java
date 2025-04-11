package Elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Init {

	public static WebDriver driver = null;
	
	@BeforeTest
	public static void Setup() throws Exception
	{
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\ASUS\\Desktop\\tester\\chromedriver-win641\\chromedriver-win64\\chromedriver.exe");
	//Setup trường hợp một số trang web cấm chatbox tự động
//	ChromeOptions options = new ChromeOptions();
//    options.addArguments("--disable-blink-features=AutomationControlled");
//    options.addArguments("--remote-allow-origins=*");
	//Cài đặt ngôn ngữ mặc định
	ChromeOptions options = new ChromeOptions();
    options.addArguments("--lang=en"); 
//    WebDriver driver = new ChromeDriver(options); 
	
    driver = new ChromeDriver(options);
    driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.navigate().to("https://demoqa.com/");
    driver.manage().window().maximize();
    Thread.sleep(2000);
	}
	
	@AfterTest
	public static void TearDown() throws Exception
	{
		Thread.sleep(6000);
		driver.quit();
	}
}
