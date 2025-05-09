# 🚀 TestForge AE: End-to-End Automation Framework

Welcome to **TestForge AE**, an advanced Java-based E2E testing framework that automates UI and API flows using Selenium WebDriver, TestNG, and Allure Reports. This project showcases clean architecture, modular design, and robust reporting — ideal for portfolio and production readiness.

![Java](https://img.shields.io/badge/Language-Java%2021-orange)
![Build](https://img.shields.io/badge/Build-Maven-blue)
![Test Framework](https://img.shields.io/badge/TestNG-Enabled-brightgreen)
![Allure](https://img.shields.io/badge/Allure%20Reports-Integrated-purple)
![Status](https://img.shields.io/badge/CI-CD%20Ready-green)

🚀 Tech Stack
Language: Java 21 (aarch64 ✅)

Build Tool: Maven

Test Framework: TestNG

Automation: Selenium WebDriver 4.19.0

Dependency Management: WebDriverManager 5.8.0

Reporting: Allure Reports 2.24.0

API Testing: RestAssured 5.4.0 (optional)
```
src
 ├── main
 │    └── java
 │         ├── api                  # Reserved for API base classes
 │         ├── base                 # BaseTestClass with WebDriver setup
 │         ├── factory              # DriverFactory for browser management
 │         ├── helper               # Helper utilities
 │         ├── pages                # Page Object Models (POM)
 │         │     └── LoginPage.java
 │         ├── utils                # Utilities (ScreenshotUtils, ConsentManager, WaitingUtils)
 │         └── resources
 └── test
      └── java
           ├── uitest
           │     ├── auth
           │     │    ├── LoginTest.java
           │     │    └── LogoutTest.java
           │     ├── cart
           │     │    └── CartTest.java
           │     └── categories
           │           ├── CategoryExpandCollapseTest.java
           │           ├── CategoryNavigationTest.java
           │           └── RapidCategoryClickTest.java
           └── apitest                # Reserved for future API tests
```
🌟 Features
✅ Auto-consent popup handling

✅ Capture screenshots on test failure (attached in Allure Reports)

✅ Parallel execution ready

✅ Headless Chrome support

✅ Full Allure Reporting Integration

✅ Clean, modular project architecture (Page Object Model)

🛠 Prerequisites
Java 21 installed

Maven installed

Chrome installed

Allure CLI installed (brew install allure on Mac)

📈 How to Run Tests and Generate Reports
bash
Copy
Edit
# Run all tests and automatically open Allure report
mvn clean test && allure serve target/allure-results
💬 Tip: You can add it as a shortcut:

bash
Copy
Edit
echo "alias runallure='mvn clean test && allure serve target/allure-results'" >> ~/.zshrc
source ~/.zshrc
Then just run:

bash
Copy
Edit
runallure
📣 Final Notes
This project serves as a real-world-ready automation blueprint for UI testing.
More improvements coming soon: API tests, Docker integration, and GitHub Actions CI/CD!

