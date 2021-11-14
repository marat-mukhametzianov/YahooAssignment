package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.PagesConstants.*;

public class PasswordPage extends DriverActions
{

    public PasswordPage(WebDriver driver)
    {
        super(driver);
    }

    public void setPassword()
    {
        findFieldAndSetText(By.xpath(PASSWORD_FIELD_LOCATOR), PASSWORD, PASSWORD_FIELD_HAS_NOT_BEEN_FOUND, 5);
        findElementAndClick(By.xpath(NEXT_BUTTON_LOCATOR), NEXT_LOGIN_BUTTON_HAS_NOT_BEEN_FOUND, 5);
    }
}
