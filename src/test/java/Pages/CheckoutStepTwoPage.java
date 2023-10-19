package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutStepTwoPage extends BaseTest {
    public CheckoutStepTwoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement checkoutOverViewHeader;


    @FindBy(id = "finish")
    WebElement finishButton;

    public void assertHeaderCheckoutOverView() {
        Assert.assertTrue(checkoutOverViewHeader.isDisplayed());
    }

    public void clickOnFinishButton() {
        Assert.assertTrue(finishButton.isDisplayed());
        finishButton.click();
    }
}
