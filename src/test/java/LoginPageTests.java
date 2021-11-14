import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MailPage;
import pages.PasswordPage;

import static pages.PagesConstants.MAIL_PAGE;

public class LoginPageTests
{
    WebDriver driver;

    @BeforeClass
    public void initialization()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(MAIL_PAGE);
    }

    @Test
    public void loginPositiveTest()
    {
        new LoginPage(driver).setLogin();
        new PasswordPage(driver).setPassword();
        MailPage mailPage = new MailPage(driver);
        mailPage.openMailPage();
        mailPage.openFirstLetter();
        String mail = mailPage.getMail();
        String sender = mailPage.getSender();
        mailPage.sendBack(sender, mail);
    }

    @AfterClass
    public void tierDown()
    {
//        driver.quit();
    }
}
