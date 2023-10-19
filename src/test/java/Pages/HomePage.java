package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BaseTest {

    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = ".error-message-container.error")
    WebElement errorMsg;

    @FindBy(id = "login_credentials")
    WebElement loginCredentials;

    @FindBy(className = "login_password")
    WebElement passwordCredential;


    //-----------------


    public void usernameInputField(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void passwordInputField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnTheLoginButton() {
        loginButton.click();
    }

    public void errorMessageAssert() {
        Assert.assertTrue(errorMsg.isDisplayed());
    }

    public void assertLoginCredentials() {
        Assert.assertTrue(loginCredentials.isDisplayed());
    }

    public void assertPasswordCredential() {
        Assert.assertTrue(passwordCredential.isDisplayed());
    }

}
