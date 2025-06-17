# 🚀 TestForge AE E2E Automation Framework

![Java](https://img.shields.io/badge/Java-21-blue.svg)
![TestNG](https://img.shields.io/badge/TestNG-7.8.0-orange.svg)
![Allure](https://img.shields.io/badge/Allure-2.24.0-brightgreen.svg)
![Build](https://img.shields.io/badge/build-Maven-007396.svg)
![Platform](https://img.shields.io/badge/Platform-macOS%20%7C%20Linux-lightgrey.svg)

> **TestForge AE** is a scalable, cleanly-architected UI automation framework built with Selenium, TestNG, Allure Reporting, and modern testing practices. Ideal for demonstrating test automation mastery in real-world E2E testing.

---

## 🧱 Tech Stack

- **Language**: Java 21 (aarch64)
- **Build Tool**: Maven
- **Test Framework**: TestNG
- **Automation**: Selenium WebDriver 4.19.0
- **Dependency Management**: WebDriverManager 5.8.0
- **Reporting**: Allure Reports 2.24.0 (TestNG adapter)
- **API Testing (Pluggable)**: RestAssured 5.4.0 (optional)

---

## 📁 Project Structure

```text
src/
├── main/
│   └── java/
│       └── com/
│           └── testforge/
│               ├── api/               # Reserved for future API support classes
│               ├── config/            # Centralized environment and configuration files
│               └── core/              # Framework core layer
│                   ├── pages/             # Page Object Models (LoginPage, BasePage, etc.)
│                   ├── utils/             # Utility classes (ConsentManager, ScreenshotUtils, WaitingUtils)
│                   ├── BaseTestClass.java # WebDriver setup and teardown logic
│                   └── DriverFactory.java # Browser instantiation logic
├── test/
│   └── java/
│       ├── apitest/
│       │   └── products/              # API tests (e.g. GetAllProducts, SearchProduct)
│       └── uitest/
│           ├── auth/                 # Login & Logout tests
│           ├── cart/                 # Cart behavior validations
│           ├── categories/           # Category menu interaction tests
│           ├── checkout/             # Checkout flow validations
│           ├── products/             # Product search, add-to-cart, detail validations
│           ├── subscription/         # Subscription module checks
│           └── visual/               # Visual/UI validation tests (image loading, layout checks)
├── testng.xml                        # TestNG suite configuration
└── pom.xml                           # Maven project descriptor
