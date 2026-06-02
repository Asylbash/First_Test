package ru.zhyldyz.tests;

import org.junit.jupiter.api.Test;
import ru.zhyldyz.pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest extends TestBase{

    @Test
    void fillUpTextBoxTest() {
        open("/text-box.html");

        $("#userName").setValue("Vanessa");
        $("#userEmail").setValue("Test@test.com");
        $("#currentAddress").setValue("via Roma 1, Rome , Italy");
        $("#permanentAddress").setValue("via Tuscolana 1, Rome , Italy");

        $("#submit").scrollTo().click();
        $("#output").scrollTo();
        $("#name").shouldHave(text("Name:Vanessa"));
        $("#email").shouldHave(text("Email:Test@test.com"));
        $("#output #currentAddress").shouldHave(text("via Roma"));
        $("#output #permanentAddress").shouldHave(text("via Tuscolana"));
    }

    @Test
    void textBoxTestPO(){
        open("/text-box.html");
        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage.typeUserName("Tomas");
        textBoxPage.typeEmailName("Test@test.com");
        textBoxPage.typeCurrentAddress("via Roma 1, Rome , Italy");
        textBoxPage.typePermanentAddress("via Tuscolana 1, Rome , Italy");

    }
}
