package ru.zhyldyz.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    SelenideElement userNameInput = $("[id = userName]");
    SelenideElement userEmailInput = $("[id = userEmail]");
    SelenideElement userCurrentAddressInput = $("[id = currentAddress]");
    SelenideElement userPermanentAddressInput = $("[id = permanentAddress]");
    SelenideElement submitButton = $("#submit");

    public TextBoxPage openTextBoxPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage typeUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage typeEmailName(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage typeCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage typePermanentAddress(String value) {
        userPermanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.scrollTo().click();
        return this;
    }
}
