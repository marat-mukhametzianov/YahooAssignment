package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxFolder extends DriverActions
{
    //URLs
    private static final String INBOX_FOLDER_URL = "https://mail.yahoo.com/d/folders/1";

    //Locators
    private static final String SENT_FOLDER_LOCATOR = "//*[@data-test-folder-container = 'Sent']";

    public InboxFolder(WebDriver driver)
    {
        super(driver);
    }

    public void getFirstLetterAndSendBack()
    {
        openFirstLetter();
        sendBack();
    }

    public void sendBack()
    {
        driver.findElement(By.xpath("//*[@data-test-id = 'compose-button']")).click();
        findFieldAndSetText(
                By.xpath("//*[@id = 'message-to-field']"),
                getSender(),
                "The address field hasn't been found",
                5
        );
        findFieldAndSetText(
                By.xpath("//*[@data-test-id = 'rte']/div"),
                getFirstMail(),
                "The message field hasn't been found",
                5
        );
        findFieldAndSetText(
                By.xpath("//*[@data-test-id = 'compose-subject']"),
                "Sent back",
                "The subject field hasn't been found",
                5
        );
        findElementAndClick(By.xpath("//*[@data-test-id = 'compose-send-button']"), "The send button hasn't been found", 5);
    }

    public String getFirstMail()
    {
        return driver.findElement(By.xpath("//*[@data-test-id = 'message-view-body-content']")).getText();
    }

    public String getSender()
    {
        String initialMail = driver.findElement(By.xpath("//*[@data-test-id = 'email-pill']/span/span")).getText();
        String email = initialMail.substring(initialMail.indexOf("<")+1, initialMail.indexOf(">"));
        return email;
    }

    public void openFirstLetter()
    {
        try
        {
            driver.findElements(By.xpath("//*[@role = 'list']/li")).get(1).click();
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("There is no the first letter.");
        }
    }
}
