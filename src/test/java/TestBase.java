import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.MailPage;
import pages.PasswordPage;

import static pages.PagesConstants.MAIL_PAGE;

public class TestBase
{
    public WebDriver driver;
    public LoginPage loginPage;
    public MailPage mailPage;
    PasswordPage passwordPage;

    @BeforeClass
    public void initialization()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
        passwordPage = new PasswordPage(driver);
    }

    @AfterClass
    public void tierDown()
    {
//        driver.quit();
    }
}
