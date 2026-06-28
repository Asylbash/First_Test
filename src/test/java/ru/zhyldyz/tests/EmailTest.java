package ru.zhyldyz.tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;

@DisplayName("Email tests")
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmailTest {


    @Test
    @Tag("Smoke")
  //  @Order(3)
    @DisplayName("Email should be sent to new user")
    void emailShouldBeSentToNewUserTest() {
        System.out.println("Hello world!");
    }

    @Test
    @DisplayName("Email should be sent to banned user")
    @Tags({@Tag("WEB"), @Tag("API")})
 //   @Order(1)
    void emailShouldBeSentToBannedUserTest() {
        System.out.println("Hello world!");
    }

    @Disabled("bug #1234")
    @Test
  //  @Order(2)
    @DisplayName("Email should be sent after changed payment method")
    void emailShouldBeSentAfterChangedPaymentMethod() throws Exception {
        System.out.println("Hello world!");
        throw new AssertionError("Test failed");
    }


    @Test
   // @Order(2)
    @DisplayName("Email should be sent after changed payment method")
    void searchTest() throws Exception {
        $(".form-language.top-select").pressEnter();
        System.out.println("Hello world!");
        throw new AssertionError("Test failed");
    }

}
