package mailRu.pages;

import mailRu.TestBase;
import org.openqa.selenium.By;

import static mailRu.helpers.WebDriverContainer.setDriver;

public class MailMainPage extends TestBase {
    private static final By composeMailButton = By.cssSelector("[class='compose-button__txt']");
    private static final By recepientField = By.xpath("//div[contains(@class,'contacts')]//input[contains(@class,'container')]");
    private static final By subjectLetterField = By.cssSelector("[name='Subject']");
    private static final By textLetterField = By.cssSelector("[role='textbox']");
    private static final By sendLetterButton = By.cssSelector("[data-test-id='send']");
    private static final By sentLettersButton = By.xpath("//a[contains(@title,'Отправленные')]");
    private static final By sentLetterTitle = By.cssSelector("[title='asd@asd.ru']");
    private static final String recepient = "asd@asd.ru";
    private static final String letterSubject = "Hello";
    private static final String letterText = "How are you?";

    private static void composeMailButtonClick() {
        setDriver().findElement(composeMailButton).click();
    }

    private static void fillRecepientFieldText() {
        setDriver().findElement(recepientField).sendKeys(recepient);
    }

    private static void fillLetterSubjectText() {
        setDriver().findElement(subjectLetterField).sendKeys(letterSubject);
    }

    private static void fillLetterTextBody() {
        setDriver().findElement(textLetterField).sendKeys(letterText);
    }

    public static void sendLetter() {
        composeMailButtonClick();
        fillRecepientFieldText();
        fillLetterSubjectText();
        fillLetterTextBody();
        setDriver().findElement(sendLetterButton).click();
        setDriver().findElement(By.cssSelector("[class=\"layer-window__block\"] [class=\"button2__wrapper button2__wrapper_centered\"] [class=\"button2__ico\"]")).click();
    }

    public static boolean ifLetterIsSent() {
        setDriver().findElement(sentLettersButton).click();
        return setDriver().findElement(sentLetterTitle).getText().equals(recepient);
    }

}
