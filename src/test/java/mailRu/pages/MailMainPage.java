package mailRu.pages;

import mailRu.TestBase;
import org.openqa.selenium.By;

import static mailRu.helpers.WebDriverContainer.setDriver;

public class MailMainPage extends TestBase {
    private static final String recipient = "asd@asd.ru";
    private static final String letterSubject = "Hello";
    private static final String letterText = "How are you?";



    private static final By composeMailButton = By.cssSelector("[class='compose-button__txt']");
    private static final By recipientField = By.xpath("//div[contains(@class,'contacts')]//input[contains(@class,'container')]");
    private static final By subjectLetterField = By.cssSelector("[name='Subject']");
    private static final By textLetterField = By.cssSelector("[role='textbox']");
    private static final By sendLetterButton = By.cssSelector("[data-test-id='send']");
    private static final By sentLettersButton = By.xpath("//a[contains(@title,'Отправленные')]");
    private static final By sentLetterTitle = By.cssSelector(String.format("[title='%s']", recipient));

    private static void composeMailButtonClick() {
        LOG.info("Clicking on Compose letter button");
        setDriver().findElement(composeMailButton).click();
    }

    private static void fillRecipientFieldText() {
        LOG.info("Filling recipient email");
        setDriver().findElement(recipientField).sendKeys(recipient);
    }

    private static void fillLetterSubjectText() {
        LOG.info("Filling subject of email");
        setDriver().findElement(subjectLetterField).sendKeys(letterSubject);
    }

    private static void fillLetterTextBody() {
        LOG.info("Filling email text");
        setDriver().findElement(textLetterField).sendKeys(letterText);
    }

    public static void sendLetter() {
        composeMailButtonClick();
        fillRecipientFieldText();
        fillLetterSubjectText();
        fillLetterTextBody();
        LOG.info("Sending letter");
        setDriver().findElement(sendLetterButton).click();
        LOG.info("Closing after-window");
        setDriver().findElement(By.cssSelector("[class=\"layer-window__block\"] [class=\"button2__wrapper button2__wrapper_centered\"] [class=\"button2__ico\"]")).click();
    }

    public static boolean ifLetterIsSent() {
        LOG.info("Clicking on Sent items in left menu");
        setDriver().findElement(sentLettersButton).click();
        LOG.info("Checking, if sent letter is correct");
        return setDriver().findElement(sentLetterTitle).getText().equals(recipient);
    }

}
