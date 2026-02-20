package Test_Component;



import org.testng.annotations.Test;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.SObjectPage;
import pages.SendEmailPage;


public class DeleteContentTest extends BaseTest {

    @Test
    public void testDeleteContent() throws InterruptedException {

        new SObjectPage(driver, OBJECT_TAB_NAME, OBJECT_RECORD_NAME).openSendEmail();

        SendEmailPage email = new SendEmailPage(driver);
        email.insertTemplate();
        email.deleteEmailContent();
        email.sendEmail();
    }
}