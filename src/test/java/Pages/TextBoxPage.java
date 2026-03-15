package Pages;

public class TextBoxPage {
   @Test
    void successfulSearchTest() {

        open("https://www.demoqa.com/text-box");
        $("[id=userName]").setValue("Vanessa");
        $("[id=userEmail]").setValue("Test@test.com");
        $("[id=currentAddress]").setValue("via Roma 1, Rome , Italy");
      $("[id=permanentAddress]").setValue("via Roma 1, Rome , Italy");
      $("[id=submit]").click();
    }
}
