package pages.areas;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxArea extends DriverActions
{
    public InboxArea(WebDriver driver)
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
        String sender = getSender();
        String firstMail = takeText
        (
            By.xpath("//*[@data-test-id = 'message-view-body-content']"),
            "The field to get text can't be found",
            5
        );
        clickElement
        (
            By.xpath("//*[@data-test-id = 'compose-button']"),
            "The compose button can't be found",
            5
        );
        setTextboxValue
        (
            By.xpath("//*[@id = 'message-to-field']"),
            sender,
            "The address field hasn't been found",
            5
        );
        setTextboxValue
        (
            By.xpath("//*[@data-test-id = 'rte']/div"),
            firstMail,
            "The message field hasn't been found",
            5
        );
        setTextboxValue
        (
            By.xpath("//*[@data-test-id = 'compose-subject']"),
            "Sent back",
            "The subject field hasn't been found",
            5
        );
        clickElement
        (
            By.xpath("//*[@data-test-id = 'compose-send-button']"),
            "The send button can't be found",
            5
        );
    }

    public String getSender()
    {
        String initialMail = takeText
        (
            By.xpath("//*[@data-test-id = 'email-pill']/span/span"),
            "The field to get email can't be found",
            5
        );
        String email = initialMail.substring(initialMail.indexOf("<")+1, initialMail.indexOf(">"));
        return email;
    }

    public void openFirstLetter()
    {
        waitForElements
        (
            By.xpath("//*[@role = 'list']/li/a[@role = 'article']"),
            "There is no the first letter.",
            5
        ).get(1).click();
    }
}
