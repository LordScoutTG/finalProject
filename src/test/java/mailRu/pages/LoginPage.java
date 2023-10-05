package mailRu.pages;

import mailRu.TestBase;
import org.openqa.selenium.By;

import static mailRu.helpers.WebDriverContainer.setDriver;

public class LoginPage extends TestBase {
    private static final String correctLoginEmail = "testfortest.2024";
    private static final String correctLoginPassword = "3iApaPlOtU*2";


    private static final By loginButton = By.cssSelector("[data-testid='enter-mail-primary']");
    private static final By userNameInputField = By.cssSelector("[name='username']");
    private static final By enterPasswordButton = By.cssSelector("[class='submit-button-wrap'] [type='submit']");
    private static final By passwordInputField = By.cssSelector("[name='password']");
    private static final By submitAndLoginButton = By.cssSelector("[class='login-row'] [type='submit']");


    private static void loginButtonClick() {
        LOG.info("Clicking on button login");
        setDriver().findElement(loginButton).click();
    }

    private static void emailInput() {
        LOG.info("Filling login email");
        setDriver().findElement(userNameInputField).sendKeys(correctLoginEmail);
    }

    private static void enterPasswordButtonClick() {
        LOG.info("Clicking on button to open password field");
        setDriver().findElement(enterPasswordButton).click();
    }

    private static void passwordInput() {
        LOG.info("Filling login password");
        setDriver().findElement(passwordInputField).sendKeys(correctLoginPassword);
    }

    public static void loginToMail() {
        loginButtonClick();
        setDriver().switchTo().frame(setDriver().findElement(By.className("ag-popup__frame__layout__iframe")));
        emailInput();
        enterPasswordButtonClick();
        passwordInput();
        LOG.info("Submit and login");
        setDriver().findElement(submitAndLoginButton).click();

    }
}
