package ru.zhyldyz.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.zhyldyz.common.ConfigReader;
import ru.zhyldyz.enums.OrangeEndpoint;
import ru.zhyldyz.pages.AdminPage;
import ru.zhyldyz.pages.OrangeLoginPage;
import ru.zhyldyz.pages.PracticeFormPage;

import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    OrangeLoginPage loginPage = new OrangeLoginPage();
    AdminPage adminPage = new AdminPage();
    PracticeFormPage practiceFormPage = new PracticeFormPage();
//    @BeforeAll
//    static void setup() {
//        Configuration.browserSize = "2560x1440";
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.timeout = 5000;
//         Configuration.holdBrowserOpen = true;
//    }

    //    @BeforeAll
//    static void setup() {
//       Configuration.baseUrl = Paths.get("src/test/resources/pages").toUri().toString();
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1024x768";
//       Configuration.browserVersion = "148.0";
//      Configuration.headless = true;
//       Configuration.pageLoadStrategy = "eager";
//       Configuration.timeout = 5000;
//    }
    @BeforeAll
    static void setup() {

        String target = ConfigReader.getProperty("target");

        if ("local".equalsIgnoreCase(target)) {
            Configuration.baseUrl =
                    Paths.get("src/test/resources/pages")
                            .toUri()
                            .toString();
        } else if ("web".equalsIgnoreCase(target)) {
            Configuration.baseUrl =
                    ConfigReader.getProperty("demoUrl");
        }

        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadStrategy = "eager";
    }

//    @BeforeEach
//
//    void login() {
//
//        open(OrangeEndpoint.LOGIN.getEndpoint());
//
//        loginPage.login(
//
//                ConfigReader.getProperty("username"),
//
//                ConfigReader.getProperty("password")
//
//        );
//
//    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
