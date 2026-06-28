package ru.zhyldyz.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AdminPage {

    private final SelenideElement pageTitle =
            $(".oxd-topbar-header-breadcrumb h6");
    private SelenideElement usernameInput =
            $x("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");

    private SelenideElement searchButton =
            $(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");

    public void searchByUsername(String username) {
        usernameInput.setValue(username);
        searchButton.click();
    }

    public String getSearchResultText(String expectedResult) {
        return $$(".oxd-text.oxd-text--span")
                .findBy(text(expectedResult))
                .shouldBe(visible)
                .getText();
    }
    public String getPageTitle() {
        return pageTitle.shouldBe(visible).getText();

    }
    }

