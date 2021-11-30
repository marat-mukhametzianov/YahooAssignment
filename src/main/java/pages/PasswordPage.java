package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.MultiUsedPageConstants.*;

public class PasswordPage extends DriverActions
{
    //Locator
    private final String PASSWORD_FIELD_LOCATOR = "//*[@id='login-passwd']";

    //Error message
    private final String PASSWORD_FIELD_HAS_NOT_BEEN_FOUND = "The password field hasn't been found";

    //Text
    private final String PASSWORD = "mmaratn_assignment";

    public PasswordPage(WebDriver driver)
    {
        super(driver);
    }

    public void setPassword()
    {
        setTextboxValue(By.xpath(PASSWORD_FIELD_LOCATOR), PASSWORD, PASSWORD_FIELD_HAS_NOT_BEEN_FOUND, 5);
        clickElement(By.xpath(NEXT_BUTTON_LOCATOR), NEXT_BUTTON_HAS_NOT_BEEN_FOUND, 5);
    }
}
