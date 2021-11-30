package pages.areas;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxArea extends DriverActions
{
    //Locator
    private final String MAIL_BODY_CONTENT_LOCATOR = "//*[@data-test-id = 'message-view-body-content']";
    private final String CREATE_NEW_MAIL_LOCATOR = "//*[@data-test-id = 'compose-button']";
    private final String ADDRESS_FIELD_LOCATOR = "//*[@id = 'message-to-field']";
    private final String MESSAGE_FIELD_LOCATOR = "//*[@data-test-id = 'rte']/div";
    private final String SUBJECT_FIELD_LOCATOR = "//*[@data-test-id = 'compose-subject']";
    private final String SEND_BUTTON_LOCATOR = "//*[@data-test-id = 'compose-send-button']";
    private final String EMAIL_LOCATOR = "//*[@data-test-id = 'email-pill']/span/span";
    private final String FIRST_LETTER_LOCATOR = "//*[@role = 'list']/li/a[@role = 'article']";

    //Error message
    private final String FIELD_GET_TEXT = "The field to get text can't be found.";
    private final String NEW_MAIL_BUTTON = "The compose button can't be found.";
    private final String ADDRESS_FIELD = "The address field hasn't been found.";
    private final String MESSAGE_FIELD = "The message field hasn't been found.";
    private final String SUBJECT_FIELD = "The subject field hasn't been found.";
    private final String SEND_BUTTON = "The send button can't be found.";
    private final String EMAIL = "The field to get email can't be found.";
    private final String FIRST_LETTER = "There is no the first letter.";

    //Text
    private final String SUBJECT_MESSAGE = "Sent back";

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
        String sender = getEmail();
        String firstMail = takeText
        (
            By.xpath(MAIL_BODY_CONTENT_LOCATOR),
            FIELD_GET_TEXT,
            5
        );
        clickElement
        (
            By.xpath(CREATE_NEW_MAIL_LOCATOR),
            NEW_MAIL_BUTTON,
            5
        );
        setTextboxValue
        (
            By.xpath(ADDRESS_FIELD_LOCATOR),
            sender,
            ADDRESS_FIELD,
            5
        );
        setTextboxValue
        (
            By.xpath(MESSAGE_FIELD_LOCATOR),
            firstMail,
            MESSAGE_FIELD,
            5
        );
        setTextboxValue
        (
            By.xpath(SUBJECT_FIELD_LOCATOR),
            SUBJECT_MESSAGE,
            SUBJECT_FIELD,
            5
        );
        clickElement
        (
            By.xpath(SEND_BUTTON_LOCATOR),
            SEND_BUTTON,
            5
        );
    }

    public String getEmail()
    {
        String initialMail = takeText
        (
            By.xpath(EMAIL_LOCATOR),
            EMAIL,
            5
        );
        String email = initialMail.substring(initialMail.indexOf("<")+1, initialMail.indexOf(">"));
        return email;
    }

    public void openFirstLetter()
    {
        waitForElements
        (
            By.xpath(FIRST_LETTER_LOCATOR),
            FIRST_LETTER,
            5
        ).get(1).click();
    }
}
