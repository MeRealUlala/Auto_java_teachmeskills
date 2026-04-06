package page;

import driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public LoginPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public LoginPage open() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}