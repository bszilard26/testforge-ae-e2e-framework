# 🧪 TestForge AE E2E Framework

![Java](https://img.shields.io/badge/Java-17+-brightgreen)
![TestNG](https://img.shields.io/badge/TestNG-7.8.0-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.19.0-orange)
![RestAssured](https://img.shields.io/badge/RestAssured-5.4.0-lightgrey)
![Allure](https://img.shields.io/badge/Allure-Reporting-pink)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

> ✨ A professional E2E automation framework built for UI & API testing of [Automation Exercise](https://automationexercise.com)

---

## 📦 Project Structure

```bash
src/
├── main/
│   └── java/
│       ├── api/           → DTOs and clients for API tests
│       ├── base/          → Test base classes and common setup
│       ├── factory/       → DriverFactory, ApiClientFactory (optional)
│       ├── helper/        → Reusable utilities (e.g., ScreenshotHelper)
│       ├── pages/         → Page Object Models
│       └── utils/         → WaitUtils, ConsentManager, TestListeners, etc.
│
└── test/
    └── java/
        ├── apitest/         → RestAssured-based API tests
        └── uitest/
            ├── auth/        → Login, Logout
            ├── cart/        → Add, Remove, Quantity
            ├── categories/  → Category navigation and validation
            ├── checkout/    → Checkout and payment flow
            ├── products/    → Product search, details, review
            ├── subscription/→ Newsletter subscription testing
            └── visual/      → Scroll, layout, and visual elements
