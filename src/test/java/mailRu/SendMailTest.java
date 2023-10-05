package mailRu;

import mailRu.pages.LoginPage;
import mailRu.pages.MailMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMailTest extends TestBase {

    @Test
    void letterSendingTest() {
        LoginPage.loginToMail();
        MailMainPage.sendLetter();
        Assert.assertTrue(MailMainPage.ifLetterIsSent(), "Mail not sent");
    }
}
