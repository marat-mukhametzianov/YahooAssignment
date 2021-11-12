import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        loginPage.openFirstLetter();
        String mail = loginPage.getMail();
        String sender = loginPage.getSender();
        loginPage.sendBack(sender, mail);
    }

    @AfterClass
    public void tierDown()
    {
//        driver.quit();
    }
}
