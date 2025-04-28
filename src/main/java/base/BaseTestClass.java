package base;

import factory.DriverFactory;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConsentManager;
import utils.ScreenshotUtils;

@Listeners({AllureTestNg.class})
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
    public void tearDown(ITestResult result) {
        if (driver != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                System.out.println("❌ Test failed. Capturing screenshot...");
                ScreenshotUtils.attachScreenshot(driver);
            }
            try {
                System.out.println("🧹 [Teardown] Closing browser...");
                driver.quit();
            } catch (Exception e) {
                System.out.println("⚠️ Browser already closed or crashed: " + e.getMessage());
            }
        }
    }

    @Attachment(value = "Page Source", type = "text/html")
    protected String savePageSource() {
        return driver.getPageSource();
    }
}
