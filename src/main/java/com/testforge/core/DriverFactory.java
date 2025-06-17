package com.testforge.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * DriverFactory provides factory methods to initialize WebDriver instances.
 * Supports both headed and headless Chrome with isolated user-data-dir.
 */
public class DriverFactory {

    /**
     * Launch a new ChromeDriver with GUI and unique user profile.
     */
    public static WebDriver newChromeDriverWithProfile(Path userDataDir) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--user-data-dir=" + userDataDir.toAbsolutePath());

        return new ChromeDriver(options);
    }


    /**
     * Launch a headless ChromeDriver with isolated user profile and CI-safe options.
     */
    public static WebDriver newHeadlessChrome() throws IOException {
        WebDriverManager.chromedriver().setup();

        Path userDataDir = Files.createTempDirectory("chrome-profile");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--user-data-dir=" + userDataDir.toAbsolutePath());

        return new ChromeDriver(options);
    }
}
