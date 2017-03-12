package ru.stqa.pft.steam.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Michael on 12.03.2017.
 */
public class BaseHelper {
    protected WebDriver wd;
    protected WebDriverWait wait;

    public BaseHelper(WebDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait=wait;
    }

    public void waitElementLocationAndClick(String locator){
        WebElement element = wait.until(presenceOfElementLocated(By.xpath(locator)));
        element.click();
    }

    public boolean isElementPresent(By locator){
        try {
            wd.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
}
