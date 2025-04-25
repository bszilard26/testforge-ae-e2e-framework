package uitest.auth;

import base.BaseTestClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

/**
 * LoginTest verifies the login functionality on AutomationExercise.com
 * using UI flows with positive and negative scenarios.
 */
public class LoginTest extends BaseTestClass {

    @Test(description = "Valid login with known credentials")
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterEmail("szilardautomationuser@gmail.com\n");
        loginPage.enterPassword("Pass1234!");
        loginPage.submit();

        assertTrue(loginPage.isLoginSuccessful(), "Login should be successful with valid credentials.");
    }

    @Test(description = "Login attempt with incorrect password")
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterEmail("valid@example.com");
        loginPage.enterPassword("wrong_password");
        loginPage.submit();

        assertTrue(loginPage.isLoginFailed(), "Login should fail with an incorrect password.");
    }

    @Test(description = "Login attempt with unknown user")
    public void loginWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterEmail("nonexistent@example.com");
        loginPage.enterPassword("some_password");
        loginPage.submit();

        assertTrue(loginPage.isLoginFailed(), "Login should fail with an unregistered email.");
    }
}
