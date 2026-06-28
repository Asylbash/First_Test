package ru.zhyldyz.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OrangeLoginPage {

    private final SelenideElement usernameInput =

            $("[name='username']");

    private final SelenideElement passwordInput =

            $("[name='password']");

    private final SelenideElement loginButton =

            $("button[type='submit']");

    public OrangeLoginPage enterUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    public OrangeLoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    private final SelenideElement errorMessage =
            $("p.oxd-alert-content-text");

    public String getErrorMessage() {
        return errorMessage.getText().trim();
    }
}

