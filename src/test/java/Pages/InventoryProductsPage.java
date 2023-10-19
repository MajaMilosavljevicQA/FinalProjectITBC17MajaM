package Pages;

import Base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class InventoryProductsPage extends BaseTest {

    public InventoryProductsPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement productsTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackpackToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addBikeLightToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addBoltTShirtToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addFleeceJacketToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement addOnsieToCartButton;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement addRedTShirtToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBackpackButton;

    @FindBy(id = "remove-sauce-labs-bike-light")
    public WebElement removeBikeLightsButton;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    public WebElement removeBoltTShirtButton;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    public WebElement removeFleeceJacketButton;

    @FindBy(id = "remove-sauce-labs-onesie")
    public WebElement removeOnsieButton;

    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    public WebElement removeRedTShirtButton;

    @FindBy(className = "product_sort_container")
    public WebElement sortItemsDropdownMenu;

    //------------

    public void assertProductTitle() {
        Assert.assertTrue(productsTitle.isDisplayed());
    }


    public void addBackpackProductToCart() {
        Assert.assertTrue(addBackpackToCartButton.isDisplayed());
        addBackpackToCartButton.click();
    }

    public void addBikeLightToCart() {
        Assert.assertTrue(addBikeLightToCartButton.isDisplayed());
        addBikeLightToCartButton.click();
    }

    public void addBoltTShirtToCart() {
        Assert.assertTrue(addBoltTShirtToCartButton.isDisplayed());
        addBoltTShirtToCartButton.click();
    }

    public void addFleeceJacketToCart() {
        Assert.assertTrue(addFleeceJacketToCartButton.isDisplayed());
        addFleeceJacketToCartButton.click();
    }

    public void addOnsieToCart() {
        Assert.assertTrue(addOnsieToCartButton.isDisplayed());
        addOnsieToCartButton.click();
    }

    public void addRedTShirtToCart() {
        Assert.assertTrue(addRedTShirtToCartButton.isDisplayed());
        addRedTShirtToCartButton.click();
    }

    public void removeBackpack() {
        Assert.assertTrue(removeBackpackButton.isDisplayed());
        removeBackpackButton.click();
    }


    public void removeBikeLight() {
        Assert.assertTrue(removeBikeLightsButton.isDisplayed());
        removeBikeLightsButton.click();
    }

    public void removeBoltShirt() {
        Assert.assertTrue(removeBoltTShirtButton.isDisplayed());
        removeBoltTShirtButton.click();
    }

    public void removeFleeceJacket() {
        Assert.assertTrue(removeFleeceJacketButton.isDisplayed());
        removeFleeceJacketButton.click();
    }

    public void removeOnsie() {
        Assert.assertTrue(removeOnsieButton.isDisplayed());
        removeOnsieButton.click();
    }

    public void removeRedTShirt() {
        Assert.assertTrue(removeRedTShirtButton.isDisplayed());
        removeRedTShirtButton.click();
    }

    public void switchTab(int x) {
        try {
            List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
           driver.switchTo().window(windowHandles.get(x));
        } catch (IndexOutOfBoundsException windowWithIndexNotFound) {
            System.out.println("Error - no tab");
        }
    }

    public void sortItemsDropDown() {
        Assert.assertTrue(sortItemsDropdownMenu.isDisplayed());
        sortItemsDropdownMenu.click();
    }

}
