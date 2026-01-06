package Test_Component;



import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactPage;
import pages.LoginPage;
import pages.SendEmailPage;

public class SendEmailOnlyTest extends BaseTest {

    @Test
    public void testSendEmailOnly() throws InterruptedException {

        new LoginPage(driver)
                .login("arun.adigopula98447@agentforce.com", "Salesforce@123");

        new ContactPage(driver).openSendEmail();

        String subject = "Meeting Follow-Up: Next Steps";
        String body =
                "Hello,\n\n" +
                "Thank you for the meeting. Here are the next steps:\n" +
                "1. Share updated proposal\n" +
                "2. Schedule follow-up call\n" +
                "3. Final approval\n\n" +
                "Regards,\nBigWorks QA Team";

        SendEmailPage email = new SendEmailPage(driver);
        email.enterSubjectAndBody(subject, body);
        email.sendEmail();
    }
}
