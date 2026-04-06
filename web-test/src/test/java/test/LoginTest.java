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
}