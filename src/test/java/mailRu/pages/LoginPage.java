package mailRu.pages;

import mailRu.TestBase;
import org.openqa.selenium.By;

import static mailRu.helpers.WebDriverContainer.setDriver;

public class LoginPage extends TestBase {
    private static final By loginButton = By.cssSelector("[data-testid='enter-mail-primary']");
    private static final By userNameInputField = By.cssSelector("[name='username']");
    private static final By enterPasswordButton = By.cssSelector("[class='submit-button-wrap'] [type='submit']");
    private static final By passwordInputField = By.cssSelector("[name='password']");
    private static final By submitAndLoginButton = By.cssSelector("[class='login-row'] [type='submit']");
    private static final String correctLoginEmail = "testfortest.2024";
    private static final String correctLoginPassword = "3iApaPlOtU*2";


    private static void loginButtonClick() {
        setDriver().findElement(loginButton).click();
    }

    private static void emailInput() {
        setDriver().findElement(userNameInputField).sendKeys(correctLoginEmail);
    }

    private static void enterPasswordButtonClick() {
        setDriver().findElement(enterPasswordButton).click();
    }

    private static void passwordInput() {
        setDriver().findElement(passwordInputField).sendKeys(correctLoginPassword);
    }

    public static void loginToMail() {
        loginButtonClick();
        setDriver().switchTo().frame(setDriver().findElement(By.className("ag-popup__frame__layout__iframe")));
        emailInput();
        enterPasswordButtonClick();
        passwordInput();
        setDriver().findElement(submitAndLoginButton).click();

    }
}
