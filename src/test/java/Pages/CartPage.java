package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement yourCartHeader;

    @FindBy(className = "inventory_item_name")
    public WebElement inventoryItemName;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(className = "cart_quantity")
    public WebElement cartQuantity;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsLinkTxt;


    public void assertTitleYourCart() {
        Assert.assertTrue(yourCartHeader.isDisplayed());
    }

    public void clickOnContinueShoppingButton() {
        Assert.assertTrue(continueShoppingButton.isDisplayed());
        continueShoppingButton.click();
    }


    public void assertInventoryItemName() {
        Assert.assertTrue(inventoryItemName.isDisplayed());
    }

    public void clickOnInventoryItemName() {
        inventoryItemName.click();
    }

    public void clickOnCheckoutButton() {
        Assert.assertTrue(checkoutButton.isDisplayed());
        checkoutButton.click();
    }

    public void verifyCartQuantity() {
        Assert.assertTrue(cartQuantity.isDisplayed());
    }

    public void clickOnBackToProductsLinkTxt() {
        Assert.assertTrue(backToProductsLinkTxt.isDisplayed());
        backToProductsLinkTxt.click();
    }

}
