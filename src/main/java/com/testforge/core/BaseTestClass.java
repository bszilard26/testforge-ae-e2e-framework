package com.testforge.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Base test class that sets up and tears down the WebDriver before/after test classes.
 */
public class BaseTestClass {

    protected WebDriver driver;
    private Path userDataDir;

    @BeforeClass
    public void setUp() throws IOException {
        // Setup driver with unique user data dir (for GitHub Actions safety)
        userDataDir = Files.createTempDirectory("chrome-profile");
        driver = DriverFactory.newChromeDriverWithProfile(userDataDir);
    }

    @AfterClass
    public void tearDown() throws IOException {
        if (driver != null) {
            driver.quit();
        }

        if (userDataDir != null) {
            Files.walk(userDataDir)
                    .map(Path::toFile)
                    .sorted((a, b) -> -a.compareTo(b)) // delete children before parents
                    .forEach(file -> {
                        if (!file.delete()) {
                            System.err.println("⚠️ Failed to delete: " + file.getAbsolutePath());
                        }
                    });
        }
    }
}
