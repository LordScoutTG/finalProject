package mailRu;

import mailRu.helpers.WebDriverContainer;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static Logger LOG = Logger.getLogger(TestBase.class);

    @BeforeMethod
    public void initDriver() {
        WebDriverContainer.setDriver().get("https://mail.ru/");
    }

    @AfterMethod
    public void teardown() {
        WebDriverContainer.closeDriver();
    }
}