package ru.zhyldyz.tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.zhyldyz.test_data.RandomPracticeFormData;
import ru.zhyldyz.test_data.TestData;
import ru.zhyldyz.utils.RandomUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.zhyldyz.test_data.TestData.*;

public class TestWithTestData extends TestBase {

    @Test
    @Description("Verify successful form submission when all required fields are " +
            "filled with valid data and the confirmation modal displays correct information")
    void fillPracticeFormTest() throws InterruptedException {

        practiceFormPage.openPracticeFormPage();
        javaScriptHelper.removeFixedElements();
       RandomPracticeFormData data = testData.randomPracticeFormData();
        practiceFormPage
                .insertFirstName(data.firstName())
                .insertLastName(data.lastName())
                .insertUserEmail(data.email())
                .selectGender(data.gender())
                .insertUserNumber(data.mobile())
                .selectDateOfBirth(data.day(), data.month(), data.year())
                .insertSubjects(data.subject1(), data.subject2())
                .selectHobby(data.hobby1())
                .uploadPicture(data.selectPic())
                .insertCurrentAddress(data.address())
                .selectState(data.state())
                .selectCity(data.city())
                .clickSubmitForm();
        Thread.sleep(3000);

//        $("#firstName").setValue(firstname);
//        $("#lastName").setValue(lastname);
//        $("#userEmail").setValue(userEmail);
//        $("#genterWrapper").$(byText(gender)).click();
//        $("#userNumber").setValue(userNumber);
//        calendarComponent.selectDate(dayOfBirth, monthOfBirth, yearOfBirth);
//        $("#subjectsInput").setValue(subject).pressEnter();
//        $("#hobbiesWrapper").$(byText(hobby)).click();
//        $("#uploadPicture").uploadFromClasspath(selectPic);
//        $("#currentAddress").setValue(currentAddress);
//        $("#state").click();
//        $("#stateCity-wrapper").$(byText(state)).click();
//        $("#city").click();
//        $("#stateCity-wrapper").$(byText(city)).click();
//        $("#submit").click();
//        String actualResult = $("#example-modal-sizes-title-lg").getText();
//        assertEquals("Thanks for submitting the form", actualResult, "The form submission confirmation message is incorrect.");
//        String actualName = $(By.xpath("//td[normalize-space()='Student Name']/following-sibling::td")).getText();
//        assertEquals(firstname + " " + lastname, actualName, "The submitted name is incorrect.");
//        String actualEmail = $(By.xpath("//td[normalize-space()='Student Email']/following-sibling::td")).getText();
//        assertEquals(userEmail, actualEmail, "The submitted email is incorrect.");
//        String actualGender = $(By.xpath("//td[normalize-space()='Gender']/following-sibling::td")).getText();
//        assertEquals(gender, actualGender);
//        String actualPhoneNumber = $(By.xpath("//td[normalize-space()='Mobile']/following-sibling::td")).getText();
//        assertEquals(userNumber, actualPhoneNumber);
//        String actualDateOfBirth = $(By.xpath("//td[normalize-space()='Date of Birth']/following-sibling::td")).getText();
//        assertEquals(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth, actualDateOfBirth);
//        String actualSubject = $(By.xpath("//td[normalize-space()='Subjects']/following-sibling::td")).getText();
//        assertEquals(subject, actualSubject);
//        String actualHobby = $(By.xpath("//td[normalize-space()='Hobbies']/following-sibling::td")).getText();
//        assertEquals(hobby, actualHobby);
//        String actualPicture = $(By.xpath("//td[normalize-space()='Picture']/following-sibling::td")).getText();
//        assertEquals(practiceFormPage.getFileName(selectPic), actualPicture);
//        String actualAddress = $(By.xpath("//td[normalize-space()='Address']/following-sibling::td")).getText();
//        assertEquals(currentAddress, actualAddress);
//        String actualStateAndCity = $(By.xpath("//td[normalize-space()='State and City']/following-sibling::td")).getText();
//        assertEquals(state + " " + city, actualStateAndCity);
        //  $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        //  $(".table-responsive").shouldHave(text(firstname + " " + lastname));
//        $(".table-responsive").shouldHave(text(userEmail));
//        $(".table-responsive").shouldHave(text(gender));
//        $(".table-responsive").shouldHave(text(userNumber));
//        $(".table-responsive").shouldHave(text((dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)));
//        $(".table-responsive").shouldHave(text(subject));
//        $(".table-responsive").shouldHave(text(hobby));
//        $(".table-responsive").shouldHave(text(practiceFormPage.getFileName(selectPic)));
//        $(".table-responsive").shouldHave(text(currentAddress));
//        $(".table-responsive").shouldHave(text(state + " " + city));

        assertEquals(
                "Thanks for submitting the form",
                modal.getTitle()
        );

        assertEquals(
                data.firstName() + " " + data.lastName(),
                modal.getValue("Student Name")
        );

        assertEquals(
                data.email(),
                modal.getValue("Student Email")
        );

        assertEquals(
                data.gender(),
                modal.getValue("Gender"));
        assertEquals(
                data.mobile(),
                modal.getValue("Mobile")
        );
        String expectedDay = String.format("%02d", Integer.parseInt(data.day()));

        assertEquals(
                expectedDay + " " + data.month() + "," + data.year(),
                modal.getValue("Date of Birth")
        );
        assertEquals(
                data.subject1() + ", " + data.subject2(),
                modal.getValue("Subjects")
        );
        assertEquals(
                data.hobby1(),
                modal.getValue("Hobbies")
        );
        assertEquals(
                practiceFormPage.getFileName(data.selectPic()),
                modal.getValue("Picture")
        );
        assertEquals(
                data.address(),
                modal.getValue("Address")
        );
        assertEquals(
                data.state() + " " + data.city(),
                modal.getValue("State and City")
        );
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

    @Test
    @Description("Verify that the form can be filled and submitted successfully with valid data")
    void textBoxTestWithRandomData() {

        open("/text-box");

        String userName = RandomUtils.generateRandomString(10);

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
