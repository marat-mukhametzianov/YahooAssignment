package endToEnd;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMailBackTest extends TestBase
{
    @Test
    public void loginCheckMailReplyPositiveTest()
    {
        loginPage.setLogin();
        passwordPage.setPassword();
        menuPage.open();
        menuPage.openFolder(0);
        inboxArea.getFirstLetterAndSendBack();
        menuPage.openFolder(1);
        sentPage.isReplySent();
        sentPage.removeSent();
        Assert.assertFalse(sentPage.sentFolderIsEmpty());
    }
}
