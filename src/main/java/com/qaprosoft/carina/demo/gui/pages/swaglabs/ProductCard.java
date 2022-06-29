package com.qaprosoft.carina.demo.gui.pages.swaglabs;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ProductCard extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[1]/img")
    private ExtendedWebElement image;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")
    private ExtendedWebElement price;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"")
    private ExtendedWebElement ADDTOCARTbtn;

    public ProductCard(WebDriver driver) {
        super(driver); setPageURL("/cart.html");
    }

    public Boolean isPresentCardImage() {
        return image.isPresent();

    }

    public String readProductName() {
        assertElementPresent(productName);
        return productName.getText();
    }

    public String readProductDescription() {
        assertElementPresent(productDescription);
        return productDescription.getText();
    }

    public String readPrice() {
        assertElementPresent(price);
        return price.getText();
    }



}
