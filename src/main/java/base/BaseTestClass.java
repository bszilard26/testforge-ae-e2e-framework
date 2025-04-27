package base;

import factory.DriverFactory;         // <-- IMPORT this
import utils.ConsentManager;          // <-- IMPORT this
import org.openqa.selenium.WebDriver;  // <-- IMPORT this
import org.testng.annotations.*;
import utils.ConsentManager;

public abstract class BaseTestClass {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void initDriver(@Optional("chrome") String browser) {
        driver = browser.equalsIgnoreCase("headless")
                ? DriverFactory.newHeadlessChrome()
                : DriverFactory.newChromeDriver();
        driver.get("https://automationexercise.com");
        ConsentManager.handleConsentIfPresent(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            System.out.println("🧹 [Teardown] Closing browser...");
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("⚠️ Browser already closed or crashed: " + e.getMessage());
            }
        }
    }
}
