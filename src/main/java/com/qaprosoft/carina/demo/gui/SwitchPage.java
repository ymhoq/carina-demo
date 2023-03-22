package com.qaprosoft.carina.demo.gui;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Set;

public class SwitchPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void switchToOpenedPage(WebDriver driver) {
        LOGGER.info("Switch page");
        if (driver.getWindowHandles().size() == 0) {
            openAvailablePage(driver);
            return;
        }

        for (String windowHandle : driver.getWindowHandles()) {
            if (!driver.getWindowHandle().contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                LOGGER.info("open "+ windowHandle);
                break;
            }
        }

    }

    private static void openAvailablePage(WebDriver driver) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }


    public static WebDriver closeWindow(WebDriver driver) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString()).close();
        return driver;
    }

    public static void openPageByIndex(WebDriver driver, int i) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[i].toString());
    }


}
