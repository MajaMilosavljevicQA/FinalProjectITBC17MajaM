package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutCompletePage extends BaseTest {

    public CheckoutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement checkoutCompleteHeaderTitle;

    @FindBy(className = "pony_express")
    WebElement correctGreenSign;

    @FindBy(className = "complete-header")
    WebElement thankYouForYourOrderHeaderMsg;

    @FindBy(className = "complete-text")
    WebElement yourOrderHasBeenDispachedMsg;

    public void assertCheckoutCompleteTitle() {
        Assert.assertTrue(checkoutCompleteHeaderTitle.isDisplayed());
    }

    public void assertCorrectSign() {
        Assert.assertTrue(correctGreenSign.isDisplayed());
    }

    public void assertThankU4YourOrderTxt() {
        Assert.assertTrue(thankYouForYourOrderHeaderMsg.isDisplayed());
    }

    public void assertOrderIsDispachedMsg() {
        Assert.assertTrue(yourOrderHasBeenDispachedMsg.isDisplayed());
    }



}
