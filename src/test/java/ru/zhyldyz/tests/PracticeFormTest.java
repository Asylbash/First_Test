package ru.zhyldyz.tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import ru.zhyldyz.MainPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class PracticeFormTest extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Description("Verify successful form submission when all required fields are " +
            "filled with valid data and the confirmation modal displays correct information")
    void fillPracticeFormTest() {

        open("/automation-practice-form");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);

        $("#firstName").setValue("Mario");
        $("#lastName").setValue("Rossi");
        $("#userEmail").setValue("test@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Eng").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/foto (1).png");
        $("#currentAddress").setValue("Test address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Mario Rossi"));
        $(".table-responsive").shouldHave(text("test@test.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("15 February,2000"));
        $(".table-responsive").shouldHave(text("Eng"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("foto (1).png"));
        $(".table-responsive").shouldHave(text("Test address"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }

    @Test
    @Description("Verify that required fields are highlighted and validation is triggered when submitting an empty form")
    void emptyFormTest() {

        open("/automation-practice-form");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));

        $("#firstName").shouldBe(empty);
        String isInvalidFirstName = executeJavaScript(
                "return document.getElementById('firstName').matches(':invalid')"
        ).toString();
        assertEquals("true", isInvalidFirstName);
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        $("#lastName").shouldBe(empty);
        String isInvalidLastName = executeJavaScript(
                "return document.getElementById('lastName').matches(':invalid')"
        ).toString();
        assertEquals("true", isInvalidLastName);
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(25, 135, 84)"));

        String isInvalidGender = executeJavaScript(
                "return document.querySelector('input[name=\"gender\"]').matches(':invalid')"
        ).toString();
        assertEquals("true", isInvalidGender);

        $("#gender-radio-1").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#gender-radio-2").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#gender-radio-3").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        $("#userNumber").shouldBe(empty);
        String isInvalidUserNumber = executeJavaScript(
                "return document.getElementById('userNumber').matches(':invalid')"
        ).toString();
        assertEquals("true", isInvalidUserNumber);
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        String actualDate = $("#dateOfBirthInput").getValue();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        String expectedDate = today.format(formatter);
        assertThat(actualDate).isEqualTo(expectedDate);

        $("#hobbies-checkbox-1").shouldHave(cssValue("border-color", "rgb(25, 135, 84)"));
        $("#hobbies-checkbox-2").shouldHave(cssValue("border-color", "rgb(25, 135, 84)"));
        $("#hobbies-checkbox-3").shouldHave(cssValue("border-color", "rgb(25, 135, 84)"));
        $("#uploadPicture").shouldHave(cssValue("border-color", "rgb(25, 135, 84)"));
        $("#currentAddress").shouldHave(cssValue("border-color", "rgb(25, 135, 84)"));

        $(".modal-content").shouldNot(appear);
    }

    @Test
    @Description("Verify validation is triggered when a required field (Gender) is not selected: " +
            "the form is not submitted, the modal is not displayed, and the field is highlighted as invalid")
    void emptyGenderFormTest() {

        open("/automation-practice-form");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);

        $("#firstName").setValue("Mario");
        $("#lastName").setValue("Rossi");
        $("#userEmail").setValue("test@test.com");
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Eng").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/foto (1).png");
        $("#currentAddress").setValue("Test address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));

        String isInvalidGender = executeJavaScript(
                "return document.querySelector('input[name=\"gender\"]').matches(':invalid')"
        ).toString();
        assertEquals("true", isInvalidGender);

        $("#gender-radio-1").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#gender-radio-2").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#gender-radio-3").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        $(".modal-content").shouldNot(appear);

    }

    @Test
    @Description("Validation for invalid email format")
    void invalidEmailTest() {

        open("/automation-practice-form");

        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);

        $("#firstName").setValue("Mario");
        $("#lastName").setValue("Rossi");

        $("#userEmail").setValue("invalidEmail");

        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Eng").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/foto (1).png");
        $("#currentAddress").setValue("Test address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#userEmail").shouldHave(cssClass("form-control"));
        String isInvalid = executeJavaScript(

                "return document.getElementById('userEmail').matches(':invalid')"

        ).toString();

        assertEquals("true", isInvalid);

        $("#firstName").shouldHave(cssClass("form-control"));

        $("#lastName").shouldHave(cssClass("form-control"));

        $("#userNumber").shouldHave(cssClass("form-control"));

        $(".modal-content").shouldNot(appear);

    }


}
