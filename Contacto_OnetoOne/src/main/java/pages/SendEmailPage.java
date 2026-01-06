package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class SendEmailPage {
WebDriver driver;
WebDriverWait wait;
JavascriptExecutor js;
Actions actions;

public SendEmailPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 30);
    js = (JavascriptExecutor) driver;
    actions = new Actions(driver);
}

private By subject = By.xpath("//input[@placeholder='Enter Subject']");
private By body = By.xpath("//textarea[contains(@class,'slds-textarea')]");
private By send = By.xpath("//button[@name='send'] | //button[normalize-space()='Send']");

private By mergeFieldBtn = By.xpath("//button[@title='Insert merge field']");
private By insertMergeRadio = By.xpath("(//input[@type='radio'])[1]");
private By insertMergeBtn = By.xpath("//button[@title='Insert' and normalize-space()='Insert']");

private By templateBtn = By.xpath("//button[@title='Insert, create, or update template']");
private By previewBtn = By.xpath("//button[@title='Preview email']");
private By deleteBtn = By.xpath("//button[@title='Clear email and revert']");
private By fileInput = By.xpath("//input[@type='file']");


public void enterSubjectAndBody(String sub, String msg) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(subject)).sendKeys(sub);
    
    WebElement bodyField = wait.until(ExpectedConditions.elementToBeClickable(body));
    bodyField.click();
    bodyField.clear();
    bodyField.sendKeys(msg); 

}
// need to write new code for updated functionality.

/*public void insertMergeField() throws InterruptedException {
    js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(mergeFieldBtn)));
    WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@role='dialog']")));
    WebElement radio = wait.until(ExpectedConditions.elementToBeClickable(insertMergeRadio));
    js.executeScript("arguments[0].click();", radio);
    WebElement insert = modal.findElement(insertMergeBtn);
    insert.click();
    wait.until(ExpectedConditions.invisibilityOf(modal));
    Thread.sleep(3000);
}
*/
public void insertTemplate() throws InterruptedException {
    js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(templateBtn)));
    Thread.sleep(3000);

    actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Insert a template...']")))).click().perform();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='Templates']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Classic Templates']"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='Folder']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='MassMailer']"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='view']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Insert']"))).click();

}

public void previewEmail() throws InterruptedException {
	Thread.sleep(3000);
    js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(previewBtn)));
    WebElement previewContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-formatted-rich-text")));
    String contentText = (previewContent.getText() != null) ? previewContent.getText().trim() : "";
    if (!contentText.isEmpty()) {
        System.out.println("Email template is inserted and visible in preview: " + contentText);
    } else {
        System.out.println("Template appears to be empty!");
    }
    WebElement CloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Close']")));
    CloseButton.click();
}


public void deleteEmailContent() throws InterruptedException {
	Thread.sleep(3000);
    js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)));
    WebElement emailBodyAfterDelete = driver.findElement(body);
	String contentAfterDelete = emailBodyAfterDelete.getText().trim();
	// Check if it is empty
	if (contentAfterDelete.isEmpty()) {
		System.out.println(" Email body cleared successfully after delete.");
	} else {
		System.out.println(" Email body still contains text after delete: " + contentAfterDelete);
	}
}

public void ChooseFile(String filePath) {
    WebElement file = wait.until(ExpectedConditions.presenceOfElementLocated(fileInput));
    js.executeScript("arguments[0].style.display = 'block';", file);
    file.sendKeys(filePath);
}

public void sendEmail() throws InterruptedException {
	Thread.sleep(3000);
   // js.executeScript("arguments[0].scrollIntoView(true);", // due to old package
	wait.until(ExpectedConditions.elementToBeClickable(send)); 
	
    wait.until(ExpectedConditions.elementToBeClickable(send)).click();
}
}
