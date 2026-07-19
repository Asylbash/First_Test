package ru.zhyldyz.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.zhyldyz.common.ConfigReader;
import ru.zhyldyz.components.CalendarComponent;
import ru.zhyldyz.components.SubmissionModal;
import ru.zhyldyz.enums.OrangeEndpoint;
import ru.zhyldyz.helpers.JavaScriptHelper;
import ru.zhyldyz.pages.AdminPage;
import ru.zhyldyz.pages.OrangeLoginPage;
import ru.zhyldyz.pages.PracticeFormPage;
import ru.zhyldyz.pages.TextBoxPage;
import ru.zhyldyz.test_data.RandomPracticeFormData;
import ru.zhyldyz.test_data.TestData;

import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    protected final OrangeLoginPage loginPage = new OrangeLoginPage();
    protected final AdminPage adminPage = new AdminPage();
    protected final PracticeFormPage practiceFormPage = new PracticeFormPage();
    protected final CalendarComponent calendarComponent = new CalendarComponent();
    protected final JavaScriptHelper javaScriptHelper = new JavaScriptHelper();
    protected final TextBoxPage textBoxPage = new TextBoxPage();
    protected final TestData testData = new TestData();
    protected final SubmissionModal modal = new SubmissionModal();

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
