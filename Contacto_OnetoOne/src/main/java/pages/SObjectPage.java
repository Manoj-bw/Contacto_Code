package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class SObjectPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private String objectApiName;
    private String targetRecordName;

    public SObjectPage(WebDriver driver, String objectApiName, String recordName) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
        this.js = (JavascriptExecutor) driver;
        this.objectApiName = objectApiName;
        this.targetRecordName = recordName;

        System.out.println("Object: " + objectApiName);
        System.out.println("Record: " + recordName);
    }

    private By sObjectTab() {
        return By.xpath("//a[@title='" + objectApiName + "']");
    }

    private By recordName() {
        return By.xpath("//a[@title='" + targetRecordName + "']");
    }

    private By sendEmailBtn = By.xpath("//a[text()='Send Email']");

    public void openSendEmail() {

        wait.until(ExpectedConditions.elementToBeClickable(sObjectTab()));
        js.executeScript("arguments[0].click();", driver.findElement(sObjectTab()));

        wait.until(ExpectedConditions.elementToBeClickable(recordName())).click();

        wait.until(ExpectedConditions.elementToBeClickable(sendEmailBtn)).click();
    }
}
