package uitest.auth;

import base.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LogoutTest extends BaseTestClass {

    @Test(description = "Verify user can log out successfully after login")
    public void testLogoutFunctionality() {
        LoginPage loginPage = LoginPage.loginPage(driver);

        loginPage.goTo();
        loginPage.enterEmail("szilardautomationuser@gmail.com"); // Replace with your real test email
        loginPage.enterPassword("Pass1234!");       // Replace with your real test password
        loginPage.submit();

        Assert.assertTrue(loginPage.isLoginSuccessful(), "❌ Login was not successful!");

        loginPage.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "❌ User was not redirected to login page after logout!");
    }
}
