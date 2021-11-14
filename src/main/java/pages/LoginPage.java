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

    public void setLogin()
    {
        findFieldAndSetText(By.xpath(LOGIN_FIELD_LOCATOR), LOGIN, LOGIN_FIELD_HAS_NOT_BEEN_FOUND, 5);
        findElementAndSetCheck(By.xpath(STAY_IN_CHECK_BOX_LOCATOR), CHECK_BOX_STAY_IN_HAS_NOT_BEEN_FOUND, false, 5);
        findElementAndClick(By.xpath(NEXT_BUTTON_LOCATOR), NEXT_LOGIN_BUTTON_HAS_NOT_BEEN_FOUND, 5);
    }
}
