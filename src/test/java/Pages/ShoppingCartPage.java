package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCartPage extends BaseTest {
    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    WebElement shoppingCartBadge;

    public void clickOnCartIcon() {
        Assert.assertTrue(cartIcon.isDisplayed());
        cartIcon.click();
    }

    public void emptyShoppingCartLogo() {
        Assert.assertTrue(cartIcon.isDisplayed());
    }

    public void shoppingCartBadgeNumber() {
        Assert.assertTrue(shoppingCartBadge.isDisplayed());
    }


}
