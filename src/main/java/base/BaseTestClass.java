package base;

import factory.DriverFactory;
import utils.ConsentManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTestClass {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        log("🔧 [Setup] Launching browser: " + browser);

        driver = browser.equalsIgnoreCase("headless")
                ? DriverFactory.newHeadlessChrome()
                : DriverFactory.newChromeDriver();

        openTestApplication();
        handleConsentPopup();
    }

    protected void openTestApplication() {
        String url = "https://automationexercise.com/";
        driver.get(url);
        log("🌐 Navigated to: " + url);
    }

    protected void handleConsentPopup() {
        try {
            ConsentManager.handleConsentIfPresent(driver);
            log("✅ [Consent] Handled cookie popup if present.");
        } catch (Exception e) {
            log("⚠️ [Consent] Failed to handle popup: " + e.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            log("🧹 [Teardown] Closing browser...");
            driver.quit();
        }
    }

    private void log(String message) {
        System.out.println(message);
    }
}
