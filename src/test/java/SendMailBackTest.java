import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMailBackTest extends TestBase
{
    @Test
    public void loginPositiveTest()
    {
        loginPage.setLogin();
        passwordPage.setPassword();
        mailPage.openMailPage();
        mailPage.openFirstLetter();
        String mail = mailPage.getMail();
        String sender = mailPage.getSender();
        mailPage.sendBack(sender, mail);
    }
}
