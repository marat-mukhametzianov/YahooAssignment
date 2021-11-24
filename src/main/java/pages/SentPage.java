package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SentPage extends DriverActions
{

    //Locators
    private static final String SENT_FOLDER_LOCATOR = "//*[@data-test-folder-container = 'Sent']";

    public SentPage(WebDriver driver)
    {
        super(driver);
    }

    public void openSentFolder()
    {
        findElementAndClick(
                By.xpath(SENT_FOLDER_LOCATOR),
                "The button Sent can't be found",
                30
        );
    }

    public boolean isSentFolderEmpty()
    {
        List<WebElement> sentList = waitForElements(By.xpath("//*[@aria-label = 'Message list']/li"), "The message list can't be found", 5);
        List<String> data = new ArrayList<>();
        for(WebElement element: sentList)
        {
            data.add(element.getText());
        }
        return true;
    }
}
