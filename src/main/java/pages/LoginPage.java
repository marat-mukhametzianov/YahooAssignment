package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static pages.PagesConstants.*;

public class LoginPage extends DriverActions
{

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void login()
    {
        findFieldAndSetText(By.xpath(LOGIN_FIELD_LOCATOR), LOGIN, LOGIN_FIELD_HAS_NOT_BEEN_FOUND, 5);
        findElementAndSetCheck(By.xpath(STAY_IN_CHECK_BOX_LOCATOR), CHECK_BOX_STAY_IN_HAS_NOT_BEEN_FOUND, false, 5);
        findElementAndClick(By.xpath(NEXT_BUTTON_LOCATOR), NEXT_LOGIN_BUTTON_HAS_NOT_BEEN_FOUND, 5);
        findFieldAndSetText(By.xpath(PASSWORD_FIELD_LOCATOR), PASSWORD, PASSWORD_FIELD_HAS_NOT_BEEN_FOUND, 5);
        findElementAndClick(By.xpath(NEXT_BUTTON_LOCATOR), NEXT_LOGIN_BUTTON_HAS_NOT_BEEN_FOUND, 5);
        driver.get("https://mail.yahoo.com/d/folders/1");
    }

    public void sendBack(String sender, String message)
    {
        driver.findElement(By.xpath("//*[@data-test-id = 'compose-button']")).click();
        findFieldAndSetText(
               By.xpath("//*[@id = 'message-to-field']"),
               sender,
               "The address field hasn't been found",
               5
        );
        findFieldAndSetText(
                By.xpath("//*[@data-test-id = 'rte']/div"),
                message,
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

    public String getMail()
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
        driver.findElements(By.xpath("//*[@role = 'list']/li")).get(1).click();
    }
}
