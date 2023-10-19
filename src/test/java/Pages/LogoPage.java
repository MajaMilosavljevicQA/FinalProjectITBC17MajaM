package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogoPage extends BaseTest {

    public LogoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "app_logo")
    public WebElement appLogo;

    public void assertSwagLabsLogo() {
        Assert.assertTrue(appLogo.isDisplayed());
    }
}
