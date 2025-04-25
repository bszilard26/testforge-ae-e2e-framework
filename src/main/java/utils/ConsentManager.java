package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConsentManager {

    private static final By CONSENT_OVERLAY = By.cssSelector(".fc-dialog-overlay");
    private static final By ACCEPT_BUTTON = By.cssSelector(".fc-button.fc-cta-consent");

    public static void handleConsentIfPresent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            if (!driver.findElements(CONSENT_OVERLAY).isEmpty()) {
                WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_BUTTON));
                acceptBtn.click();

                // Optionally wait for overlay to disappear after clicking
                wait.until(ExpectedConditions.invisibilityOfElementLocated(CONSENT_OVERLAY));
                System.out.println("✅ Consent popup accepted and dismissed.");
            } else {
                System.out.println("ℹ️ Consent overlay not found. Proceeding...");
            }
        } catch (Exception e) {
            System.out.println("⚠️ [ConsentManager] Issue handling popup: " + e.getMessage());
        }
    }
}
