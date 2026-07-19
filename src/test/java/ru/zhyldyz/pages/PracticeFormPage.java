package ru.zhyldyz.pages;

import com.codeborne.selenide.SelenideElement;
import ru.zhyldyz.components.CalendarComponent;

import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PracticeFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderRadio = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesCheckbox = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateButton = $("#state");
    private final SelenideElement stateCityInput = $("#stateCity-wrapper");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");


    public PracticeFormPage openPracticeFormPage() {

        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage insertFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage insertLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage insertUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public PracticeFormPage selectGender(String value) {
        genderRadio.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage insertUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public PracticeFormPage selectDateOfBirth(String day, String month, String year) {
        calendarComponent.selectDate(day, month, year);
        return this;
    }

    public PracticeFormPage insertSubjects(String ... values) {
        for (String value : values) {
            subjectsInput.setValue(value).pressEnter();
        }
        return this;
    }

    public PracticeFormPage selectHobby(String value) {

        hobbiesCheckbox
                .$(byText(value))
                .shouldBe(visible, enabled)
                .scrollIntoView(true)
                .click();
        return this;

    }

    public PracticeFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage insertCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public PracticeFormPage selectState(String value) {
        stateButton.click();
        stateCityInput
                .$(byText(value))
                .scrollTo()
                .shouldBe(visible, enabled)
                .scrollIntoView(true)
                .click();
        return this;
    }

    public PracticeFormPage selectCity(String value) {
        cityInput.click();
        stateCityInput
                .$(byText(value))
                .scrollTo()
                .shouldBe(visible, enabled)
                .scrollIntoView(true)
                .click();
        return this;
    }

    public PracticeFormPage clickSubmitForm() {
        submitButton
                .scrollTo()
                .click();
        return this;
    }

    public String getFileName(String filePath) {

        return Paths.get(filePath).getFileName().toString();

    }
}


//pages/
//PracticeFormPage
//
//components/
//CalendarComponent
//
//models/
//RandomPracticeFormData
//
//utils/
//RandomUtils
//
//tests/
//PracticeFormTest