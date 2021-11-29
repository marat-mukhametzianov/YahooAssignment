package pages;

import auxiliary.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.PagesConstants.*;

public class LoginPage extends DriverActions
{
    //URLs
    private final String MAIN_PAGE = "https://login.yahoo.com/";

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void setLogin()
    {
        driver.get(MAIN_PAGE);
        setTextboxValue(By.xpath(LOGIN_FIELD_LOCATOR), LOGIN, LOGIN_FIELD_HAS_NOT_BEEN_FOUND, 5);
        setCheckboxTrueOrFalse(By.xpath(STAY_IN_CHECK_BOX_LOCATOR), CHECK_BOX_STAY_IN_HAS_NOT_BEEN_FOUND, false, 5);
        clickElement(By.xpath(NEXT_BUTTON_LOCATOR), NEXT_LOGIN_BUTTON_HAS_NOT_BEEN_FOUND, 5);
    }
}
