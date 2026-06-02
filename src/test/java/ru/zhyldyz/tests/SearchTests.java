package ru.zhyldyz.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SearchTests{
    @Test
    void successfulSearchTest() {

        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }

    @Test
    void newSearch() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadStrategy = "eager";
        open("https://duckduckgo.com/");
        $("#searchbox_input").setValue("selenide").pressEnter();
        $("#react-layout").shouldHave(text("ru.selenide.org"));
    }
}
