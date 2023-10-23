package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutStepOnePage extends BaseTest {

    public CheckoutStepOnePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu_button_container")
    WebElement checkoutYourInformationHeaderTxt;

    @FindBy(id = "first-name")
    WebElement firstNameInputField;

    @FindBy(id = "last-name")
    WebElement lastNameInputField;

    @FindBy(id = "postal-code")
    WebElement postalCodeInputField;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "cancel")
    WebElement cancelButton;

    public void verifyYourInfoHeaderText() {
        Assert.assertTrue(checkoutYourInformationHeaderTxt.isDisplayed());
    }

    public void inputFirstName(String firstname) {
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstname);
    }

    public void inputLasName(String lastname) {
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastname);
    }

    public void inputPostalCode(int postalcode) {
        postalCodeInputField.clear();
        postalCodeInputField.sendKeys(Integer.toString(postalcode));
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void clickOnCancelButton() {
        cancelButton.click();
    }
}
