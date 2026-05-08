package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.ProductsPage;
import io.qameta.allure.*;

import static org.assertj.core.api.Assertions.*;

@Epic("Web")
@Feature("Login")
public class LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Story("Valid login")
    @Description("Проверка успешного логина")
    @Test
    public void successfulLoginTest() {
        logger.info("Start successfulLoginTest");

        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        logger.info("Checking page title and URL");

        assertThat(productsPage.getPageTitleText()).isEqualTo("Products");
        assertThat(productsPage.getCurrentUrl()).contains("inventory");
    }

    @Test
    public void loginWithProblemUserTest() {
        logger.info("Start loginWithProblemUserTest");

        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();

        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");

        assertThat(productsPage.getPageTitleText()).isEqualTo("Products");
        assertThat(productsPage.getCurrentUrl()).contains("inventory");
    }

    @Test
    public void loginWithVisualUserTest() {
        logger.info("Start loginWithVisualUserTest");

        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();

        loginPage.open();
        loginPage.login("visual_user", "secret_sauce");

        assertThat(productsPage.getPageTitleText()).isEqualTo("Products");
        assertThat(productsPage.getCurrentUrl()).contains("inventory");
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        logger.info("Start loginWithInvalidPasswordTest");

        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login("standard_user", "wrong_password");

        assertThat(loginPage.getErrorMessageText())
                .isEqualTo("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        logger.info("Start loginWithEmptyPasswordTest");

        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login("standard_user", "");

        assertThat(loginPage.getErrorMessageText())
                .isEqualTo("Epic sadface: Password is required");
    }

    @Test
    public void loginWithEmptyCredentialsTest() {
        logger.info("Start loginWithEmptyCredentialsTest");

        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login("", "");

        assertThat(loginPage.getErrorMessageText())
                .isEqualTo("Epic sadface: Username is required");
    }
}