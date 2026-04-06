package page;

import driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    public ProductsPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public String getPageTitleText() {
        return pageTitle.getText();
    }

    public String getCurrentUrl() {
        return DriverFactory.getDriver().getCurrentUrl();
    }
}