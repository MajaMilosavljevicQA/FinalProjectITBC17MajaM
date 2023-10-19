package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddToCartTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {

        driver.navigate().to("https://www.saucedemo.com/");
        homePage.usernameInputField("standard_user");
        homePage.passwordInputField("secret_sauce");
        homePage.clickOnTheLoginButton();
    }

    @Test(priority = 10)
    public void addToCartAndRemoveFromCart() {
        shoppingCartPage.emptyShoppingCartLogo();
        inventoryProductsPage.addBackpackProductToCart();
        inventoryProductsPage.removeBackpack();
    }


    @Test(priority = 20)
    public void addAndRemoveAllItemsToCartOnInventoryPage() {
        inventoryProductsPage.addBackpackProductToCart();
        inventoryProductsPage.addBikeLightToCart();
        inventoryProductsPage.addBoltTShirtToCart();
        inventoryProductsPage.addOnsieToCart();
        inventoryProductsPage.addRedTShirtToCart();
        inventoryProductsPage.addFleeceJacketToCart();
        inventoryProductsPage.removeBackpack();
        inventoryProductsPage.removeBikeLight();
        inventoryProductsPage.removeBoltShirt();
        inventoryProductsPage.removeFleeceJacket();
        scroll(0, 300);
        inventoryProductsPage.removeOnsie();
        inventoryProductsPage.removeRedTShirt();
    }

    @Test(priority = 30)
    public void removeProductsFromCartOnCartPageAndContinueShopping() {
        shoppingCartPage.emptyShoppingCartLogo();
        inventoryProductsPage.addBoltTShirtToCart();
        scroll(0, 50);
        inventoryProductsPage.addFleeceJacketToCart();
        shoppingCartPage.shoppingCartBadgeNumber();
        shoppingCartPage.clickOnCartIcon();
        logoPage.assertSwagLabsLogo();
        cartPage.assertTitleYourCart();
        cartPage.assertInventoryItemName();
        cartPage.verifyCartQuantity();
        inventoryProductsPage.removeBoltShirt();
        cartPage.clickOnContinueShoppingButton();
        shoppingCartPage.shoppingCartBadgeNumber();
    }

    @Test(priority = 40)
    public void cancelOrderStepOneAndStepTwo() {
        shoppingCartPage.emptyShoppingCartLogo();
        scroll(0, 250);
        inventoryProductsPage.addOnsieToCart();
        shoppingCartPage.shoppingCartBadgeNumber();
        shoppingCartPage.clickOnCartIcon();
        cartPage.assertInventoryItemName();
        cartPage.verifyCartQuantity();
        cartPage.clickOnCheckoutButton();

    }

    @Test(priority = 50)
    public void userCannotFinishShoppingWithEmptyCart() {
        shoppingCartPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        //nedostaju elementi za asertaciju Error poruke na CartPage-u --> ne mozemo obaviti kupovinu kad je korpa prazna
    }


    @Test (priority = 60)
    public void sortItems() {
        inventoryProductsPage.sortItemsDropDown();
        Select itemsDropDown = new Select(inventoryProductsPage.sortItemsDropdownMenu);
        itemsDropDown.selectByIndex(1); // 0, 1, 2, 3
        itemsDropDown.selectByValue("lohi"); // "az", "za", "lohi", "hilo"
        itemsDropDown.selectByVisibleText("Price (high to low)");// "Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)"
    }

    @Test (priority = 70)
    public void backToProducts() {
        inventoryProductsPage.addBikeLightToCart();
        shoppingCartPage.clickOnCartIcon();
        cartPage.assertInventoryItemName();
        cartPage.clickOnInventoryItemName();
        cartPage.clickOnBackToProductsLinkTxt();
        inventoryProductsPage.assertProductTitle();
    }


}
