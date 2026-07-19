package ru.zhyldyz.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SubmissionModal {
    public String getValue(String label) {

        return $(By.xpath("//td[normalize-space()='" + label +
                "']/following-sibling::td"))
                .getText();
    }

    public String getTitle() {

        return $("#example-modal-sizes-title-lg").getText();
    }
}
