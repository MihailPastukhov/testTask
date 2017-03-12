package ru.stqa.pft.steam.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.steam.appmanager.ApplicationManager;

/**
 * Created by Michael on 11.03.2017.
 */
public class BaseTest {


    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() throws Exception {
        app.init(BrowserType.CHROME);
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }
}
