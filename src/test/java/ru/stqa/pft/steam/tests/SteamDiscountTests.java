package ru.stqa.pft.steam.tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Michael on 11.03.2017.
 */
public class SteamDiscountTests extends BaseTest {


    @Test
    public void steamEnglishDiscountTest(){

        app.getMenuHelper().goSteamHomePage();

        app.getMenuHelper().setLanguage("English");

        app.getMenuHelper().goSteamHomePage();

        app.getMenuHelper().goGamesMenu();
        app.getMenuHelper().goActionsPage();
        app.getMenuHelper().goSpecialsTab();

        String maxDiscountValue = app.getMenuHelper().getMaxDiscountValue();
        List<String> pricesValuesOnGlobalPage = app.getMenuHelper().getPricesValues(maxDiscountValue);

        app.getMenuHelper().selectGameWithMaxDiscountValue(maxDiscountValue);

        List<String> pricesValuesOnGamePage = app.getMenuHelper().getPricesValues();

        assertThat(pricesValuesOnGlobalPage, is(equalTo(pricesValuesOnGamePage)));
    }

    @Test
    public void steamRussianDiscountTest()  {

        app.getMenuHelper().goSteamHomePage();

        app.getMenuHelper().setLanguage("Русский");

        app.getMenuHelper().goSteamHomePage();

        app.getMenuHelper().goGamesMenu();
        app.getMenuHelper().goActionsPage();
        app.getMenuHelper().goSpecialsTab();

        String maxDiscountValue = app.getMenuHelper().getMaxDiscountValue();
        List<String> pricesValuesOnGlobalPage = app.getMenuHelper().getPricesValues(maxDiscountValue);

        app.getMenuHelper().selectGameWithMaxDiscountValue(maxDiscountValue);

        List<String> pricesValuesOnGamePage = app.getMenuHelper().getPricesValues();

        assertThat(pricesValuesOnGlobalPage, is(equalTo(pricesValuesOnGamePage)));
    }


}

