package Test_Component;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SendEmailPage;

public class ChooseFileTest  extends BaseTest {

    @Test
    public void testFileUpload() throws InterruptedException {

        new pages.ContactPage(driver).openSendEmail();

        SendEmailPage email = new SendEmailPage(driver);
        email.enterSubjectAndBody("File Upload", "See attachment");
      
        email.ChooseFile("C:\\Users\\user\\Documents\\test data\\testfile.pdf");
        email.sendEmail();
    }
}
