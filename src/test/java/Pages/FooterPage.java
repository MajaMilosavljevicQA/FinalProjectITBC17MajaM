package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FooterPage extends BaseTest {

    public FooterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "footer_copy")
    public WebElement footerCopy;

    @FindBy(className = "social_twitter")
    public WebElement twitterButton;

    @FindBy(className = "social_facebook")
    public WebElement facebookButton;

    @FindBy(className = "social_linkedin")
    public WebElement linkedInButton;


    public void clickOnTwitterButton() {
        Assert.assertTrue(twitterButton.isDisplayed());
        twitterButton.click();
    }

    public void clickOnFacebookButton() {
        Assert.assertTrue(facebookButton.isDisplayed());
        facebookButton.click();
    }

    public void clickOnLinkedInButton() {
        Assert.assertTrue(linkedInButton.isDisplayed());
        linkedInButton.click();
    }

    public void assertFooterText() {
        Assert.assertTrue(footerCopy.isDisplayed());
    }
}
