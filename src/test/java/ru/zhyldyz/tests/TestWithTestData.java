package ru.zhyldyz.tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.zhyldyz.test_data.TestData.*;

public class TestWithTestData extends TestBase {

    @Test
    @Description("Verify successful form submission when all required fields are " +
            "filled with valid data and the confirmation modal displays correct information")
    void fillPracticeFormTest() {

        open("/automation-practice-form");

        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        practiceFormPage.selectDateDatepicker(dateOfBirth);

        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(selectPic);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        String state = practiceFormPage.selectRandomItem("//*[contains(@id,'react-select-3-option')]");

        $("#city").click();
        String city = practiceFormPage.selectRandomItem("//*[contains(@id,'react-select-4-option')]");
        System.out.println("Selected state: " + state);
        System.out.println("Selected city: " + city);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstname + " " + lastname));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(practiceFormPage.formatDateForResult(dateOfBirth)));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text(hobby));
        $(".table-responsive").shouldHave(text(practiceFormPage.getFileName(selectPic)));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(state + " " + city));

    }

    @Test
    @Description("Verify that the form can be filled and submitted successfully with valid data")
    void textBoxTest() {

        open("/text-box");

        $("#userName").setValue(firstname);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        $("#submit").scrollTo().click();
        $("#output").scrollTo();
        $("#name").shouldHave(text(firstname));
        $("#email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }

}
