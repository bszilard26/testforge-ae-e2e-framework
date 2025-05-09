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

<pre lang="text"> 📦 testforge-ae-e2e-framework ├── 📁 .idea/ # IDE settings ├── 📄 .gitignore ├── 📄 pom.xml # Maven config ├── 📄 testng.xml # TestNG suite file ├── 📄 README.md # Project overview ├── 📁 src/ │ ├── 📁 main/ │ │ ├── 📁 java/ │ │ │ ├── 📁 api/ # (Reserved for API models/tests) │ │ │ ├── 📁 base/ # BaseTestClass, BasePage │ │ │ ├── 📁 factory/ # WebDriverFactory, DriverManager │ │ │ ├── 📁 helper/ # Common helpers (if any) │ │ │ ├── 📁 pages/ # Page Object Model classes │ │ │ └── 📁 utils/ # ScreenshotUtils, ConsentManager, WaitingUtils │ │ └── 📁 resources/ # Any resource files if used │ └── 📁 test/ └── 📁 java/ ├── 📁 apitest/ # Reserved for future API tests └── 📁 uitest/ ├── 📁 auth/ │ ├── LoginTest.java │ └── LogoutTest.java ├── 📁 cart/ │ └── CartTest.java └── 📁 categories/ ├── CategoryExpandCollapseTest.java ├── CategoryNavigationTest.java └── RapidCategoryClickTest.java </pre>
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

