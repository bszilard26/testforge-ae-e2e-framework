package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class ScreenshotUtils {

    /**
     * Captures a screenshot and attaches it to the Allure report.
     * @param driver WebDriver instance
     * @param name Optional screenshot name (e.g., test method name)
     */
    public static void capture(WebDriver driver, String name) {
        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name != null ? name : "Screenshot", new ByteArrayInputStream(screenshot));
        } else {
            System.out.println("⚠️ Driver does not support screenshots.");
        }
    }

    /**
     * Captures a screenshot without a custom name.
     */
    public static void capture(WebDriver driver) {
        capture(driver, "Screenshot");
    }
}
