package Test_Component;



import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactPage;
import pages.SendEmailPage;

public class PreviewTest extends BaseTest {

    @Test
    public void testPreviewEmail() throws InterruptedException {
    	
        new ContactPage(driver).openSendEmail();

        SendEmailPage email = new SendEmailPage(driver);
        email.insertTemplate();
        email.previewEmail();
        email.sendEmail();
    }
}
