import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SendMailBackTest extends TestBase
{
    @Test
    public void loginPositiveTest()
    {
        loginPage.setLogin();
        passwordPage.setPassword();
        menuPage.openFolder(0);
        inboxPage.getFirstLetterAndSendBack();
        sentPage.isSentFolderEmpty();
    }
}
