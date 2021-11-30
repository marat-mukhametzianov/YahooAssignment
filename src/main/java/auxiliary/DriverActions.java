package auxiliary;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DriverActions
{
    public WebDriver driver;

    public DriverActions(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setCheckboxTrueOrFalse(By by, String errorMessage, boolean condition, int timeToWait)
    {
        WebElement checkBox = waitForElement(by, errorMessage, timeToWait);
        if (checkBox.isSelected() != condition)
        {
            checkBox.click();
        }
    }

    public void setTextboxValue(By by, String text, String errorMessage, int timeToWait)
    {
        WebElement field = waitForElement(by, errorMessage, timeToWait);
        clearTextbox(field);
        field.sendKeys(text);
    }

    public String takeText(By by, String errorMessage, int timeToWait)
    {
        WebElement field = waitForElement(by, errorMessage, timeToWait);
        return field.getText();
    }

    public void clickElement(By by, String errorMessage, int timeToWait)
    {
        waitForElement(by,errorMessage, timeToWait).click();
    }

    public WebElement waitForElement(By by, String errorMessage, int timeToWait)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeToWait);
        webDriverWait.withMessage(errorMessage);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitForElements(By by, String errorMessage, int timeToWait)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeToWait);
        webDriverWait.withMessage(errorMessage);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        List<WebElement> returnedValue = driver.findElements(by);
        return returnedValue;
    }

    public void clearTextbox(WebElement field)
    {
        field.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.SHIFT, Keys.LEFT, Keys.DELETE));
    }

    public boolean elementExists(By by, int timeToWait)
    {
        try
        {
            new WebDriverWait(driver, timeToWait).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        }
        catch (TimeoutException e)
        {
            return false;
        }
    }
}
