package endToEnd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.*;
import pages.areas.InboxArea;
import sun.net.www.content.text.PlainTextInputStream;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase
{
    //SauceLabs
    private final String SAUCELABS_URL = "https://vgnwdbhwrwotvsdtcg:e3c12d3e-da8a-4508-afbc-6be34da91e3f@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    private final String USERNAME = "vgnwdbhwrwotvsdtcg";
    private final String KEY = "e3c12d3e-da8a-4508-afbc-6be34da91e3f";

    //Error message
    private final String URL_EXCEPTION = "Something with URL";

    WebDriver driver;
    LoginPage loginPage;
    InboxArea inboxArea;
    PasswordPage passwordPage;
    SentPage sentPage;
    MenuPage menuPage;

    @BeforeClass
    public void initialization(@Optional("chrome") String browserName)
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
