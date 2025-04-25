package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final WebDriverWait wait;

    // Locators
    private final By loginMenu = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private final By errorMessage = By.xpath("//p[contains(text(),'incorrect')]");
    private final By loggedInUsername = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By consentOverlay = By.cssSelector(".fc-dialog-overlay");
    private final By consentClose = By.cssSelector(".fc-dialog-overlay .fc-close");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Factory method
    public static LoginPage loginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    // Actions
    public void goTo() {
        driver.get("https://automationexercise.com");

        // ✅ Handle cookie consent if present
        try {
            if (!driver.findElements(consentOverlay).isEmpty()) {
                WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(consentClose));
                closeBtn.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(consentOverlay));
            }
        } catch (Exception e) {
            System.out.println("⚠️ Modal dismiss skipped or already gone: " + e.getMessage());
        }

        wait.until(ExpectedConditions.elementToBeClickable(loginMenu)).click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginSuccessful() {
        return !driver.findElements(loggedInUsername).isEmpty();
    }

    public boolean isLoginFailed() {
        return !driver.findElements(errorMessage).isEmpty();
    }

    public WebElement getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
    }

    public void logout() {
        By logoutButton = By.xpath("//a[contains(text(),'Logout')]");
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

}
