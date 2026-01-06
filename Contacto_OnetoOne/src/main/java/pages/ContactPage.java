package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ContactPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);  
        this.js = (JavascriptExecutor) driver;
    }
    private By contactsTab = By.xpath("//a[@title='Contacts']");
    private By contactName = By.xpath("//a[@title='Manoj']");
   // this line commented due to old package
    //private By sendEmailBtn = By.xpath("//a[text()='Send Email']");
    

    public void openSendEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(contactsTab));
        js.executeScript("arguments[0].click();", driver.findElement(contactsTab));

        wait.until(ExpectedConditions.elementToBeClickable(contactName)).click();

     //   wait.until(ExpectedConditions.elementToBeClickable(sendEmailBtn)).click();
    }
}

    
    /*

    private By contactsTab = By.xpath("//one-app-nav-bar-item-root//a[@title='Contacts']");
    private By contactName = By.xpath("//a[@title='Manoj']");

    // ⚠️ Salesforce Lightning uses different DOM for this
    private By sendEmailBtn = By.xpath(
        "//runtime_platform_actions-action-renderer//a[contains(@title,'Email') or contains(.,'Email')] | " +
        "//a[contains(@title,'Email')] | //button[contains(.,'Email')]"
    );

    public void openSendEmail() {

        // Click Contacts Tab
        WebElement contacts =
                wait.until(ExpectedConditions.elementToBeClickable(contactsTab));
        js.executeScript("arguments[0].click();", contacts);

        // Click Contact
        wait.until(ExpectedConditions.elementToBeClickable(contactName)).click();

        // Wait for page load
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//records-lwc-detail-panel"))
        );

        // ⚡ Sometimes Salesforce loads Email inside iframe
        try {
            driver.switchTo().frame(
                    wait.until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//iframe[contains(@title,'Email')]")))
            );
        } catch (Exception e) {
            // If no iframe, ignore
        }

        // Click Send Email
        WebElement emailBtn =
                wait.until(ExpectedConditions.elementToBeClickable(sendEmailBtn));
        js.executeScript("arguments[0].click();", emailBtn);
    }
}*/
