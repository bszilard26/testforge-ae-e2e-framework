package uitest.auth;

import base.BaseTestClass;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

@Epic("Authentication")
@Feature("Login Feature")
@Listeners({AllureTestNg.class}) // ✅ Use only AllureTestNg listener
public class LoginTest extends BaseTestClass {

    @Test(description = "Valid login with known credentials")
    @Story("User logs in successfully with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterEmail("szilardautomationuser@gmail.comx");
        loginPage.enterPassword("Pass1234!");
        loginPage.submit();

        assertTrue(loginPage.isLoginSuccessful(), "Login should be successful with valid credentials.");
    }

    @Test(description = "Login attempt with incorrect password")
    @Story("User fails login with incorrect password")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterEmail("valid@example.com");
        loginPage.enterPassword("wrong_password");
        loginPage.submit();

        assertTrue(loginPage.isLoginFailed(), "Login should fail with an incorrect password.");
    }

    @Test(description = "Login attempt with unknown user")
    @Story("User fails login with unregistered email")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterEmail("nonexistent@example.com");
        loginPage.enterPassword("some_password");
        loginPage.submit();

        assertTrue(loginPage.isLoginFailed(), "Login should fail with an unregistered email.");
    }
}
