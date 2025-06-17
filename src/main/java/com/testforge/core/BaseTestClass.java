package com.testforge.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseTestClass {

    protected WebDriver driver;
    private Path userDataDir;

    @BeforeClass
    public void setUp() throws IOException {
        // Generate unique temporary user data directory
        userDataDir = Files.createTempDirectory("chrome-user-data");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--user-data-dir=" + userDataDir.toAbsolutePath().toString());

        driver = new ChromeDriver(options);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

        // Cleanup temp user data directory
        try {
            Files.deleteIfExists(userDataDir);
        } catch (IOException e) {
            System.err.println("⚠️ Failed to delete temporary user-data-dir: " + e.getMessage());
        }
    }
}
