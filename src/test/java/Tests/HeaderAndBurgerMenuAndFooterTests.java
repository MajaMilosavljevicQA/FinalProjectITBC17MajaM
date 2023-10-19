package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderAndBurgerMenuAndFooterTests extends BaseTest {

    public HeaderAndBurgerMenuAndFooterTests() {
        PageFactory.initElements(driver, this);
    }

    @BeforeMethod
    public void pageSetUp() {

        driver.navigate().to("https://www.saucedemo.com/");
        homePage.usernameInputField("standard_user");
        homePage.passwordInputField("secret_sauce");
        homePage.clickOnTheLoginButton();
    }


    @Test(priority = 10)
    public void clikOnSideBarLinksAndCloseBurgerMenu() {
        sidebarPage.clickOnBurgerMenuButton();
        sidebarPage.clickOnAboutSideBarLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
        driver.navigate().back();
        sidebarPage.clickOnBurgerMenuButton();
        sidebarPage.clickAllItemsSideBarLink();  // pada test --> nisu klikabilni linkovi/ne pokrece se nista posle klika
        driver.navigate().back();
        sidebarPage.clickOnBurgerMenuButton();
        sidebarPage.clickOnResetAppLink(); // pada test --> nisu klikabilni linkovi/ne pokrece se nista posle klika
        driver.navigate().back();
        sidebarPage.clickOnBurgerMenuButton();
        sidebarPage.closeBurgerMenu();
    }

    @Test(priority = 20)
    public void assertLogoAndTitleAndFooterCopy() {
        logoPage.assertSwagLabsLogo();
        inventoryProductsPage.assertProductTitle();
        footerPage.assertFooterText();
    }

    @Test(priority = 30)
    public void openSocialMediaFooterButtons() {
        scroll(0, 500);
        footerPage.clickOnTwitterButton();
        inventoryProductsPage.switchTab(1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/saucelabs");
        driver.close();
        inventoryProductsPage.switchTab(0);
        scroll(0, 500);
        footerPage.clickOnFacebookButton();
        inventoryProductsPage.switchTab(1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs");
        driver.close();
        inventoryProductsPage.switchTab(0);
        scroll(0, 500);
        footerPage.clickOnLinkedInButton();
        inventoryProductsPage.switchTab(1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");
        driver.close();
    }

    @Test (priority = 40)
    public void verifyYourInfoTxtHeaderAndCheckoutOverview() {
        checkoutStepOnePage.verifyYourInfoHeaderText();
        checkoutStepTwoPage.assertHeaderCheckoutOverView();
    }

}
