package uitest.auth;

import base.BaseTestClass;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("Authentication")
@Feature("Logout Feature")
@Listeners({AllureTestNg.class}) // ✅ Use only AllureTestNg listener
public class LogoutTest extends BaseTestClass {

    @Test(description = "Verify user can log out successfully after login")
    @Story("User logs out after successful login")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogoutFunctionality() {
        LoginPage loginPage = LoginPage.loginPage(driver);

        loginPage.goTo();
        loginPage.enterEmail("szilardautomationuser@gmail.com");
        loginPage.enterPassword("Pass1234!");
        loginPage.submit();

        Assert.assertTrue(loginPage.isLoginSuccessful(), "❌ Login was not successful!");

        loginPage.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "❌ User was not redirected to login page after logout!");
    }
}
