package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test (priority = 10)
    public void assertLogoText() {
        logoPage.assertSwagLabsLogo();
    }

    @Test (priority = 15)
    public void assertCredentials() {
        homePage.assertLoginCredentials();
        homePage.assertPasswordCredential();
    }

    @Test (priority = 17)
    public void userCanLogInAndLogOutExcel() {
        for (int i = 1; i < excelReader.getLastRow("Login")-1; i++) {
            String validUsername = excelReader.getStringData("Login", i, 0);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            homePage.usernameInputField(validUsername);
            homePage.passwordInputField(validPassword);
            homePage.clickOnTheLoginButton();
            sidebarPage.clickOnBurgerMenuButton();
            sidebarPage.logout();
        }
    }

    @Test(priority = 20)
    public void verifyUserCanLogInAndLogout() {
        homePage.usernameInputField("standard_user");
        homePage.passwordInputField("secret_sauce");
        homePage.clickOnTheLoginButton();
        sidebarPage.clickOnBurgerMenuButton();
        sidebarPage.logout();

    }

    @Test (priority = 25)
    public void userCannotLoginWithInvalidDataExcel() {
        for (int i = 1; i < excelReader.getLastRow("Login")-1; i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", i, 3);
            homePage.usernameInputField(invalidUsername);
            homePage.passwordInputField(invalidPassword);
            homePage.clickOnTheLoginButton();
            homePage.errorMessageAssert();
        }
    }

    @Test(priority = 30)
    public void verifyUserCannotLoginWithInvalidDataEmptyFields() {
        homePage.usernameInputField(" ");
        homePage.passwordInputField(" ");
        homePage.clickOnTheLoginButton();
        homePage.errorMessageAssert();
    }
}
