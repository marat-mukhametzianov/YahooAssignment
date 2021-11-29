package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SentPage extends DriverActions
{
    //Locators
    private final String SELECT_ALL_SENT_LETTERS_LOCATOR = "//*[@data-test-id='checkbox']";
    private final String DELETE_BUTTON_LOCATOR = "//*[@data-test-id='toolbar-delete']";
    private final String MESSAGE_LIST_LOCATOR = "//*[@aria-label='Message list']/li";

    public SentPage(WebDriver driver)
    {
        super(driver);
    }

    /**
     * Just to check the existence of the list. If the list doesn't exist then nothing was sent.
     * @return
     */
    public boolean isReplySent()
    {
        boolean returnedValue = false;
        List<WebElement> sentList = waitForElements
        (
            By.xpath(MESSAGE_LIST_LOCATOR),
            "The message list can't be found",
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
            "The checkbox Select all can't be found",
            true,
            5
        );
        clickElement
        (
            By.xpath(DELETE_BUTTON_LOCATOR),
            "The Delete button can't be found",
            5
        );
    }

    public boolean sentFolderIsEmpty()
    {
        return elementExists(By.xpath(MESSAGE_LIST_LOCATOR), 5);
    }
}
