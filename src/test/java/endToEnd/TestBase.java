package endToEnd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import pages.areas.InboxArea;
import sun.net.www.content.text.PlainTextInputStream;

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
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.setCapability("username", "powercat");
        mutableCapabilities.setCapability("accessKey", "81ebdd4b-2c73-4dab-a5ae-9e05a52f5950");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("sauce:options", mutableCapabilities);
        desiredCapabilities.setCapability("browserVersion", "latest");
        desiredCapabilities.setCapability("platformName", "windows 7");
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
