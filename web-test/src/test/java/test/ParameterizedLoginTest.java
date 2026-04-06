package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;

public class ParameterizedLoginTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "standard_user, wrong_password, Epic sadface: Username and password do not match any user in this service",
            "standard_user, '', Epic sadface: Password is required",
            "'', '', Epic sadface: Username is required"
    })
    public void loginWithInvalidCredentialsParameterizedTest(String username, String password, String expectedErrorMessage) {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login(username, password);

        Assertions.assertEquals(expectedErrorMessage, loginPage.getErrorMessageText());
    }
}