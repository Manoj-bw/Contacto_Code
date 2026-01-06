package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import Selenium.maven.Selenium.maven.demo.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
    	 ChromeOptions options = new ChromeOptions();
         options.addArguments("--start-maximized");
         options.addArguments("--disable-notifications");
         
    	 WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();    
        driver.get("https://login.salesforce.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
        		"shivapawarsp55661@agentforce.com",
                "Shivraj@44"
        );
        
    }
    
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Capture screenshot if test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            Screenshot.takeScreenshot(driver, result.getName());
        }

        if (driver != null) {
        //    driver.quit();
        }
    }
 // ✅ This will be used by ExtentReportListener
    
    public static WebDriver getDriver1() {
        return driver;
    
    }

	public static WebDriver getDriver() {
		return null;
	}
}

