package pages;

import org.testng.annotations.Test;

import base.BaseTest;

public class loginCredentials extends BaseTest {

    @Test
    public void loginCredentials() {

        //Create object of LoginPage
        LoginPage loginPage = new LoginPage(driver);

        //  Call login method with credentials
        loginPage.login(
                "shivapawarsp55661@agentforce.com",
                "Shivraj@44"
        );
    }
}
