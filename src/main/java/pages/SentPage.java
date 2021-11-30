package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SentPage extends DriverActions
{
    //Locator
    private final String SELECT_ALL_SENT_LETTERS_LOCATOR = "//*[@data-test-id='checkbox']";
    private final String DELETE_BUTTON_LOCATOR = "//*[@data-test-id='toolbar-delete']";
    private final String MESSAGE_LIST_LOCATOR = "//*[@aria-label='Message list']/li";

    //Error message
    private final String MESSAGE_LIST = "The message list can't be found";
    private final String SELECT_ALL = "The checkbox Select all can't be found";
    private final String DELETE_BUTTON = "The Delete button can't be found";

    public SentPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isReplySent()
    {
        boolean returnedValue = false;
        List<WebElement> sentList = waitForElements
        (
            By.xpath(MESSAGE_LIST_LOCATOR),
            MESSAGE_LIST,
            20
        );
        if (sentList.size() != 0)
        {
            returnedValue = true;
        }
        return returnedValue;
    }

    public void removeSent()
    {
        setCheckboxTrueOrFalse
        (
            By.xpath(SELECT_ALL_SENT_LETTERS_LOCATOR),
            SELECT_ALL,
            true,
            5
        );
        clickElement
        (
            By.xpath(DELETE_BUTTON_LOCATOR),
            DELETE_BUTTON,
            5
        );
    }

    public boolean sentFolderIsEmpty()
    {
        return elementExists(By.xpath(MESSAGE_LIST_LOCATOR), 5);
    }
}
