package ru.stqa.pft.steam.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Michael on 12.03.2017.
 */
public class MenuHelper extends BaseHelper {

    public MenuHelper(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public void goSteamHomePage(){
        wd.get("http://store.steampowered.com/");
    }

    public void goGamesMenu() {
        if (isElementPresent(By.xpath("//a[contains(text(),'Игры')]"))){
            waitElementLocationAndClick("//a[contains(text(),'Игры')]/following-sibling::span");
        }
        else {
            waitElementLocationAndClick("//a[contains(text(),'Games')]/following-sibling::span");
         }
    }

    public void goActionsPage() {
        if ( isElementPresent(By.xpath("//a[@class='popup_menu_item'][contains(text(),'Экшен')]"))){
            waitElementLocationAndClick("//a[@class='popup_menu_item'][contains(text(),'Экшен')]");
        }
        else {
            waitElementLocationAndClick("//a[@class='popup_menu_item'][contains(text(),'Action')]");
        }
    }

    public void goSpecialsTab() {
        waitElementLocationAndClick("//div[@id='tab_select_Discounts']");
    }

    public String getMaxDiscountValue() {
        List<WebElement> discount = wd.findElements(By.xpath("//div[@id='tab_Discounts_content']//div[@class='discount_pct']"));

        List<String> discountValues = discount.stream().map(WebElement::getText).collect(Collectors.toList());

        String max = discountValues.stream().max(String::compareTo).get();

        return max;
    }

    public List<String> getPricesValues(String max) {

        String originalPrice = wd.findElement(By.xpath("//div[@class='discount_pct'][contains(text(),'" + max + "')]//..//div[@class='discount_original_price']")).getText();
        String discountPrice = wd.findElement(By.xpath("//div[@class='discount_pct'][contains(text(),'" + max + "')]//..//div[@class='discount_final_price']")).getText();

        List<String> prices = new ArrayList<String>();
        prices.add(max);
        prices.add(originalPrice);
        prices.add(discountPrice);
        return prices;
    }

    public List<String> getPricesValues() {

        String discountValue = wd.findElement(By.xpath("//div[@class='discount_pct']")).getText();
        String originalPrice = wd.findElement(By.xpath("//div[@class='discount_pct'][contains(text(),'" + discountValue + "')]//..//div[@class='discount_original_price']")).getText();
        String discountPrice = wd.findElement(By.xpath("//div[@class='discount_pct'][contains(text(),'" + discountValue + "')]//..//div[@class='discount_final_price']")).getText();

        List<String> prices = new ArrayList<String>();
        prices.add(discountValue);
        prices.add(originalPrice);
        prices.add(discountPrice.substring(0, discountPrice.lastIndexOf(' ')));
        return prices;
    }

    public void selectGameWithMaxDiscountValue(String maxDiscountValue) {
        wd.findElement(By.xpath("//div[@class='discount_pct'][contains(text(),'" + maxDiscountValue + "')]")).click();
    }

    public void goDownloadSteamPage() {
        wd.get("http://store.steampowered.com/about/");
    }

    public void setLanguage(String language) {
        waitElementLocationAndClick("//span[@id='language_pulldown']");
        if (language.equals("English")){
            waitElementLocationAndClick("//a[contains(text(),'English')]");
        }
        else if (language.equals("Русский")){
            waitElementLocationAndClick("//a[contains(text(),'Русский')]");
        }

    }
}
