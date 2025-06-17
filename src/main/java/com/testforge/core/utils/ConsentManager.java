package com.testforge.core.utils;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // longer wait

        try {
            if (!driver.findElements(CONSENT_OVERLAY).isEmpty()) {
                System.out.println("⚡ Consent popup detected. Trying to close...");
                WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_BUTTON));
                acceptBtn.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(CONSENT_OVERLAY));
                System.out.println("✅ Consent popup closed successfully.");
            } else {
                System.out.println("ℹ️ No consent popup detected.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Consent popup handling skipped or failed: " + e.getMessage());
        }
    }
}
