package Test_Component;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactPage;
import pages.SendEmailPage;

public class MergeFieldTest extends BaseTest {

    @Test
    public void testMergeField() throws InterruptedException {


        new ContactPage(driver).openSendEmail();

        SendEmailPage email = new SendEmailPage(driver);
        email.enterSubjectAndBody("Test Merge", "Testing Merge Field");
       // email.insertMergeField();
        email.sendEmail();
    }
}
