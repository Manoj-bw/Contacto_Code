package Test_Component;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactPage;
import pages.SObjectPage;
import pages.SendEmailPage;

public class MergeFieldTest extends BaseTest {

    @Test
    public void testMergeField() throws InterruptedException {


       // new ContactPage(driver).openSendEmail();
    	new SObjectPage(driver, OBJECT_TAB_NAME, OBJECT_RECORD_NAME).openSendEmail();

        SendEmailPage email = new SendEmailPage(driver);
    //    email.enterSubjectAndBody("Test Merge", "Testing Merge Field"); 
    //     not need this line because we are calling the merge field data into body field.
        
        email.insertMergeField();
        email.sendEmail();
    }
}
