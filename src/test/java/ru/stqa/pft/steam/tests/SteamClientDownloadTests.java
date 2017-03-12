package ru.stqa.pft.steam.tests;

import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Michael on 11.03.2017.
 */
public class SteamClientDownloadTests extends BaseTest {

    @Test
    public void downloadAFile() {
        app.getMenuHelper().goSteamHomePage();
        app.getMenuHelper().goDownloadSteamPage();

        List<String> response = app.getFileDownloader().downloadSteam();

        assertThat(new File(response.get(0)).exists(), is(equalTo(true)));
        assertThat(Integer.parseInt(response.get(1)), is(equalTo(200)));
    }

}
