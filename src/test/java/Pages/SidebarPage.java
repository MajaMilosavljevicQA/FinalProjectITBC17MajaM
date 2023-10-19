package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    WebElement sidebarLink;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenuButton;

    @FindBy(id = "react-burger-cross-btn")
    WebElement closeBurgerMenuButton;

    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsSideBarLink;

    @FindBy(id = "about_sidebar_link")
    WebElement aboutSideBarLink;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetSideBarLink;

    List<String> sidebarLinkNames = new ArrayList<String>(); //"All Items", "About", "Logout", "Reset App State";



    public void setSidebarLinkNames() {
        this.sidebarLinkNames.add("All Items");
        this.sidebarLinkNames.add("About");
        this.sidebarLinkNames.add("Logout");
        this.sidebarLinkNames.add("Reset App State");
    }

    public List<String> getSidebarLinkNames() {
        return sidebarLinkNames;
    }

    public List<WebElement> getSidebarLink() {
        return driver.findElements(By.cssSelector(".bm-item.menu-item"));
    }

    public void clickOnSidebarLink(String linkName) {
        for (int i = 0; i < getSidebarLink().size(); i++) {
            if(getSidebarLink().get(i).getText().equals(linkName)) {
                getSidebarLink().get(i).click();
                break;
            }
        }
    }

    public void closeBurgerMenu() {
        Assert.assertTrue(closeBurgerMenuButton.isDisplayed());
        closeBurgerMenuButton.click();
    }

    public void clickOnBurgerMenuButton() {
        Assert.assertTrue(burgerMenuButton.isDisplayed());
        burgerMenuButton.click();
    }

    public void clickAllItemsSideBarLink() {
        Assert.assertTrue(allItemsSideBarLink.isDisplayed());
        allItemsSideBarLink.click();
    }

    public void clickOnAboutSideBarLink() {
        aboutSideBarLink.click();
    }

    public void logout() {
        logoutLink.click();
    }

    public void clickOnResetAppLink() {
    //    Assert.assertTrue(resetSideBarLink.isDisplayed());  --> pada test kada imamo asertacije za sajdbar linkove
        resetSideBarLink.click();
    }
}
