package ru.zhyldyz.pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage {

    SelenideElement userNameInput = $("[id = userName]");
    SelenideElement userEmailInput = $("[id = userEmail]");
    SelenideElement userCurrentAddressInput = $("[id = currentAddress]");
    SelenideElement userPermanentAddressInput = $("[id = permanentAddress]");

    public void typeUserName(String value) {
        userNameInput.setValue(value);
    }

    public void typeEmailName(String value) {
        userEmailInput.setValue(value);
    }
    public void typeCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);
    }
    public void typePermanentAddress(String value) {
        userPermanentAddressInput.setValue(value);
    }


}
