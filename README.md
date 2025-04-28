🧪  TestForge AE E2E Automation Framework
Welcome to the TestForge AutomationExercise E2E Framework!
This project automates UI and API flows using modern tools, clean architecture, and professional practices.

🚀 Tech Stack

Area	Tech Used
Language	Java 21 (aarch64 ✅)
Build Tool	Maven
Test Framework	TestNG
Automation	Selenium WebDriver 4.19.0
Dependency Mgmt	WebDriverManager 5.8.0
Reporting	Allure Reports 2.24.0 (TestNG adapter)
API Testing	RestAssured 5.4.0 (optional)
Browser	Chrome (default)
🛠 Project Structure
graphql
Copy
Edit
src/
├── main/
│    └── java/
│         ├── api/                      # (Reserved for API base classes)
│         ├── base/                     # BaseTestClass with WebDriver setup
│         ├── factory/                  # DriverFactory for browser initialization
│         ├── helper/                   # (Reserved for future utilities/helpers)
│         ├── pages/
│         │     ├── BasePage.java        # Common methods for page objects
│         │     └── LoginPage.java       # Login page interactions
│         └── utils/
│               ├── ConsentManager.java  # Handle cookie consent popups
│               ├── ScreenshotUtils.java # Capture screenshots on failure
│               └── WaitingUtils.java    # (Reserved for smart waits)
│
└── test/
└── java/
├── apitest/                  # (Reserved for future API tests)
├── listeners/                # (Test listeners if needed)
├── uitest/
│     ├── auth/
│     │     ├── LoginTest.java
│     │     └── LogoutTest.java
│     ├── cart/
│     │     └── CartTest.java
│     ├── categories/
│     │     ├── CategoryExpandCollapseTest.java
│     │     ├── CategoryNavigationTest.java
│     │     └── RapidCategoryClickTest.java
│     ├── checkout/
│     ├── products/
│     ├── subscription/
│     └── visual/
resources/
🧩 Features
✅ Page Object Model (POM)

✅ Auto-consent popup handling

✅ Screenshots captured on test failures (Allure attachments)

✅ Parallel execution ready

✅ Headless Chrome support

✅ Allure Reporting Integration

📋 Prerequisites
Java 21 (aarch64 chip support ✅)

Maven

Chrome installed

Allure CLI installed:

bash
Copy
Edit
brew install allure
⚙️ How to Run Tests and View Report
Run tests and immediately open Allure report:

bash
Copy
Edit
mvn clean test
allure serve target/allure-results
💡 Pro Tip (Create a shortcut command):

bash
Copy
Edit
echo "alias runallure='mvn clean test && allure serve target/allure-results'" >> ~/.zshrc
source ~/.zshrc
Then simply:

bash
Copy
Edit
runallure
