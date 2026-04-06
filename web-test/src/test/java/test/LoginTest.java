package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.ProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assertions.assertEquals("Products", productsPage.getPageTitleText());
        Assertions.assertTrue(productsPage.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void loginWithProblemUserTest() {
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();

        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");

        Assertions.assertEquals("Products", productsPage.getPageTitleText());
        Assertions.assertTrue(productsPage.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void loginWithVisualUserTest() {
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();

        loginPage.open();
        loginPage.login("visual_user", "secret_sauce");

        Assertions.assertEquals("Products", productsPage.getPageTitleText());
        Assertions.assertTrue(productsPage.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login("standard_user", "wrong_password");

        Assertions.assertEquals(
                "Epic sadface: Username and password do not match any user in this service",
                loginPage.getErrorMessageText()
        );
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login("standard_user", "");

        Assertions.assertEquals(
                "Epic sadface: Password is required",
                loginPage.getErrorMessageText()
        );
    }

    @Test
    public void loginWithEmptyCredentialsTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login("", "");

        Assertions.assertEquals(
                "Epic sadface: Username is required",
                loginPage.getErrorMessageText()
        );
    }
}