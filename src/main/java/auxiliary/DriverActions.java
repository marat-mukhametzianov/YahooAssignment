package auxiliary;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverActions
{
    public WebDriver driver;

    public DriverActions(WebDriver driver)
    {
        this.driver = driver;
    }

    public void findElementAndSetCheck(By by, String errorMessage, boolean condition, int timeToWait)
    {
        WebElement checkBox = waitForElement(by, errorMessage, timeToWait);
        if (checkBox.isSelected() != condition)
        {
            checkBox.click();
        }
    }

    public void findFieldAndSetText(By by, String text, String errorMessage, int timeToWait)
    {
        WebElement field = waitForElement(by, errorMessage, timeToWait);
        clearField(field);
        field.sendKeys(text);
    }

    public void findElementAndClick(By by, String errorMessage, int timeToWait)
    {
        waitForElement(by,errorMessage, timeToWait).click();
    }

    public WebElement waitForElement(By by, String errorMessage, int timeToWait)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeToWait);
        webDriverWait.withMessage(errorMessage);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clearField(WebElement field)
    {
        field.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.SHIFT, Keys.LEFT, Keys.DELETE));
    }
}
