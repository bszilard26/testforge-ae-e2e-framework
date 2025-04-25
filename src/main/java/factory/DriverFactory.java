package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

/**
 * DriverFactory provides factory methods to initialize WebDriver instances.
 * Supports both headed and headless Chrome.
 */
public class DriverFactory {

    public static WebDriver newChromeDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        return applyCommonSetup(new ChromeDriver(options));
    }

    public static WebDriver newHeadlessChrome() {
        WebDriverManager.chromedriver().setup();  // ✅ Put it here

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");

        return applyCommonSetup(new ChromeDriver(options));  // ✅ This returns the ready-to-go driver
    }

    private static WebDriver applyCommonSetup(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}

