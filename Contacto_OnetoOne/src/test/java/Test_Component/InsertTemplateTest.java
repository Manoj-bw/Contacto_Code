package Test_Component;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactPage;
import pages.SendEmailPage;

public class InsertTemplateTest extends BaseTest {

    @Test
    public void testInsertTemplate() throws InterruptedException {


        new ContactPage(driver).openSendEmail();

        SendEmailPage email = new SendEmailPage(driver);
        email.insertTemplate();
        email.sendEmail();
    }
}
