package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {

        driver.navigate().to("https://www.saucedemo.com/");
        homePage.usernameInputField("standard_user");
        homePage.passwordInputField("secret_sauce");
        homePage.clickOnTheLoginButton();
        inventoryProductsPage.addBikeLightToCart();
        shoppingCartPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutStepOnePage.verifyYourInfoHeaderText();
    }

    @Test(priority = 10)
    public void verifyUserCanInsertValidInfoInInformationFormAndCancelOrderStepOne() {
        for (int i = 1; i < excelReader.getLastRow ("Ordering Info")-1; i++) {
            String validFirstName = excelReader.getStringData("Ordering Info", i, 0);
            String validLastName = excelReader.getStringData("Ordering Info", i, 1);
            String validPostalCode = excelReader.getStringData("Ordering Info", i, 2);
            checkoutStepOnePage.inputFirstName(validFirstName);
            checkoutStepOnePage.inputLasName(validLastName);
            checkoutStepOnePage.inputPostalCode(validPostalCode);
        }
        checkoutStepOnePage.clickOnCancelButton();

        //todo   test pada --> proveri sa Dragoljubom sta moze da se uradi

    }

    @Test (priority = 20)
    public void verifyUserCanFillInfoFormAndFinishOrderAndGoToProductsPage() {
        checkoutStepOnePage.inputFirstName("Maja");
        checkoutStepOnePage.inputLasName("Milosavljevic");
        checkoutStepOnePage.inputPostalCode("11000");
        checkoutStepOnePage.clickOnContinueButton();
        checkoutStepTwoPage.clickOnFinishButton();
        checkoutCompletePage.assertCheckoutCompleteTitle();
        checkoutCompletePage.assertCorrectSign();
        checkoutCompletePage.assertThankU4YourOrderTxt();
        checkoutCompletePage.assertOrderIsDispachedMsg();
        cartPage.clickOnBackToProductsLinkTxt();  // isti id za Back to Home Button na Checkout Complete Pg
        inventoryProductsPage.assertProductTitle();
    }

    @Test (priority = 20)
    public void verifyUserCanFillInfoFormAndCancelOrderOnStepOne() {
        checkoutStepOnePage.inputFirstName("Petra");
        checkoutStepOnePage.inputLasName("Petric");
        checkoutStepOnePage.inputPostalCode("36000");
        checkoutStepOnePage.clickOnCancelButton();
        cartPage.assertTitleYourCart();
    }

    @Test (priority = 20)
    public void verifyUserCanFillInfoFormAndCancelOrderOnStepTwo() {
        checkoutStepOnePage.inputFirstName("Љиљана");
        checkoutStepOnePage.inputLasName("Шумановић - Џокичиђ - Жижањ");
        checkoutStepOnePage.inputPostalCode("36000");
        checkoutStepOnePage.clickOnContinueButton();
        checkoutStepTwoPage.assertHeaderCheckoutOverView();
        checkoutStepOnePage.clickOnCancelButton();
        inventoryProductsPage.assertProductTitle();
    }


}
