TestForge AE E2E Automation Framework
Welcome to the TestForge AE Automation Framework!
This project automates UI and API flows using modern tools, clean architecture, and professional practices.

🚀 Tech Stack
Language: Java 21 (aarch64 ✅)

Build Tool: Maven

Test Framework: TestNG

Automation: Selenium WebDriver 4.19.0

Dependency Management: WebDriverManager 5.8.0

Reporting: Allure Reports 2.24.0

API Testing: RestAssured 5.4.0 (optional)

<pre> testforge-ae-e2e-framework ├── .idea/ # IDE settings ├── .gitignore ├── pom.xml # Maven configuration ├── testng.xml # TestNG suite config ├── README.md ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ ├── api/ # Reserved for API base classes │ │ │ ├── base/ # BaseTestClass, BasePage │ │ │ ├── factory/ # WebDriverFactory, BrowserManager │ │ │ ├── helper/ # Shared utilities │ │ │ ├── pages/ # Page Object Models (POM) │ │ │ └── utils/ # ScreenshotUtils, ConsentManager, WaitingUtils │ │ └── resources/ # Any test resources if needed │ └── test/ └── java/ ├── apitest/ # Reserved for API tests (future) └── uitest/ ├── auth/ # Login, Logout test cases │ ├── LoginTest.java │ └── LogoutTest.java ├── cart/ │ └── CartTest.java └── categories/ ├── CategoryExpandCollapseTest.java ├── CategoryNavigationTest.java └── RapidCategoryClickTest.java </pre>
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

