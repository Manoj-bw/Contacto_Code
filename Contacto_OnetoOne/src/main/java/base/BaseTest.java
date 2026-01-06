package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;

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
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

