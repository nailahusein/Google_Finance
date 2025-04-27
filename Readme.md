# Altruist QA Take Home Task

This project is a Selenium automation suite built in Java for Altruist's QA Take Home Exercise.  
It verifies stock symbols from Google Finance against an expected collection.

---

## Tech Stack
- Java 17
- Selenium WebDriver 4.19.1
- TestNG 7.9.0
- Maven
- WebDriverManager 5.8.0
- Lombok 1.18.32
- Java Faker (optional for any dummy data generation)

---

## Problem Statement
Automate the following steps:

1. Open [Google Finance](https://www.google.com/finance) on Chrome.
2. Verify the page title.
3. Retrieve stock symbols listed under **"You may be interested in"** section.
4. Compare the retrieved stock symbols against a provided expected list.
5. Print:
    - Stock symbols that appear in the UI but not in the expected list.
    - Stock symbols that appear in the expected list but not in the UI.

---

