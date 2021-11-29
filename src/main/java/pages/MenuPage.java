package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

public class MenuPage extends DriverActions
{
    //URLs
    private final String MAIL_PAGE = "https://mail.yahoo.com/d/folders/1";

    //Locators
    private final String INBOX_BUTTON_LOCATOR = "//*[@data-test-folder-container = 'Inbox']";
    private final String SENT_BUTTON_LOCATOR = "//*[@data-test-folder-container = 'Sent']";

    private Map<Integer, String> locators = new HashMap<>();

    public MenuPage(WebDriver driver)
    {
        super(driver);
        initializeLocators();
    }

    public void open()
    {
        driver.get(MAIL_PAGE);
    }

    private void initializeLocators()
    {
        locators.put(0, INBOX_BUTTON_LOCATOR);
        locators.put(1, SENT_BUTTON_LOCATOR);
    }

    public void openFolder(Integer folderNumber)
    {
        clickElement(
                By.xpath(locators.get(folderNumber)),
                new Formatter().format("The folder button %d can't be found", folderNumber).toString(),
                5
        );
    }

}