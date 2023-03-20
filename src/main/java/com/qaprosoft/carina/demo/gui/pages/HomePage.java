/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.WeValuePrivacyAd;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@id = 'footer']//div[@id = 'footmenu']")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(xpath = "//div[@id = 'footer']//div[@id = 'footmenu']")
    private ExtendedWebElement footerMenuElement;
    @FindBy(xpath = "//*[@id = 'header']")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//span[@class = 'lines']")
    private ExtendedWebElement openMenuButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public HomePage openHeaderMenu() {
        openMenuButton.click();
        return this;
    }


    public void scrollToFooterMenu() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        boolean elementFound = false;
        while (!elementFound) {
            jsExecutor.executeScript("document.body.scrollHeight");
            // Проверяем, что элемент видим на странице
            if (isFooterOpen()) {

                elementFound = true;
            } else {
                // Прокручиваем страницу на 500 пикселей вниз
                jsExecutor.executeScript("window.scrollBy(0, 500)");
            }
        }
    }

    public boolean isFooterOpen() {
        if (footerMenuElement.isElementPresent(1)) return true;
        else return false;
    }

    public BrandModelsPage selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return new BrandModelsPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }

    public WeValuePrivacyAd getWeValuePrivacyAd() {
        return new WeValuePrivacyAd(driver);
    }


    public static void scrollUntilElementIsVisible(WebDriver driver, ExtendedWebElement extendedWebElement) {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean elementFound = false;
        while (elementFound) {

            if (extendedWebElement.isElementPresent(5) || extendedWebElement.isPresent(5)) {
                elementFound = true;
            }
            jsExecutor.executeScript("window.scrollBy(0,500)");
        }
    }

}
