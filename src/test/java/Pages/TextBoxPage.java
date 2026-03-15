package Pages;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    @Test
    void successfulSearchTest() {

        open("https://www.demoqa.com/text-box");
        $("[id=userName]").setValue("Vanessa");
        $("[id=userEmail]").setValue("Test@test.com");
        $("[id=currentAddress]").setValue("via Roma 1, Rome , Italy");
        $("[id=permanentAddress]").setValue("via Tuscolana 1, Rome , Italy");
        $("[id=submit]").click();
        $("#name").shouldHave(text("Vanessa"));
        $("#email").shouldHave(text("Test@test.com"));
        $("#currentAddress").shouldHave(text("via Roma 1, Rome , Italy"));
        $("#permanentAddress").shouldHave(text("via Tuscolana 1, Rome , Italy"));
    }
}
