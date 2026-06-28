package ru.zhyldyz.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import ru.zhyldyz.enums.OrangeEndpoint;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrangeTest extends TestBase {

    @ParameterizedTest
    @CsvSource({
            "Admin, admin123, true",
            "Admin, wrong, false",
            "Wrong, admin123, false",
            "Wrong, wrong, false"
    })
    void testOrangeLogin(String username,
                         String password,
                         boolean success) {

        open(OrangeEndpoint.LOGIN.getEndpoint());

        loginPage.login(username, password);

        if (success) {
            assertEquals("Dashboard",
                    adminPage.getPageTitle());
        } else {
            assertEquals("Invalid credentials",
                    loginPage.getErrorMessage());
        }
    }
    @ParameterizedTest
    @EnumSource(value = OrangeEndpoint.class, names = {
            "ADMIN",
            "PIM",
            "DIRECTORY",
            "DASHBOARD"
    })
    void verifyNavigation(OrangeEndpoint endpoint) {

        open(endpoint.getEndpoint());

        assertEquals(
                endpoint.getPageTitle(),
                adminPage.getPageTitle()
        );
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/test_data/orangeUsers.csv", numLinesToSkip = 1)
    void verifySearchUser(String username,
                          String expectedResult) {

        open(OrangeEndpoint.ADMIN.getEndpoint());
        assertEquals(
                OrangeEndpoint.ADMIN.getPageTitle(),
                adminPage.getPageTitle()
        );

        adminPage.searchByUsername(username);

        assertEquals(
                expectedResult,
                adminPage.getSearchResultText(expectedResult)
        );
    }

}
