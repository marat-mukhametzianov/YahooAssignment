package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

public class MenuPage extends DriverActions
{
    //Locators
    private final String INBOX_BUTTON_LOCATOR = "//*[@data-test-folder-container = 'Inbox']";
    private final String SENT_BUTTON_LOCATOR = "//*[@data-test-folder-container = 'Sent']";

    private Map<Integer, String> locators = new HashMap<>();

    public MenuPage(WebDriver driver)
    {
        super(driver);
        initializeLocators();
    }

    private void initializeLocators()
    {
        locators.put(0, INBOX_BUTTON_LOCATOR);
        locators.put(1, SENT_BUTTON_LOCATOR);
    }

    public void openFolder(Integer folderNumber)
    {
        findElementAndClick(
                By.xpath(locators.get(folderNumber)),
                new Formatter().format("The folder button %d can't be found", folderNumber).toString(),
                5
        );
    }

}