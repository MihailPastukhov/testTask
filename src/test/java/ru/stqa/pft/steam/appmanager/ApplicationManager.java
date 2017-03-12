package ru.stqa.pft.steam.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Michael on 12.03.2017.
 */
public class ApplicationManager {


    public WebDriver wd;
    public WebDriverWait wait;

    private FileDownloader fileDownloader;
    private MenuHelper menuHelper;


    public void init(String browser) {
        if(browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
        else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }
        wait = new WebDriverWait(wd, 10/*seconds*/);
        wd.manage().window().maximize();
        menuHelper = new MenuHelper(wd, wait);
        fileDownloader = new FileDownloader(wd, wait);
    }

    public void stop() {
        wd.quit();
    }


    public MenuHelper getMenuHelper() {
        return menuHelper;
    }

    public FileDownloader getFileDownloader() {
        return fileDownloader;
    }
}
