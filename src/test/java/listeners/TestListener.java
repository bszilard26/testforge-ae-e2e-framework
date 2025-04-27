package listeners;

import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtils;
import java.lang.reflect.Field;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();

        try {
            Field driverField = testInstance.getClass().getSuperclass().getDeclaredField("driver");
            driverField.setAccessible(true);
            WebDriver driver = (WebDriver) driverField.get(testInstance);

            ScreenshotUtils.capture(driver, result.getName());

        } catch (Exception e) {
            Allure.addAttachment("❌ Screenshot failed", e.getMessage());
        }
    }
}
