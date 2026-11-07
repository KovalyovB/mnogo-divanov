package tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import tests.helpers.Attach;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    String userFirstName;
    String userLastName;
    String userPhoneNumber;
    String userEmail;
    String userPassword;
    String wrongUserEmail = "unregisteredTest12345@mail.ru";
    String wrongUserPassword = "12345ff";

    @BeforeAll
    static void setupEnvironment() {

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browsersize", "1920x1080");
        Configuration.baseUrl = System.getProperty(
                "url",
                "https://www.mnogodivanov.ru/"
        );
        Configuration.browserVersion = System.getProperty("version");
        Configuration.headless = Boolean.parseBoolean(
                System.getProperty("headless", "false")
        );

        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--disable-dev-shm-usage",
                "--no-sandbox"
        );

        options.addArguments("--disable-blink-features=AutomationControlled");

        options.setExperimentalOption(
                "excludeSwitches",
                List.of("enable-automation")
        );

        options.setExperimentalOption(
                "useAutomationExtension",
                false
        );

        options.setCapability(
                "selenoid:options",
                Map.of(
                        "enableVNC", true,
                        "enableVideo", true
                )
        );

        Configuration.browserCapabilities = options;

        Configuration.remote = System.getProperty("remote");
    }

    @BeforeEach
    public void prepareTestData() {
        Faker faker = new Faker(new Locale("ru"));
        Faker fakerEn = new Faker();

        userFirstName = faker.name().firstName();
        userLastName = faker.name().lastName();
        userPhoneNumber = faker.phoneNumber().phoneNumber();
        userEmail = fakerEn.internet().emailAddress();
        userPassword = fakerEn.internet().password();
    }

    void addListener() {
        SelenideLogger.addListener(
                "Allure Selenide",
                new AllureSelenide()
        );
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}