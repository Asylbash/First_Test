package ru.zhyldyz.tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import ru.zhyldyz.enums.Language;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DHLWebTest {

    private void acceptCookiesIfPresent() {

        if ($("#onetrust-reject-all-handler").exists()) {

            $("#onetrust-reject-all-handler")
                    .shouldBe(enabled)
                    .click();

            $(".ot-sdk-container")
                    .should(disappear);
        }
    }
//    private void acceptCookiesIfPresent() {
//
//        if ($("#onetrust-reject-all-handler").exists()) {
//
//            $("#onetrust-reject-all-handler")
//                    .shouldBe(visible)
//                    .click();
//
//        } else if ($("#onetrust-accept-btn-handler").exists()) {
//
//            $("#onetrust-accept-btn-handler")
//                    .shouldBe(visible)
//                    .click();
//        }
//
//        $(".onetrust-pc-dark-filter")
//                .should(disappear);
//    }

    @BeforeEach
    void setUp() {
        open("https://www.dhl.com/it-en/home.html");
        acceptCookiesIfPresent();
    }

    /*@CsvSource(value = {)
            "Track, Track & Trace",
            "Customer Service, Customer Service"
    })*/
    @CsvFileSource(resources = "/test_data/dhlSiteShouldOpenCorrectPage.csv")
    @ParameterizedTest(name = "DHL site should open correct page for menu item {0} and expected header {1}")
    @Tag("SMOKE")
    void dhlSiteShouldOpenCorrectPage(String menuItem,
                                      String expectedHeader) {

        $$(".c-navigation-menu--link")

                .findBy(exactText("Track"))

                .click();

        $("h1")
                .shouldBe(visible)
                .shouldHave(text(expectedHeader));

    }

    @EnumSource(Language.class)
    @ParameterizedTest(name = "DHL site should display correct buttons for selected language {0}")
    @Tag("SMOKE")
    void dhlSiteShouldDisplayCorrectButtonsForSelectedLanguage(Language language) {

        SelenideElement langElement =
                $$(".c-navigation-menu--language-list a")
                        .find(text(language.name()));

        if (langElement.exists()) {
            langElement.click();
        }

        $("h2.c-voc-marketing-stage--block-text")

                .shouldHave(text(language.text));
    }



}
