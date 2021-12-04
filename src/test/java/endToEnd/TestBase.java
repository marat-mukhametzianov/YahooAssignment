package endToEnd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import pages.areas.InboxArea;

public class TestBase
{
    WebDriver driver;
    LoginPage loginPage;
    InboxArea inboxArea;
    PasswordPage passwordPage;
    SentPage sentPage;
    MenuPage menuPage;

    @BeforeClass
    public void initialization()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        menuPage = new MenuPage(driver);
        loginPage = new LoginPage(driver);
        inboxArea = new InboxArea(driver);
        passwordPage = new PasswordPage(driver);
        sentPage = new SentPage(driver);
    }

    @AfterClass
    public void tierDown()
    {
        driver.quit();
    }
}
