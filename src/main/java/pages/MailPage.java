package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage extends DriverActions
{
    public MailPage(WebDriver driver)
    {
        super(driver);
    }

    public void openMailPage()
    {
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
