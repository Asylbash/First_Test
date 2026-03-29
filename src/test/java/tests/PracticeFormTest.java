package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracticeFormTest extends TestBase {

    @Test
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
    }
    @Test
    void emptyFormTest() {

        open("/automation-practice-form");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);

        $("#submit").click();

        $("#firstName").shouldBe(empty);
        $("#lastName").shouldBe(empty);
        $("#userNumber").shouldBe(empty);
    }
    @Test
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
        $(".modal-content").shouldNot(appear);

    }
    @Test
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

        String isInvalid = executeJavaScript(
                "return document.getElementById('userEmail').matches(':invalid')"
        ).toString();

        assertEquals("true", isInvalid);

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
